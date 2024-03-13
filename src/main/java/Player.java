import java.util.ArrayList;

public class Player {
    private double playerHealthPoints;
    private Room currentRoom;
    private String wayBlocked;
    private ArrayList<Item> inventoryList;
    private String question = "What do you wish to do?";

    public Player(Room firstRoom) {
        currentRoom = firstRoom;
        wayBlocked = "Be careful, you cannot go this way...";
        inventoryList = new ArrayList<>();
    }

    public ArrayList<Item> getInventory() {
        return inventoryList;
    }

    public void removeItem(Item item) {
        inventoryList.remove(item);
    }

    public void addItem(Item item) {
        inventoryList.add(item);
    }

    public void takeItem(Item item) {
        inventoryList.add(item);
    }

    public ArrayList<Item> getInventoryList() {
        return inventoryList;
    }

    public String showInventory() {
        String showItems = "";
        if (inventoryList.isEmpty()) {
            return ("Your inventory is empty...");
        } else {
            for (Item item : inventoryList) {
                showItems += (item.getShortName()) + ", ";
            }
            showItems = showItems.substring(0, showItems.length() - 2) + "."; //Fjerner det sidste komma
        }
        return "You have collected: " + showItems;
    }

    public void setItemInRoom(ArrayList<Item> itemInRoomList) {
        this.inventoryList = itemInRoomList;
    }

    public String takeItem(String itemDescription) {
        int i = currentRoom.searchItem(itemDescription);
        {
            if (i < 0) {
                return "The item you are looking for is not in this room";
            } else {
                Item collectedItem = currentRoom.removeItem(i);
                inventoryList.add(collectedItem);
                return collectedItem.getShortName() + " is now part of your inventory";
            }
        }
    }

    public String dropItem(String itemToDrop) {
        Item item = findItemInInventory(itemToDrop);
        if (item != null) {
            inventoryList.remove(item);
            currentRoom.addItem(item);
            return ("You dropped the " + item.getShortName());
        } else {
            return ("You dont have this " + itemToDrop + " in your inventory");
        }
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventoryList) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public String eatFood(String foodDescription) {
        int i = currentRoom.searchItem(foodDescription);
        if (i < 0) {
            return "The food you are looking for is not in this room";
        } else if (currentRoom.removeItem(i) instanceof Food food) {
            if (food.isEdible()) {
                playerHealthPoints += food.getHealthPoints();
                return "You have eaten the " + foodDescription + " and your health is now " + playerHealthPoints + " points";
            } else {
                return "The " + foodDescription + " is not edible";
            }
        }
        return "You can't eat this";
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
}
