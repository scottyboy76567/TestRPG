import java.io.*;
public class combatTester
{
    public static void main(String args[])
    {
        /**********/
        /***INIT***/
        /**********/
        //REMEMBER: character(String name, int health, int strength, int dexterity, int luck, int wisdom)
        character a = new character("Mario", 50, 20, 5, 80, 100, 10, 99);
        character b = new character("Goomba", 40, 10, 5,50, 100, 0, 99);
        
        // Give them weapons
        a.wieldedWeapon = new rustySword();
        b.wieldedWeapon = new woodenStaff();
        
        // Give them armor
        a.wornHelmet = new oldHood();
        a.wornChestPlate = new oldLeatherVest();
        a.wornPants = new oldLeatherPants();
        b.wornHelmet = new oldHood();
        b.wornChestPlate = new oldLeatherVest();
        b.wornPants = new oldLeatherPants();
        
        /**********/
        /**COMBAT**/
        /**********/
        int damage;
        // now starting all the combat code from here
        System.out.println("BATTLE START: " + a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
        while (true)
        {
            b.takeDamage(a.giveDamage());
            System.out.println(a.name + " hit " + b.name + " for " + a.giveDamage() + " damage, " + b.name + " has " + (b.wornHelmet.DT + b.wornChestPlate.DT + b.wornPants.DT) + " DT and " + (b.wornHelmet.DR + b.wornChestPlate.DR + b.wornPants.DR) + " DR");
            System.out.println(a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
            if (b.isDead())
            {
                System.out.println(a.name + " killed " + b.name + " with " + a.health + " HP Left.");
                break;
            }
            a.takeDamage(b.giveDamage());
            System.out.println(b.name + " hit " + a.name + " for " + b.giveDamage() + " damage, " + a.name + " has " + (a.wornHelmet.DT + a.wornChestPlate.DT + a.wornPants.DT) + " DT and " + (a.wornHelmet.DR + a.wornChestPlate.DR + a.wornPants.DR) + " DR");
            System.out.println(a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
            if(a.isDead())
            {
                System.out.println(b.name + " killed " + a.name + " with " + b.health + " HP Left.");
                break;
            }
        }
    }
}
