package onlinebookingssystem;

import java.io.FileNotFoundException;
import java.io.IOException;


/** 11/12/2017 -- Programming 2 course: course Project
 *This is the main test class where our application runs from
 */
public class TestOnlineBookingManager {

    /**
     *
     * @param args user inputs that is passed during the run time
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        MovieBookingSystem bMgr = new MovieBookingSystem();
        CarRentSystem cMgr = new CarRentSystem();
        FoodBookingSystem fMgr = new FoodBookingSystem();
                
        try {
            bMgr.load("movies.txt");            
            cMgr.load("vehicle.txt");  
            fMgr.load("");
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        UI ui = new UI(bMgr,cMgr,fMgr);
        ui.run(); //Launch the UI
    }
}
