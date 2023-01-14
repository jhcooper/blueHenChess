/**
 * @author John Henry Cooper
 * @version 15.0.2
 * Contains a constructor for an ActionAttack object as well as an overridden preformAction method that carries out an
 * an attack command
 */
public class ActionAttack extends Action{

    /**
    @param fromRow - row inxed of attacking piece
    @param fromColumn - column index of attacking piece
    @param toRow - row inxed of where attacking piece will attack
    @param toColumn - column index of where attacking piece will attack
    calls super constructors and returns an ActionAttack object
    */

    public ActionAttack(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     *   preform action method:
     *     when called for attacking opponent method
     *     - call from speak method
     *     -remove attacked opponents piece from both the board and team
     *     -move attacking piece from from square to to square
     *     -change turn
     *     when called with EvilMinion Piece:
     *     - attacking its own team
     *     - calls from piece speak method
     *     - remove attacked piece from board and team
     *     - create a new EvilMinion piece in place of attacked piece and add to current team and on board
     *     - change turn
     */
    @Override
    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        Piece piece2 = boardSquares[toRow][toColumn].getPiece();


        boardSquares[toRow][toColumn].removePiece();
        if(piece2.getTeamColor() == game.getOpponentTeam().getTeamColor()){
            // New Piece Modification
            if(piece1 instanceof PieceArcher){
                piece1.speak();
                game.getCurrentTeam().removePieceFromTeam(piece2);
                boardSquares[toRow][toColumn].removePiece();
            }
            piece1.speak();
            game.getOpponentTeam().removePieceFromTeam(piece2);
            boardSquares[fromRow][fromColumn].removePiece();
            boardSquares[toRow][toColumn].setPiece(piece1);
        }
        if(piece1 instanceof PieceEvilMinion && piece2 instanceof  PieceMinion){
            if (piece2.getTeamColor() == game.getCurrentTeam().getTeamColor()){
                piece1.speak();
                game.getCurrentTeam().removePieceFromTeam(piece2);
                PieceEvilMinion newEvilMinion = new PieceEvilMinion();
                game.getCurrentTeam().addPieceToTeam(newEvilMinion);
                boardSquares[toRow][toColumn].setPiece(newEvilMinion);
            }
        }

        game.changeTurn();
    }
}
