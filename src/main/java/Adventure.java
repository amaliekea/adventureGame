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
    public Adventure() {
        room1 = new Rooms("\"Dungeon\": ", "You land in a desolate desert dungeon, with nothing in sight except two doors");
        room2 = new Rooms("\"Prison\": ", "Iron bars that surround you, try to get out, there are two detours");
        room3 = new Rooms("\"Cave\": ", "Open cave with animal life surrounding your feet, two possibilities");
        room4 = new Rooms("\"Forest\": ", "Dry plain forest completely devoid of life, two doors");
        room5 = new Rooms("\"Creek\": ", "Dense vegetation of alien coming up from the lake, there is only one way out");
        room6 = new Rooms("\"Sprawling City\": ", "Poisonous animals living inside, except two roads");
        room7 = new Rooms("\"Castle\": ", "Dark palace where light is dim");
        room8 = new Rooms("\"Basement\": ", "Dark place with steep clips, rocks falling down");
        room9 = new Rooms("\"Catacombs\": ", "Skulls buried all around you");

        room1.setEastConnection(room2); //adgang fra 1
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

    public String movePlayer(String userInput) {
        String wayBlocked = "Can't go this way...";


        if (userInput.equalsIgnoreCase("n")) {
            if (currentRoom.getNorthConnection() != null) {
                currentRoom = currentRoom.getNorthConnection();
                return roomNameAndDescription();
            } else {
                return wayBlocked;
            }
        } else if (userInput.equalsIgnoreCase("e")) {
            if (currentRoom.getEastConnection() != null) {
                currentRoom = currentRoom.getEastConnection();
                return roomNameAndDescription();
            } else {
                return wayBlocked;
            }
        } else if (userInput.equalsIgnoreCase("w")) {
            if (currentRoom.getWestConnection() != null) {
                currentRoom = currentRoom.getWestConnection();
                return roomNameAndDescription();
            } else {
                return wayBlocked;
            }
        } else if (userInput.equalsIgnoreCase("s")) {
            if (currentRoom.getSouthConnection() != null) {
                currentRoom = currentRoom.getSouthConnection();
                return roomNameAndDescription();
            } else {
                return wayBlocked;
            }
        } else if (userInput.equalsIgnoreCase("look")) {
            return roomNameAndDescription(); //kan ikke håndteres i ui, da den retunerer roomnameand di
        }

//        switch (userInput) {
//
//            case "north":
//                if (currentRoom.getNorthConnection() != null) {
//                    currentRoom = currentRoom.getNorthConnection();
//                    System.out.println(roomNameAndDescription());
//                } else {
//                    System.out.println("Can't go this way...");
//                }
//                break;
//
//            case "east":
//                if (currentRoom.getEastConnection() != null) {
//                    currentRoom = currentRoom.getEastConnection();
//                    System.out.println(roomNameAndDescription());
//                } else {
//                    System.out.println("Can't go this way...");
//                }
//                break;
//
//            case "west":
//                if (currentRoom.getWestConnection() != null) {
//                    currentRoom = currentRoom.getWestConnection();
//                    System.out.println(roomNameAndDescription());
//                } else {
//                    System.out.println("Can't go this way...");
//                }
//                break;
//
//            case "south":
//                if (currentRoom.getSouthConnection() != null) {
//                    currentRoom = currentRoom.getSouthConnection();
//                    System.out.println(roomNameAndDescription());
//                } else {
//                    System.out.println("Can't go this way...");
//                }
//                break;
//
//            case "look":
//                System.out.println(roomNameAndDescription());
//                break;
//            case "help":
//                System.out.println("Enter north, east, south or west to navigate");
//                System.out.println("Enter \"look\" to get room information");
//                System.out.println("Enter \"exit\" to quit the game");
//                break;
//
//            default:
//                if(userInput.equalsIgnoreCase("exit")) {
//                    break;
//                }else {
//                    System.out.println("Invalid user input. Please enter north, east, south or west");
//                    break;
//                }
//            }

        return null;
    }


    public String roomNameAndDescription(){
        return currentRoom.getName() + currentRoom.getDescription();
    }
//    public Rooms getRoom(){
//        return currentRoom
//    }

}
