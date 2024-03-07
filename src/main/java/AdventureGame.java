public class AdventureGame {
    Player player;
    Map maps;
    public AdventureGame() {
        maps = new Map();
        player = new Player(maps.getFirstRoom());
        player.movePlayer(player.currentRoomDescription());

    }
public String getCurrentRoom() {
    return player.currentRoomDescription();
}

public String movePlayer(String userInput) {
        return player.movePlayer(userInput);
}

}