package lab1;

/**
 *
 * @author Isaac Zheng
 */
public class Member extends Passenger {
    
    //Instance Variables
    private int yearsOfMembership;
    
    //Constructor
    public Member(String name, int age, int yearsOfMembership){
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    //Getters and Setters
    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    
    //Overrides applyDiscount method
    @Override
    public double applyDiscount(double p){
        if (yearsOfMembership > 5)
            return p * 0.50; //Returns price with 50% discount
        else if (yearsOfMembership > 1 && yearsOfMembership <= 5)
            return p * 0.90; //Returns price with 10% discount
        else
            return p; //Returns price with no discount
    }
    
}

