package onlinebookingssystem;

/**
 * this class represents invoice object where any invoice must have customer
 * details , child classes will add its distinguished attributes it has abstract
 * method which is total cost where each child class can implement it its own
 * way
 */
public abstract class Invoice {

    // attributes
    private Customer customer;

    /**
     * Get the value of totalCost
     *
     * @return the value of totalCost
     */
    public abstract double getTotalCost();

    // default constructor
    public Invoice() {
    }

    // parameterized constructor
    public Invoice(Customer customer) {
        this.customer = customer;
    }

    /**
     * Get the value of customer
     *
     * @return the value of customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the value of customer
     *
     * @param customer new value of customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * override of the toString method.
     *
     * @return string represents that invoice details
     */
    @Override
    public String toString() {
        return "Invoice Details:\n" + "Customer Name: " + customer.getName()
                + "\nCustomer Address : " + customer.getAddress()
                + "\nCustomer Phone : " + customer.getTelephoneNumber();
    }

}
