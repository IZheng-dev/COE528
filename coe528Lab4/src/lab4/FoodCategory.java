package lab4;

/**
 *
 * @author Isaac Zheng
 */

import java.util.*;

public class FoodCategory extends FoodComponent{
    
    //Instance variables
    private ArrayList<FoodComponent> foodComps = new ArrayList();
    
    //Constructor
    public FoodCategory(String foodName){
        super(foodName);
    }
    
    //Methods
    
    //Add method
    public void add(FoodComponent component){
        foodComps.add(component);
    }
    
    //Remove method
    public void remove(FoodComponent component){
        foodComps.remove(component);
    }
    
    @Override
    public double getPrice(){
        double totalPrice = 0;
        for (FoodComponent component : foodComps)
            totalPrice += component.getPrice();
        
        return totalPrice;
    }
    
    @Override
    public void print(int level){
        System.out.println("\t".repeat(level) + "FoodCategory (" + foodName + ", " + getPrice() + ") contains:");
        for (FoodComponent component: foodComps){
            component.print(level+1);
        }
        
    }
    
}
