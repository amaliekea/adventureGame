public class AdventureGame {
    Player player;
    Map maps;

    public AdventureGame() {
        maps = new Map();
        player = new Player(maps.getFirstRoom());
        //player.movePlayer(player.currentRoomDescription());

    }

    public String getCurrentRoom() {
        return player.currentRoomDescription();
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