import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    private String userInput;
    private AdventureGame adventure;
    private Scanner input;
    public UserInterface() {
        adventure = new AdventureGame();
        input = new Scanner(System.in);
    }


    public void menu() {
        System.out.println("*** Welcome to the Adventure Game! ***\n");
        System.out.println("1. NEW GAME \n2. EXIT");
        int sentinel = 2;



            int userInput = Integer.parseInt(input.nextLine());

        while (userInput != sentinel) {
            if (userInput < 0 || userInput > 4) {
                System.out.println("*** Input invalid *** \nPlease enter 1 to start game, 2 to resume game or 3 to exit");
                userInput = Integer.parseInt(input.nextLine());
            } else if (userInput == 1) {
                System.out.println("Starting new game....\n");
                startGame();
                return;
            }
            System.out.println("Exiting....\n");
        }

    }
    public void startGame(){

        //Opsætter et do-while loop, så vi kan bevæge os rundt i rummene (se movePlayer metode i Adventure klassen)

        String helpinfo = "Enter north, east, south or west to navigate" +
                "\nEnter \"look\" to get room information" +
                "\nEnter \"exit\" to quit the game";
        String exit = "Exiting game...";

        String userInput = "";
        System.out.println(adventure.getCurrentRoom());

        ArrayList<item> inventoryArr = adventure.getInventory();
        System.out.println("Your inventory contains these items: ");
        for (item invItem : inventoryArr) {
            System.out.println("Item short name: " + invItem.getShortName());
        }

            while (!userInput.equalsIgnoreCase("exit")) {
            userInput = input.nextLine();
            userInput=parseInput(userInput);
            if (userInput == null) {
                System.out.println("Invalid user input. Please enter north, east, south or west...");
            } else {
                if (userInput.equalsIgnoreCase("help")) {
                    System.out.println(helpinfo);
                }
                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting game...");
                    return;
                } else {
                    String message = adventure.movePlayer(userInput);
                    System.out.println(message);
                }
            }
        }
    }
    String parseInput(String userInput) { //delt op da det tager alt brugerinput
        if (userInput.equalsIgnoreCase("exit")) { //hvis bruger input lig exit
            return "exit"; //hvis det er retuner exit
        }
        if (userInput.equalsIgnoreCase("look") || userInput.equalsIgnoreCase("l")) {
            return "look";
        }
        if (userInput.equalsIgnoreCase("help") || userInput.equalsIgnoreCase("h")){
            return "help";
        }
        if (userInput.equalsIgnoreCase("north") || userInput.equalsIgnoreCase("n")
                || userInput.equalsIgnoreCase("go north")) {
            return "n";
        }
        if (userInput.equalsIgnoreCase("east") || userInput.equalsIgnoreCase("e")
                || userInput.equalsIgnoreCase("go east")) {
            return "e";
        }
        if ((userInput.equalsIgnoreCase("west") || userInput.equalsIgnoreCase("w")
                || userInput.equalsIgnoreCase("go west"))) {
            return "w";
        }
        if (userInput.equalsIgnoreCase("south") || userInput.equalsIgnoreCase("s")
                || userInput.equalsIgnoreCase("go south")) {
            return "s";
        }
        if (userInput.equalsIgnoreCase("help") || userInput.equalsIgnoreCase("help me") || userInput.equalsIgnoreCase("info") || userInput.equalsIgnoreCase("h")) {
            return "help";
        }
        return "";
    }
}