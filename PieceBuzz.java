/**
 *
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * An extension of the Piece class.
 * Includes all methods and properties required to assemble a PieceBuzz object, Including:
 * Inherited methods and properties, as well as three additional properties, an overloaded
 * constructor and zero-param constructor, accessor and mutator methods, a speak method
 */
public class PieceBuzz extends Piece implements Attacker{
    protected int numAttacks;
    protected int numTimesBeenAttacked;
    protected boolean workingLaser;

    /**
     * Seven-paramter overloaded constructor for a PieceBuzz object that calls the super constructor
     * @param symbol char representing the type of piece
     * @param teamColor String representing the team color
     * @param numAttacks int representing number of attacks
     * @param numTimesBeenAttacked int representing number of times attacked
     * @param workingLaser boolean representing if the laser works
     * @param hidden boolean representing if the piece is hidden
     * @param original boolean representing if the piece is original
     */
    public PieceBuzz(char symbol, String teamColor, int numAttacks, int numTimesBeenAttacked, boolean workingLaser, boolean hidden, boolean original) {
        super(symbol,teamColor,hidden,original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    /**
     * Zero parameter constructor for a PieceBuzz object
     */
    public PieceBuzz(){
        this('B',"- -",0,0,true,false,true);
    }

    public int getNumAttacks() {
        return numAttacks;
    }
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }
    public boolean canAttack(){
        return workingLaser;
    }

    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }

    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }

    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    /**
     * Prints the message "To Infinity and Beyond!"
     */
    public void speak(){
        System.out.println("To Infinity and Beyond!");
    }

    /**
     *  Empty ValidMovePath method. Will be updated later
     * @param fromSquareRow int
     * @param fromSquareCol int
     * @param toSquareRow   int
     * @param toSquareCol   int
     * @return
     */
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        return true;
    }

    /**
     * inherited spawn method, this piece cannot spawn so returns null
     * @return null
     */
    public Piece spawn(){
        return null;
    }

    /**
     * This piece cannot spawn, so returns false
     * @return boolean
     */
    public boolean canSpawn(){
        return false;
    }

    @Override
    public boolean validAttackPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {
       if (rowFrom == rowTo){
           return true;
       }
       else if((columnFrom == columnTo) && (rowTo == rowFrom + 2 || rowTo == rowFrom - 2)){
           return true;
       }
       return false;
    }

    public boolean validSpawnPath(int rowFrom, int columnFrom, int rowTo, int columnTo){
        return false;
    }

    public boolean validRecruitPath(int rowFrom, int columnFrom, int rowTo, int columnTo){
        return false;
    }
}
