package event;

import skill.Skill;
import unit.character.CommonProps;
import unit.monster.MonsterProps;
import unit.monster._11to20.*;
import unit.monster._1to10.Goblin;
import unit.monster._1to10.Slime;
import unit.monster._21to30.Bear;
import unit.monster._21to30.Cyclops;
import unit.monster._21to30.DarkElf;
import unit.monster._21to30.Gorlem;
import unit.monster._31to40.BabyDevil;
import unit.monster._31to40.Cerberos;
import unit.monster._31to40.Chimera;
import unit.monster._41to50.Banshee;
import unit.monster._41to50.Incubus;
import unit.monster._41to50.Succubus;
import unit.monster._51to60.Gargoyle;
import unit.monster._51to60.Giant;
import unit.monster._61to70.Devil;
import unit.monster._61to70.Griffon;
import unit.monster._71to90.*;
import unit.monster._91to99.BlackDragon;
import unit.monster._91to99.GreenDragon;
import unit.monster._91to99.WhiteDragon;

import java.util.Scanner;

public class Battle {

   public Battle() {
   }

   public MonsterProps choiceMonster(CommonProps character) {
      System.out.println("실행");
      MonsterProps monster = null;
      int random = (int) Math.round(Math.random() * 10);
      int level = character.getLevel();
      if (level <= 10) {
         monster = monsterOneToTen();
      } else if (level <= 20) {
         if (random > 2) {
            monster = monsterTenToTwenty();
         } else {
            monster = monsterOneToTen();
         }
      } else if (level <= 30) {
         if (random > 2) {
            monster = monsterTwentyToThirty();
         } else {
            monster = monsterTenToTwenty();
         }
      } else if (level <= 40) {
         if (random > 2) {
            monster = monsterThirtyToForty();
         } else {
            monster = monsterTwentyToThirty();
         }
      } else if (level <= 50) {
         if (random > 2) {
            monster = monsterFortyToFifty();
         } else {
            monster = monsterThirtyToForty();
         }
      } else if (level <= 60) {
         if (random > 2) {
            monster = monsterFiftyToSixty();
         } else {
            monster = monsterFortyToFifty();
         }
      } else if (level <= 70) {
         if (random > 2) {
            monster = monsterSixtyToSeventy();
         } else {
            monster = monsterFiftyToSixty();
         }
      } else if (level <= 90) {
         if (random > 2) {
            monster = monsterSeventyToNinety();
         } else {
            monster = monsterSixtyToSeventy();
         }
      } else if (level <= 99) {
         if (random > 2) {
            monster = monsterNinetyToNinetyNine();
         } else {
            monster = monsterSeventyToNinety();
         }
      }

      return monster;
   }

   private MonsterProps monsterNinetyToNinetyNine() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random <= 3) {
         monster = new BlackDragon();
      } else if (random <= 6) {
         monster = new GreenDragon();
      } else if (random <= 10) {
         monster = new WhiteDragon();
      }
      return monster;
   }

   private MonsterProps monsterSeventyToNinety() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random <= 2) {
         monster = new GiantWorm();
      } else if (random <= 4) {
         monster = new Hydra();
      } else if (random <= 6) {
         monster = new Lich();
      } else if (random <= 8) {
         monster = new Vampire();
      } else if (random <= 10) {
         monster = new Shaman();
      }
      return monster;
   }

   private MonsterProps monsterSixtyToSeventy() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random > 5) {
         monster = new Devil();
      } else {
         monster = new Griffon();
      }
      return monster;
   }

   private MonsterProps monsterFiftyToSixty() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random > 5) {
         monster = new Gargoyle();
      } else {
         monster = new Giant();
      }
      return monster;
   }

   private MonsterProps monsterFortyToFifty() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random <= 3) {
         monster = new Banshee();
      } else if (random <= 6) {
         monster = new Incubus();
      } else if (random <= 10) {
         monster = new Succubus();
      }
      return monster;
   }

   private MonsterProps monsterThirtyToForty() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random <= 3) {
         monster = new BabyDevil();
      } else if (random <= 6) {
         monster = new Cerberos();
      } else if (random <= 10) {
         monster = new Chimera();
      }
      return monster;
   }

   private MonsterProps monsterTwentyToThirty() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random <= 3) {
         monster = new Bear();
      } else if (random <= 4) {
         monster = new Cyclops();
      } else if (random <= 7) {
         monster = new DarkElf();
      } else if (random <= 10) {
         monster = new Gorlem();
      }
      return monster;
   }

   private MonsterProps monsterTenToTwenty() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random <= 2) {
         monster = new Ghoul();
      } else if (random <= 4) {
         monster = new Mimic();
      } else if (random <= 6) {
         monster = new Naga();
      } else if (random <= 8) {
         monster = new Skeleton();
      } else if (random <= 10) {
         monster = new SkeletonArcher();
      }
      return monster;
   }

   private MonsterProps monsterOneToTen() {
      int random = (int) Math.round(Math.random() * 10);
      MonsterProps monster = null;
      if (random > 5) {
         monster = new Goblin();
      } else {
         monster = new Slime();
      }
      return monster;
   }

   public void start(CommonProps character, MonsterProps monster) {
      System.out.println("야생의 " + monster.getName() + "이(가) 나타났다 !");
      Scanner sc = new Scanner(System.in);
      Thread monsterThread = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               while (monster.getCurHp() > 0 && character.getCurHp() > 0) {
                  Thread.sleep((long) monster.getAttackSpeed() * 1000);
                  monster.attack(character);
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      int choice = 0;
      monsterThread.start();
      while (monster.getCurHp() > 0 && character.getCurHp() > 0) {
         System.out.println("행동을 선택해주세요.");
         System.out.println("1. 공격");
         System.out.println("2. 스킬");
         choice = sc.nextInt();
         if (choice == 1) {
            if (character.attack(monster)) {
               monster.activeCounter(character);
            }
         } else if (choice == 2) {
            character.selectSkill();
         } else {
            System.out.println("올바르게 입력해주세요.");
         }

      }

      System.out.println("전투가 종료되었습니다.");
      endBattle(character, monster);
   }

   private void endBattle(CommonProps character, MonsterProps monster) {
      if (monster.getCurHp() <= 0) {
         System.out.println(monster.getName() + "을 처치하셨습니다.");
         System.out.println("획득 경험치 : " + monster.getExp());

         character.setLastAttackTime(0);

         int totalExp = character.getCurExp() + monster.getExp();
         if (totalExp >= character.getMaxExp()) {
            character.levelUp();
         } else {
            character.setCurExp(character.getCurExp() + monster.getExp());
         }

         for (Skill skill : character.getSkillList()) {
            skill.setLastCastTime(0);
         }
      }
   }


}
