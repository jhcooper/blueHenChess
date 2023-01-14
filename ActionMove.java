/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Contains a constructor for an ActionMove object as well as an overridden preformAction method that carries out an
 * a move command
 */
public class ActionMove extends Action{

    /**
    @param fromRow - row inxed of attacking piece
    @param fromColumn - column index of attacking piece
    @param toRow - row inxed of where attacking piece will attack
    @param toColumn - column index of where attacking piece will attack
    calls it's super constructor and passes values to create an ActionMove object
    */

    public ActionMove(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     * calls the piece's speak method, removes it from its square and moves it to the to square.
     */
    @Override
    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        piece1.speak();
        boardSquares[fromRow][fromColumn].removePiece();
        boardSquares[toRow][toColumn].setPiece(piece1);
        game.changeTurn();
    }
}
