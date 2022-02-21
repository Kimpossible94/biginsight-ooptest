package unit.character;

import skill.Skill;
import skill.common.Heal;
import skill.common.Steam;
import unit.monster.MonsterProps;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CommonProps {
   private int level;
   private String name;
   private Heal heal;
   private Steam steam;
   private List<Weapon> weaponList;
   private List<Skill> skillList;
   private int skillPoint;
   private int maxHp;
   private int curHp;
   private int maxMp;
   private int curMp;
   private int curExp;
   private int maxExp;
   private double attackDamage;
   private double attackSpeed;
   private double defence;
   private double avoidability;
   private long lastAttackTime;

   public CommonProps(String name, int maxHp, int curHp, int maxMp, int curMp, double attackDamage, double attackSpeed, double defence,
                      double avoidability) {
      this.level = 1;
      this.name = name;
      this.maxHp = maxHp;
      this.curHp = curHp;
      this.maxMp = maxMp;
      this.curMp = curMp;
      this.curExp = 0;
      this.maxExp = 10;
      this.skillPoint = 0;
      this.attackDamage = attackDamage;
      this.attackSpeed = attackSpeed;
      this.defence = defence;
      this.avoidability = avoidability;
      this.heal = new Heal();
      this.steam = new Steam();
      this.skillList = new ArrayList<Skill>();
      this.skillList.add(this.heal);
      this.skillList.add(this.steam);
      this.weaponList = new ArrayList<Weapon>();
      this.lastAttackTime = 0;
   }

   public int getSkillPoint() {
      return skillPoint;
   }

   public void setSkillPoint(int skillPoint) {
      this.skillPoint = skillPoint;
   }

   public int getCurExp() {
      return curExp;
   }

   public void setCurExp(int curExp) {
      this.curExp = curExp;
   }

   public int getMaxExp() {
      return maxExp;
   }

   public void setMaxExp(int maxExp) {
      this.maxExp = maxExp;
   }

   public Heal getHeal() {
      return heal;
   }

   public Steam getSteam() {
      return steam;
   }

   public List<Skill> getSkillList() {
      return skillList;
   }

   public List<Weapon> getWeaponList() {
      return weaponList;
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int level) {
      this.level = level;
   }

   public String getName() {
      return name;
   }

   public int getMaxHp() {
      return maxHp;
   }

   public void setMaxHp(int maxHp) {
      this.maxHp = maxHp;
   }

   public int getCurHp() {
      return curHp;
   }

   public void setCurHp(int curHp) {
      this.curHp = curHp;
   }

   public int getMaxMp() {
      return maxMp;
   }

   public void setMaxMp(int maxMp) {
      this.maxMp = maxMp;
   }

   public int getCurMp() {
      return curMp;
   }

   public void setCurMp(int curMp) {
      this.curMp = curMp;
   }

   public double getAttackDamage() {
      return attackDamage;
   }

   public void setAttackDamage(double attackDamage) {
      this.attackDamage = attackDamage;
   }

   public double getAttackSpeed() {
      return attackSpeed;
   }

   public void setAttackSpeed(double attackSpeed) {
      this.attackSpeed = attackSpeed;
   }

   public double getDefence() {
      return defence;
   }

   public void setDefence(double defence) {
      this.defence = defence;
   }

   public double getAvoidability() {
      return avoidability;
   }

   public void setAvoidability(double avoidability) {
      this.avoidability = avoidability;
   }

   public long getLastAttackTime() {
      return lastAttackTime;
   }

   public void setLastAttackTime(long lastAttackTime) {
      this.lastAttackTime = lastAttackTime;
   }

   public void checkSkill() {
      Scanner sc = new Scanner(System.in);
      System.out.println("================================================");
      for (Skill skill : skillList) {
         System.out.println("스킬 이름 : " + skill.getName() + ", mp 소모량 : " + skill.getMpCost()
                 + ", 스킬 레벨 : " + skill.getLevel() + " / " + skill.getMaxLevel());
      }
      System.out.println("사용 가능한 스킬 포인트 : " + getSkillPoint());
      System.out.println("스킬을 레벨업 하시겠습니까 ? (y/n)");
      String choice = sc.next();
      if (choice.equalsIgnoreCase("y")) {
         skillLevelUpMenu();
      } else {
         return;
      }
   }

   private void skillLevelUpMenu() {
      int choice = choiceSkill();
      if (choice == skillList.size() + 1) {
         return;
      } else {
         skillList.get(choice-1).levelUp(this);
      }
   }

   private int choiceSkill() {
      Scanner sc = new Scanner(System.in);
      System.out.println("================================================");
      System.out.println("스킬을 선택해주세요.");
      while (true) {
         int num = 1;
         for (Skill skill : skillList) {
            System.out.println("(" + num + ") 스킬 이름 : " + skill.getName() + ", mp 소모량 : " + skill.getMpCost()
                    + ", 스킬 레벨 : " + skill.getLevel() + " / " + skill.getMaxLevel());
            num++;
         }
         System.out.println("(" + num + ") 뒤로가기");
         int choice = sc.nextInt();
         if (choice < 1 || choice > skillList.size() + 1) {
            System.out.println("번호를 올바르게 입력하세요");
         } else {
            return choice;
         }
      }
   }

   public void changeWeapon() {
      Scanner sc = new Scanner(System.in);
      while (true){
         System.out.println("================================================");
         System.out.println("장비를 선택해주세요.");
         int num = 1;
         for (Weapon weapon : weaponList) {
            if(weapon.isEquipment()){
               System.out.println("(" + num + ") 장비 이름 : " + weapon.getName() + ", 레벨 제한 : " + weapon.getLevel() + " (착용중)");
            } else {
               System.out.println("(" + num + ") 장비 이름 : " + weapon.getName() + ", 레벨 제한 : " + weapon.getLevel());
            }
            num++;
         }
         System.out.println("(" + num + ") 뒤로가기");
         int choice = sc.nextInt();
         if (choice < 1 || choice > skillList.size()+1) {
            System.out.println("번호를 올바르게 입력하세요");
            continue;
         }

         if(choice == weaponList.size()+1){
            return;
         }

         weaponList.get(choice-1).equip(this);
      }
   }

   public void selectSkill() {
      int choice = choiceSkill();
      if (choice == skillList.size() + 1) {
         return;
      } else {
         skillList.get(choice-1).activate(this);
      }
   }

   private double timeAfterAttack() {
      double afterTime = System.currentTimeMillis() - getLastAttackTime();
      return afterTime/1000;
   }

   public boolean attack(MonsterProps monster) {
      double time = timeAfterAttack();
      if (time < (1 / attackSpeed)) {
         System.out.println("아직 공격할 수 없습니다.");
         return false;
      }
      double attackDamage = getAttackDamage() - monster.getDefence();
      double finalDamage = attackDamage - monster.getDefence();
      if(finalDamage < 0){
         finalDamage = 0;
      }
      monster.setCurHp((int) (monster.getCurHp() - finalDamage));
      setLastAttackTime(System.currentTimeMillis());
      System.out.println("-------------------- 몬스터를 공격하였습니다. 남은 몬스터 체력 : " + monster.getCurHp() + " / " + monster.getMaxHp());
      return true;
   }

   public void checkStatus() {
      System.out.println(
              "===========================상태창=============================\n" +
                      "레벨 : " + level + "\n" +
                      "직업 : " + name + "\n" +
                      "Hp : {" + curHp + "/" + maxHp + "}\n" +
                      "Mp : {" + curMp + "/" + maxMp + "}\n" +
                      "공격력 : " + attackDamage + "\n" +
                      "공격속도 : " + attackSpeed + "\n" +
                      "방어력 : " + defence + "\n" +
                      "회피력 : " + avoidability + "\n" +
                      "=============================================================");
   }

   public abstract void levelUp();
}
