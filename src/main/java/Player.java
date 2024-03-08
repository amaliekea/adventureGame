import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private String wayBlocked;
    ArrayList<item> itemObjekter;

    public Player(Room firstRoom) {
        currentRoom = firstRoom;
        wayBlocked = "Can't go this way...";
        itemObjekter = new ArrayList<>();
    }

    public String currentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String movePlayerNorth() { //har delt metoden op i 4
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



