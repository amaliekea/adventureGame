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

        room1.setEastConnection(room2);
        room1.setSouthConnection(room4);

        room2.setEastConnection(room3);
        room2.setWestConnection(room1);

        room3.setSouthConnection(room6);
        room3.setWestConnection(room2);

        room4.setNorthConnection(room1);
        room4.setSouthConnection(room7);

        room5.setSouthConnection(room8);

        room6.setSouthConnection(room9);
        room6.setNorthConnection(room3);

        room7.setNorthConnection(room4);
        room7.setEastConnection(room8);

        room8.setNorthConnection(room5);
        room8.setEastConnection(room9);
        room8.setWestConnection(room7);

        room9.setNorthConnection(room6);
        room9.setWestConnection(room8);

        currentRoom = room1;
    }

    //Metoden tager parameteren String userinput, som bruges til at tage brugerinput og skifte mellem hver case alt efter hvad brugeren indtaster.

    public void movePlayer (String userInput) {


        switch (userInput) {

            case "north":
                if (currentRoom.getNorthConnection() != null) {
                    currentRoom = currentRoom.getNorthConnection();
                } else {
                    System.out.println("Can't go this way...");
                }
                break;

            case "east":
                if (currentRoom.getEastConnection() != null) {
                    currentRoom = currentRoom.getEastConnection();
                } else {
                    System.out.println("Can't go this way...");
                }
                break;

            case "west":
                if (currentRoom.getWestConnection() != null) {
                    currentRoom = currentRoom.getWestConnection();
                } else {
                    System.out.println("Can't go this way...");
                }
                break;

            case "south":
                if (currentRoom.getSouthConnection() != null) {
                    currentRoom = currentRoom.getSouthConnection();
                } else {
                    System.out.println("Can't go this way...");
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
