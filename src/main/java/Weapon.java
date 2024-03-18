public abstract class Weapon extends Item{

    protected int damage;
    protected boolean hasAmmunition;

    public Weapon(String longName, String shortName, int damage, boolean hasAmmunition) {
        super(longName, shortName);
        this.damage = damage;
        this.hasAmmunition = hasAmmunition;
    }

}

