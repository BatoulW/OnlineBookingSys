package onlinebookingssystem;

/**
 * a class represents vehicle attributes as an object
 */
public class Vehicle implements reservable{

    // attributes
    private String vehicleType;
    private String model;
    private int carYear;
    private boolean available;

    // default constructor
    public Vehicle() {
    }

    // parameterized constructor
    public Vehicle(String vehicleType, String model, int year,boolean av) {
        this.vehicleType = vehicleType;
        this.model = model;
        this.carYear = year;
        available = av;
    }

    /**
     * Get the value of available
     *
     * @return the value of available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Set the value of available
     *
     * @param available new value of available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Get the value of carYear
     *
     * @return the value of carYear
     */
    public int getCarYear() {
        return carYear;
    }

    /**
     * Set the value of carYear
     *
     * @param carYear new value of carYear
     */
    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    /**
     * Get the value of model
     *
     * @return the value of model
     */
    public String getModel() {
        return model;
    }

    /**
     * Set the value of model
     *
     * @param model new value of model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Get the value of vehicleType
     *
     * @return the value of vehicleType
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Set the value of vehicleType
     *
     * @param vehicleType new value of vehicleType
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * override of the toString method.
     *
     * @return string represents that person details
     */
    @Override
    public String toString() {
        return "\nVehicle Details: " + "\nVehicle  Type: " + vehicleType + "\nModel:" + model
                + "\nModel Year:" + carYear;
    }

}
