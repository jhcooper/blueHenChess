import java.util.ArrayList;
import java.util.Collections;

/**
 * @author John Henry Cooper and Katie Oates
 * @version 15.0.2
 * Includes all methods and properties to construct a Team object.
 * Includes two property fields, an overloaded constructor, accessor and mutator methods,
 * and an overridden toString method
 */
public class Team {
    protected String teamColor;
    protected ArrayList<Piece>  teamPieces ;

    /**
     * Two parameter constructor for a Team Object
     * @param teamColor String
     * @param teamPieces ArrayList<Piece>
     */
    public Team(String teamColor, ArrayList<Piece> teamPieces){
        this.teamColor = teamColor;
        this.teamPieces = teamPieces;
    }

    public String getTeamColor(){
        return teamColor;
    }
    public ArrayList<Piece> getTeamPieces(){
        return teamPieces;
    }

    /**
     * Removes a piece from the teamPieces array list
     * @param removedPiece Piece piece to be removed from the team
     */
    public void removePieceFromTeam(Piece removedPiece){
        teamPieces.remove(removedPiece);
    }

    /**
     * Adds a piece to the teamPieces array list
     * @param addedPiece Piece piece to be removed
     */
    public void addPieceToTeam(Piece addedPiece){
        addedPiece.setTeamColor(teamColor);
        teamPieces.add(addedPiece);
    }

    /**
     * Overridden toString method that returns "Team (teamColor) Pieces : " followed by the super toString for each Piece object in the teamPieces array on a new line
     * @return String
     */
    @Override
    public String toString(){
        int i;
        String ret = "Team " + getTeamColor() +  " Pieces :\n";
        Collections.sort(teamPieces);
        for (i=0; i< this.teamPieces.size(); i++){
            ret += teamPieces.get(i).toString() +" ";
        }
        return ret;
    }
}
