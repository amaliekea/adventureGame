public class Enemy {
    private String longName;
    private String shortName;
    private int healthPoints;
    private Weapon weapon;

    public Enemy(String longName, String shortName, int healthPoints, Weapon weapon) {
        this.longName = longName;
        this.shortName = shortName;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
    }

    public String getLongName() {
        return longName;
    }
    public String getShortName() {
        return shortName;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int reduceHealthPoints(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        return healthPoints;
    }

    public boolean isEnemyDead() {
        if (getHealthPoints() == 0) {
            return true;
        }
        return false;
    }
}
