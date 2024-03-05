import java.util.Scanner;

public class UserInterface {
    //Opretter Adventure klasse objekt og Scanner objekt
    Adventure adventure = new Adventure();
    Scanner input = new Scanner(System.in);
    String userInput = "";
    int sentinel = 2;

    public void menu() {
        System.out.println("*** Welcome to the Adventure Game! ***\n");
        System.out.println("1. NEW GAME \n2. EXIT");

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

    //Opretter en startGame metode
    public void startGame() {

        //Opsætter et do-while loop, så vi kan bevæge os rundt i rummene (se movePlayer metode i Adventure klassen)

        System.out.println(adventure.roomNameAndDescription());

        while (!userInput.equalsIgnoreCase("exit")) {
            userInput = input.nextLine();
            adventure.movePlayer(userInput);
        }
    }
}

