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
      //  inventoryArr.add(new Item("tester", "tester")); //tilføj items til player objekt
       // inventoryArr.add(new Item("sword", "A dusty sword"));
    }

    public ArrayList<Item> getInventory() {
        return inventoryArr;
    }
    public void removeItem(Item item) { //fjern items
        inventoryArr.remove(item);
    }
    public void addItem(Item item) {
        inventoryArr.add(item);
    }
    public void takeItem(Item item) {
        inventoryArr.add(item);
    }

    public ArrayList<Item> getInventoryArr() { //til at få items i array
        return inventoryArr;
    }
    public String showInventory() {
        String show = "";
        if (inventoryArr.isEmpty()) { //hvis det er tomt
            return ("Ur inventory is empty...");
        } else {
            for (Item item : inventoryArr) { //for hvert object item i ivetory
                show += (item.getShortName()) + ", "; //printer longname ud for hvert objekt
            }
            show = show.substring(0, show.length() - 2) + "."; // for at fjerne det sidste komma
        }
        return "you have collected " + show;
    }
    public void setItemInRoom(ArrayList<Item> itemInRoomArr) { //til at sætte items i arr
        this.inventoryArr = itemInRoomArr;
    }

    public String takeItem(String description) {
        int i = currentRoom.searchItem(description); {
            if (i < 0) {
                return "oops i couldn't find that item";
            } else {
                Item pickedUpItem= currentRoom.removeItem(i);
                inventoryArr.add(pickedUpItem);  //tilføjer item til players array
                return "items added succesfully" ;
            }
        }
    }
    public String dropItem(String drop) {
        Item item = findItemInInventory(drop);
        if (item != null) {
            inventoryArr.remove(item);
            currentRoom.addItem(item);
            return ("you dropped the " + item.getShortName());
        } else {
            return ("you dont have this " + drop + " in your inventory.");
        }
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



