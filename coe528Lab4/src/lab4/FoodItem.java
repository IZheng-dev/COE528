package lab4;

/**
 *
 * @author Isaac Zheng
 */
public class FoodItem extends FoodComponent{
    
    //Instance variables
    private double price;
    
    //Constructor
    public FoodItem(String foodName, double price){
        super(foodName);
        this.price = price;
    }
    
    //Methods
    
    @Override
    public double getPrice(){
        return price;
    }
    
    @Override
    public void print(int level){
        System.out.println("\t".repeat(level) + "FoodItem: " + foodName + ", " + price);
    }
    
}
