package lab1;

/**
 *
 * @author Isaac Zheng
 */
public abstract class Passenger {
    
    //Instance Variables
    private String name;
    private int age;
    
    //Constructor
    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    //applyDisccount abstract method
    public abstract double applyDiscount(double p);
    
}

