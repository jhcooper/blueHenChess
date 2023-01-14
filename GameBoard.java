/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Includes all methods and properties to construct a GameBoard object.
 * Includes 3 property fields, an overloaded constructor, accessor and mutator methods,
 * and an overridden toString method
 */
public class GameBoard {
    protected int numRows;
    protected int numColumns;
    protected BoardSquare[][] squares;

    /**
     * Two parameter constructor for a GameBoard object that makes a call to setUpEmptyBoard
     * @param numRows int number of rows
     * @param numColumns int number of columns
     */
    public GameBoard(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }


    public int getNumRows(){
        return this.numRows;
    }
    public int getNumColumns(){
        return this.numColumns;
    }
    public BoardSquare[][] getSquares() {
        return squares;
    }


    /**
     * Checks if a set of row and column indexes are in range of the number of rows and columns of GameBoard object
     * @param rowIdx  int row
     * @param columnIdx int column
     * @return boolean
     */
    public boolean inBounds(int rowIdx, int columnIdx){
        if (((rowIdx <= numRows-1) && (rowIdx>=0)) && ((columnIdx  <= numColumns-1) && (columnIdx>=0))){
            return true;
        }
        return false;
    }

    /**
     * Creates a BoardSquare object for each location in the squares 2 dimensional array, alternating the color value between blue and yellow
     */
    public void setUpEmptyBoard(){
        int i;
        int c;
        int colorCount = 1;

        for (i = 0; i<this.numRows; i++){
            for(c = 0; c<this.numColumns; c++){
                if (colorCount%2 == 0){
                    this.squares[i][c]=new BoardSquare("Blue");
                }
                else {
                    this.squares[i][c] = new BoardSquare("Yellow");
                }
                colorCount++;//Modified
            }
            colorCount++;//Modified
        }
    }

    /**
     * Finds a random square in a GameBoard object that is empty and in range.
     * @return BoardSquare
     */
    public BoardSquare findRandomEmptySpace(){
        int rowRange = this.numRows-1;
        int columnRange = this.numColumns-1;
        int randRow = (int)(Math.random()*rowRange);
        int randColumn = (int)(Math.random()*columnRange);
        while (this.squares[randRow][randColumn].isEmpty() == false){
            randRow = (int)(Math.random()*rowRange);
            randColumn = (int)(Math.random()*columnRange);
        }
        return this.squares[randRow][randColumn];
    }


    /**
     * finds an empty random board square on the bottom half of the board
     * @return BoardSquare
     */
    public BoardSquare findRandomEmptyBlueSpace(){// New Rule Modification
        int columnRange = this.numColumns-1;
        int rowRange = ((this.numRows/2) );
        int rowMin;
        int randRow;
        int randColumn = (int)(Math.random()*columnRange);
        if (this.numRows % 2 != 0){
            rowMin = rowRange;
            randRow = (int)(Math.random()*rowRange + rowMin);
            while (this.squares[randRow][randColumn].isEmpty() == false){
                randRow = (int)(Math.random()*rowRange + rowMin);
                randColumn = (int)(Math.random()*columnRange);
            }
        }
        else{
            rowMin = rowRange;
            randRow = (int)(Math.random()*rowRange + rowMin);
            while (this.squares[randRow][randColumn].isEmpty() == false){
                randRow = (int)(Math.random()*rowRange + rowMin);
                randColumn = (int)(Math.random()*columnRange);
            }
        }
        return this.squares[randRow][randColumn];
    }
    /**
     * finds an empty random board square on the top half of the board
     * @return BoardSquare
     */
    public BoardSquare findRandomEmptyRedSpace(){// New Rule Modification
        int columnRange = this.numColumns-1;
        int rowRange = ((this.numRows/2));
        int randRow = (int)(Math.random()*rowRange);
        int randColumn = (int)(Math.random()*columnRange);
        while (this.squares[randRow][randColumn].isEmpty() == false){
            randRow = (int)(Math.random()*rowRange);
            randColumn = (int)(Math.random()*columnRange);
        }
        return this.squares[randRow][randColumn];
    }

    /**
     * Overridden toString that returns the GameBoard
     * @return String message
     */
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}
