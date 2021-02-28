package onlinebookingssystem;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This interface should be implemented by any system which applies booking
 * mechanism anything bookable should implement this
 *
 */
public interface bookable {

    // method to get invoice
    public Invoice getInvoice();    
    // method to load file database for any implementation
    public void load(String fileName)throws FileNotFoundException, IOException;
    // method to update file database for any implementation
    public void updateFile() throws FileNotFoundException, IOException;
    // add any reservable item to the list of reservables
    public void add(reservable m);
    // add a list of reservables and return it on string
    public String getNamesList();
    // get details of any reservable (Movie/Car)
    public reservable getDetails(int index);
    // check availability of any reservable item
    public boolean checkAvailable(int index);
    
}
