/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Contains All methods and member fields for a PieceArcher object. (getters , setters, constructors, valid action methods, can methods)
 *
 */
public class PieceArcher extends Piece implements Attacker, Recruiter {
// New Piece Modification

    protected int numRecruits;
    protected int numAttacks;
    protected int numTimesSpawned;
    public static int MAX_NUM_TIMES_SPAWNED = 1;
    public static int MAX_ATTACKS = 4;
    public static int MAX_RECRUITS = 1;


    public PieceArcher (char symbol, String teamColor, int numAttacks, int numTimesSpawned, boolean hidden, boolean original){
        super(symbol,teamColor,hidden,original);
        this.numTimesSpawned = numTimesSpawned;
    }
    public PieceArcher(){
        this('A',"NON",0,0,false,true);

    }


    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }
    public int getNumAttacks(){
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }
    public void setNumRecruits(int numRecruits){
        this.numRecruits = numRecruits;
    }
    public void setNumAttacks(int numAttacks){
        this.numAttacks = numAttacks;
    }


    /**
     * Prints "Ready to fire!"
     */
    public void speak(){
        System.out.println("Ready To Fire!");
    }


    public PieceGuard spawn(){
        this.numTimesSpawned += 1;
        return new PieceGuard('G',this.teamColor,0, 0, false, false, 3,0,true);
    }

    /**
     * @param rowFrom
     * @param columnFrom
     * @param rowTo
     * @param columnTo
     * @return boolean
     * checks if the action path is valid
     */
    @Override
    public boolean validAttackPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {
        return ((columnFrom == columnTo) && (rowTo <= rowFrom+3 && rowTo >= rowFrom-3) && (this.numAttacks <= MAX_ATTACKS) && (rowFrom != rowTo));
    }

    /**
     * @param rowFrom
     * @param columnFrom
     * @param rowTo
     * @param columnTo
     * @return boolean
     * checks if the action path is valid
     */
    @Override
    public boolean validRecruitPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {
        return ((rowFrom == rowTo) && (columnTo <= columnFrom+2 ||
                columnTo >= columnFrom-2) && (columnFrom != columnTo) && canRecruit());
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
        return (((toRow == fromRow + 1) || (toRow == fromRow -1))&& (fromColumn == toColumn) && (toRow != fromRow) && (canSpawn()));
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
        if ((fromRow == toRow) && (toColumn == fromColumn - 1 || toColumn == fromColumn + 1)){
            return true;
        }

        else if ((fromColumn == toColumn) && (toRow == fromRow - 1 || toRow == fromRow + 1)){
            return true;
        }
        return false;
    }

    @Override
    public boolean canSpawn() {
        return (this.getNumTimesSpawned() < MAX_NUM_TIMES_SPAWNED);
    }

    public boolean canRecruit(){
        return ((this.getNumRecruits() < MAX_RECRUITS) && !(this instanceof PieceGuard));
    }
}
