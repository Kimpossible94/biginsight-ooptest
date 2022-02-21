package skill.common;

import unit.character.CommonProps;
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
         target.setCurMp(target.getCurMp() - getMpCost());
      }
   }


   @Override
   public boolean levelUp(CommonProps target) {
      if (checkPossibleLevelUp(target)) {
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
