package character;

import skill.Skill;
import skill.common.Heal;
import skill.common.Steam;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonProps {
   private int level;
   private String name;
   private Heal heal;
   private Steam steam;
   private List<Weapon> weaponList;
   private List<Skill> skillList;
   private int maxHp;
   private int curHp;
   private int maxMp;
   private int curMp;
   private double attackDamage;
   private double defaultDmg;
   private double attackSpeed;
   private double defaultAttackSpeed;
   private double defence;
   private double defaultDefense;
   private double avoidability;
   private double defaultAvd;

   public CommonProps(String name, int maxHp, int curHp, int maxMp, int curMp, double attackDamage,
                      double defaultDmg, double attackSpeed, double defaultAttackSpeed, double defence, double defaultDefense,
                      double avoidability, double defaultAvd) {
      this.level = 1;
      this.name = name;
      this.maxHp = maxHp;
      this.curHp = curHp;
      this.maxMp = maxMp;
      this.curMp = curMp;
      this.attackDamage = attackDamage;
      this.defaultDmg = defaultDmg;
      this.attackSpeed = attackSpeed;
      this.defaultAttackSpeed = defaultAttackSpeed;
      this.defence = defence;
      this.defaultDefense = defaultDefense;
      this.avoidability = avoidability;
      this.defaultAvd = defaultAvd;
      this.heal = new Heal();
      this.steam = new Steam();
      this.skillList = new ArrayList<Skill>();
      this.skillList.add(this.heal);
      this.skillList.add(this.steam);
      this.weaponList = new ArrayList<Weapon>();
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

   public void setName(String name) {
      this.name = name;
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

   public double getDefaultDmg() {
      return defaultDmg;
   }

   public void setDefaultDmg(double defaultDmg) {
      this.defaultDmg = defaultDmg;
   }

   public double getAttackSpeed() {
      return attackSpeed;
   }

   public void setAttackSpeed(double attackSpeed) {
      this.attackSpeed = attackSpeed;
   }

   public double getDefaultAttackSpeed() {
      return defaultAttackSpeed;
   }

   public void setDefaultAttackSpeed(double defaultAttackSpeed) {
      this.defaultAttackSpeed = defaultAttackSpeed;
   }

   public double getDefence() {
      return defence;
   }

   public void setDefence(double defence) {
      this.defence = defence;
   }

   public double getDefaultDefense() {
      return defaultDefense;
   }

   public void setDefaultDefense(double defaultDefense) {
      this.defaultDefense = defaultDefense;
   }

   public double getAvoidability() {
      return avoidability;
   }

   public void setAvoidability(double avoidability) {
      this.avoidability = avoidability;
   }

   public double getDefaultAvd() {
      return defaultAvd;
   }

   public void setDefaultAvd(double defaultAvd) {
      this.defaultAvd = defaultAvd;
   }

   public void checkStatus() {
      System.out.println(
              "===========================상태창=============================\n" +
              "레벨 : " + level + "\n" +
              "직업 : " + name +  "\n" +
              "Hp : {" + curHp + "/" + maxHp + "}\n" +
              "Mp : {" + curMp + "/" + maxMp + "}\n" +
              "공격력 : " + attackDamage + "\n" +
              "공격속도 : " + attackSpeed + "\n" +
              "방어력 : " + defence + "\n" +
              "회피력 : " + avoidability + "\n" +
              "=============================================================");
   }
}
