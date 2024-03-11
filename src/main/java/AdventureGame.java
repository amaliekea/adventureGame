import java.util.ArrayList;

public class AdventureGame {
    Player player;
    Map maps;


    public AdventureGame() {
        maps = new Map();
        player = new Player(maps.getFirstRoom());

    }
    public Player player() {
        // retuner Player instance
        return this.player;
    }

    public String getCurrentRoom() {
        return player.getCurrentRoom();
    }
    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }
    public ArrayList<Item> getInventoryArr() {
        return player.getInventoryArr();
    }
    public String takeItem (String description) {
        return player.takeItem(description);
    }



    public String lookPlayer() {
        return player.getCurrentRoom();
        //return player.currentRoomDescription();
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
           return player.getCurrentRoom();
        }
        return "";
    }
}