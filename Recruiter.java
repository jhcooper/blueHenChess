/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Interface containing all methods required for a piece that can recruit
 */
public interface Recruiter {

    public int getNumRecruits();
    public void setNumRecruits(int numRecruits);

    /**
     * Checks if an inputted path is valid
     * @param rowFrom
     * @param columnFrom
     * @param rowTo
     * @param columnTo
     * @return boolean
     */
    public boolean validRecruitPath(int rowFrom , int columnFrom , int rowTo , int columnTo);
}
