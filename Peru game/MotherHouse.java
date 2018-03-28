
/**
 * Write a description of class Airport here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MotherHouse implements Location {
    @Override
    public String getName(){
        // Location name will match class name for convenience
        return "MotherHouse";
    }

    @Override
    public String enter(Player p) throws InterruptedException{
        System.out.println("This is a change! For changing! Hope and change!");
        System.out.println("SKELETON FOR " + getName());
        return "GameOver";
    }
}