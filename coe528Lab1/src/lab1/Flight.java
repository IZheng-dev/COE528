package lab1;

/**
 *
 * @author Isaac Zheng (501263130)
 */

public class Flight {
    
    //Instance Variables
    private int flightNumber, capacity, numberOfSeatsLeft;
    private String origin, destination, departureTime;
    private double originalPrice;
    
    //Constructor
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice){
        //Checks if the origin and destination is same
        if (origin.equals(destination))
            throw new IllegalArgumentException("Specified Origin and Destination are the Same");
        
        //Initialize Instance Variables
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;  //Initialized based on specified capacity
        this.originalPrice = originalPrice;
    }

    //Getters and Setters
    public int getFlightNumber() {
        return flightNumber;
    }
    
    public void setFlightNumber(int flightNumber) {    
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    
     public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    //bookASeat method to book an available seat
    public boolean bookASeat(){
        if(numberOfSeatsLeft > 0){
            numberOfSeatsLeft--;
            return true;    //Returns true if booking successful
        }
        return false;   //Returns false if seats are full
    }
    
    //toString method
    @Override
    public String toString(){
        return String.format("Flight " + flightNumber + ", " + origin + " to " + destination + ", " + departureTime + ", Original Price: $%.2f", originalPrice);
    }
    
}
