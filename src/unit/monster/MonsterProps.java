package unit.monster;

import unit.character.CommonProps;

public class MonsterProps {
   private String name;
   private int curHp;
   private int maxHp;
   private double minDamage;
   private double maxDamage;
   private double defence;
   private int exp;
   private int counterPercent;
   private double attackSpeed;

   public MonsterProps(String name, int maxHp, double minDamage,double maxDamage, double defence,
                       int exp, int counterPercent, double attackSpeed) {
      this.name = name;
      this.maxHp = maxHp;
      this.curHp = this.maxHp;
      this.minDamage = minDamage;
      this.maxDamage = maxDamage;
      this.defence = defence;
      this.exp = exp;
      this.counterPercent = counterPercent;
      this.attackSpeed = attackSpeed;
   }

   public String getName() {
      return name;
   }

   public int getMaxHp() {
      return maxHp;
   }

   public int getCounterPercent() {
      return counterPercent;
   }

   public double getMinDamage() {
      return minDamage;
   }

   public double getMaxDamage() {
      return maxDamage;
   }

   public double getDefence() {
      return defence;
   }

   public int getCurHp() {
      return curHp;
   }

   public void setCurHp(int curHp) {
      this.curHp = curHp;
   }

   public int getExp() {
      return exp;
   }

   public double getAttackSpeed() {
      return attackSpeed;
   }

   public void activeCounter(CommonProps character){
      int random = (int) Math.round(Math.random() * 100);
      if(random > counterPercent || getCurHp() <= 0){
         return;
      }
      System.out.println("몬스터가 반격하였습니다.");
      double attackDamage = Math.round((Math.random() * (maxDamage - minDamage) + minDamage) * 0.7);
      changeCharacterHp(character, attackDamage);
   }

   private void changeCharacterHp(CommonProps character, double attackDamage) {
      double finalDamage = attackDamage - character.getDefence();
      if(finalDamage < 0){
         finalDamage = 0;
      }
      character.setCurHp((int) (character.getCurHp() - finalDamage));
      System.out.println(finalDamage + "의 데미지를 입었습니다. (현재 체력 : " + character.getCurHp() + " / " + character.getMaxHp() + ")");
   }

   public void attack(CommonProps character){
      if(getCurHp() <= 0){
         return;
      }
      System.out.println("몬스터가 공격하였습니다.");
      int random = (int) Math.round(Math.random() * 100);
      if(random <= character.getAvoidability()){
         System.out.println("몬스터의 공격을 회피하였습니다.");
         return;
      }

      double attackDamage = Math.round(Math.random() * (maxDamage - minDamage) + minDamage);
      changeCharacterHp(character, attackDamage);
   }

   public void checkMonsterInfo(){
      System.out.println(
              "===========================상태창=============================\n" +
                      "Hp : {" + curHp + "/" + maxHp + "}\n" +
                      "최소 공격력 : " + minDamage + "\n" +
                      "최대 공격력 : " + maxDamage + "\n" +
                      "방어력 : " + defence + "\n" +
                      "획득 경험치 : " + exp + "\n" +
                      "=============================================================");
   }


}
