public class Player {
    private Room currentRoom;

    public Player(Room firstRoom) {
        currentRoom = firstRoom;
    }

    public String currentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String movePlayer(String userInput) {
        String wayBlocked = "Can't go this way...";


        if (userInput.equalsIgnoreCase("n")) {
            if (currentRoom.getConnectionNorth() != null) {
                currentRoom = currentRoom.getConnectionNorth();
                return currentRoom.getDescription();
            } else {
                return wayBlocked;
            }
        } else if (userInput.equalsIgnoreCase("e")) {
            if (currentRoom.getConnectionEast() != null) {
                currentRoom = currentRoom.getConnectionEast();
                return currentRoom.getDescription();
            } else {
                return wayBlocked;
            }
        } else if (userInput.equalsIgnoreCase("w")) {
            if (currentRoom.getConnectionWest() != null) {
                currentRoom = currentRoom.getConnectionWest();
                return currentRoom.getDescription();
            } else {
                return wayBlocked;
            }
        } else if (userInput.equalsIgnoreCase("s")) {
            if (currentRoom.getConnectionSouth() != null) {
                currentRoom = currentRoom.getConnectionSouth();
                return currentRoom.getDescription();
            } else {
                return wayBlocked;
            }
        } else if (userInput.equalsIgnoreCase("look")) {
            return currentRoom.getDescription();
        }
return "";
    }
}


