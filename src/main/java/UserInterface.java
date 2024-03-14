import java.util.Scanner;

public class UserInterface {
    private AdventureGame adventure;
    private Scanner input;

    public UserInterface() {
        adventure = new AdventureGame();
        input = new Scanner(System.in);
    }

    public void menu() {

        System.out.println("✦✦✦✦✦✦ WELCOME TO THE ADVENTURE GAME ✦✦✦✦✦✦");
        System.out.println("_______________________________________________");
        System.out.println("|      NEW GAME      - Starts a new game      |");
        System.out.println("|      EXIT          - Exits the program      |");
        System.out.println("-----------------------------------------------");
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

    public void commands() {
        System.out.println("Commands:");
        System.out.println("GO <direction>  - Move in the specified direction (e.g., 'go north', 'go west'). You can also use N, S, E, and W.");
        System.out.println("EXIT            - Exit the program.");
        System.out.println("LOOK            - Take another look around the room.");
        System.out.println("TAKE <item>     - Pick up an object from a room (e.g., 'take knife').");
        System.out.println("DROP <item>     - Drop an item inside a room (e.g., 'drop knife').");
        System.out.println("EAT <item>      - Consume an item for health (e.g., 'eat apple').");
        System.out.println("INVENTORY       - View items in your inventory.\n");
    }

    public void startGame() {
        String exit = "Exiting game...";
        String question = "What do you wish to do?";
        String userInput;

        System.out.println("As your spacecraft descends onto the alien soil of a new planet, anticipation fills the air.");
        System.out.println("You step out into a world of surreal landscapes and unfamiliar sounds, the sky above swirling with colors unknown.");
        System.out.println("With every breath, you sense the adventure awaiting on this uncharted frontier.");
        System.out.println("Welcome, explorer, to the planet Anthoria.\n");

        commands();

        System.out.println("If you wish to go forward, press ENTER. But beware of detours...");
        input.nextLine();
        System.out.println(adventure.getCurrentRoom());
        System.out.println(question);


        while (true) {
            userInput = input.nextLine().toLowerCase();

            switch (userInput.split(" ")[0]) {

                case "help" -> commands();
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
                case "drink" -> {
                    String liquidDescription = userInput.toLowerCase().substring(6);
                    System.out.println(adventure.drinkLiquid(liquidDescription));
                }
                case "go" -> {
                    String direction = userInput.split(" ", 2)[1];
                    switch (direction) {
                        case "n", "north" -> {
                            String message = adventure.player.movePlayerNorth();
                            System.out.println(message);
                        }
                        case "e", "east" -> {
                            String message = adventure.player.movePlayerEast();
                            System.out.println(message);
                        }
                        case "w", "west" -> {
                            String message = adventure.player.movePlayerWest();
                            System.out.println(message);
                        }
                        case "s", "south" -> {
                            String message = adventure.player.movePlayerSouth();
                            System.out.println(message);
                        }

                    }
                }
                default -> System.out.println("Invalid input, press HELP if you need to revisit the command menu");
            }
        }
    }
}

