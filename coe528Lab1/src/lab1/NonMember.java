package lab1;

/**
 *
 * @author Isaac Zheng
 */
public class NonMember extends Passenger {
    
    //Constructor 
    public NonMember(String name, int age){
            super(name, age);
    }
    
    //Overrides applyDiscount method
    @Override
    public double applyDiscount(double p){
        if (getAge() > 65)
            return p * 0.90; //Returns price with 10% discount for elders
        else
            return p; //No discount
    }
    
}

