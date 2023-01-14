import java.util.ArrayList;

/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Contains all information to Create a game object GameS22 , as well as a method to check if the game is ended
 *  and who won
 */
public class GameS22 extends Game{

    /**
     * Creates a GameS22 object
     * @param numRows
     * @param numColumns
     * @param team1
     * @param team2
     */
    public GameS22 (int numRows ,int numColumns, Team team1 , Team team2){
        super (numRows, numColumns, team1, team2);
    }

    // Board Square Modification
    public void checkTeleporter(BoardSquare teleporter){
        if(!(teleporter.isEmpty())){
            System.out.println("You have been teleported!");
            Piece teleportedPiece = teleporter.getPiece();
            teleporter.removePiece();
            this.board.findRandomEmptySpace().setPiece(teleportedPiece);
        }
    }
    /**
     * Checks to see if the team has won
     * @return boolean
     */
    @Override
    public boolean isAWinner() {
        if (getWinner() != null){
            return true;
        }
        return false;
    }

    /**
     * Checks to see if the game has ended
     * @return boolean
     */
    @Override
    public boolean isGameEnded() {
        if(team1.getTeamPieces().size() == 0 || team2.getTeamPieces().size() == 0){
            return true;
        }
        BoardSquare[][] boardSquares = this.getBoardSquares();
        int i, r = 0 , b = 0;
        for(i = 0 ; i < board.numColumns ; i++){// New Objective Modification
            if (!boardSquares[0][i].isEmpty()){
                if(boardSquares[0][i].getPiece().getTeamColor() == "Blu"){
                    b++;
                }
            }
            if(!boardSquares[board.numRows-1][i].isEmpty()){
                if (boardSquares[board.numRows-1][i].getPiece().getTeamColor() == "Red"){
                    r++;
                }
            }
        }
        if( r >= 3 || b >= 3){
            return true;
        }
        return false;
    }

    /**
     * Returns which team won
     * @return Team
     */
    @Override
    public Team getWinner() {
        if(team1.getTeamPieces().size() == 0 && team2.getTeamPieces().size() != 0 ) {
            return team2;
        }
        else if (team2.getTeamPieces().size() == 0 && team1.getTeamPieces().size() != 0 ){
            return team1;
        }
        BoardSquare[][] boardSquares = this.getBoardSquares();
        int i, r = 0 , b = 0;
        for(i = 0 ; i < board.numColumns ; i++){// New Objective Modification
            if (!boardSquares[0][i].isEmpty()){
                if(boardSquares[0][i].getPiece().getTeamColor() == "Blu"){
                    b++;
                }
            }
            if(!boardSquares[board.numRows-1][i].isEmpty()){
                if (boardSquares[board.numRows-1][i].getPiece().getTeamColor() == "Red"){
                    r++;
                }
            }
        }
        if (r >= 3 && b < 3){
            return team2;
        }
        else if (b >= 3 && r<3){
            return team1;
        }
        return null;
    }
}

