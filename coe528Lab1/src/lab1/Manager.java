package lab1;

import java.util.*;

/**
 *
 * @author Isaac Zheng (501263130)
 */
public class Manager {
    
    //Instance Variables
    ArrayList<Flight> flightsList;
    ArrayList<Ticket> ticketsList;
    
    //Constructor
    public Manager(){
        flightsList = new ArrayList<>();
        ticketsList = new ArrayList<>();
    }
    
    //createFlights method
    public void createFlights(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of Flights: "); //Prompt user to enter # of created flights
        int numFlights = input.nextInt();
        input.nextLine(); //Goes to nextline
        
        //Prompt user to enter flight details
        for (int i = 0; i < numFlights; i++){
            System.out.println("Enter Info for Flight " + (i+1));
            System.out.println("Flight Number: ");
            int flightNumber = input.nextInt();
            input.nextLine();
            
            System.out.println("Origin: ");
            String origin = input.nextLine();
            
            System.out.println("Destination: ");
            String destination = input.nextLine();
            
            System.out.println("Departure Time: ");
            String departureTime = input.nextLine();
            
            System.out.println("Capacity: ");
            int capacity = input.nextInt();
            
            System.out.println("Original Price: ");
            double originalPrice = input.nextDouble();
            
            input.nextLine();
            
            //Add the flight object to the flights array list
            Flight flight = new Flight(flightNumber, origin, destination, departureTime, capacity, originalPrice);
            flightsList.add(flight);
        }
    }
    
    //displayAvailableFlights method
    public void displayAvailableFlights(String origin, String destination){
        boolean hasFlight = false;
        System.out.println("Displayed available flights from " + origin + " to " + destination + ": ");
        for (Flight flight : flightsList){
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getNumberOfSeatsLeft() > 0){
                System.out.println(flight);
                hasFlight = true;
            }
        }
        if (!hasFlight){
            System.out.println("None Available");
            System.exit(0);
        }
    }
    
    //getFlight method
    public Flight getFlight(int flightNumber){
        for (Flight flight : flightsList){
            if (flight.getFlightNumber() == flightNumber)
                return flight;
        }
        return null; //Return null if no flight number found
    }
    
    //bookSeat method
    public void bookSeat(int flightNumber, Passenger p){
        Flight flight = getFlight(flightNumber);
        if (flight == null){
            System.out.println("No flight exists.");
            return;
        }
        
        if (flight.bookASeat()){
            Ticket ticket = new Ticket(p, flight, p.applyDiscount(flight.getOriginalPrice()));
            ticketsList.add(ticket);
            System.out.println("Flight Booked.");
            System.out.println(ticket);
        }
        else
            System.out.println("No seats available on flight.");
    }
    
    //Main method
    public static void main(String[] args){
        //Create new manager object
        Manager manager = new Manager();
        //Initialize the scanner
        Scanner input = new Scanner(System.in);
        
        //Create the flights
        manager.createFlights(); //Runs createFlights method
        
        //Display the available flights
        System.out.println("Enter Your origin: ");
        String origin = input.nextLine();
        System.out.println("Enter Your Destination: ");
        String destination = input.nextLine();
        manager.displayAvailableFlights(origin, destination);
        
        //Book a seat on the flight
        Passenger passenger;
        System.out.println("Enter flight number: ");
        int flightNumber = input.nextInt();
        input.nextLine();
        //Display the flights (tests getFlight method)
        Flight flight = manager.getFlight(flightNumber);
        if (flight == null){
            System.out.println("No flight found");
            System.exit(0);
        }
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Are you a member (y/n)?: ");
        String member = input.nextLine();
        
        if(member.equals("y")){
            System.out.println("Enter membership years: ");
            int yearsOfMembership = input.nextInt();
            input.nextLine();
            passenger = new Member(name, age, yearsOfMembership);
        }
        else
            passenger = new NonMember(name, age);
        
        manager.bookSeat(flightNumber, passenger);
        
    }
    
}
