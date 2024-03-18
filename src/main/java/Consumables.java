public abstract class Consumables extends Item{
    protected int healthPoints;
    public Consumables(String longName, String shortName, int healthPoints) {
        super(longName, shortName);
        this.healthPoints = healthPoints;
    }

    public abstract int getHealthPoints();
}
