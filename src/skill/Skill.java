package skill;

import unit.character.CommonProps;

public abstract class Skill {
   private String name; //기술 이름
   private long lastCastTime; //최근 기술 시전 시각
   private long cooldown; //기술 쿨타임
   private long duration; //기술 지속 시간
   private int mpCost; //mp 소모량
   private int level;
   private final int maxLevel;
   private int amount;

   protected Skill(String name, long lastCastTime, long cooldown, long duration, int mpCost, int level, int amount, int maxLevel) {
      this.name = name;
      this.lastCastTime = lastCastTime;
      this.cooldown = cooldown;
      this.duration = duration;
      this.mpCost = mpCost;
      this.level = level;
      this.amount = amount;
      this.maxLevel = maxLevel;
   }

   protected int getMaxLevel() {
      return maxLevel;
   }

   protected String getName() {
      return name;
   }

   protected void setName(String name) {
      this.name = name;
   }

   protected long getLastCastTime() {
      return lastCastTime;
   }

   protected void setLastCastTime(long lastCastTime) {
      this.lastCastTime = lastCastTime;
   }

   protected long getCooldown() {
      return cooldown;
   }

   protected void setCooldown(long cooldown) {
      this.cooldown = cooldown;
   }

   protected long getDuration() {
      return duration;
   }

   protected void setDuration(long duration) {
      this.duration = duration;
   }

   protected int getMpCost() {
      return mpCost;
   }

   protected void setMpCost(int mpCost) {
      this.mpCost = mpCost;
   }

   protected int getLevel() {
      return level;
   }

   protected void setLevel(int level) {
      this.level = level;
   }

   protected int getAmount() {
      return amount;
   }

   protected void setAmount(int amount) {
      this.amount = amount;
   }

   public abstract void activate(CommonProps target);

   public abstract boolean levelUp();

   public abstract void deactivate(CommonProps target);

   // 스킬 사용후 지난시간 확인
   private long timeAfterActivate() {
      return ((System.currentTimeMillis() - getLastCastTime()) / 1000);
   }

   // 스킬 활성 가능여부 확인
   protected boolean checkPossibleActivate(CommonProps target){
      long time = timeAfterActivate();

      if (time < getCooldown()) {
         System.out.print("아직 기술을 사용할 수 없습니다");
         System.out.println("(" + getName() + "의 남은 시간 : " + (getCooldown() - time) + " 초)");
         return false;
      }

      if (target.getCurMp() < getMpCost()) {
         System.out.print("스킬 시전에 필요한 mp가 부족합니다.");
         System.out.println("(당신의 현재 mp : " + target.getCurMp() + ", 필요한 mp : " + getMpCost() + ")");
         return false;
      }

      return true;
   }

   //기술 레벨업 가능 여부 확인
   protected boolean checkPossibleLevelUp(){
      if (getMaxLevel() <= getLevel()) {
         System.out.println("기술 레벨이 최대입니다.");
         return true;
      }
      System.out.println("기술 레벨업 !!!");
      return false;
   }

   @Override
   public String toString() {
      return "Skill{" +
              "name='" + name + '\'' +
              ", lastCastTime=" + lastCastTime +
              ", cooldown=" + cooldown +
              ", duration=" + duration +
              ", mpCost=" + mpCost +
              ", level=" + level +
              ", maxLevel=" + maxLevel +
              ", amount=" + amount +
              '}';
   }
}
