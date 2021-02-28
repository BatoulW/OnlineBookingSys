package onlinebookingssystem;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class represents food booking system it implements bookable interface
 * where anything applicable to booking should have all methods in this
 * interface
 */
public class FoodBookingSystem implements bookable {

    private Food[] foodArray;

    /**
     * override of the getInvoice method from interface bookable.
     *
     * @return invoice represents that food invoice
     */
    @Override
    public Invoice getInvoice() {
        return new FoodSystemInvoice();
    }

    /**
     * This function loads food list with some predefined foods
     *
     * @param fileName the file which will contains data.
     * @throws java.io.FileNotFoundException
     */
    @Override
    public void load(String fileName) throws FileNotFoundException, IOException {
        foodArray = new Food[5];
        foodArray[0] = new Food("Pop Corn", 10, 0);
        foodArray[1] = new Food("Lays", 5, 0);
        foodArray[2] = new Food("Cola", 5, 0);
        foodArray[3] = new Food("Galaxy Choclate", 10, 0);
        foodArray[4] = new Food("Smoothie", 15, 0);
    }

    @Override
    public void updateFile() throws FileNotFoundException, IOException {
        // doing nothing
    }

    /**
     * This function is not applicable for food system as we don't add food.
     *
     * @return list of movies names
     */
    @Override
    public void add(reservable m) {
        // no add function for food
    }

    /**
     * This function return a list of food names
     *
     * @return list of movies names
     */
    @Override
    public String getNamesList() {
        String returnS = "Item\t\t\t\tPrice\n";

        for (int i = 0; i < foodArray.length; i++) {
            if (foodArray[i].getFoodName().length() == 4) {
                returnS += foodArray[i].getFoodName() + "\t\t\t\t" + foodArray[i].getFoodPrice() + " SAR\n";
            } else {
                returnS += foodArray[i].getFoodName() + "\t\t\t" + foodArray[i].getFoodPrice() + " SAR\n";
            }

        }
        return returnS;
    }

    /**
     * This method return food details using its index
     *
     * @param index index of this movie in the list
     * @return movie details
     */
    @Override
    public Food getDetails(int index) {
        return foodArray[index];
    }

    @Override
    public boolean checkAvailable(int index) {
        // TODO
        return true;
    }
}
