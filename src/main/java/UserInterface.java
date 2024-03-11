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
            }
            System.out.println("Exiting....\n");
        }

    }

    public void startGame() {
        String helpInfo = "Enter north, east, south, or west to navigate.\nEnter \"look\" to get room information.\nEnter \"exit\" to quit the game.";
        String exit = "Exiting game...";

        System.out.println("As your spacecraft descends onto the alien soil of a new planet, anticipation fills the air.");
        System.out.println("You step out into a world of surreal landscapes and unfamiliar sounds, the sky above swirling with colors unknown.");
        System.out.println("With every breath, you sense the adventure awaiting on this uncharted frontier.");
        System.out.println("Welcome, explorer, to the planet Anthoria.\n");

        System.out.println("If you wish to go forward, press ENTER. But beware of detours...");
        input.nextLine();
        System.out.println(adventure.getCurrentRoom());
        System.out.println("What do you wish to do?");

        String userInput;

        while (true) {
            userInput = input.nextLine().toLowerCase();

            switch (userInput) {
                case "help" -> {
                    System.out.println(helpInfo);
                }
                case "exit" -> {
                    System.out.println(exit);
                }
                case "look" -> {
                    System.out.println(adventure.lookPlayer());
                }
                default -> {
                    userInput = parseInput(userInput);
                    String message = adventure.movePlayer(userInput);
                    System.out.println(message);
                }
            }
        }
    }

    public String parseInput(String userInput) {
        switch (userInput.toLowerCase()) {
            case "north", "n", "go north" -> {
                return "n";
            }
            case "east", "e", "go east" -> {
                return "e";
            }
            case "west", "w", "go west" -> {
                return "w";
            }
            case "south", "s", "go south" -> {
                return "s";
            }
            default -> {
                return "";
            }
        }
    }
}