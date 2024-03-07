import java.util.Scanner;

public class UserInterface {
private Scanner input;
private String userInput;

    public UserInterface() {
        input = new Scanner(System.in);
        userInput = "";
    }

    public void menu() {
        System.out.println("**** Welcome to the Adventure Game ****\n");
        System.out.println("PRESS: \nSTART GAME \nEXIT");
        String sentinel = "exit";
        userInput = input.nextLine();

        while(userInput.equalsIgnoreCase("start game") || userInput.equalsIgnoreCase("exit")) {
            if(userInput.equalsIgnoreCase("start game")) {
                startGame();
            } else {
                System.out.println("exiting...");
            }
        }

    }

    public void startGame() {
        String helpInfo="Enter north, south, east or west to navigate\n Enter 'look' for room description\n Enter 'Exit' to leave the game"
                String userInpt="";
        System.out.println(input.);
    }
}