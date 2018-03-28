/**
 * Locaiton in a school based text adventure game. Currently a skeleton.
 * @author Sean Stern
 * @version 0.0
 * @see AdventureForSoftwareEngineering
 */
public class SubwayPlatformMorning implements Location{

    @Override
    public String getName(){
        // Location name will match class name for convenience
        return "SubwayPlatformMorning";
    }

    @Override
    public String enter(Player p) throws InterruptedException{
        System.out.println("This is a change! For changing! Hope and change!");
        System.out.println("SKELETON FOR " + getName());
        return "GameOver";
    }
}