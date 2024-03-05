public class Adventure {
    Rooms room1;
    Rooms room2;
    Rooms room3;
    Rooms room4;
    Rooms room5;
    Rooms room6;
    Rooms room7;
    Rooms room8;
    Rooms room9;

    private Rooms currentRoom;

    //Constructor is set to room1 for the starting point
    public Adventure(){
        room1 = new Rooms("\"Dungeon\": " , "Dark place where light is dim");
        room2 = new Rooms("\"Prison\": " , "Dark place where light is dim");
        room3 = new Rooms("\"Cave\": " , "Dark place where light is dim");
        room4 = new Rooms("\"Forest\": " , "Dark place where light is dim");
        room5 = new Rooms("\"Creek\": " , "Dark place where light is dim");
        room6 = new Rooms("\"Sprawling City\": " , "Dark place where light is dim");
        room7 = new Rooms("\"Castle\": " , "Dark place where light is dim");
        room8 = new Rooms("\"Basement\": " , "Dark place where light is dim");
        room9 = new Rooms("\"Catacombs\": " , "Dark place where light is dim");

        room1.setE(room2);
        room1.setS(room4);

        room2.setE(room3);
        room2.setW(room1);

        room3.setS(room6);
        room3.setW(room2);

        room4.setN(room1);
        room4.setS(room7);

        room5.setS(room8);

        room6.setS(room9);
        room6.setN(room3);

        room7.setN(room4);
        room7.setE(room8);

        room8.setN(room5);
        room8.setE(room9);
        room8.setW(room7);

        room9.setN(room6);
        room9.setW(room8);

        currentRoom = room1;
    }

    //Metoden tager parameteren String userinput, som bruges til at tage brugerinput og skifte mellem hver case alt efter hvad brugeren indtaster.

    public void movePlayer (String userInput) {


        switch (userInput) {

            case "north":
                if (currentRoom.getN() != null) {
                    currentRoom = currentRoom.getN();
                }
                break;

            case "east":
                if (currentRoom.getE() != null) {
                    currentRoom = currentRoom.getE();
                }
                break;

            case "west":
                if (currentRoom.getW() != null) {
                    currentRoom = currentRoom.getW();
                }
                break;

            case "south":
                if (currentRoom.getS() != null) {
                    currentRoom = currentRoom.getS();
                }
                break;

            case "look":

                break;

            default:
                System.out.println("Invalid user input. Please enter north, east, south or west");
                break;
            }


    }

    public String roomNameAndDescription(){
        return currentRoom.getName() + currentRoom.getDescription();
    }
//    public Rooms getRoom(){
//        return currentRoom
//    }

}
