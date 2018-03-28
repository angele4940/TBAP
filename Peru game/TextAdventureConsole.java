/**
 * A text adventure console that binds together an {@link Engine} and a
 * {@link Game}. 
 * @author Sean Stern
 * @version 1.0
 */
public class TextAdventureConsole{

    /**
     * Creates a predetermined {@link Game}, inserts it into an {@link Engine}
     * and plays the game.
     *
     * @throws InterruptedException if the game is interrupted while paused
     */
    public static void main(String[] args) throws InterruptedException{
        Game g = new AdventureForSoftwareEngineering();
        Engine e = new SimpleEngine(g);
        e.start();
        while(!e.isGameDone()){
            e.goToNextState();
        }
    }
}