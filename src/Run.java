import character.Elf;

public class Run {
   public static void main(String[] args) {
      try {
         Elf elf = new Elf();
         elf.checkStatus();
         elf.getSteam().activate(elf);
         System.out.println("첫번째 실행");
         elf.checkStatus();
         Thread.sleep(8000);
         elf.checkStatus();
         Thread.sleep(12000);
         elf.getSteam().levelUp();
         elf.getSteam().activate(elf);
         System.out.println("두번째 실행");
         elf.checkStatus();
         Thread.sleep(9000);
         elf.checkStatus();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
