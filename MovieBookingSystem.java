package onlinebookingssystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents Movie booking system it implements bookable interface
 * where anything applicable to booking should have all methods in this
 * interface
 *
 * @author alshaerahmed
 */
public class MovieBookingSystem implements bookable {

    private ArrayList<Movie> moviesList;

    /**
     * override of the getInvoice method from interface bookable.
     *
     * @return invoice represents that movie invoice
     */
    @Override
    public Invoice getInvoice() {
        return new CinemaSystemInvoic();
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
        file = new File(fileName);
        Scanner scan = new Scanner(file);
        moviesList = new ArrayList<>();
        Movie newMovie = new Movie();
        // reading file
        while (scan.hasNext()) {

            String nextLine = scan.nextLine();
            if (nextLine.contains("MovieName=")) {
                newMovie.setMovieName(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()));
            } else if (nextLine.contains("MoiveDirector=")) {
                newMovie.setMovieDirector(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()));
            } else if (nextLine.contains("Movieday=")) {
                newMovie.setMovieDay(Integer.parseInt(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()).trim()));
            } else if (nextLine.contains("Moviemonth=")) {
                newMovie.setMovieMonth(Integer.parseInt(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()).trim()));
            } else if (nextLine.contains("Movieyear=")) {
                newMovie.setMovieYear(Integer.parseInt(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()).trim()));
            } else if (nextLine.contains("MovieTime=")) {
                newMovie.setMovieTime(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()));
            } else if (nextLine.contains("availableseats=")) {
                newMovie.setAvailableSeats(Integer.parseInt(nextLine.substring(nextLine.indexOf("=") + 1, nextLine.length()).trim()));
                moviesList.add(newMovie);
                newMovie = new Movie();
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
        File file;
        file = new File("movies.txt");
        PrintWriter writer = new PrintWriter(file);
        for (Movie movie : moviesList) {
            writer.println("MovieName= " + movie.getMovieName());
            writer.println("MoiveDirector= " + movie.getMovieDirector());
            writer.println("Movieday= " + movie.getMovieDay());
            writer.println("Moviemonth= " + movie.getMovieMonth());
            writer.println("Movieyear= " + movie.getMovieYear());
            writer.println("MovieTime= " + movie.getMovieTime());
            writer.println("availableseats= " + movie.getAvailableSeats());
            writer.println("");
        }
        writer.close();
    }

    /**
     * This function adds a movie to the moviesList and then call update file
     *
     * @param m movie to add
     */
    @Override
    public void add(reservable m) {
        Movie mm = (Movie) m;
        moviesList.add(mm);
        try {
            updateFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This function return a list of movies names
     *
     * @return list of movies names
     */
    @Override
    public String getNamesList() {
        String returnString = "";
        for (int i = 0; i < moviesList.size(); ++i) {
            returnString += i + 1 + ". " + moviesList.get(i).getMovieName() + ".\n";
        }
        return returnString;
    }

    /**
     * This method return movie details using its index
     *
     * @param index index of this movie in the list
     * @return movie details
     */
    @Override
    public Movie getDetails(int index) {
        return moviesList.get(index);
    }

    /**
     * This method updates movie date and time based on their index in the list.
     *
     * @param index index of the movie in the list
     * @param newYear new year value of this movie
     * @param newMonth new month value of this movie
     * @param newDay new day value of this movie
     * @param newTime new time value of this movie
     * @return the updated movie
     */
    public Movie updateMovieByIndex(int index, int newYear, int newMonth, int newDay, String newTime) {
        Movie movieToBeUpdated = moviesList.get(index);
        movieToBeUpdated.setMovieDay(newDay);
        movieToBeUpdated.setMovieMonth(newMonth);
        movieToBeUpdated.setMovieYear(newYear);
        movieToBeUpdated.setMovieTime(newTime);

        try {
            updateFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return movieToBeUpdated;
    }

    /**
     * This method checks if a specific movie at specific index is available for
     * booking
     *
     * @param index index of the movie in the list
     * @return movie available or not
     */
    @Override
    public boolean checkAvailable(int index) {
        return moviesList.get(index).getAvailableSeats() > 0;
    }
}
