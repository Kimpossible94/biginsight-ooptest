package unit.character;

import skill.elf.Elusion;
import skill.elf.Rapid;
import weapon.elf.IronBow;
import weapon.elf.ShortBow;

public class Elf extends CommonProps{

   private Elusion elusion;
   private Rapid rapid;
   private IronBow ironBow;
   private ShortBow shortBow;

   public Elf() {
      super("Elf", 50, 50, 100, 100, 10,
              0.8, 3, 30);
      this.elusion = new Elusion();
      getSkillList().add(this.elusion);
      this.ironBow = new IronBow();
      this.shortBow = new ShortBow();
      getWeaponList().add(this.ironBow);
      getWeaponList().add(this.shortBow);
   }

   public Elusion getElusion() {
      return elusion;
   }

   public Rapid getRapid() {
      return rapid;
   }

   public void setRapid(Rapid rapid) {
      this.rapid = rapid;
   }

   public IronBow getIronBow() {
      return ironBow;
   }

   public ShortBow getShortBow() {
      return shortBow;
   }

   @Override
   public void levelUp() {
      setLevel(getLevel() + 1);
      setMaxHp(getMaxHp() + 2);
      setMaxMp(getMaxMp() + 10);
      setCurHp(getMaxHp());
      setCurMp(getMaxMp());
      setAttackDamage(getAttackDamage() + 0.25);
      setDefence(getDefence()+0.02);
      setAvoidability(getAvoidability()+0.1);
      if(getLevel() / 3 == 0){
         setAttackSpeed(getAttackSpeed() + 0.05);
      }
      setMaxExp(getMaxExp() + getLevel() * 5);
      setCurExp(0);

      if(getLevel() == 99){
         this.rapid = new Rapid();
         getSkillList().add(this.rapid);
      }
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      System.out.println("레벨업 하였습니다 !");
      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
   }
}
