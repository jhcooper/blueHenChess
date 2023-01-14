/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Includes all methods and properties to construct a BoardSquare object.
 * Includes 3 property fields, an overloaded constructor, accessor and mutator methods,
 * and an overridden toString method
 */
public class BoardSquare {

    protected boolean empty;
    protected Piece piece;
    protected String squareColor;


    /**
     * One-parameter constructor for a BoardSquare object
     * @param squareColor String squareColor
     */
    public BoardSquare(String squareColor){
        this.squareColor = squareColor;
        empty = true;
    }


    public Piece getPiece(){
        return this.piece;
    }
    public boolean isEmpty(){
        return this.empty;
    }
    public String getSquareColor(){
        return this.squareColor;
    }


    /**
     * sets the piece property of a BoardSquare object and updates the
     * empty property to false
     * @param piece Piece
     */
    public void setPiece(Piece piece){
        this.piece = piece;
        this.empty = false;
    }

    /**
     * Removes the piece property of a BoardSquare object, updates
     * empty to true, and returns the piece that was removed
     * @return Piece temp
     */
    public Piece removePiece(){
        Piece temp = this.piece;
        this.piece = null;
        this.empty = true;
        return temp;
    }


    /**
     * Overridden string method that returns "-------" if the BoardSquare is empty
     * or returns the super toString of the piece if the BoardSquare is occupied
     * @return String message
     */
    @Override
    //Extra Modification
    public String toString(){
        if (this.piece == null){
            if (this.squareColor == "Blue"){
                return "■■■■■■■";
            }
            if (this.squareColor == "Yellow"){
                return "□□□□□";
            }
        }
        return "-" + this.piece.toString() + "-";
    }
}
