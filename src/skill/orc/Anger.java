package skill.orc;

import unit.character.CommonProps;
import skill.Skill;

public class Anger extends Skill {
   private int secondAmount;

   public Anger() {
      super("Anger", 0, 30, 5, 10, 1, 150, 10);
      this.secondAmount = 110;
   }

   public int getSecondAmount() {
      return secondAmount;
   }

   public void setSecondAmount(int secondAmount) {
      this.secondAmount = secondAmount;
   }

   @Override
   public void activate(CommonProps target) {
      if(checkPossibleActivate(target)){
         target.setDefence(target.getDefence() / getAmount() * 100);
         target.setAttackDamage(target.getAttackDamage() * getSecondAmount() / 100);
         setLastCastTime(System.currentTimeMillis());
         target.setCurMp(target.getCurMp() - getMpCost());
         deactivate(target);
      }
   }

   @Override
   public boolean levelUp(CommonProps target) {
      if (checkPossibleLevelUp(target)) {
         return false;
      }
      setLevel(getLevel() + 1);
      setAmount(getAmount() + 2);
      setCooldown(getCooldown() - 1);
      if(getLevel()/2 == 0){
         setSecondAmount(getSecondAmount() - 1);
      }
      setDuration(getDuration() + 1);
      return false;
   }

   @Override
   public void deactivate(CommonProps target) {
      Thread t = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               Thread.sleep(getDuration()*1000);
               target.setDefence(target.getDefence() * getSecondAmount() / 100);
               target.setAttackDamage(target.getAttackDamage() / getSecondAmount() * 100);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      t.start();
   }
}
