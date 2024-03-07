public class Player {
    private Room currentRoom;

    public String currentRoom() {
        currentRoom = room1;
        return currentRoom.getDescription();
    }
}
