/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Interface containing all methods required for a piece that can attack
 */
public interface Attacker {

    public int getNumAttacks();
    public void setNumAttacks(int numAttacks);

    /**
     * Checks if an inputted path is valid
     * @param rowFrom
     * @param columnFrom
     * @param rowTo
     * @param columnTo
     * @return boolean
     */
    public boolean validAttackPath(int rowFrom , int columnFrom , int rowTo , int columnTo);
}
