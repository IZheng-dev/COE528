package lab2;

/**
 *
 * @author Isaac Zheng (501263130)
 */

public class ProceduralAbstraction {
    
    //Requires: None
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    // (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
    // integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        
        //Initialize the variables
        int n = 1, factorialAns = 1;
        
        //Solve factorial until it is greater than x
        while(factorialAns < x){
            n++;
            factorialAns *= n;
        }
        
        return factorialAns >= x ? n : 1; //Returns n if factorial is >= x, otherwise returns 1
        
    }
    
    //Requires: None
    //Modifies: None
    //Effects: If the matrix arr satisfies Nice property, prints the sum and
    // returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        
        //Determine of the matrix is a square matrix
        for (int[] rows : arr) {    //Iterates through each row of array
            if (rows.length != arr.length){ //Checks if column length = rows length
                return false;
            }
        }
        
        //Create a reference number based on first row of array to compare with other sums
        int sum = 0;
        for (int cols = 0; cols < arr.length; cols++)
            sum += arr[0][cols];   //Determine sum of first row
        
        //Sum of ints in each row 
        for (int[] rows: arr){
            int rowSum = 0; //Initialize the sum of the row to be 0
            for (int cols = 0; cols < arr.length; cols++)
                rowSum += rows[cols];
            if (rowSum != sum)
                return false;
        }
        
        //Sum of ints in each column
        for (int cols = 0; cols < arr.length; cols++){
            int colSum = 0; //Initialize the sum of the columns to be 0
            for (int[] rows : arr) {
                colSum += rows[cols];
            }
            if (colSum != sum)
                return false;
        }
        
        //Sum of ints in diagonals
        int diaSum1 = 0, diaSum2 = 0;
        for (int index = 0; index < arr.length; index++)
            diaSum1 += arr[index][index];
        for (int index = 0; index < arr.length; index++)
            diaSum2 += arr[index][(arr.length - 1) - index];
        if (diaSum1 != sum || diaSum2 != sum)
            return false;
        
        System.out.println("The Sum of the Nice Matrix is: " + sum);
        return true;
        
    }
    
    public static void main(String[] args){
        
        //Tests the reverseFactorial method
        //Will return smallest positive integer n
        int test1 = reverseFactorial(7);
        int test2 = reverseFactorial(24);
        int test3 = reverseFactorial(119);
        
        //Will return 1
        int test4 = reverseFactorial(0);
        int test5 = reverseFactorial(-5);
        
        System.out.println("reverseFactorial Method: ");
        System.out.println("7: "  + test1 + "\n24: " + test2 + "\n119: " + test3);
        System.out.println("0: " + test4 + "\n-5: " + test5);
        
        //Tests the isMatrixNice method
        System.out.println("isMatrixNice Method: ");
        //Nice matrix
        int[][] niceMatrix = {{2, 7, 6},
                              {9, 5, 1},
                              {4, 3, 8}};
        isMatrixNice(niceMatrix);
        
        //Not nice matrix
        int[][] notNiceMatrix = {{-3, 1, 0},
                                 {4, -3, 4,},
                                 {7, -9, 0}};
        isMatrixNice(notNiceMatrix);
        
    }


}
