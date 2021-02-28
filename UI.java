package onlinebookingssystem;

import java.util.Scanner;

/**
 * This class is responsible for the user interface and user interactions
 */
public class UI {

    public static int EXIT = 3;
    public static final String CINEMA_NAME = "Jeddah Cinema";

    private int userInput;
    private MovieBookingSystem movieBookingManager;
    private CarRentSystem carBookingManager;
    private FoodBookingSystem foodBookingManager;

    // instance variables 
    Scanner input;

    // constructor
    public UI(MovieBookingSystem mMgr, CarRentSystem cMgr, FoodBookingSystem fMgr) {
        movieBookingManager = mMgr;
        carBookingManager = cMgr;
        foodBookingManager = fMgr;
        input = new Scanner(System.in);
    }

    // methods
    public void run() {
        // Read user commands and execute them    
        do {
            System.out.println("\n~~~~~~~~~~~~~~~~~Welcome To Online Booking System~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Online Cinema Booking System");
            System.out.println("2. Online Car Rental System");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");
            userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    do {
                        System.out.println("1. Online Movie Booking System");
                        System.out.println("2. Online Resturant Booking System");
                        System.out.println("3. Return to Previous Menu");
                        System.out.print("Please choose an option: ");
                        userInput = input.nextInt();
                        switch (userInput) {
                            case 1:
                                manageMovieSystem(userInput);
                                break;
                            case 2:
                                manageResturantSystem(userInput);
                                break;
                        }
                    } while (userInput != 3);
                    break;
                case 2:
                    manageCarSystem(userInput);
                    break;
                case 3:
                    System.out.println("Good Day!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    /**
     * This method is responsible for managing user interaction for movies
     *
     * @param userInput input
     */
    private void manageMovieSystem(int userInput) {
        do {
            System.out.println("1.Admin - Add new Movie.");
            System.out.println("2.Admin - Update movie date/time.");
            System.out.println("3.Customer - Book Movie ticket");
            System.out.println("4.Return to main menu");
            System.out.print("Please choose an option: ");
            userInput = input.nextInt();
            switch (userInput) {
                case 1:

                    System.out.print("Please Enter Movie Name: ");
                    input.nextLine();
                    String movieName = input.nextLine();
                    System.out.print("Please Enter Movie Director Name: ");
                    String directorName = input.nextLine();
                    System.out.print("Please Enter Movie Day: ");
                    int daay = input.nextInt();
                    System.out.print("Please Enter Movie Month: ");
                    int month = input.nextInt();
                    System.out.print("Please Enter Movie Year: ");
                    int year = input.nextInt();
                    System.out.print("Please Enter Movie Time (HH:MM PM/AM): ");
                    input.nextLine();
                    String time = input.nextLine();
                    System.out.print("Please Enter Available Seats: ");
                    int avaSeats = input.nextInt();

                    Movie newMovie = new Movie(movieName, directorName, year, month, daay, time,
                            avaSeats);
                    movieBookingManager.add(newMovie);
                    System.out.println("Movie: " + movieName + " has been added into the system");
                    break;
                // handling update Movie
                case 2:
                    System.out.print(movieBookingManager.getNamesList());
                    System.out.print("Please choose movie: ");
                    userInput = input.nextInt() - 1;
                    System.out.println(movieBookingManager.getDetails(userInput));
                    System.out.println("Please enter new Date and Time");
                    System.out.print("New Year: ");
                    int newYear = input.nextInt();
                    System.out.print("New Month: ");
                    int newMonth = input.nextInt();
                    System.out.print("New Day: ");
                    int newDay = input.nextInt();
                    System.out.print("New Time (HH:MM AM/PM): ");
                    input.nextLine();
                    String newTime = input.nextLine();
                    Movie updatedMovie = movieBookingManager.updateMovieByIndex(userInput, newYear, newMonth, newDay, newTime);
                    System.out.println("Movie: " + updatedMovie.getMovieName() + " , has been updated successfully!!!!!");
                    break;
                // book movie ticket
                case 3:
                    System.out.print(movieBookingManager.getNamesList());
                    System.out.print("Please choose movie to book: ");
                    userInput = input.nextInt() - 1;
                    Movie choosenMovie = movieBookingManager.getDetails(userInput);
                    System.out.println(choosenMovie);
                    boolean movieAvailableForBooking = movieBookingManager.checkAvailable(userInput);
                    if (!movieAvailableForBooking) {
                        System.out.println("unfortunately Movie: " + choosenMovie.getMovieName() + " is not available for booking as number of seats is zero !!!");
                    } else {
                        System.out.print("Please enter number of tickets you want: ");
                        int ticketsNo = input.nextInt();
                        if (ticketsNo > choosenMovie.getAvailableSeats()) {
                            System.out.println("Sorry number of available seats is less than requested tickets");
                        } else {
                            choosenMovie.setAvailableSeats(choosenMovie.getAvailableSeats() - ticketsNo);
                            System.out.print("Enter Customer Name: ");
                            input.nextLine();
                            String customerName = input.nextLine();
                            System.out.print("Enter Customer Adress: ");
                            String customerAddress = input.nextLine();
                            System.out.print("Enter Customer Phone: ");
                            String telephoneNumber = input.next();
                            System.out.print("Choose Seat Number: ");
                            String seatNumber = input.next();
                            Customer customer = new Customer(customerName, customerAddress, telephoneNumber, "Cinema Customer");
                            CinemaSystemInvoic invoice = (CinemaSystemInvoic) movieBookingManager.getInvoice();//ترجع اوبجيكت من نوع انفويس (سوبر)
                            invoice.setCinemaName(CINEMA_NAME);
                            invoice.setMovie(choosenMovie);
                            invoice.setNumberOfTickets(ticketsNo);
                            invoice.setCustomer(customer);
                            invoice.setSeatNumber(seatNumber);

                            // printing invoice
                            System.out.println(invoice);
                        }
                    }
                    break;
            }
        } while (userInput != 4);
    }

    /**
     * This method is responsible for managing user interaction for cars
     *
     * @param userInput input
     */
    private void manageCarSystem(int userInput) {
        do {
            System.out.println("1.Add new Car/Truck.");
            System.out.println("2.Remove Car/Truck.");
            System.out.println("3.Rent Car/Truck.");
            System.out.println("4.Return to main menu");
            System.out.print("Please choose an option: ");
            userInput = input.nextInt();
            switch (userInput) {

                case 1:
                    System.out.print("Please Enter Car Model: ");
                    input.nextLine();
                    String carModel = input.nextLine();
                    System.out.print("Please Enter Car Model Year: ");
                    int modelYear = input.nextInt();
                    System.out.print("Please Enter Car Type :\n1. SEDAN\n2. SUV ");
                    int sedanOrUSV = input.nextInt();
                    String carType = "";
                    if (sedanOrUSV == 1) {
                        carType = "SEDAN";
                    } else if (sedanOrUSV == 2) {
                        carType = "SUV";
                    }
                    // creating object
                    Vehicle newVehicle = new Vehicle(carType, carModel, modelYear, true);
                    carBookingManager.add(newVehicle);
                    System.out.println("Car: " + carModel + " has been added into the system");
                    break;
                case 2:
                    System.out.print(carBookingManager.getNamesList());
                    System.out.print("Please choose car to remove: ");
                    userInput = input.nextInt() - 1;
                    Vehicle v = carBookingManager.getDetails(userInput);
                    System.out.println(v);
                    System.out.println("Are you sure you want to remove from System?\n1. Yes\n2. No");
                    System.out.print("Please choose an option: ");
                    String result = input.next();
                    if (result.equals("1") || result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("y")) {
                        carBookingManager.removeVehicle(userInput);
                        System.out.println("Car: " + v.getModel() + " , has been remmoved successfully!!!!!");
                    }

                    break;
                // handling rent car
                case 3:
                    System.out.print(carBookingManager.getNamesList());
                    System.out.print("Please choose car to rent: ");
                    userInput = input.nextInt() - 1;
                    Vehicle choosenCar = carBookingManager.getDetails(userInput);
                    System.out.println(choosenCar);
                    boolean carAvailableForBooking = carBookingManager.checkAvailable(userInput);
                    if (!carAvailableForBooking) {
                        System.out.println("unfortunately car: " + choosenCar.getModel() + " is not available for rent as it's already rented!!!");
                    } else {
                        System.out.print("Please enter number of days you want to rent: ");
                        int numberOfDays = input.nextInt();
                        choosenCar.setAvailable(false);
                        System.out.print("Enter Customer Name: ");
                        input.nextLine();
                        String customerName = input.nextLine();
                        System.out.print("Enter Customer Adress: ");
                        String customerAddress = input.nextLine();
                        System.out.print("Enter Customer Phone: ");
                        String telephoneNumber = input.next();
                        Customer customer = new Customer(customerName, customerAddress, telephoneNumber, "Cinema Customer");
                        CarRentSystemInvoice invoice = (CarRentSystemInvoice) carBookingManager.getInvoice();
                        invoice.setCustomer(customer);
                        invoice.setNoOfDays(numberOfDays);
                        invoice.setVehicle(choosenCar);

                        // printing invoice
                        System.out.println(invoice);

                    }
                    break;
            }
        } while (userInput != 4);
    }

    /**
     * This method is responsible for managing user interaction for resturant
     *
     * @param userInput input
     */
    private void manageResturantSystem(int userInput) {
        do {
            System.out.println("1.Order Food");
            System.out.println("2.Return to main menu");
            System.out.print("Please choose an option: ");
            userInput = input.nextInt();
            switch (userInput) {
                // book movie ticket
                case 1:
                    System.out.print(foodBookingManager.getNamesList());
                    System.out.print("Please choose food : ");
                    userInput = input.nextInt() - 1;
                    Food choosenFood = foodBookingManager.getDetails(userInput);
                    System.out.println(choosenFood);
                    System.out.print("Please enter quantity of " + choosenFood.getFoodName() + " you want: ");
                    int quantity = input.nextInt();
                    if (quantity <= 0) {
                        System.out.println("Sorry quantity should be more than 0");
                    } else {
                        choosenFood.setQuantity(quantity);
                        System.out.print("Enter Customer Name: ");
                        input.nextLine();
                        String customerName = input.nextLine();
                        Customer customer = new Customer(customerName, "", "", "Food Customer");
                        System.out.println("Did this customer bought a movie ticket?\n1. Yes\n2. No");
                        System.out.print("Please choose an option: ");
                        boolean customerBoughtTicket = false;
                        String result = input.next();
                        if (result.equals("1") || result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("y")) {
                            customerBoughtTicket = true;
                        }
                        System.out.println("");
                        FoodSystemInvoice invoice = (FoodSystemInvoice) foodBookingManager.getInvoice();// يرجع اوبجيكت من نوع انفويس داون كاستينغ
                        invoice.setFood(choosenFood);
                        invoice.setCustomerBoughtFood(customerBoughtTicket);
                        invoice.setNoOfItemsOrdered(quantity);
                        invoice.setCustomer(customer);

                        // printing invoice
                        System.out.println(invoice);
                        userInput = 2;
                    }

                    break;
            }
        } while (userInput != 2);
    }

}
