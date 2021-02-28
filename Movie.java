package onlinebookingssystem;

/**
 * This class represents movie object
 */
public class Movie implements reservable {

    private String movieName;
    private String movieDirector;
    private int movieYear;
    private int movieMonth;
    private int movieDay;
    private String movieTime;
    private int availableSeats;

    // default constructor
    public Movie() {
    }

    // parameterized constructor
    public Movie(String movieName, String movieDirector, int movieYear, int movieMonth, int movieDay,
            String movieTime, int availableSeats) {
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieYear = movieYear;
        this.movieMonth = movieMonth;
        this.movieDay = movieDay;
        this.movieTime = movieTime;
        this.availableSeats = availableSeats;
    }

    /**
     * Get the value of availableSeats
     *
     * @return the value of availableSeats
     */
    public int getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Set the value of availableSeats
     *
     * @param availableSeats new value of availableSeats
     */
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * Get the value of movieTime
     *
     * @return the value of movieTime
     */
    public String getMovieTime() {
        return movieTime;
    }

    /**
     * Set the value of movieTime
     *
     * @param movieTime new value of movieTime
     */
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    /**
     * Get the value of movieDay
     *
     * @return the value of movieDay
     */
    public int getMovieDay() {
        return movieDay;
    }

    /**
     * Set the value of movieDay
     *
     * @param movieDay new value of movieDay
     */
    public void setMovieDay(int movieDay) {
        this.movieDay = movieDay;
    }

    /**
     * Get the value of movieMonth
     *
     * @return the value of movieMonth
     */
    public int getMovieMonth() {
        return movieMonth;
    }

    /**
     * Set the value of movieMonth
     *
     * @param movieMonth new value of movieMonth
     */
    public void setMovieMonth(int movieMonth) {
        this.movieMonth = movieMonth;
    }

    /**
     * Get the value of movieYear
     *
     * @return the value of movieYear
     */
    public int getMovieYear() {
        return movieYear;
    }

    /**
     * Set the value of movieYear
     *
     * @param movieYear new value of movieYear
     */
    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    /**
     * Get the value of movieDirector
     *
     * @return the value of movieDirector
     */
    public String getMovieDirector() {
        return movieDirector;
    }

    /**
     * Set the value of movieDirector
     *
     * @param movieDirector new value of movieDirector
     */
    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    /**
     * Get the value of movieName
     *
     * @return the value of movieName
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * Set the value of movieName
     *
     * @param movieName new value of movieName
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Movie Name: " + movieName + "\nMovie Director: " + movieDirector + "\nMovie Date : " + movieYear + "\\" + movieMonth + "\\"
                + movieDay + "\nMovie Time: " + movieTime + "\nAvailable Seats: " + availableSeats;
    }

}
