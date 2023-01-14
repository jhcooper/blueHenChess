/**
 * @authors John Henry Cooper
 * @version 15.0.2
 * Contains a constructor for an ActionThrowSpear object as well as an overridden preformAction method that carries out an
 *  * a throwSpear command
 */
public class ActionThrowSpear extends Action{
// New Action Modification

    public ActionThrowSpear(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    /**
     * Depending on if the piece is red or blue, removes all pieces up or down the column from the piece
     */
    @Override
    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        Piece piece2;

        int i;
        if (piece1.getTeamColor().equals("Blu")){
            for(i = fromRow-1 ; i >= 0 ; i--){
                if(!(boardSquares[i][fromColumn].isEmpty())){
                    String teamColor = boardSquares[i][fromColumn].getPiece().getTeamColor();
                    if (teamColor.equals(game.getCurrentTeam().getTeamColor())){
                        game.getCurrentTeam().removePieceFromTeam(boardSquares[i][fromColumn].getPiece());
                    }
                    else if (teamColor.equals(game.getOpponentTeam().getTeamColor())){
                        game.getOpponentTeam().removePieceFromTeam(boardSquares[i][fromColumn].getPiece());
                    }
                    boardSquares[i][fromColumn].removePiece();
                }
            }
        }
        else if (piece1.getTeamColor().equals("Red")){
            for(i = fromRow+1 ; i < game.getGameBoard().numRows ; i++){
                if(!(boardSquares[i][fromColumn].isEmpty())){
                    String teamColor = boardSquares[i][fromColumn].getPiece().getTeamColor();
                    if (teamColor.equals(game.getCurrentTeam().getTeamColor())){
                        game.getCurrentTeam().removePieceFromTeam(boardSquares[i][fromColumn].getPiece());
                    }
                    else if (teamColor.equals(game.getOpponentTeam().getTeamColor())){
                        game.getOpponentTeam().removePieceFromTeam(boardSquares[i][fromColumn].getPiece());
                    }
                    boardSquares[i][fromColumn].removePiece();
                }
            }
        }
        game.changeTurn();
    }
}
