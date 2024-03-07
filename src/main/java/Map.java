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
        room1 = new Room("","", null, room2, room4, null);
        room2 = new Room("","", null, room3, null, room1);
        room3 = new Room("","", null, null, room6, room2);
        room4 = new Room("","", room1, null, room7, null);
        room5 = new Room("","", null, null, room8, null);
        room6 = new Room("","", room3, null, room9, null);
        room7 = new Room("","", room4, room8, null, null);
        room8 = new Room("","", room5, room9, null, room7);
        room9 = new Room("","", room6, null, null, room8);

        currentRoom = room1;
    }

}
