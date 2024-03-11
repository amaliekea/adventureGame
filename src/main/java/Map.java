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
    private Room firstRoom;

    public Map() {
        room1 = new Room("AREA ONE", "You are in a desolate and lifeless area, nothing but dark sand around. In the distance you see a green area full of life in one direction and dry land in the other.");
        room2 = new Room("AREA TWO", "You are in a beautiful, green area full of life. In the distance you see an open ocean area in one direction and a dark desert area in the other.");
        room3 = new Room("AREA THREE", "You are in an open ocean area full of life. In the distance you see a dense forest area in one direction and a green area full of life in the other.");
        room4 = new Room("AREA FOUR", "You are in a dry plain area devoid of life. In the distance you see a dark desert area in one direction and an area of rocks and cliffs in the other.");
        room5 = new Room("AREA FIVE", "You are in a dense alien-forest full of weird plants and animals. In the distance you see a large mountain.");
        room6 = new Room("AREA SIX", "You are in a dark and dense forest area with scrub and questionable animal life. In the distance you see an open ocean area in one direction and an open meadow full of exotic flowers in the other.");
        room7 = new Room("AREA SEVEN", "You are in a rocky area with steep cliffs. In the distance you see a dry, desolate area in one direction and a large mountain in the other.");
        room8 = new Room("AREA EIGHT", "You are by a large mountain. In the distance you see a rocky cliff area in one direction, a dense alien-forest in another and an open meadow area a third.");
        room9 = new Room("AREA NINE", "You are in an open meadow area full of exotic flowers. In the distance you see a dark, dense forest in one direction and a large mountain in the other.");

        firstRoom = room1;

        room1.setConnectionEast(room2);
        room1.setConnectionSouth(room4);

        room2.setConnectionWest(room1);
        room2.setConnectionEast(room3);

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

        room1.addItem(new Item("a shiny lamp", "lamp"));
        room1.addItem(new Item("a dangerous animal", "animal"));
        room2.addItem(new Item("a gold knife","knife"));
        room3.addItem(new Item("a diamond pickaxe","pickaxe"));
    }

    public Room getFirstRoom() {
        return firstRoom;
    }
}