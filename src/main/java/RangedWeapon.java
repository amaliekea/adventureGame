public class RangedWeapon extends Weapon{
private int amountOfUses;

public RangedWeapon(String longName, String shortName, int damage, int amountOfUses) {
    super(longName, shortName, damage, true);
    this.amountOfUses = amountOfUses;
}

    public int getUses() {
        return amountOfUses;
    }
    public int getDamage() {
        return damage;
    }

}
