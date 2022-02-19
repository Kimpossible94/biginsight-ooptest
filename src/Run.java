import character.Elf;

public class Run {
   public static void main(String[] args) {
      Elf elf = new Elf();
      elf.checkStatus();
      elf.getShortBow().equip(elf);
      elf.checkStatus();
      elf.setLevel(25);
      elf.getIronBow().equip(elf);
      elf.checkStatus();
   }
}
