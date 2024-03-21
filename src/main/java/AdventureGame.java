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
    public ArrayList<Item> getInventoryList() {
        return player.getInventoryList();
    }
    public String takeItem (String itemDescription) {
        return player.takeItem(itemDescription);
    }
    public String dropItem(String itemToDrop) {
        return player.dropItem(itemToDrop);
    }

    public String consumeItem(String itemDescription) {
        return player.consumeItem(itemDescription);
    }

    public String showInventory() {
        return player.showInventory();
    }

    public String lookPlayer() {
        return player.getCurrentRoom();
    }

    public String equipWeapon(String itemDescription) {
        return player.equipWeapon(itemDescription);
    }

    public String attackEnemy(String enemyDescription) {
        return player.attackEnemy(enemyDescription);
    }
}
