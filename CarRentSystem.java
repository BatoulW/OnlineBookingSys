package onlinebookingssystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents Car booking system
 *
 * 
 */
public class CarRentSystem implements bookable {

    private ArrayList<Vehicle> carsList;

    /**
     * override of the getInvoice method from interface bookable.
     *
     * @return invoice represents that car rent invoice
     */
    @Override
    public Invoice getInvoice() {
        return new CarRentSystemInvoice();
    }

    /**
     * This function reads the existing records from file and creates the
     * initial database , user can add on it and update and delete .
     *
     * @param fileName the file which will contains data.
     * @throws java.io.FileNotFoundException
     */
    @Override
    public void load(String fileName) throws FileNotFoundException, IOException {
        File file;
        file = new File(fileName);// أمرر اسم الملف الي انشأته
        Scanner scan = new Scanner(file);// لفتح الملف
        carsList = new ArrayList<>();
        Vehicle newVehicle = new Vehicle();
        // reading file
        while (scan.hasNext()) {

            String nextLine = scan.nextLine();
            if (nextLine.contains("CarModel=")) {
                newVehicle.setModel(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()));
            } else if (nextLine.contains("CarType=")) {
                newVehicle.setVehicleType(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()));
            } else if (nextLine.contains("CarYear=")) {
                newVehicle.setCarYear(Integer.parseInt(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()).trim()));
            } else if (nextLine.contains("Available=")) {
                if (nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()).trim().equalsIgnoreCase("yes")) {
                    newVehicle.setAvailable(true);
                } else {
                    newVehicle.setAvailable(false);
                }
                carsList.add(newVehicle);// أسند مؤشر للاراي ليست
                newVehicle = new Vehicle();// اذا في سيارة ثانية مشان يخزنها بالدورة الثانية
            }
        }
    }

    /**
     * This function reads the existing records from file and creates/update the
     * database , user can add on it and update and delete .
     *
     * @throws java.io.FileNotFoundException
     */
    @Override
    public void updateFile() throws FileNotFoundException, IOException {
        File file = new File("vehicle.txt");
        PrintWriter writer = new PrintWriter(file);// اوبيجكت للكتابة على الفايل وتاخذ بالباراميتر اوبيجكت الفايل
        for (Vehicle vehicle : carsList) {
            writer.println("CarModel= " + vehicle.getModel());
            writer.println("CarType= " + vehicle.getVehicleType());
            writer.println("CarYear= " + vehicle.getCarYear());
            writer.println("Available= " + (vehicle.isAvailable() ? "yes" : "no"));
            writer.println("");
        }

        writer.close();// بعد الكتابة لازم نغلق الملف
    }

    /**
     * This function adds a car to the cars List and then call update file
     *
     * @param m movie to add
     */
    @Override
    public void add(reservable m) {
        Vehicle v = (Vehicle) m;// يؤشر على مؤشرموجود
        carsList.add(v);
        try {
            updateFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This function return a list of vehicles names
     *
     * @return list of cars details
     */
    @Override
    public String getNamesList() {
        String returnString = "";
        for (int i = 0; i < carsList.size(); ++i) {
            returnString += (i + 1) + ". " + carsList.get(i).getModel() + " -- " + carsList.get(i).getVehicleType()+ " -- " + carsList.get(i).getCarYear() + ".\n";
        }
        return returnString;
    }

    /**
     * This method return car details using its index
     *
     * @param index index of this car in the list
     * @return car details
     */
    @Override
    public Vehicle getDetails(int index) {
        return carsList.get(index);
    }

    /**
     * This function remove a car to the cars List and then call update file
     *
     * @param m movie to add
     */
    public void removeVehicle(int m) {
        carsList.remove(m);
        try {
            updateFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method checks if a specific car at specific index is available for
     * booking
     *
     * @param index index of the car in the list
     * @return car available or not
     */
    @Override
    public boolean checkAvailable(int index) {
        return carsList.get(index).isAvailable();
    }
}
