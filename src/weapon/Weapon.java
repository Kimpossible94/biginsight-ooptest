package weapon;

import unit.character.CommonProps;

public abstract class Weapon {
   private String name;
   private int level;
   private double damage;
   private double speed;
   private boolean equipment;

   protected Weapon(String name, int level, double damage, double speed) {
      this.name = name;
      this.level = level;
      this.damage = damage;
      this.speed = speed;
      this.equipment = false;
   }

   public String getName() {
      return name;
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int level) {
      this.level = level;
   }

   public boolean isEquipment() {
      return equipment;
   }

   public void setEquipment(boolean equipment) {
      this.equipment = equipment;
   }

   protected double getDamage() {
      return damage;
   }

   protected void setDamage(double damage) {
      this.damage = damage;
   }

   protected double getSpeed() {
      return speed;
   }

   protected void setSpeed(double speed) {
      this.speed = speed;
   }

   //장비 장착
   public void equip(CommonProps target) {
      if (target.getLevel() < getLevel()) {
         System.out.println("착용 제한 레벨보다 캐릭터의 레벨이 낮습니다. (장비 착용 가능 레벨 : " + getLevel() + ", 당신의 레벨 : " + target.getLevel() + ")");
         return;
      }
      unequip(target);
      setEquipment(true);
      equipStatus(target);
   }


   //장비 해제
   public void unequip(CommonProps target) {
      for (Weapon weapon : target.getWeaponList()) {
         if(weapon.isEquipment()){
            unequipStatus(target, weapon);
            weapon.setEquipment(false);
         }
      }
   }

   //장비 장착시 스텟변경
   private void equipStatus(CommonProps target) {
      double damage = getDamage();
      double damageAbs = Math.abs(damage);
      double speed = getSpeed();
      double speedAbs = Math.abs(speed);

      if (damage < 0) {
         target.setAttackDamage(target.getAttackDamage() / damageAbs * 100);
      } else {
         target.setAttackDamage(target.getAttackDamage() * damageAbs / 100);
      }

      if (speed < 0) {
         target.setAttackSpeed(target.getAttackSpeed() / speedAbs * 100);
      } else {
         target.setAttackSpeed(target.getAttackSpeed() * speedAbs / 100);
      }

      System.out.println(getName() + "을 착용하였습니다.");
   }

   //장비 해제시 스텟변경
   private void unequipStatus(CommonProps target, Weapon weapon) {
      double damage = weapon.getDamage();
      double damageAbs = Math.abs(damage);
      double speed = weapon.getSpeed();
      double speedAbs = Math.abs(speed);

      if (damage < 0) {
         target.setAttackDamage(target.getAttackDamage() * damageAbs / 100);
      } else {
         target.setAttackDamage(target.getAttackDamage() / damageAbs * 100);
      }

      if (speed < 0) {
         target.setAttackSpeed(target.getAttackSpeed() * speedAbs / 100);
      } else {
         target.setAttackSpeed(target.getAttackSpeed() / speedAbs * 100);
      }

      System.out.println(weapon.getName() + "을 해제하였습니다.");
   }

   @Override
   public String toString() {
      return "Weapon{" +
              "level=" + level +
              ", damage=" + damage +
              ", speed=" + speed +
              ", equipment=" + equipment +
              '}';
   }
}
