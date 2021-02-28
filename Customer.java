package onlinebookingssystem;

/**
 * This is Customer class which represents a customer object
 *
 */
public class Customer {

    // instance variabes 
    private String name;
    private String address;
    private String telephoneNumber;
    private String customerType;

    // default constructor
    public Customer() {
    }

    // parameterized constructor
    public Customer(String name, String address, String telephoneNumber, String type) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.customerType = type;
    }

    /**
     * Get the value of customerType
     *
     * @return the value of customerType
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Set the value of customerType
     *
     * @param customerType new value of customerType
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * Get the value of telephoneNumber
     *
     * @return the value of telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Set the value of telephoneNumber
     *
     * @param telephoneNumber new value of telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * override of the toString method.
     *
     * @return string represents that person details
     */
    @Override
    public String toString() {
        return "Customer Name: " + name + "\nCustomer Address: " + address
                + "\nCustomer Telephone Number: " + telephoneNumber
                + "\nCustomer Type: " + customerType;
    }

}
