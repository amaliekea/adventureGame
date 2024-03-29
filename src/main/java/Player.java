import java.util.ArrayList;

public class Player {
    private int playerHealthPoints;
    private Room currentRoom;
    private String wayBlocked = "Be careful, you cannot go this way...";
    private String question = "What do you wish to do?";
    private ArrayList<Item> inventoryList;

    public Player(Room firstRoom) {
        currentRoom = firstRoom;
        inventoryList = new ArrayList<>();
        playerHealthPoints = 150;
    }

    public ArrayList<Item> getInventory() {
        return inventoryList;
    }

    public void removeItem(Item item) {
        inventoryList.remove(item);
    }

    public void addItem(Item item) {
        inventoryList.add(item);
    }

    public ArrayList<Item> getInventoryList() {
        return inventoryList;
    }

    public String showInventory() {
        String showItems = "";
        if (inventoryList.isEmpty()) {
            return ("Your inventory is empty...");
        } else {
            for (Item item : inventoryList) {
                showItems += (item.getShortName()) + ", ";
            }
            showItems = showItems.substring(0, showItems.length() - 2) + "."; //Fjerner det sidste komma
        }
        return "You have collected: " + showItems;
    }

    public String takeItem(String itemDescription) {
        Item item = currentRoom.searchItem(itemDescription);
        {
            if (!item.getShortName().equalsIgnoreCase(itemDescription)) {
                return "The item you are looking for is not in this room";
            } else {
                Item collectedItem = currentRoom.removeItem(item);
                inventoryList.add(collectedItem);
                return "The " + collectedItem.getShortName() + " is now part of your inventory";
            }
        }
    }

    public String dropItem(String itemToDrop) {
        Item item = findItemInInventory(itemToDrop);
        if (item != null) {
            inventoryList.remove(item);
            currentRoom.addItem(item);
            return ("You dropped the " + item.getShortName());
        } else {
            return ("You dont have this " + itemToDrop + " in your inventory");
        }
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventoryList) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public String consumeItem(String itemDescription) {
        Item item = currentRoom.searchItem(itemDescription);
        Item item1 = findItemInInventory(itemDescription);

        // Check if the item is in the room or inventory
        if (item == null && item1 == null) {
            return "The item you are looking for is neither in the room nor part of your inventory.";
        }

        // Determine which item reference to use
        Consumables consumable;
        if (item instanceof Consumables) {
            consumable = (Consumables) item;
        } else if (item1 instanceof Consumables) {
            consumable = (Consumables) item1;
        } else {
            return "The item is not consumable.";
        }

        // Check if it's food or drink
        if (consumable instanceof Food) {
            if (consumable.getHealthPoints() < 0) {
                return "Warning: Consuming this food may have negative effects on your health!";
            } else {
                playerHealthPoints += consumable.getHealthPoints();
                if (item != null) {
                    currentRoom.removeItem(item);
                } else {
                    removeItem(item1);
                }
                return "You have consumed the " + consumable.getShortName() + ". Your HP is now " + playerHealthPoints;
            }
        } else if (consumable instanceof Liquid) {
            if (consumable.getHealthPoints() < 0) {
                return "Warning: Consuming this drink may have negative effects on your health!";
            } else {
                playerHealthPoints += consumable.getHealthPoints();
                if (item != null) {
                    currentRoom.removeItem(item);
                } else {
                    removeItem(item1);
                }
                return "You have consumed the " + consumable.getShortName() + ". Your HP is now " + playerHealthPoints;
            }
        } else {
            return "The item is neither food nor drink.";
        }
    }

    public String equipWeapon(String itemDescription) {
        Item item = findItemInInventory(itemDescription);

        // Check if the weapon is part of the inventory
        if (item == null) {
            return "The item you are looking for is not part of your inventory.";
        }

        // Check if the item is a weapon
        if (item instanceof Weapon) {
            // Determine if the weapon takes ammunition
            if (((Weapon) item).hasAmmunition) {
                ((Weapon) item).isEquipped();
                return "The " + item.getShortName() + " is now equipped and ready to use" + "\nYou have " + ((RangedWeapon) item).getAmountOfAmmo() + " tries";
            } else {
                return "The " + item.getShortName() + " does not need ammunition, you can use it as is.";
            }
        }
        return "The " + item.getShortName() + " is not a weapon, choose something else from your inventory.";
    }

    public String attackEnemy(String enemyDescription) {
        Enemy enemy = currentRoom.searchEnemy(enemyDescription);

        // Check if the enemy exists
        if (enemy == null) {
            return "There is no such enemy in this area.";
        }

        // Check if the player has enough health points
        if (playerHealthPoints <= 0) {
            return "You are in no shape to do battle. First replenish with food and drink!";
        }

        // Check if the player has a weapon
        for (Item item : inventoryList) {
            if (item instanceof Weapon weapon) {
                String returnMessage = "You have defeated the " + enemy.getShortName() + ". \nYour health is now " + playerHealthPoints + ". \nIt's time to replenish with food and drink.";

                // Deduct health points if attacking with a melee weapon
                if (!weapon.hasAmmunition) {
                    enemy.reduceHealthPoints(weapon.damage);
                    playerHealthPoints -= enemy.getWeapon().damage;
                    if (enemy.isEnemyDead()) {
                        currentRoom.removeEnemy(enemy);
                        return returnMessage;
                    }
                    return "You attacked the " + enemy.getShortName() + ". \nYour health: " + playerHealthPoints + ". \nEnemy's health: " + enemy.getHealthPoints() + ".\n";
                }

                // Check if the weapon is equipped
                if (!weapon.isEquipped()) {
                    return "You need to equip your weapon with ammunition before you can use it.";
                }

                // Attack with the weapon
                else if (weapon.isEquipped() && weapon.getAmountOfAmmo() > 0) {
                    enemy.reduceHealthPoints(weapon.damage);
                    weapon.reduceAmmo();
                    playerHealthPoints -= enemy.getWeapon().damage;
                    if (enemy.isEnemyDead()) {
                        currentRoom.removeEnemy(enemy);
                        return returnMessage;
                    }

                    return "You attacked the " + enemy.getShortName() + ". \nRemaining uses of your weapon: " + weapon.getAmountOfAmmo() + ". \nYour health: " + playerHealthPoints + ". \nEnemy's health: " + enemy.getHealthPoints() + ".\n";
            }
        }
        return "The " + item.getShortName() + " is not a weapon. You cannot use it for battle";
    }
        return"You are not ready for battle. First, get yourself a weapon.";
}

public String getCurrentRoom() {
    return currentRoom.getRoomName() + ": " + currentRoom.getRoomDescription();
}

public String movePlayerNorth() {
    if (currentRoom.getConnectionNorth() != null) {
        currentRoom = currentRoom.getConnectionNorth();
        return getCurrentRoom() + "\n" + question;
    } else {
        return wayBlocked;
    }
}

public String movePlayerEast() {
    if (currentRoom.getConnectionEast() != null) {
        currentRoom = currentRoom.getConnectionEast();
        return getCurrentRoom() + "\n" + question;
    } else {
        return wayBlocked;
    }
}

public String movePlayerWest() {
    if (currentRoom.getConnectionWest() != null) {
        currentRoom = currentRoom.getConnectionWest();
        return getCurrentRoom() + "\n" + question;
    } else {
        return wayBlocked;
    }
}

public String movePlayerSouth() {
    if (currentRoom.getConnectionSouth() != null) {
        currentRoom = currentRoom.getConnectionSouth();
        return getCurrentRoom() + "\n" + question;
    } else {
        return wayBlocked;
    }
}
}

