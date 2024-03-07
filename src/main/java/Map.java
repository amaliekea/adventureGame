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
//first room
    private Room firstRoom;

    public Map() {
        room1 = new Room("Area ONE", "Desolate and lifeless area, nothing but dark sand around. In the distance you see a green area full of life in one direction and dry land in the other");
        room2 = new Room("Area TWO", "Beautiful, green area full of life. In the distance you see an open ocean area and a dark desert area");
        room3 = new Room("Area THREE", "Open ocean area full of life. In the distance you see a dense forest area and a green area full of life");
        room4 = new Room("Area FOUR", "Dry plain area devoid of life. In the distance you see a dark desert area and an area of rocks and cliffs");
        room5 = new Room("Area FIVE", "Dense alien-forest full of weird plants and animals. In the distance you see a large mountain");
        room6 = new Room("Area SIX", "Dark and dense forest area with scrub and questionable animal life. In the distance you see an open ocean area and a open meadow full of exotic flowers");
        room7 = new Room("Area SEVEN", "Rocky area with steep cliffs. In the distance you see a dry, desolate area and a large mountain");
        room8 = new Room("Area EIGHT", "Large mountain. In the distance you see a rocky cliff area, a dense alien-forest and an open meadow area");
        room9 = new Room("Area NINE", "Open meadow area full of exotic flowers. In the distance you see a dark, dense forest and a large mountain");

        firstRoom = room1;

        room1.setConnectionEast(room2);
        room1.setConnectionSouth(room4);

        room2.setConnectionEast(room3);
        room2.setConnectionWest(room1);

        room3.setConnectionSouth(room6);
        room3.setConnectionWest(room2);

        room4.setConnectionNorth(room1);
        room4.setConnectionSouth(room7);

        room5.setConnectionSouth(room8);

        room6.setConnectionNorth(room3);
        room6.setConnectionSouth(room9);

        room7.setConnectionNorth(room4);
        room7.setConnectionEast(room8);

        room8.setConnectionNorth(room5);
        room8.setConnectionEast(room9);
        room8.setConnectionWest(room7);

        room9.setConnectionNorth(room6);
        room9.setConnectionWest(room8);
    }

    public Room getFirstRoom() {
        return firstRoom;
    }
}