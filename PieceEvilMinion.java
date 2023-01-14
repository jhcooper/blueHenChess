/**
 *
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * An extension of the Piece and PieceMinion classes.
 * Includes all methods and properties required to assemble a PieceEvilMinion object, Including:
 * Inherited methods and properties, as well as two additional properties, an overloaded
 * constructor and zero-param constructor, accessor and mutator methods, a speak method, and a spawn method
 *
 */
public class PieceEvilMinion extends PieceMinion implements Recruiter, Attacker {
    protected int numAttacks;
    protected boolean hungry;

    public static int MAX_NUM_ATTACKS = 4;

    /**
     * Seven-parameter overloaded constructor for a PieceEvilMinion object that calls the super constructor
     *
     * @param symbol          char representing the type of piece
     * @param teamColor       String representing the team color
     * @param numRecruits     int representing the number of recruits
     * @param numAttacks      int representing number of attacks
     * @param numTimesSpawned int representing the number of times spawned
     * @param hidden          boolean representing if the piece is hidden
     * @param original        boolean representing if the piece is original
     */
    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    /**
     * Zero-parameter constructor for a PieceEvilMinion object with symbol
     * set to 'E' color set to "NON, numRecruits, attacks , and times
     * spawned set to zero, hidden set to false , and original set to true
     */
    public PieceEvilMinion() {
        PieceEvilMinion EvilMinion1 = new PieceEvilMinion('E', "NON", 0, 0, 0, false, true);
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public boolean canAttack() {
        return hungry;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public void updateHungry() {
        this.hungry = numAttacks < 4;
    }

    /**
     * prints "Roar!"
     */
    public void speak() {
        System.out.println("Roar!");
    }

    /**
     * Empty ValidMovePath method. Will be updated later
     *
     * @return boolean
     */
    public boolean validMovePath() {
        return true;
    }

    /**
     * Creates a new SPAWNED PieceEvilMinion, identical to it's parent but with a lowercase symbol, numRecruits to 1
     * and numTimesSpawned updated to be 1 more for the parent peice
     *
     * @return PieceEvilMinion spawn1
     */
    public PieceEvilMinion spawn() {
        PieceEvilMinion spawn1 = new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1, 0, 0, false, false);
        this.numTimesSpawned += 1;
        return spawn1;

    }


    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if ((toSquareCol == fromSquareCol)) {
            return true;
        } else if ((fromSquareRow == toSquareRow) && (toSquareCol == fromSquareCol + 2 || toSquareCol == fromSquareCol - 2)) {
            return true;
        }
        return false;
    }


    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if ((toSquareCol == fromSquareCol)) {
            return true;
        } else if ((fromSquareRow == toSquareRow) && (toSquareCol == fromSquareCol + 2 || toSquareCol == fromSquareCol - 2)) {
            return true;
        }
        return false;
    }

    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if ((toSquareCol == fromSquareCol)) {
            return true;
        } else if ((fromSquareRow == toSquareRow) && (toSquareCol == fromSquareCol + 2 || toSquareCol == fromSquareCol - 2)) {
            return true;
        }
        return false;
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if ((toSquareCol == fromSquareCol)) {
            return true;
        } else if ((fromSquareRow == toSquareRow) && (toSquareCol == fromSquareCol + 2 || toSquareCol == fromSquareCol - 2)) {
            return true;
        }
        return false;
    }
}
