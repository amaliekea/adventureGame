import java.util.Scanner;

public class UserInterface {
    //Opretter Adventure klasse objekt og Scanner objekt
    Adventure adventure = new Adventure();
    Scanner input = new Scanner(System.in);

    //Opretter en startGame metode
    public void startGame(){

        //Opsætter et do-while loop, så vi kan bevæge os rundt i rummene (se movePlayer metode i Adventure klassen)

        String helpinfo = "Enter north, east, south or west to navigate" +
                "\nEnter \"look\" to get room information" +
                "\nEnter \"exit\" to quit the game";
        String wayBlocked = "Can't go this way...";
        String exit = "Exiting game...";
        String invalid = "Invalid user input. Please enter north, east, south or west";

        String userInput = "";
        System.out.println(adventure.roomNameAndDescription());

        while (!userInput.equalsIgnoreCase("exit")){
            userInput = input.nextLine();
            adventure.movePlayer(userInput, helpinfo, wayBlocked,
                    exit, invalid);
        }
    }
}
