/**
 *
 * @author John Henry Cooper
 * @version 15.0.2
 * An extension of the Piece class.
 * Includes all methods and properties required to assemble a PieceMinion object, Including:
 * Inherited methods and properties, as well as three additional properties, an overloaded
 * constructor and zero-param constructor, accessor and mutator methods, a speak method
 */
public class PieceMinion extends Piece implements Recruiter{
    protected int numRecruits;
    protected int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    /**
     * Six Parameter constructor for a PieceMinion object that calls the super constructor
     * @param symbol char representing the type of piece
     * @param teamColor String representing the team color
     * @param numRecruits int representing the number of recruits
     * @param numTimesSpawned int representing the number of times spawned
     * @param hidden boolean representing if the piece is hidden
     * @param original boolean representing if the piece is original
     */
    public PieceMinion(char symbol, String teamColor, int numRecruits, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol,teamColor,hidden,original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    /**
     * Zero-parameter constructor for a PieceMinion object with symbol
     * set to 'M' color set to "NON, numRecruits and times
     * spawned set to zero, hidden set to false , and original set to true
     */
    public PieceMinion(){
        this('M',"NON",0,0,false,true);
    }

    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    /**
     * Prints "Bello!"
     */
    public void speak(){
        System.out.println("Bello!");
    }

    /**
     * Empty ValidMovePath method. Will be updated later
     * @param fromSquareRow int
     * @param fromSquareCol int
     * @param toSquareRow   int
     * @param toSquareCol   int
     * @return
     */
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        if((toSquareCol == fromSquareCol)){
            return true;
        }
        else if((fromSquareRow == toSquareRow) && (toSquareCol == fromSquareCol + 2 || toSquareCol == fromSquareCol - 2)){
            return true;
        }
        return false;
    }

    /**
     * Spawns an identical PieceMinion with the symbol set to lowercase and original set to false
     * @return PieceMinion spawned PieceMinion
     */
    public PieceMinion spawn(){
        return new PieceMinion(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }

    /**
     * returns true if the piece is original and has spawned less than the max times spawned
     * and false otherwise
     * @return boolean
     */
    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }


    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol,
                                    int toSquareRow, int toSquareCol) {
        if((toSquareCol == fromSquareCol)){
            return true;
        }
        else if((fromSquareRow == toSquareRow) && (toSquareCol == fromSquareCol + 2 || toSquareCol == fromSquareCol - 2)){
            return true;
        }
        return false;
    }

    public boolean validAttackPath(int rowFrom ,int columnFrom, int rowTo, int columnTo){
        return false;
    }

    public boolean validSpawnPath(int rowFrom ,int columnFrom, int rowTo, int columnTo){
        return true;
    }
}


