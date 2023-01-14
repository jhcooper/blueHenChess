import java.util.ArrayList;
import java.util.Collections;

/**
 * @author John Henry Cooper
 * @version 15.0.2
 * Includes all methods and properties to construct a Game object.
 * Includes 4 property fields, an overloaded constructor,
 * a method to initialize the GameBoard property, accessor and mutator methods,
 * methods to change the turn, check opposing and current team,and an overridden toString method
 */
public abstract class Game {
    protected GameBoard board;
    protected Team team1;
    protected Team team2;
    protected String turn;

    /**
     * Creates a GameBoard object, assigns each team's pieces to a random empty
     * space on the GameBoard, and then sets the board property to this GameBoard
     * @param numRows int the number of rows
     * @param numColumns int the number of columns
     */
    private void initializeGameBoard(int numRows, int numColumns){
        this.board = new GameBoard(numRows, numColumns);
        for (Piece piece : team1.getTeamPieces()){
            board.findRandomEmptyBlueSpace().setPiece(piece);// New Rule Modification
        }
        for (Piece piece : team2.getTeamPieces()){
            board.findRandomEmptyRedSpace().setPiece(piece);// New Rule Modification
        }
    }


    /**
     * Four parameter constructor for a Game object that makes a call to
     * initializeGameBoard
     * @param numRows int the number of rows
     * @param numColumns int the number of columns
     * @param team1 Team the first team
     * @param team2 Team the second team
     */
    public Game(int numRows, int numColumns, Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        this.turn = team1.getTeamColor();
        initializeGameBoard(numRows,numColumns);
    }

    public GameBoard getGameBoard(){
        return this.board;
    }

    /**
     * Returns the team whose turn it is
     * @return Team
     */
    public Team getCurrentTeam(){
        if (this.turn.equals(team1.getTeamColor()) ){
            return team1;
        }
        return team2;
    }

    /**
     * Returns the team whose turn it isn´t
     * @return Team
     */
    public Team getOpponentTeam(){
        if (this.turn.equals(team1.getTeamColor()) ){
            return team2;
        }
        return team1;
    }

    /**
     * Checks if the given team´s turn is right now
     * @param team Team the team to be checked
     * @return boolean
     */
    public boolean isTurn(Team team){
        return this.getCurrentTeam() == team;
    }

    /**
     * Returns the 2D array of BoardSquares
     * @return BoardSquare[][]
     */
    public BoardSquare[][] getBoardSquares(){
            return this.getGameBoard().getSquares();
    }

    /**
     * Changes which team´s turn it is
     */
    public void changeTurn(){
        if (this.turn.equals(team1.getTeamColor()) ){
            this.turn = this.team2.getTeamColor();
        }
        else{
            this.turn = this.team1.getTeamColor();
        }
    }

    /**
     * returns the corner board square closest to the fromrow fromcolumn board square
     * @param fromRow
     * @param fromColumn
     * @return BoardSquare
     */
    //Added for PieceMinion Spawning
    public BoardSquare NearestEmptyCorner(int fromRow, int fromColumn){
        int rowRange = board.getNumRows() - 1;
        int columnRange = board.getNumColumns() - 1;

        int topLeftDist = Math.abs(fromRow + fromColumn);
        int topRightDist = Math.abs(fromRow + (columnRange - fromColumn));
        int bottomLeftDist = Math.abs((rowRange - fromRow) + fromColumn);
        int bottomRightDist = Math.abs((rowRange - fromRow) + (columnRange-fromColumn));
        BoardSquare square;

        int minDist = Math.min(Math.min(topLeftDist,topRightDist),Math.min(bottomRightDist,bottomLeftDist));

        if(minDist == topLeftDist){
            if(board.getSquares()[0][0].isEmpty()){
                return board.getSquares()[0][0];
            }
            minDist = Math.min(Math.min(bottomRightDist,bottomLeftDist),topRightDist);

        }
        else if(minDist == topRightDist){
            if(board.getSquares()[0][columnRange].isEmpty()){
                return board.getSquares()[0][columnRange];
            }
            minDist = (Math.min(bottomRightDist,bottomLeftDist));
        }
        else if(minDist == bottomLeftDist){
            if(board.getSquares()[rowRange][0].isEmpty()){
                return board.getSquares()[rowRange][0];
            }
        }

        else if (board.getSquares()[rowRange][columnRange].isEmpty()){
            return board.getSquares()[rowRange][columnRange];
        }
        return null;
    }

    /**
     * Overridden toString method that returns the Game
     * @return String message
     */
    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }
    // Board Square Modification
    public abstract void checkTeleporter(BoardSquare teleporter);// Board Square Modification
    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();
}

