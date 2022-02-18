package skill.common;

import character.CommonProps;
import skill.Skill;

public class Heal extends Skill {

   public Heal() {
      super("Heal", 0, 3, 0, 10, 1, 20, 5);
   }

   @Override
   public void activate(CommonProps target) {
      if(checkPossibleActivate(target)){
         int hpAfterHeal = target.getCurHp() + getAmount();
         target.setCurHp(Math.min(hpAfterHeal, target.getMaxHp()));
         setLastCastTime(System.currentTimeMillis());
         target.setCurMp(target.getMaxMp() - getMpCost());
      }
   }


   @Override
   public boolean levelUp() {
      if (getMaxLevel() <= getLevel()) {
         System.out.println("기술 레벨이 최대입니다.");
         return false;
      }
      setLevel(getLevel() + 1);
      setAmount(getAmount() + 10);
      setCooldown(getCooldown() - 1);
      setMpCost(getMpCost() + 7);
      return true;
   }

   @Override
   public void deactivate(CommonProps target) {}

}
