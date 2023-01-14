/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Contains All methods and member fields for a PieceGuard object. (getters , setters, constructors, valid action methods, can methods)
 *
 */
public class PieceGuard extends PieceArcher{
    // New Extended Piece Modification
    protected int health;
    public int numThrows;
    public boolean workingShield;
    public static int MAX_NUM_TIMES_SPAWNED = 2;
    public static int MAX_THROWS = 1;



    public PieceGuard(char symbol, String teamColor, int numAttacks, int numTimesSpawned, boolean hidden, boolean original, int health, int numThrows, boolean workingShield){
        super(symbol,teamColor,numAttacks,numTimesSpawned,hidden,original);
        this.health = health;
        this.numThrows = numThrows;
        this.workingShield = workingShield;
    }
    public PieceGuard (){
        this ('G',"NAN",0,0,false,true,3,0,true);
    }

    public int getHealth(){
        return health;
    }
    public int getNumThrows(){
        return numThrows;
    }
    public boolean getWorkingShield(){
        return workingShield;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setWorkingShield(boolean workingShield){
        this.workingShield = workingShield;
    }

    /**
     * Prints "Stabdubg Guard!"
     */
    public void speak(){
        System.out.println("Standing Guard!");
    }

    /**
     * @param fromRow
     * @param fromColumn
     * @param toRow
     * @param toColumn
     * @return boolean
     * checks if the action path is valid
     */
    public boolean validAttackPath(int fromRow, int fromColumn, int toRow, int toColumn) {
        if ((fromRow == toRow) && ( toColumn == fromColumn + 1 || toColumn == fromColumn - 1)){
            return true;
        }

        else if ((fromColumn == toColumn) && (toRow == fromRow + 1)){
            return true;
        }

        else if  ((toRow == fromRow + 1) && ( toColumn == fromColumn + 1 || toColumn == fromColumn - 1)){
            return true;
        }
        return false;
    }
    /**
     * @param fromRow
     * @param fromColumn
     * @param toRow
     * @param toColumn
     * @return boolean
     * checks if the action path is valid
     */
    public boolean validSpawnPath(int fromRow , int fromColumn , int toRow, int toColumn) {
        return ((toRow == fromRow ) && ((toColumn == fromColumn - 1) || (toColumn == fromColumn + 1)));
    }
    /**
     * @param fromRow
     * @param fromColumn
     * @param toRow
     * @param toColumn
     * @return boolean
     * checks if the action path is valid
     */
    public boolean validMovePath(int fromRow , int fromColumn , int toRow , int toColumn){
        return ((toRow == fromRow + 1 || toRow == fromRow -1) && (fromColumn == toColumn));
    }
    /**
     * @param fromRow
     * @param fromColumn
     * @param toRow
     * @param toColumn
     * @return boolean
     * checks if the action path is valid
     */
    public boolean validThrowSpearPath(int fromRow , int fromColumn , int toRow , int toColumn){
        if(getTeamColor().equals("Blu")){
            return ((fromColumn==toColumn) && (toRow<fromRow));
        }
        return((fromColumn==toColumn)&& (toRow>fromRow));
    }

    public boolean canSpawn() {
        return (this.getNumTimesSpawned() < MAX_NUM_TIMES_SPAWNED);
    }

    /**
     *
     * @return boolean
     * checks if the number of attacks is less then max
     */
    public boolean canThrow(){
        return (this.numThrows < MAX_THROWS);
    }

    /**
     * Setter for health, If health reaches zero, sets workingShield to false
     */
    public void updateHealth(){
        this.health--;
        if (this.health <= 0){
            this.workingShield = false;
        }

    }

}
