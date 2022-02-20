package skill.human;

import unit.character.CommonProps;
import skill.Skill;

public class Invincible extends Skill {

   public Invincible() {
      super("Invincible", 0, 300, 10, 40, 1, -1, 1);
   }

   @Override
   public void activate(CommonProps target) {
      if(checkPossibleActivate(target)){
         setAmount(1);
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
               setAmount(-1);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      t.start();
   }
}
