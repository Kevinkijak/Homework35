/**this will randomly generate a number that i set the maximum too */
import java.util.Random;
public class CircleCalc 
{
    
    public static void main(String args[]) {
        Random rnd= new Random();
        int x1;
        /**below is creating to variables that i will later use to calculate
         * and print out the final answer
         */
        double radius;
        double circum;
        x1 = rnd.nextInt(25);
        radius = 3.14 * x1 * x1;
        circum = 2 * 3.14 * x1;
        /**the line of code number 18 was used for my own help to 
         * check if it was calcualting close to the right answer. Is it ok to
         * leave it inside the code for my own help?
         */
        System.out.printf("the radius is %d", x1);
        System.out.printf("The area of this circle is " +radius);
        System.out.printf("\nThe circumference of this circle is " +circum);
        /**the last two lines will print out to the user the area and circumference
         * of the circle.
         */
    }
}
