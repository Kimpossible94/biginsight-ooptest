package skill.elf;

import unit.character.CommonProps;
import skill.Skill;

public class Elusion extends Skill {

   public Elusion() {
      super("Elusion", 0, 30, 5, 15, 1, 130, 10);
   }

   @Override
   public void activate(CommonProps target) {
      if(checkPossibleActivate(target)){
         target.setAvoidability(target.getAvoidability() * getAmount() / 100);
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
               target.setAttackDamage(target.getAttackDamage() / getAmount() * 100);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      t.start();
   }
}
