import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private String wayBlocked;
    private ArrayList<Item> inventoryArr;
    private String question = "Which way do you wish to travel?";

    public Player(Room firstRoom) {
        currentRoom = firstRoom;
        wayBlocked = "Be careful, you cannot go this way...";
        inventoryArr = new ArrayList<>();
    }
    public void addItem(Item item) { //tilføj items
        inventoryArr.add(item);
    }
    public void removeItem(Item item) { //fjern items
        inventoryArr.remove(item);
    }

    public ArrayList<Item> getItemInRoomArr() { //til at få items i array
        return inventoryArr;
    }

    public void setItemInRoom(ArrayList<Item> itemInRoomArr) { //til at sætte items i arr
        this.inventoryArr = itemInRoomArr;
    }
    public void takeItem(Item item) {
        inventoryArr.add(item); //tilføjer item til array
        currentRoom.removeItem(item); //fjerner item fra currentroom
    }

    public void dropItem(Item item) { //flytter et item method
        inventoryArr.remove(item); //fjerner item fra array
        currentRoom.addItem(item); //tilføjer derefter item til det rum man er i
    }
    public Item findItemInInventory(String itemName) {
        for (Item item : inventoryArr) { //iterer et item gennem hele inventory
            if (item.getShortName().equalsIgnoreCase(itemName)) { // hvis item er lig itemname
                return item; //retuner item hvis fundet
            }
        }
        return null;
    }
    public String getCurrentRoom() {
        return currentRoom.getName() + ": " + currentRoom.getDescription();
    }

    public String movePlayerNorth() { //har delt metoden op i 4
        if (currentRoom.getConnectionNorth() != null) {
            currentRoom = currentRoom.getConnectionNorth();
            return getCurrentRoom() + "\n" + question;
        } else {
            return wayBlocked;
        }
    }

    public String movePlayerEast() {
        if (currentRoom.getConnectionEast() != null) {
            currentRoom = currentRoom.getConnectionEast();
            return getCurrentRoom() + "\n" + question;
        } else {
            return wayBlocked;
        }
    }

    public String movePlayerWest() {
        if (currentRoom.getConnectionWest() != null) {
            currentRoom = currentRoom.getConnectionWest();
            return getCurrentRoom() + "\n" + question;
        } else {
            return wayBlocked;
        }
    }

    public String movePlayerSouth() {
        if (currentRoom.getConnectionSouth() != null) {
            currentRoom = currentRoom.getConnectionSouth();
            return getCurrentRoom() + "\n" + question;
        } else {
            return wayBlocked;
        }
    }
}



