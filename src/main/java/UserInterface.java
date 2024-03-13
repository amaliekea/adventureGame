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
        System.out.println("PRESS: \nNEW GAME \nEXIT");
        String userInput = input.nextLine();

        while (!(userInput.isEmpty())) {
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else if (userInput.equalsIgnoreCase("new game")) {
                System.out.println("Starting new game....\n");
                startGame();
            }
            System.out.println("*** Input invalid *** \nPlease enter NEW GAME to start game or EXIT to end the program");
            userInput = input.nextLine();
        }

    }

    public void startGame() {
        String helpInfo = "Enter north, east, south or west to navigate \nEnter \"look\" to get room information \nEnter \"exit\" to quit the game";
        String exit = "Exiting game...";
        String question = "What do you wish to do?";
        String userInput;

        System.out.println("As your spacecraft descends onto the alien soil of a new planet, anticipation fills the air.");
        System.out.println("You step out into a world of surreal landscapes and unfamiliar sounds, the sky above swirling with colors unknown.");
        System.out.println("With every breath, you sense the adventure awaiting on this uncharted frontier.");
        System.out.println("Welcome, explorer, to the planet Anthoria.\n");

        System.out.println("If you wish to go forward, press ENTER. But beware of detours...");
        input.nextLine();
        System.out.println(adventure.getCurrentRoom());
        System.out.println(question);


        while (true) {
            userInput = input.nextLine().toLowerCase();

            switch (userInput.split(" ")[0]) {
                case "help" -> System.out.println(helpInfo);
                case "exit" -> {
                    System.out.println(exit);
                    System.exit(0);
                }
                case "look" -> {
                    System.out.println(adventure.lookPlayer());
                }
                case "take" -> {
                    String itemDescription = userInput.toLowerCase().substring(5);
                    System.out.println(adventure.takeItem(itemDescription));
                }
                case "inventory" -> {
                    System.out.println(adventure.showInventory());
                }
                case "drop" -> {
                    String itemToDrop = userInput.toLowerCase().substring(5);
                    System.out.println(adventure.dropItem(itemToDrop));
                }
                case "eat" -> {
                    String foodDescription = userInput.toLowerCase().substring(4);
                    System.out.println(adventure.eatFood(foodDescription));
                }
                case "north", "n", "go north" -> {
                    String message = adventure.player.movePlayerNorth();
                    System.out.println(message);
                }
                case "east", "e", "go east" -> {
                    String message = adventure.player.movePlayerEast();
                    System.out.println(message);
                }
                case "west", "w", "go west" -> {
                    String message = adventure.player.movePlayerWest();
                    System.out.println(message);
                }
                case "south", "s", "go south" -> {
                    String message = adventure.player.movePlayerSouth();
                    System.out.println(message);
                }
                default -> {
                    System.out.println("Invalid input");
                }
            }
        }

    }
}

