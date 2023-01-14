import org.w3c.dom.Text;
import java.util.ArrayList;


/**
 * @author John Henry Cooper
 * @version 15.0.2
 * Sets up and plays the game
 * Contains a setUpGameModel method that returns a game object, as well as carryOutAction that creates an action object
 * depending on user input, as well as a playGame and main method that play the game
 */
public class Controller {

    protected GameS22 game;
    protected TextView view;

    public GameS22 setUpGameModel(){
        // Create 5 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        /** Adds a pieceArcher */
        piecesTeamA.add(new PieceArcher('A',"Blu",0,0,false,true));// New Piece Modification
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 5 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        piecesTeamB.add(new PieceArcher('A',"Red",0,0,false,true));// New Piece Modification
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public Controller (){
        this.game = setUpGameModel();
        this.view = new TextView();
        view.updateView(this.game);
    }

    /**
     creates instance depending on which action type is passed to this method
     @param fromRow - row inxed of attacking piece
     @param fromColumn - column index of attacking piece
     @param toRow - row inxed of where attacking piece will attack
     @param toColumn - column index of where attacking piece will attack
     then calls the preformAction method
     */

    public void carryOutAction(int fromRow , int fromColumn , int toRow , int toColumn , char actionType){

        if (actionType == 'M'){
            ActionMove move = new ActionMove(game , fromRow,fromColumn,toRow,toColumn);
            move.performAction();
        }

        if (actionType == 'A'){
            ActionAttack attack = new ActionAttack(game , fromRow,fromColumn,toRow,toColumn);
            attack.performAction();
        }

        if (actionType == 'R'){
            ActionRecruit recruit = new ActionRecruit(game , fromRow,fromColumn,toRow,toColumn);
            recruit.performAction();
        }

        if (actionType == 'S'){
            ActionSpawn spawn = new ActionSpawn(game , fromRow,fromColumn,toRow,toColumn);
            spawn.performAction();
        }

        if (actionType == 'T'){ // New Action Modification
            ActionThrowSpear throwSpear = new ActionThrowSpear(game, fromRow,fromColumn,toRow,toColumn);
            throwSpear.performAction();
        }
    }

    /**
     implements the following algorithim:
     -calls getNextPlayersAction
     -calls Rules.checkValidAction (to see if users action is valid if not repeat a and b)
     - calls carryOutAction
     -prints game object
     -if the game is not over repead a and b
     -print a message that the game is over and the winning team
     */

    public void playGame(){
        BoardSquare teleporter = game.board.findRandomEmptySpace(); //ADDED
        while(!(game.isGameEnded())){
            boolean flag = false;
            while (!flag){
                view.getNextPlayersAction(game);
                flag = Rules.checkValidAction(game, view.fromRow , view.fromColumn , view.toRow , view.toColumn , view.action);
            }
            this.carryOutAction(view.fromRow , view.fromColumn , view.toRow , view.toColumn , view.action);
            game.checkTeleporter(teleporter); // Board Square Modification
            view.updateView(game);
        }
        view.printEndOfGameMessage(game);
    }

    public static void main (String[] args){
        Controller controller = new Controller();
        controller.playGame();
    }


}

    
