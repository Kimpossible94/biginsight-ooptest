package character;

import skill.common.Heal;
import skill.common.Steam;

public class Elf extends CommonProps{

   private Heal heal;
   private Steam steam;

   public Elf() {
      super("elf", 50, 50, 100, 100, 10,
              10, 1, 1, 5, 5, 40, 40);
      this.heal = new Heal();
      this.steam = new Steam();
   }

   public Heal getHeal() {
      return heal;
   }

   public Steam getSteam() {
      return steam;
   }
}
