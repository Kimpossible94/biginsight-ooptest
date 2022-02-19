package skill.common;

import character.CommonProps;
import skill.Skill;

public class Steam extends Skill {

   public Steam() {
      super("Steam", 0, 20, 7, 10, 1, 120, 5);
   }

   @Override
   public void activate(CommonProps target) {
      if(checkPossibleActivate(target)){
         target.setAttackDamage(target.getAttackDamage() * getAmount() / 100);
         setLastCastTime(System.currentTimeMillis());
         target.setCurMp(target.getCurMp() - getMpCost());
         deactivate(target);
      }
   }

   @Override
   public boolean levelUp() {
      if (checkPossibleLevelUp()) {
         return false;
      }
      setLevel(getLevel() + 1);
      setAmount(getAmount() + 5);
      setCooldown(getCooldown() - 1);
      setMpCost(getMpCost() + 5);
      setDuration(getDuration() + 1);
      return true;
   }

   @Override
   public void deactivate(CommonProps target) {
      Thread t = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               Thread.sleep(getDuration()*1000);
               target.setAttackDamage(target.getAttackDamage() / getAmount() * 100);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      t.start();
   }
}
