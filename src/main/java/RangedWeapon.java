public class RangedWeapon extends Weapon {
    private int amountOfAmmo;

    public RangedWeapon(String longName, String shortName, int damage, int amountOfAmmo) {
        super(longName, shortName, damage, true);
        this.amountOfAmmo = amountOfAmmo;
    }

    @Override
    public int getAmountOfAmmo() {
        return amountOfAmmo;
    }

    @Override
    public int reduceAmmo() {
        amountOfAmmo -= 1;
        return amountOfAmmo;
    }

}
