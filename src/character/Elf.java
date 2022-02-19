package character;

import skill.elf.Elusion;
import skill.elf.Rapid;
import weapon.elf.IronBow;
import weapon.elf.ShortBow;

public class Elf extends CommonProps{

   private Elusion elusion;
   private Rapid rapid;
   private IronBow ironBow;
   private ShortBow shortBow;

   public Elf() {
      super("elf", 50, 50, 100, 100, 10,
              10, 1, 1.2, 5, 5, 40, 40);
      this.elusion = new Elusion();
      getSkillList().add(this.elusion);
      this.ironBow = new IronBow();
      this.shortBow = new ShortBow();
      getWeaponList().add(this.ironBow);
      getWeaponList().add(this.shortBow);
   }

   public Elusion getElusion() {
      return elusion;
   }

   public Rapid getRapid() {
      return rapid;
   }

   public void setRapid(Rapid rapid) {
      this.rapid = rapid;
   }

   public IronBow getIronBow() {
      return ironBow;
   }

   public ShortBow getShortBow() {
      return shortBow;
   }
}
