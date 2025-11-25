package lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isaac Zheng (501263130)
 */
public class FlightTest {
    
    //Instance Variable
    private Flight flight;
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        flight = new Flight(1, "Toronto", "Tokyo", "14/01/2025 6:42 am", 200, 1050.00);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of testConstructor method, of class Flight.
     */
    @Test
    public void testConstructor(){
        System.out.println("testConstructor");
        flight = new Flight(1, "Toronto", "Tokyo", "14/01/2025 6:42 am", 200, 1050.00);
        assertEquals(1, flight.getFlightNumber());
        assertEquals("Toronto", flight.getOrigin());
        assertEquals("Tokyo", flight.getDestination());
        assertEquals("14/01/2025 6:42 am", flight.getDepartureTime());
        assertEquals(200, flight.getCapacity());
        assertEquals(1050.00, flight.getOriginalPrice(),0.001);
    }
    
    /**
     * Test of testInvalidConstructor, of class Flight
     */
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor(){
        System.out.println("testInvalidConstructor");
        //Throws IllegalArgumentException because origin = destination
        flight = new Flight(2, "Toronto", "Toronto", "14/01/2025 6:42 am", 200, 1050.00);
    }

    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");
        int expResult = 1;
        int result = flight.getFlightNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        int flightNumber = 3;
        flight.setFlightNumber(flightNumber);
        assertEquals(flightNumber, flight.getFlightNumber());
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        String expResult = "Toronto";
        String result = flight.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String origin = "Ottawa";
        flight.setOrigin(origin);
        assertEquals(origin, flight.getOrigin());
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        String expResult = "Tokyo";
        String result = flight.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String destination = "Seoul";
        flight.setDestination(destination);
        assertEquals(destination, flight.getDestination());
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        String expResult = "14/01/2025 6:42 am";
        String result = flight.getDepartureTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        String departureTime = "21/02/2025 5:11 pm";
        flight.setDepartureTime(departureTime);
        assertEquals(departureTime, flight.getDepartureTime());
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        int expResult = 200;
        int result = flight.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int capacity = 150;
        flight.setCapacity(capacity);
        assertEquals(capacity, flight.getCapacity());
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("getNumberOfSeatsLeft");
        int expResult = 200;
        int result = flight.getNumberOfSeatsLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("setNumberOfSeatsLeft");
        int numberOfSeatsLeft = 11;
        flight.setNumberOfSeatsLeft(numberOfSeatsLeft);
        assertEquals(numberOfSeatsLeft, flight.getNumberOfSeatsLeft());
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        double expResult = 1050.00;
        double result = flight.getOriginalPrice();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        double originalPrice = 1350.99;
        flight.setOriginalPrice(originalPrice);
        assertEquals(originalPrice, flight.getOriginalPrice(), 0.001);
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
        flight.setNumberOfSeatsLeft(1); //Set so only 1 seat is left
        assertEquals(1, flight.getNumberOfSeatsLeft()); //Check only 1 seat left
        assertTrue(flight.bookASeat()); //Books a seat returns true
        assertEquals(0, flight.getNumberOfSeatsLeft()); //Check 0 seats left
        assertFalse(flight.bookASeat()); //No seats are left returns false
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Flight 1, Toronto to Tokyo, 14/01/2025 6:42 am, Original Price: $1050.00";
        String result = flight.toString();
        assertEquals(expResult, result);
    }
    
}
