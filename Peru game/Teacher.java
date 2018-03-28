/**
 * Sample player for school based text adventure game.
 * @author Sean Stern
 * @version 1.0
 */
public class Teacher implements Player{
    
    private int health = 100;

    @Override
    public int getHealth(){
        // Teachers are always 100% healthy
        return health;
    }

    @Override
    public void changeHealth(int delta){
        health = health + delta;
    }

    @Override
    public Inventory getInventory(){
        // Teachers have nothing but their education to
        // make it through school
        return null; 
    }
}