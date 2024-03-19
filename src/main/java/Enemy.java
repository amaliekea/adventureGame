public class Enemy {
    private String type;
    private String description;
    private int healthPoints;
    private Weapon weapon;

    public Enemy(String type, String description, int healthPoints, Weapon weapon) {
        this.type = type;
        this.description = description;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
    }

    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

}
