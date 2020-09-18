
import java.util.Random;
public class CircleCalc 
{
    
    public static void main(String args[]) {
        Random rnd= new Random();
        int x1;
        double radius;
        double circum;
        x1 = rnd.nextInt(25);
        radius = 3.14 * x1 * x1;
        circum = 2 * 3.14 * x1;
        System.out.printf("the radius is %d", x1);
        System.out.printf("The area of this circle is " +radius);
        System.out.printf("\nThe circumference of this circle is " +circum);
    }
}
