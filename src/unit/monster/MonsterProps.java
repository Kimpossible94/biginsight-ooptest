package unit.monster;

public class MonsterProps {
   private int curHp;
   private int maxHp;
   private double minDamage;
   private double maxDamage;
   private double defence;
   private int exp;
   private int counterPercent;
   private double attackSpeed;

   public MonsterProps(int maxHp, double minDamage,double maxDamage, double defence, int exp, int counterPercent, double attackSpeed) {
      this.maxHp = maxHp;
      this.curHp = this.maxHp;
      this.minDamage = minDamage;
      this.maxDamage = maxDamage;
      this.defence = defence;
      this.exp = exp;
      this.counterPercent = counterPercent;
      this.attackSpeed = attackSpeed;
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

   public boolean activeCounter(){
      int random = (int) Math.round(Math.random() * 100);
      return random <= counterPercent;
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
