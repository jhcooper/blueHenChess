import java.util.Scanner;
/**
 * @author John Henry Cooper
 * @version 15.0.2
 * Contains all rules for if an action is valid or not
 */
public class Rules {
    /**
     * Cheks if an action is valid
     * @param gameS22 The active game
     * @param fromRow The row index of the desired piece
     * @param fromColumn The column index of the desired piece
     * @param toRow The row index of the destination
     * @param toColumn The column index of the destination
     * @param action the desired action
     * @return boolean
     */
    public static boolean checkValidAction(Game gameS22, int fromRow, int fromColumn, int toRow, int toColumn, char action) {

        Piece piece1;
        Piece piece2;
        Boolean piece2Valid;
        BoardSquare[][] boardSquares = gameS22.getBoardSquares();

        if (boardSquares[fromRow][fromColumn].isEmpty()){
            System.out.println("Invalid Action");
            return false;
        }

        if(!boardSquares[fromRow][fromColumn].isEmpty()){
            piece1 = boardSquares[fromRow][fromColumn].getPiece();
            Boolean piece1Valid = ((piece1 != null) && (piece1.getTeamColor().equals(gameS22.getCurrentTeam().teamColor)));
            if (!piece1Valid){
                System.out.println("Invalid Action");
                return false;
            }
        }
        piece1 = boardSquares[fromRow][fromColumn].getPiece();

        String currentTeam = gameS22.getCurrentTeam().getTeamColor();
        String opposingTeam = gameS22.getOpponentTeam().getTeamColor();
        Boolean fromInBounds = gameS22.getGameBoard().inBounds(fromRow, fromColumn);
        Boolean toInBounds = gameS22.getGameBoard().inBounds(toRow, toColumn);

        Boolean isValidMovePath = piece1.validMovePath(fromRow, fromColumn, toRow, toColumn);
        Boolean isValidSpawnPath = piece1.validSpawnPath(fromRow,fromColumn,toRow,toColumn);
        Boolean isValidRecruitPath = piece1.validRecruitPath(fromRow, fromColumn, toRow, toColumn);
        Boolean isValidAttackPath = piece1.validAttackPath(fromRow, fromColumn, toRow, toColumn);

        if (fromInBounds && toInBounds) {

            if (action == 'M') {
                if (boardSquares[toRow][toColumn].isEmpty() && isValidMovePath) {
                    return true;
                }
            }

            if (action == 'S') {
                //Modified
                if (!(piece1 instanceof PieceBuzz) && !(piece1 instanceof PieceGuard) && isValidSpawnPath) {
                    System.out.println("the path is valid");
                    if (piece1 instanceof PieceMinion && !(piece1 instanceof  PieceEvilMinion)){
                        if(boardSquares[toRow][toColumn]== gameS22.NearestEmptyCorner(fromRow,fromColumn)){
                            return true;
                        }
                    }

                    if (boardSquares[toRow][toColumn].isEmpty()) {
                        if (piece1 instanceof PieceEvilMinion){
                            return piece1.canSpawn();
                        }
                        return true;
                    }
                }
            }

            if (action == 'R') {

                if (!(piece1 instanceof PieceBuzz) && isValidRecruitPath) {
                    if(!boardSquares[toRow][toColumn].isEmpty()) {
                        piece2 = boardSquares[toRow][toColumn].getPiece();
                        piece2Valid = ((piece2 != null) && (piece2.getTeamColor().equals(gameS22.getOpponentTeam().teamColor)));
                        if (piece2Valid) {
                            return true;
                        }
                    }

                }
            }
            if (action == 'A'&& isValidAttackPath) {
                if(piece1 instanceof PieceEvilMinion && !boardSquares[toRow][toColumn].isEmpty()){
                    piece2 = boardSquares[toRow][toColumn].getPiece();
                    piece2Valid = ((piece2 != null) && (piece2.getTeamColor().equals(gameS22.getOpponentTeam().teamColor)));

                    if (piece2Valid || piece2 instanceof PieceMinion){
                        if(((PieceEvilMinion) piece1).hungry){
                            return true;
                        }
                    }
                }
                if(!(piece1 instanceof PieceMinion) && !boardSquares[toRow][toColumn].isEmpty()) {
                    piece2 = boardSquares[toRow][toColumn].getPiece();
                    piece2Valid = ((piece2 != null) && (piece2.getTeamColor().equals(gameS22.getOpponentTeam().teamColor)));

                    if (piece1 instanceof PieceBuzz) {
                        if (piece2Valid && ((PieceBuzz) piece1).workingLaser) {
                            return true;
                        }
                    }

                    if (piece1 instanceof PieceBlueHen) {
                        if (piece2Valid) {
                            return true;
                        }
                    }
                    // New Piece Modification
                    if (piece1 instanceof PieceArcher && piece2Valid){
                        if(!(piece1 instanceof PieceGuard) && !(piece2 instanceof PieceGuard)){
                            if(piece2 instanceof PieceArcher) {
                                ((PieceArcher) piece1).setNumAttacks(0);
                                return true;
                            }
                            return true;
                        }
                        // New Extended Piece Modification
                        if(piece1 instanceof PieceGuard) {
                            if(((PieceGuard) piece1).getWorkingShield()) {
                                return true;
                            }
                        }
                    }
                }
            }
            // New Action Modification
            if (action == 'T'){
                if (piece1 instanceof PieceGuard && ((PieceGuard) piece1).numThrows < 1){
                    if(((PieceGuard) piece1).validThrowSpearPath(fromRow,fromColumn,toRow,toColumn)) {
                        ((PieceGuard) piece1).numThrows++;
                        return true;
                    }
                }
            }
        }
        System.out.println("Invalid Action");
        return false;
    }
}
