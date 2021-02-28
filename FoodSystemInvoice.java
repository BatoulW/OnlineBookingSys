package onlinebookingssystem;

/**
 * This class represents food booking system invoice it inherits the invoice
 * class and add some of its own attributes to that like cinema name and movie
 * attached to this bill
 *
 */
public class FoodSystemInvoice extends Invoice {

    private Food food;
    private int noOfItemsOrdered;
    private boolean customerBoughtFood;

    /**
     * Get the value of customerBoughtFood
     *
     * @return the value of customerBoughtFood
     */
    public boolean isCustomerBoughtFood() {
        return customerBoughtFood;
    }

    /**
     * Set the value of customerBoughtFood
     *
     * @param customerBoughtFood new value of customerBoughtFood
     */
    public void setCustomerBoughtFood(boolean customerBoughtFood) {
        this.customerBoughtFood = customerBoughtFood;
    }

    /**
     * Get the value of noOfItemsOrdered
     *
     * @return the value of noOfItemsOrdered
     */
    public int getNoOfItemsOrdered() {
        return noOfItemsOrdered;
    }

    /**
     * Set the value of noOfItemsOrdered
     *
     * @param noOfItemsOrdered new value of noOfItemsOrdered
     */
    public void setNoOfItemsOrdered(int noOfItemsOrdered) {
        this.noOfItemsOrdered = noOfItemsOrdered;
    }

    /**
     * Get the value of food
     *
     * @return the value of food
     */
    public Food getFood() {
        return food;
    }

    /**
     * Set the value of food
     *
     * @param food new value of food
     */
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * Get the total value for a specific booking
     *
     * @return the value of total cost
     */
    @Override
    public double getTotalCost() {
        double total = 0.0;

        total += getFood().getFoodPrice() * noOfItemsOrdered;

        return total;
    }

    /**
     * override of the toString method.
     *
     * @return string represents that invoice details
     */
    @Override
    public String toString() {
        String returnS = "Invoice Details as below : \n";

        if (getFood().getFoodName().length() == 4) {
            returnS += getFood().getFoodName() + "\t\t\t\t"
                    + getFood().getFoodPrice() + " SAR\n"
                    + "Total:\t\t\t\t" + getTotalCost() + " SAR\n";
        } else {
            returnS += getFood().getFoodName() + "\t\t\t"
                    + getFood().getFoodPrice() + " SAR\n"
                + "Total:\t\t\t\t" + getTotalCost() + " SAR\n";

        }
        if (customerBoughtFood) {
            returnS += "\nCustomer got 10% discount\n";
            returnS += "Total before discount:\t\t\t" + getTotalCost() + " SAR\n";
            returnS += "Total after discount:\t\t\t" + (getTotalCost() - (getTotalCost() * 0.1)) + " SAR\n";
        }

        return returnS;
    }

}
