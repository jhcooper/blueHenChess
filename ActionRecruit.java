/**
 * @author John Henry Cooper
 * @version 15.0.2
 * Contains a constructor for an ActionRecruit object as well as an overridden preformAction method that carries out an
 * an recruit command
 */
public class ActionRecruit extends Action{

    /**
    @param fromRow - row inxed of attacking piece
    @param fromColumn - column index of attacking piece
    @param toRow - row inxed of where attacking piece will attack
    @param toColumn - column index of where attacking piece will attack
    calls super constructor to make a ActionRecruit object
    */

    public ActionRecruit(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     *-call from speak piece method
     *-remove the recruited opponent piece and add that piece to current team
     *-change turn
     */
    @Override

    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        Piece piece2 = boardSquares[toRow][toColumn].getPiece();

        piece1.speak();
        // New Piece Modification
        if (piece1 instanceof PieceArcher && piece2 instanceof PieceMinion) {
            game.getOpponentTeam().removePieceFromTeam(piece2);
            game.getCurrentTeam().addPieceToTeam(piece2);
            game.changeTurn();
        }
        else if (!(piece1 instanceof PieceArcher)){
            game.getOpponentTeam().removePieceFromTeam(piece2);
            game.getCurrentTeam().addPieceToTeam(piece2);
            game.changeTurn();
        }
    }
}



