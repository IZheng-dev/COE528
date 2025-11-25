package lab1;

/**
 *
 * @author Isaac Zheng (501263130)
 */
public class Ticket {
    
    //Instance Variables
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;
    private static int ticketNum = 1;
    
    //Constructor
    public Ticket(Passenger passenger, Flight flight, double price){
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        this.number = ticketNum++;
    }
    
    //Getters and Setters
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    //toString method

    @Override
    public String toString() {
        return passenger.getName() + ", " + flight.toString() + String.format(", Ticket Price: $%.2f", price);
    }
    
}
