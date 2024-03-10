import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private String wayBlocked;
    private ArrayList<item> inventoryArr;

    public Player(Room firstRoom) {
        currentRoom = firstRoom;
        wayBlocked = "Can't go this way...";
        this.inventoryArr = new ArrayList<>();
    }
    public ArrayList<item> getInventory() {
        return inventoryArr;
    }
    public void addItem(item item) { //tilføj items
        this.inventoryArr.add(item);
    }
    public void removeItem(item item) { //fjern items
        inventoryArr.remove(item);
    }

    public ArrayList<item> getItemInRoomArr() { //til at få items i array
        return inventoryArr;
    }

    public void setItemInRoom(ArrayList<item> itemInRoomArr) { //til at sætte items i arr
        this.inventoryArr = itemInRoomArr;
    }
    public void takeItem(item item) {
        inventoryArr.add(item); //tilføjer item til array
        currentRoom.removeItem(item); //fjerner item fra currentroom
    }

    public void dropItem(item item) { //flytter et item method
        inventoryArr.remove(item); //fjerner item fra array
        currentRoom.addItem(item); //tilføjer derefter item til det rum man er i
    }
    public item findItemInInventory(String itemName) {
        for (item item : inventoryArr) { //iterer et item gennem hele inventory
            if (item.getShortName().equalsIgnoreCase(itemName)) { // hvis item er lig itemname
                return item; //retuner item hvis fundet
            }
        }
        return null;
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
