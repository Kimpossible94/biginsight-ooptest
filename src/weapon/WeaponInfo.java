package weapon;

public class WeaponInfo implements Weapon{
   private String weaponName;
   private double additionalDamage;
   private double additionalSpeed;

   public WeaponInfo(String weaponName, double additionalDamage, double additionalSpeed) {
      this.weaponName = weaponName;
      this.additionalDamage = additionalDamage;
      this.additionalSpeed = additionalSpeed;
   }

   public String getWeaponName() {
      return weaponName;
   }

   public void setWeaponName(String weaponName) {
      this.weaponName = weaponName;
   }

   public double getAdditionalDamage() {
      return additionalDamage;
   }

   public void setAdditionalDamage(double additionalDamage) {
      this.additionalDamage = additionalDamage;
   }

   public double getAdditionalSpeed() {
      return additionalSpeed;
   }

   public void setAdditionalSpeed(double additionalSpeed) {
      this.additionalSpeed = additionalSpeed;
   }

   @Override
   public void attack() {

   }
}
