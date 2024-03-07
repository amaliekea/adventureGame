public class Player {
    private Room currentRoom;
    private String wayBlocked;

    public Player(Room firstRoom) {
        currentRoom = firstRoom;
        wayBlocked = "Can't go this way...";
    }

    public String currentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String movePlayerNorth() {
        if (currentRoom.getConnectionNorth() != null) {
            currentRoom = currentRoom.getConnectionNorth();
            return currentRoom.getDescription();
        } else {
            return wayBlocked;
        }
    }

    public String movePlayerEast() {
        if (currentRoom.getConnectionEast() != null) {
            currentRoom = currentRoom.getConnectionEast();
            return currentRoom.getDescription();
        } else {
            return wayBlocked;
        }
    }

    public String movePlayerWest() {
        if (currentRoom.getConnectionWest() != null) {
            currentRoom = currentRoom.getConnectionWest();
            return currentRoom.getDescription();
        } else {
            return wayBlocked;
        }
    }

    public String movePlayerSouth() {
        if (currentRoom.getConnectionSouth() != null) {
            currentRoom = currentRoom.getConnectionSouth();
            return currentRoom.getDescription();
        } else {
            return wayBlocked;
        }
    }
}



