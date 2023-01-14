import java.util.Scanner;
/**
 @author John Henry Cooper
 @version 15.0.2
 Provides a text based interface to players of the game
 has:
 -5 member feilds: fromRow, fromColumn, toRow, toColumn, and action
 that represents aspects of the game and board
 -getters for all member feilds
 */
public class TextView {



    protected int fromRow, fromColumn, toRow, toColumn;
    protected char action;

    public char getAction() {
        return action;
    }

    public int getFromColumn() {
        return fromColumn;
    }

    public int getFromRow() {
        return fromRow;
    }

    public int getToColumn() {
        return toColumn;
    }

    public int getToRow() {
        return toRow;
    }

    /**
     * Asks the user to enter an integer repeatedly until their entry falls between min and max
     * @param min minimum
     * @param max maximum
     * @param scr a scanner
     * @return the first valid value the user enters
     */
    public static int getValidInt( int min, int max, Scanner scr){
        boolean flag=true;
        int intValue = max + 1;
        System.out.println("Enter an integer between " + min + " and " + max + ":");
        while(flag){
            if (scr.hasNextInt()){
                intValue = scr.nextInt();
                if (intValue>=min && intValue<=max) {
                    flag = false;
                }
                else {
                    System.out.println("Invalid Entry. Please enter an integer between " + min + " and " + max + ":" );

                }
            }
            else {
                System.out.println("Invalid Entry. Please enter an integer between " + min + " and " + max + ":" );
                scr.next();
            }
        }
        return intValue;
    }

    /**
     * Prompts the user to enter a valid action type (A for Attack,M for Move,R for Recruit, T for ThrowSpear, or S for Spawn)
     * @param scr the scanner that gets the user input
     * @return nextAction returns character A,M,R,T, or S once the user inputs one of these values
     */
    public static char getUsersNextActionType(Scanner scr){
        char nextAction = 'F';
        boolean flag = true;
        System.out.println("Type A to attack, M to move, R to recruit, T to Throw Spear, or S to spawn");// New Action Modification
        while (flag){
            char userInput = scr.next().charAt(0);
            userInput = Character.toUpperCase(userInput);
            if (!(Character.isDigit(userInput))) {
                if (userInput == 'A' || userInput == 'M' || userInput == 'R' || userInput == 'T' || userInput == 'S') {// New Action Modification
                    nextAction = userInput;
                    flag = false;
                }
                else {
                    System.out.println("Invalid input. Please type A, M, R, or S");
                }
            }
        }
        return nextAction;
    }
    /**
     * Gets the action selected by the player who is next
     * @param game
     * @ return the next players action that was selected
     */

    public void getNextPlayersAction(GameS22 game){
        Scanner scr = new Scanner(System.in);
        this.action = getUsersNextActionType(scr);
        System.out.println("Enter the row index of the desired piece:");
        this.fromRow = getValidInt(0,game.board.getNumRows()-1,scr);
        System.out.println("Enter the column index of the desired piece:");
        this.fromColumn = getValidInt(0,game.board.getNumColumns()-1,scr);

        System.out.println("Enter the row index of the desired destination:");
        this.toRow = getValidInt(0,game.board.getNumRows()-1,scr);
        System.out.println("Enter the column index of the desired destination:");
        this.toColumn = getValidInt(0,game.board.getNumColumns()-1,scr);
    }
    /**
     prints the game to the screen
     */
    public void updateView(Game game){
        System.out.println(game);
    }

    /**
     * prints the game over message to the screem
     * @param game a game object
     */
    public void printEndOfGameMessage(Game game){
        System.out.println(
                "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" +
                "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n" +
                "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" +
                "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n" +
                "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" +
                "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" +
                "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" +
                "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n" +
                "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼\n" +
                "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                "WINNING TEAM: " + game.getWinner().getTeamColor());
    }
}

