public class Map {
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;
    private Room currentRoom;

    public Map() {
        room1 = new Room("","");
        room2 = new Room("","");
        room3 = new Room("","");
        room4 = new Room("","");
        room5 = new Room("","");
        room6 = new Room("","");
        room7 = new Room("","");
        room8 = new Room("","");
        room9 = new Room("","");

        room1.setConnectionEast(room2);
        room1.setConnectionSouth(room4);

        room2.setConnectionEast(room3);
        room2.setConnectionWest(room1);

        room3.setConnectionSouth(room6);
        room3.setConnectionWest(room2);

        room4.setConnectionSouth(room7);
        room4.setConnectionNorth(room1);

        room5.setConnectionSouth(room8);

        room6.setConnectionSouth(room9);
        room6.setConnectionNorth(room3);

        room7.setConnectionEast(room8);
        room7.setConnectionNorth(room4);

        room8.setConnectionNorth(room5);
        room8.setConnectionEast(room9);
        room8.setConnectionWest(room7);

        room9.setConnectionNorth(room6);
        room9.setConnectionWest(room8);

        currentRoom = room1;
    }

}
