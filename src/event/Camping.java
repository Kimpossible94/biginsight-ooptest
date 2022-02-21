package event;

import unit.character.CommonProps;

public class Camping {
   private CommonProps character;

   public Camping(CommonProps character) {
      this.character = character;
   }

   public void start(){
      System.out.println("캠핑하기 좋은 장소를 마련해 캠핑을하며 쉬었습니다.");
      System.out.println("체력과 마나를 모두 회복하였습니다.");
      character.setCurHp(character.getMaxHp());
      character.setCurMp(character.getMaxMp());
   }
}
