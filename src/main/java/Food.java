public class Food extends Consumables{

    public Food(String longName, String shortName, int healthPoints) {
        super(longName, shortName, healthPoints);
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }
}
