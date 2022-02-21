package unit.character;

import skill.human.Guard;
import skill.human.Invincible;
import weapon.human.LongSword;
import weapon.human.ShortSword;

public class Human extends CommonProps{
   private Guard guard;
   private Invincible invincible;
   private ShortSword shortSword;
   private LongSword longSword;

   public Human() {
      super("Human", 60, 60, 80, 80, 12, 0.7, 3, 25);
      this.guard = new Guard();
      getSkillList().add(this.guard);
      this.shortSword = new ShortSword();
      this.longSword = new LongSword();
      getWeaponList().add(this.shortSword);
      getWeaponList().add(this.longSword);
   }

   public void setInvincible(Invincible invincible) {
      this.invincible = invincible;
   }

   public Guard getGuard() {
      return guard;
   }

   public Invincible getInvincible() {
      return invincible;
   }

   public ShortSword getShortSword() {
      return shortSword;
   }

   public LongSword getLongSword() {
      return longSword;
   }

   @Override
   public void levelUp() {
      setLevel(getLevel() + 1);
      setMaxHp(getMaxHp() + 3);
      setMaxMp(getMaxMp() + 7);
      setAttackDamage(getAttackDamage() + 0.35);
      setDefence(getDefence()+0.03);
      setAvoidability(getAvoidability()+0.075);
      if(getLevel() / 3 == 0){
         setAttackSpeed(getAttackSpeed() + 0.035);
      }
      setMaxExp(getMaxExp() + getLevel() * 5);
      setCurExp(0);
      setLastAttackTime(0);


      if(getLevel() == 99){
         this.invincible = new Invincible();
         getSkillList().add(this.invincible);
      }

      System.out.println("레벨업 하였습니다 !");
   }
}
