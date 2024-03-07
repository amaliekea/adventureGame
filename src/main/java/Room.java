public class Room {
    private String name;
    private String description;
    private Room connectionNorth;
    private Room connectionEast;
    private Room connectionSouth;
    private Room connectionWest;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        connectionNorth = null;
        connectionEast = null;
        connectionSouth = null;
        connectionWest = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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