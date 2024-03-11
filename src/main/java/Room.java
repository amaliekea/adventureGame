import java.util.ArrayList;

public class Room {
    private String roomName;
    private String roomDescription;
    private Room connectionNorth;
    private Room connectionEast;
    private Room connectionSouth;
    private Room connectionWest;
    private ArrayList<Item> itemsInRoomArr = new ArrayList<>();

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

    public String getRoomDescription() { //udskriver description + hvilke items i rum
        StringBuilder itemsInRoomDescription = new StringBuilder();
        for (int i=0; i<itemsInRoomArr.size(); i++) {
            itemsInRoomDescription.append(itemsInRoomArr.get(i).getShortName());
            if(i< itemsInRoomArr.size()-1) {
                itemsInRoomDescription.append(" & ");
            }
        }
        if (itemsInRoomArr.isEmpty()) {
            itemsInRoomDescription = new StringBuilder("no items");
        }
        return roomDescription + "\nThis room contains: " + itemsInRoomDescription;
    }

    public void addItem(Item item) {
        itemsInRoomArr.add(item);
    }
    public Item removeItem(int i) {
        Item item = itemsInRoomArr.get(i);
        itemsInRoomArr.remove(i);
        return item;
    }
    public int searchItem(String itemDescription) { //søger efter objekt i rum
        int count = 0; //tæller antal items der opfylder search

        for (Item i: itemsInRoomArr) { //for hvert item objekt 'i' i itemInRoomArr
            if (i.getShortName().toLowerCase().contains(itemDescription.toLowerCase())) {
                return count;
            }
            count++;
        }
        return -1;
    }

    public ArrayList<Item> getItemInRoomArr() { //til at få items i array
        return itemsInRoomArr;
    }

    public void setItemInRoom(ArrayList<Item> itemInRoomArr) { //til at sætte items i arr
        this.itemsInRoomArr = itemInRoomArr;
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

}
