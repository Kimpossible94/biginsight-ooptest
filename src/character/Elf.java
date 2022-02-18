package character;

import skill.common.Heal;

import java.util.ArrayList;
import java.util.List;

public class Elf extends CommonProps{

   private Heal heal;

   public Elf() {
      super("elf", 50, 50, 100, 100, 10,
              10, 1, 1, 5, 5, 40, 40);
      this.heal = new Heal();
   }

   public Heal getHeal() {
      return heal;
   }
}
