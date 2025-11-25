package lab4;

/**
 *
 * @author Isaac Zheng
 */
abstract class FoodComponent {
    
    //Instance variables
    protected String foodName;
    
    //Constructor
    public FoodComponent(String foodName){
        this.foodName = foodName;
    }
    
    //Methods
    public abstract double getPrice();
    
    public abstract void print(int level);
    
}
