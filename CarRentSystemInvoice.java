package onlinebookingssystem;

/**
 * This class represents car rent system invoice it inherits the invoice class
 * and add some of its own attributes to that like cinema name and movie
 * attached to this bill
 *
 */
public class CarRentSystemInvoice extends Invoice {

    public static final double SUV_COST_PER_DAY = 250;
    public static final double SEDAN_COST_PER_DAY = 150;

    // attributes
    private Vehicle vehicle;
    private int noOfDays;
    
    

    /**
     * Get the value of noOfDays
     *
     * @return the value of noOfDays
     */
    public int getNoOfDays() {
        return noOfDays;
    }

    /**
     * Set the value of noOfDays
     *
     * @param noOfDays new value of noOfDays
     */
    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    /**
     * Get the value of vehicle
     *
     * @return the value of vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Set the value of vehicle
     *
     * @param vehicle new value of vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Get the total value for a specific booking
     *
     * @return the value of total cost
     */
    @Override
    public double getTotalCost() {
        double total = 0.0;
        if (getVehicle().getVehicleType().equals("SUV")) {
            total = getNoOfDays() * SUV_COST_PER_DAY;
        } else {
            total = getNoOfDays() * SEDAN_COST_PER_DAY;
        }
        return total;
    }
    
    /**
     * override of the toString method.
     *
     * @return string represents that invoice details
     */
    @Override
    public String toString() {
        return super.toString() + "\nCar Model: " + this.getVehicle().getModel()
                + "\nCar Type: " + this.getVehicle().getVehicleType()
                + "\nModel Year : " + this.getVehicle().getCarYear()       
                + "\nTotal rent days : " + this.getNoOfDays()
                + "\nTotal Cost : " + getTotalCost() +" SAR"
                + "\nThanks you !";
        
    }
    
    

}
