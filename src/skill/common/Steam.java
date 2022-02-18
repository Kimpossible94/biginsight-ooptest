package skill.common;

import character.CommonProps;
import skill.Skill;

public class Steam extends Skill {
   protected Steam() {
      super("steam", 0, 20, 7, 10, 1, 120, 5);
   }

   @Override
   public void activate(CommonProps target) {
      if(checkPossibleActivate(target)){
         target.setAttackDamage(target.getAttackDamage() * getAmount() / 100);
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
      setAmount(getAmount() + 5);
      setCooldown(getCooldown() - 1);
      setMpCost(getMpCost() + 5);
      setDuration(getDuration() + 1);
      return true;
   }

   @Override
   public void deactivate(CommonProps target) {
      if(checkPossibleDeactivate()){
         target.setAttackDamage(target.getAttackDamage() / getAmount() * 100);
      }
   }
}
