package onlinebookingssystem;

/**
 * This class represents cinema system invoice it inherits the invoice class and
 * add some of its own attributes to that like cinema name and movie attached to
 * this bill
 *
 */
public class CinemaSystemInvoic extends Invoice {
    
    public static final double SEAT_COST = 15;

    // attributes
    private String cinemaName;
    private Movie movie;
    private String seatNumber;
    private int numberOfTickets;
    
    // default constructor
    public CinemaSystemInvoic() {
        super();
    }

    // parameterized constructor
    public CinemaSystemInvoic(String cinemaName, Movie movie, Customer customer, String seatNo,int numberOfTickets) {
        super(customer);
        this.cinemaName = cinemaName;
        this.movie = movie;
        this.seatNumber = seatNo;
        this.numberOfTickets = numberOfTickets;
    }

    /**
     * Get the total value for a specific booking
     *
     * @return the value of total cost
     */
    @Override
    public double getTotalCost() {
        return SEAT_COST * getNumberOfTickets();

    }   

    /**
     * Get the value of numberOfTickets
     *
     * @return the value of numberOfTickets
     */
    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    /**
     * Set the value of numberOfTickets
     *
     * @param numberOfTickets new value of numberOfTickets
     */
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    /**
     * Get the value of seatNumber
     *
     * @return the value of seatNumber
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * Set the value of seatNumber
     *
     * @param seatNumber new value of seatNumber
     */
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Get the value of movie
     *
     * @return the value of movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Set the value of movie
     *
     * @param movie new value of movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Get the value of cinemaName
     *
     * @return the value of cinemaName
     */
    public String getCinemaName() {
        return cinemaName;
    }

    /**
     * Set the value of cinemaName
     *
     * @param cinemaName new value of cinemaName
     */
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }
    
    /**
     * override of the toString method.
     *
     * @return string represents that invoice details
     */
    @Override
    public String toString() {
        return super.toString() + "Cinema Name: " + getCinemaName()
                + "\nMovie Name: " + movie.getMovieName()
                + "\nNumber of purchased Tickets : " + getNumberOfTickets()
                + "\nSeat Number : " + getSeatNumber() 
                + "\nTotal Cost : " + getTotalCost() +" SAR"
                + "\nThanks you !";
        
    }

}
