public class Liquid extends Consumables{

    public Liquid(String longName, String shortName, int healthPoints) {
        super(longName, shortName, healthPoints);
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }
}
