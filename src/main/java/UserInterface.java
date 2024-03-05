import java.util.Scanner;

public class UserInterface {
    //Opretter Adventure klasse objekt og Scanner objekt
    Adventure adventure = new Adventure();
    Scanner input = new Scanner(System.in);

    //Opretter en startGame metode
    public void startGame(){

        //Opsætter et do-while loop, så vi kan bevæge os rundt i rummene (se movePlayer metode i Adventure klassen)

        String userInput = "";
        System.out.println(adventure.roomNameAndDescription());

        while (!userInput.equalsIgnoreCase("exit")){
            userInput = input.nextLine();
            adventure.movePlayer(userInput);
        }
    }
}
