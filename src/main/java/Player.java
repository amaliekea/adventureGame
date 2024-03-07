public class Player {
    private Map map;
    private String name;

    public Player(String name) {
        this.name = name;
        map = new Map();
    }

    public String currentRoomDescription() {
        return map.getCurrentRoom().getDescription();
    }

    public String movePlayer(Room room) {
        if(room.getConnectionNorth() != null) {
            map.setCurrentRoom(room.getConnectionNorth());
        } else if (room.getConnectionEast() != null) {
            map.setCurrentRoom(room.getConnectionEast());
        } else if (room.getConnectionSouth() != null) {
            map.setCurrentRoom(room.getConnectionSouth());
        } else if (room.getConnectionWest() != null) {
            map.setCurrentRoom(room.getConnectionWest());
        } else {
            return "Be careful, you cannot go that way";
        } return map.getCurrentRoom().getDescription();
    }

}


