/***
 *
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * An extension of the Piece class.
 * Includes all methods and properties required to assemble a PieceBlueHen object, Including:
 * Inherited methods and properties, as well as four additional properties, an overloaded
 * constructor and zero-param constructor, accessor and mutator methods, a speak method
 */
public class PieceBlueHen extends Piece implements Recruiter, Attacker {
    protected int numAttacks;
    protected int numRecruits;
    protected boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    /**
     * Six Param constructor for a PieceBlueHen object that calls the super constructor
     *
     * @param symbol      char representing the type of piece
     * @param teamColor   String representing the team color
     * @param numAttacks  int representing number of attacks
     * @param numRecruits int representing the number of recruits
     * @param hidden      boolean representing if the piece is hidden
     * @param original    boolean representing if the piece is original
     */
    public PieceBlueHen(char symbol, String teamColor, int numAttacks, int numRecruits, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    /**
     * Zero-parameter constructor for a PieceBlueHen object
     */
    public PieceBlueHen() {
        this('H', "NON", 0, 0, false, true);
    }


    public int getNumAttacks() {
        return this.numAttacks;
    }

    public int getNumRecruits() {
        return this.numRecruits;
    }

    public boolean canFly() {
        return this.flies;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
        updateFly();
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    /**
     * Mutator method for the flies property that sets flies to true if
     * numAttacks < MAX_NUM_ATTACKS and false otherwise
     */
    private void updateFly() {
        if (this.numAttacks < MAX_NUM_ATTACKS) {
            this.flies = true;
        } else {
            this.flies = false;
        }
    }

    /**
     * prints "Go UD!"
     */
    public void speak() {
        System.out.println("Go UD!");
    }

    /**
     * Empty ValidMovePath method. Will be updated later
     *
     * @param fromSquareRow int
     * @param fromSquareCol int
     * @param toSquareRow   int
     * @param toSquareCol   int
     * @return boolean true
     */
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        if (this.flies = true) {
            return true;
        }
        if (this.flies = false) {
            if ((toSquareCol <= fromSquareCol+1) && (toSquareCol >= fromSquareCol-1) &&
                    (toSquareRow <= fromSquareRow+1) && (toSquareRow >= fromSquareRow-1)){
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a copied SPAWNED PieceBlueHen object that is identical to it's parent but the symbol is lowercase
     *
     * @return PieceBlueHen spawned PieceBlueHen
     */
    public PieceBlueHen spawn() {
        PieceBlueHen copyHen = new PieceBlueHen(Character.toLowerCase(this.symbol), this.teamColor, this.numAttacks, this.numRecruits, false, false);
        return copyHen;
    }

    /**
     * This piece can always spawn, so returns true
     *
     * @return boolean true
     */
    public boolean canSpawn() {
        return true;
    }

    @Override
    public boolean validRecruitPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {
        if (this.flies = true) {
            return true;
        }
        if (this.flies = false) {
            if (columnTo == columnFrom && (rowFrom + 1 == rowTo || rowFrom - 1 == rowTo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validAttackPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {
        if (this.flies = true) {
            return true;
        }
        if (this.flies = false) {
            if (rowFrom == rowTo && ((columnFrom + 1 == columnTo) || (columnFrom - 1 == columnTo))) {
                return true;
            }
        }
        return false;
    }

    public boolean validSpawnPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {
        if (this.flies = true) {
            return true;
        }
        if (this.flies = false) {
            if (((rowFrom + 1 == rowTo) || (rowFrom - 1 == rowTo)) && ((columnFrom + 1 == columnTo) || (columnFrom - 1 == columnTo))) {
                return true;
            }
        }
        return true;
    }
}

