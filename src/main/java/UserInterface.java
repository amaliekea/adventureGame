import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
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

        String helpInfo = "Enter north, east, south or west to navigate \nEnter \"look\" to get room information \nEnter \"exit\" to quit the game";
        String exit = "Exiting game...";

        String userInput = "";
        System.out.println("As your spacecraft descends onto the alien soil of a new planet, anticipation fills the air. \nYou step out into a world of surreal landscapes and unfamiliar sounds, the sky above swirling with colors unknown. \nWith every breath, you sense the adventure awaiting on this uncharted frontier. \nWelcome, explorer, to the planet Anthoria.\n");
        System.out.println("If you wish to go forward, press any key followed my enter. But beware of detours...");
        input.next();
        System.out.println(adventure.getCurrentRoom());
        System.out.println("Which way do you wish to travel?");

            while (!userInput.equalsIgnoreCase("exit")) {
            userInput = input.nextLine();
            if (userInput == null) {
                System.out.println("Invalid user input. Please enter north, east, south or west...");
            } else {
                if (userInput.equalsIgnoreCase("help")) {
                    System.out.println(helpInfo);
                }
                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println(exit);
                else if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting game...");
                    return;
                }
                else if (userInput.equalsIgnoreCase("look")) {
                    System.out.println(adventure.lookPlayer());
                }
                else if (userInput.toLowerCase().startsWith("take")) {
                    String itemdescription = userInput.toLowerCase().substring(5);//remove take and leave description
                    System.out.println(adventure.takeItem(itemdescription));
                } else {
                   userInput=parseInput(userInput);
                   String message = adventure.movePlayer(userInput);
                    System.out.println(message);
                }
            }
        }
    }
    public String parseInput(String userInput) { //delt op da det tager alt brugerinput
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