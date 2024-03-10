import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room connectionNorth;
    private Room connectionEast;
    private Room connectionSouth;
    private Room connectionWest;
    private ArrayList<item> itemInRoomArr = new ArrayList<>(); //opretter arrayliste

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.connectionNorth = null;
        this.connectionEast = null;
        this.connectionSouth = null;
        this.connectionWest = null;
    }
    public void addItem(item item) { //tilføj items
        this.itemInRoomArr.add(item);
    }
    public void removeItem(item item) { //fjern items
        itemInRoomArr.remove(item);
    }

    public ArrayList<item> getItemInRoomArr() { //til at få items i array
        return itemInRoomArr;
    }

    public void setItemInRoom(ArrayList<item> itemInRoomArr) { //til at sætte items i arr
        this.itemInRoomArr = itemInRoomArr;
    }


    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getDescription() { //udskriver desciption + hvilke items i rum
        String desc="";
        for (int i=0; i<itemInRoomArr.size(); i++) {
            desc += itemInRoomArr.get(i).getShortName();
            if(i< itemInRoomArr.size()-1) {
                desc+=", ";
            }
        }
        if (itemInRoomArr.size()==0) {
            desc = "no items";
        }
        return description + "\n This room contains: "+ desc;
    }
    public Room getConnectionNorth() {
        return connectionNorth;
    }

    public void setDescription(String description) {
        this.description = description;
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
