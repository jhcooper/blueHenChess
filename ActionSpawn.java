/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Contains a constructor for an ActionSpawn object as well as an overridden preformAction method that carries out an
 * a spawn command
 */
public class ActionSpawn extends Action{

    /**
    @param fromRow - row inxed of attacking piece
    @param fromColumn - column index of attacking piece
    @param toRow - row inxed of where attacking piece will attack
    @param toColumn - column index of where attacking piece will attack
    calls super constructor and returns an ActionSpawn object
    */
    public ActionSpawn(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     *implements the performAction method
     *-call From Piece speak method
     *-calls spawn method
     *-add the piece created to current team and put it on the to square
     *-change turn
     */
    @Override
    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        piece1.speak();
        Piece spawn = piece1.spawn();
        game.getCurrentTeam().addPieceToTeam(spawn);
        boardSquares[toRow][toColumn].setPiece(spawn);
        game.changeTurn();
    }
}
