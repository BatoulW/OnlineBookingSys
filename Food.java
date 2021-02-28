package onlinebookingssystem;

/**
 * This class represents food object
 */
public class Food implements reservable {

    // attributes
    private String foodName;
    private double foodPrice;
    private int quantity;

    // default constructor
    public Food() {
    }

    // parameterized constructor
    public Food(String foodName, double foodPrice,int q) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = q;
    }

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrices(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "Food Name: " + foodName + ", Food Price: " + foodPrice + " SAR";
    }

}
