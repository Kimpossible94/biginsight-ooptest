package skill.elf;

import character.CommonProps;
import skill.Skill;

public class Rapid extends Skill {

   public Rapid() {
      super("Rapid", 0, 300, 60, 40, 1, 500, 1);
   }

   @Override
   public void activate(CommonProps target) {
      if(checkPossibleActivate(target)){
         target.setAttackSpeed(target.getAttackSpeed() * getAmount() / 100);
         setLastCastTime(System.currentTimeMillis());
         target.setCurMp(target.getCurMp() - getMpCost());
         deactivate(target);
      }
   }

   @Override
   public boolean levelUp() {
      System.out.println("궁극 기술은 레벨업 할 수 없습니다.");
      return false;
   }

   @Override
   public void deactivate(CommonProps target) {
      Thread t = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               Thread.sleep(getDuration()*1000);
               target.setAttackSpeed(target.getAttackSpeed() / getAmount() * 100);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      t.start();
   }
}
