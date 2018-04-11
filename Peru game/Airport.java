import java.util.Scanner;
/**
 * Write a description of class Airport here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Airport implements Location {
    @Override
    public String getName(){
        // Location name will match class name for convenience
        return "Airport";
    }
    
    private int timeHr = 7;
    private String month = "December";
    private int day = 8;

    @Override
    public String enter(Player p) throws InterruptedException{

        decideToGetUp(p);

        String nextLocationName;
        if(timeHr > 8){
            // After 8:30 MT, you're going to be late :-(
            int hrsLate = timeHr - 8;
            int ptsOff = hrsLate * 20;
            System.out.format("\n##\n##RUNNING %d HRS LATE.\n" +
                "##LOSE %d HEALTH!\n##\n\n", hrsLate, ptsOff);
            p.changeHealth(-ptsOff);
            Thread.sleep(1000);
            System.out.println("'Oh gosh, I'm late!'");
            Thread.sleep(1000);
            System.out.println("'Let's get dressed...'");
            Thread.sleep(1000);
            System.out.println("'And head to the subway!'");
            Thread.sleep(1000);
            nextLocationName = "MOTHERHOUSE";
        }
        else if(timeHr > 6){
            // After 6:30 MT, you have just enough time to go
            System.out.println("'Oh gosh, I'm need to go!'");
            Thread.sleep(1000);
            System.out.println("'Let's get dressed...'");
            Thread.sleep(1000);
            System.out.println("'And grab my wallet, keys, and phone!'");
            Thread.sleep(1000);
            // TBD: Create inventory items including cash, keys, phone
            // and add this to player inventory for future locations
            // e.g.
            // Item bills = new Money("Money", 20);
            // Item keys = new Keys("Keys", 5);
            // Item phone = new Phone("Phone");
            nextLocationName = "MOTHERHOUSE";
        }
        else{
            // 6:30 MT or earlier, enough time to shower, eat, grab
            // all stuff
            System.out.println("'Nothing like a shower to wake me up!'");
            Thread.sleep(1000);
            System.out.println("'...bruffin mah teef...'");
            Thread.sleep(1000);
            System.out.println("'Let's get dressed...'");
            Thread.sleep(1000);
            System.out.println("'Grab my wallet, keys, and phone.'");
            Thread.sleep(1000);
            System.out.println("'Wow, I nearly forgot to bring the first " +
                "day's quizzes!'");
            Thread.sleep(1000);
            // TBD: Create inventory items including cash, keys, phone,
            // student quizzes this to player inventory for future
            // locations
            // e.g.
            // Item bills = new Money("Money", 20);
            // Item keys = new Keys("Keys", 5);
            // Item phone = new Phone("Phone");
            // Item quizzes = new Quizzes("Quiz", 28);
            nextLocationName = "CEMETERY";
        }

        // Before leaving the location, always 
        //  -check if we've hit game over (player is dead)
        //  -update the day and time for the next time player enters
        if(p.getHealth() <= 0){
            nextLocationName = "GameOver";
        }
        timeHr = 4;
        day++;
        // TBD: update month correctly

        return nextLocationName;
    }

    private void decideToGetUp(Player p) throws InterruptedException{
        Scanner sc = new Scanner(System.in);

        String sound = "beep!";
        for(int i = 0; i < 2; i++){
            System.out.println();
            for(int j = 0; j < 3; j++){
                System.out.println(sound);
                // Pauses command line for 750 ms (0.75 sec)
                Thread.sleep(750);
            }
            System.out.print("\n**\n**[enter] TO CONTINUE\n**\n> ");
            // Pauses command line until user hits enter
            sc.nextLine();
            sound = sound.toUpperCase();
            Thread.sleep(1000);
        }

        System.out.format("\n%d:30 (MT) on %s %d.\n", timeHr, month, day );
        Thread.sleep(1000);
        System.out.println("'The first day of school--and I'm exhausted.'");
        Thread.sleep(1000);

        String options = "sdw";
        int selectedIdx = -1;
        while(!(selectedIdx >= 0)){
            System.out.print("**\n**[s] TO STAY\n**[d] TO DINE\n"+
                "**[w] TO WAKE UP\n**\n> ");
            String userInput = sc.next();
            Thread.sleep(1000);
            selectedIdx = options.indexOf(userInput);
            if(selectedIdx == 0){
                STAY(p);
            }
            else if(selectedIdx == 1){
                DINE(p);
            }
        }
    }

    private void STAY(Player p) throws InterruptedException{
        timeHr+=1;
        // Snoozing gives 10 health points
        p.changeHealth(10);
        System.out.println("\n##\n##STAY.\n##Lose 5 HEALTH!\n" + 
            "##\n");
        Thread.sleep(1000);
        decideToGetUp(p);
    }

    private void DINE(Player p) throws InterruptedException{
        timeHr+=2;
        // Dismissing gives 20 health points  
        p.changeHealth(20);
        System.out.println("\n##\n##DINE\n##GAINED 20 HEALTH!\n" +
            "##\n");
        Thread.sleep(1000);
        decideToGetUp(p);
    }
}
