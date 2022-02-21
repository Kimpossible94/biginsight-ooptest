package unit.character;

import skill.orc.Anger;
import skill.orc.Frenzy;
import weapon.orc.IronHammer;
import weapon.orc.ShortAxe;

public class Orc extends CommonProps{

   private Anger anger;
   private Frenzy frenzy;
   private ShortAxe shortAxe;
   private IronHammer ironHammer;

   public Orc() {
      super("Orc", 70, 70, 50, 50, 15, 0.5, 3, 20);
      this.anger = new Anger();
      getSkillList().add(this.anger);
      this.shortAxe = new ShortAxe();
      this.ironHammer = new IronHammer();
      getWeaponList().add(this.shortAxe);
      getWeaponList().add(this.ironHammer);
   }

   public Anger getAnger() {
      return anger;
   }

   public void setFrenzy(Frenzy frenzy) {
      this.frenzy = frenzy;
   }

   public Frenzy getFrenzy() {
      return frenzy;
   }

   public ShortAxe getShortAxe() {
      return shortAxe;
   }

   public IronHammer getIronHammer() {
      return ironHammer;
   }

   @Override
   public void levelUp() {
      setLevel(getLevel() + 1);
      setMaxHp(getMaxHp() + 5);
      setMaxMp(getMaxMp() + 5);
      setAttackDamage(getAttackDamage() + 0.5);
      setDefence(getDefence()+0.04);
      setAvoidability(getAvoidability()+0.05);
      if(getLevel() / 3 == 0){
         setAttackSpeed(getAttackSpeed() + 0.025);
      }
      setMaxExp(getMaxExp() + getLevel() * 5);
      setCurExp(0);
      setLastAttackTime(0);

      if(getLevel() == 99){
         this.frenzy = new Frenzy();
         getSkillList().add(this.frenzy);
      }

      System.out.println("레벨업 하였습니다 !");

   }
}
