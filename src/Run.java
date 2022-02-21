import event.Battle;
import event.Camping;
import unit.character.CommonProps;
import unit.character.Elf;
import unit.character.Human;
import unit.character.Orc;
import unit.monster.MonsterProps;

import java.util.Scanner;

public class Run {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      CommonProps character = null;
      int choiceNum = 0;
      while (true) {
         System.out.println("생성할 캐릭터를 골라주세요");
         System.out.println("1. 엘프");
         System.out.println("2. 오크");
         System.out.println("3. 인간");
         choiceNum = sc.nextInt();
         if (choiceNum == 1) {
            character = new Elf();
            break;
         } else if (choiceNum == 2) {
            character = new Orc();
            break;
         } else if (choiceNum == 3) {
            character = new Human();
            break;
         } else {
            System.out.println("번호를 제대로 선택해주세요.");
         }
      }
      System.out.println("모험을 시작합니다 !");
      System.out.println("================================================");
      System.out.println();
      Camping camping = new Camping(character);
      Battle battle = new Battle();

      while (character.getCurHp() > 0) {
         System.out.println("행동을 선택해주세요");
         System.out.println("================================================");
         System.out.println("1. 이동하기");
         System.out.println("2. 상태확인");
         System.out.println("3. 스킬확인");
         System.out.println("4. 장비변경");

         choiceNum = sc.nextInt();
         if(choiceNum == 1){
            int randomNum = (int) Math.round(Math.random() * 100);
            if(randomNum > 80){
               camping.start();
            } else {
               MonsterProps monster = battle.choiceMonster(character);
               battle.start(character, monster);
            }
         } else if(choiceNum == 2){
            character.checkStatus();
         } else if(choiceNum == 3){
            character.checkSkill();
         } else if(choiceNum == 4) {
            character.changeWeapon();
         } 

      }
   }
}
