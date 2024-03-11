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
    public ArrayList<Item> getInventory() {
        return inventoryArr;
    }
    public void removeItem(Item item) {
        inventoryArr.remove(item);
    }

    public ArrayList<Item> getItemInRoomArr() {
        return inventoryArr;
    }

    public void setItemInRoom(ArrayList<Item> itemInRoomArr) {
        this.inventoryArr = itemInRoomArr;
    }
    public String takeItem(String itemDescription) {
        int i = currentRoom.searchItem(itemDescription); {
            if (i < 0) {
                return "The " + itemDescription + " is not in your inventory";
            } else {
                Item itemCollected = currentRoom.removeItem(i);
                inventoryArr.add(itemCollected);
                return itemDescription + " added to your inventory successfully";
            }
        }
    }

    public void dropItem(Item item) {
        inventoryArr.remove(item);
        currentRoom.addItem(item);
    }
    public Item findItemInInventory(String itemName) {
        for (Item item : inventoryArr) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    public String getCurrentRoom() {
        return currentRoom.getRoomName() + ": " + currentRoom.getRoomDescription();
    }

    public String movePlayerNorth() {
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


    public String movePlayer(String userInput) {
        if (isValidInput(userInput)) {
            switch (userInput.toLowerCase()) {
                case "n":
                    return movePlayerNorth();
                case "e":
                    return movePlayerEast();
                case "s":
                    return movePlayerSouth();
                case "w":
                    return movePlayerWest();
                case "look":
                    return getCurrentRoom();
            }
        }
        return "Invalid input";
    }

    private boolean isValidInput(String userInput) {
        return userInput.equalsIgnoreCase("n") ||
                userInput.equalsIgnoreCase("e") ||
                userInput.equalsIgnoreCase("s") ||
                userInput.equalsIgnoreCase("w") ||
                userInput.equalsIgnoreCase("look");
    }
}





