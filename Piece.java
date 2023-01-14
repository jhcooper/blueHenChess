/**
 *
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Parent class for PieceBuzz, PieceEvilMinion, PieceBlueHen, and PieceMinion.
 * Includes all methods and properties to construct a piece object.
 * Includes 4 property fields, a default and overloaded constructor, accessor and mutator methods,
 * and an overridden toString method, as well as abstract methods speak, spawn, and validMovePath
 */
public abstract class Piece implements Comparable<Piece> {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    /**
     * Four parameter overloaded constructor
     * @param symbol char representing the type of piece
     * @param teamColor String representing the team color
     * @param hidden boolean representing if the piece is hidden
     * @param original boolean representing if the piece is original
     */
    public Piece(char symbol, String teamColor, boolean hidden, boolean original){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    /**
     * Zero Parameter constructor that sets symbol to 'X', teamColor to "NON", hidden to false, and original to true
     */
    public  Piece(){
        this('X',"NON",false,true);
    }

    public String getTeamColor(){
        return teamColor;
    }
    public boolean isHidden(){
        return hidden;
    }
    public boolean isOriginal(){
        return original;
    }
    public void setSymbol(char newSymbol){
        this.symbol = newSymbol;
    }
    public void setTeamColor(String newTeamColor){
        this.teamColor = newTeamColor;
    }
    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }
    public void setOriginal(boolean original){
        this.original = original;
    }
    public char getSymbol(){
        return symbol;
    }

    /**
     * Overridden toString method that returns a Piece's team color followed by it's symbol
     * @return String message
     */
    @Override
    public String toString(){
        return this.teamColor + " " + this.symbol;
    }

    /**
     * Abstract speak method (inherited)
     */
    public abstract void speak();

    /**
     * Abstract spawn method (inherited)
     * @return Piece
     */
    abstract Piece spawn();

    /**
     * Abstract validMovePath method (inherited)
     * @param fromSquareRow int
     * @param fromSquareCol int
     * @param toSquareRow int
     * @param toSquareCol int
     * @return boolean
     */

    //Added Methods
    abstract boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);
    abstract boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);
    abstract boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);
    abstract boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);
    public abstract boolean canSpawn();

    @Override
    public int compareTo(Piece piece){
        return Character.valueOf(this.symbol).compareTo(Character.valueOf(piece.symbol));
    }
}
