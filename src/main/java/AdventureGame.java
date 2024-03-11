import java.util.ArrayList;

public class AdventureGame {
    Player player;
    Map maps;


    public AdventureGame() {
        maps = new Map();
        player = new Player(maps.getFirstRoom());

    }

    public String getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public String takeItem(String description) {
        return player.takeItem(description);
    }

    public String lookPlayer() {
        return player.getCurrentRoom();
    }

    public String movePlayer(String userInput) {
        return player.movePlayer(userInput);
    }
}
