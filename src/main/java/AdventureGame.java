import java.util.ArrayList;

public class AdventureGame {
    Player player;
    Map maps;


    public AdventureGame() {
        maps = new Map();
        player = new Player(maps.getFirstRoom());
        //player.movePlayer(player.currentRoomDescription());

    }
    public Player player() {
        // retuner Player instance
        return this.player;
    }

    public String getCurrentRoom() {
        return player.currentRoomDescription();
    }
    public ArrayList<item> getInventory() {
        return player.getInventory();
    }

    public String movePlayer(String userInput) {
        if (userInput.equalsIgnoreCase("n")) {
           return player.movePlayerNorth();
        } else if (userInput.equalsIgnoreCase("e")) {
           return player.movePlayerEast();
        } else if (userInput.equalsIgnoreCase("s")) {
           return player.movePlayerSouth();
        } else if (userInput.equalsIgnoreCase("w")) {
           return player.movePlayerWest();
        } else if (userInput.equalsIgnoreCase("look")) {
           return player.currentRoomDescription();
        }
        return "";
    }
}