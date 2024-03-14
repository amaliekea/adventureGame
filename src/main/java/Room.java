import java.util.ArrayList;

public class Room {
    private String roomName;
    private String roomDescription;
    private Room connectionNorth;
    private Room connectionEast;
    private Room connectionSouth;
    private Room connectionWest;
    private ArrayList<Item> itemsInRoomList = new ArrayList<>();

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        connectionNorth = null;
        connectionEast = null;
        connectionSouth = null;
        connectionWest = null;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        String itemDescription = "";
        for (int i = 0; i < itemsInRoomList.size(); i++) {
            itemDescription += itemsInRoomList.get(i).getLongName();
            if (i < itemsInRoomList.size() - 1) {
                itemDescription += ", ";
            }
        }
        if (!itemsInRoomList.isEmpty()) {
            return roomDescription + "\nThis room contains: " + itemDescription;
        }
        return itemDescription = "This room contains no items";
    }

    public Room getConnectionNorth() {
        return connectionNorth;
    }

    public void setConnectionNorth(Room connectionNorth) {
        this.connectionNorth = connectionNorth;
    }

    public Room getConnectionEast() {
        return connectionEast;
    }

    public void setConnectionEast(Room connectionEast) {
        this.connectionEast = connectionEast;
    }

    public Room getConnectionSouth() {
        return connectionSouth;
    }

    public void setConnectionSouth(Room connectionSouth) {
        this.connectionSouth = connectionSouth;
    }

    public Room getConnectionWest() {
        return connectionWest;
    }

    public void setConnectionWest(Room connectionWest) {
        this.connectionWest = connectionWest;
    }

    public void addItem(Item item) {
        itemsInRoomList.add(item);
    }

    public Item removeItem(int i) {
        Item item = itemsInRoomList.get(i);
        itemsInRoomList.remove(i);
        return item;
    }

    public int searchItem(String itemDescription) {
        int count = 0;

        for (Item i : itemsInRoomList) {
            if (i.getShortName().toLowerCase().contains(itemDescription.toLowerCase())) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
