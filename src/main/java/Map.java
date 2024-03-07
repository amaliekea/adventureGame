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
        room1 = new Room("Area ONE","Desolate and lifeless area, nothing but dark sand around. In the distance you see a green area full of life in one direction and dry land in the other", null, room2, room4, null);
        room2 = new Room("Area TWO","Beautiful, green area full of life. In the distance you see an open ocean area and a dark desert area", null, room3, null, room1);
        room3 = new Room("Area THREE","Open ocean area full of life. In the distance you see a dense forest area and a green area full of life", null, null, room6, room2);
        room4 = new Room("Area FOUR","Dry plain area devoid of life. In the distance you see a dark desert area and an area of rocks and cliffs", room1, null, room7, null);
        room5 = new Room("Area FIVE","Dense alien-forest full of weird plants and animals. In the distance you see a large mountain", null, null, room8, null);
        room6 = new Room("Area SIX","Dark and dense forest area with scrub and questionable animal life. In the distance you see an open ocean area and a open meadow full of exotic flowers", room3, null, room9, null);
        room7 = new Room("Area SEVEN","Rocky area with steep cliffs. In the distance you see a dry, desolate area and a large mountain", room4, room8, null, null);
        room8 = new Room("Area EIGHT","Large mountain. In the distance you see a rocky cliff area, a dense alien-forest and an open meadow area", room5, room9, null, room7);
        room9 = new Room("Area NINE","Open meadow area full of exotic flowers. In the distance you see a dark, dense forest and a large mountain", room6, null, null, room8);

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
