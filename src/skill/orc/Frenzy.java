package skill.orc;

import unit.character.CommonProps;
import skill.Skill;

public class Frenzy extends Skill {

   public Frenzy() {
      super("Frenzy", 0, 300, 60, 30, 1, 500, 1);
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
               target.setAttackDamage(target.getAttackDamage() / getAmount() * 100);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      t.start();
   }
}
