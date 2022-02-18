package weapon;

public class HumanWeapon extends WeaponInfo{
   private boolean shortSword;
   private boolean longSword;

   public HumanWeapon(String weaponName, double additionalDamage, double additionalSpeed) {
      super(weaponName, additionalDamage, additionalSpeed);
   }
}
