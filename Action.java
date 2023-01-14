/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Abstract class for all Actions. Contains a constructor, 2 member fields, and a preformAction field
 */
public abstract class Action {

    /**
    this class represents actions that the players can make during thier turn
    @param fromRow - row inxed of attacking piece
    @param fromColumn - column index of attacking piece
    @param toRow - row inxed of where attacking piece will attack
    @param toColumn - column index of where attacking piece will attack
    sets the five member fields
    */

    protected GameS22 game;
    protected int fromRow , fromColumn , toRow, toColumn;

    public Action (GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        this.game  = game;
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = toRow;
        this.toColumn = toColumn;
    }

    public abstract void performAction();
}