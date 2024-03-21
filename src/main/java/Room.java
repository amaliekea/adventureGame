import java.util.ArrayList;

public class Room {
    private String roomName;
    private String roomDescription;
    private Room connectionNorth;
    private Room connectionEast;
    private Room connectionSouth;
    private Room connectionWest;
    private ArrayList<Item> itemsInRoomList = new ArrayList<>();
    private ArrayList<Enemy> enemiesInRoomList = new ArrayList<>();

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
        String enemyDescription = "";
        boolean hasItems;
        boolean hasEnemies;

        for (int i = 0; i < itemsInRoomList.size(); i++) {
            itemDescription = itemsInRoomList.get(i).getLongName();
            if (i < itemsInRoomList.size() - 1) {
                itemDescription += ", ";
            }
        }
        for (int i = 0; i < enemiesInRoomList.size(); i++) {
            enemyDescription = enemiesInRoomList.get(i).getType();
            if (i < enemiesInRoomList.size() - 1) {
                enemyDescription += ", ";
            }
        }
        hasItems = !itemsInRoomList.isEmpty();
        hasEnemies = !enemiesInRoomList.isEmpty();

        if (hasItems && hasEnemies)
            return roomDescription + "\nThis area contains: " + itemDescription + " & " + enemyDescription;
        if (hasItems) {
            return roomDescription + "\nThis area contains: " + itemDescription;
        }
        if (hasEnemies) {
            return roomDescription + "\nThis area contains: " + enemyDescription;
        }
        return roomDescription + "\nThis area is empty.";
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

    public Item removeItem(Item item) {
        itemsInRoomList.remove(item);
        return item;
    }

    public Item searchItem(String itemDescription) {
        for (Item item : itemsInRoomList) {
            if (item.getShortName().equalsIgnoreCase(itemDescription)) {
                return item;
            }
        }
        return null;
    }

    public void addEnemy(Enemy enemy) {
        enemiesInRoomList.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemiesInRoomList.remove(enemy);
    }

    public Enemy searchEnemy(String enemyDescription) {
        for (Enemy enemy : enemiesInRoomList) {
            if (enemy.getType().equalsIgnoreCase(enemyDescription)) {
                return enemy;
            }
        }
        return null;
    }
}
