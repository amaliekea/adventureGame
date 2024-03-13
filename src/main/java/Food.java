public class Food extends Item{
    double healthPoints;
    boolean isEdible;

    public Food(String longName, String shortName, double healthPoints) {
        super(longName, shortName);
        this.healthPoints = healthPoints;
        isEdible = true;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public boolean isEdible() {
        return isEdible;
    }
}
