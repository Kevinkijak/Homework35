// This is my attempt at creating the floor java program
import java.util.Scanner;

public class Flooring {

   public static void main(final String[] args) {
       /*
        * We are creating variables for the are of the house and each board area will
        * use this to find how many it needs to add for the total area
        */
       double roomarea = 0, length, width;
       final int area_of_each_board = 30 * 6;

       int number_of_boards = 0;
       final int number_of_packages = 0;
       double total_package_cost = 0.0;

       /*
        * putting the line of code below with the scanner function will allow whatever
        * the user inputs to be read
        */
       final Scanner sc = new Scanner(System.in);

       /*
        * the new print statements are asking what the user length and width is and it
        * will save there values entered
        */

       System.out.print("Whats the width of the room(ft):");
       width = sc.nextDouble();

       System.out.print("Whats the length of the room (ft):");
       length = sc.nextDouble();

       /*
        * The 5 lines below are basically the whole math behind the code
        */
       roomarea = length * width * 12;

       
       roomarea = (int) (roomarea + (roomarea * 0.20));

       
       number_of_boards = (int) Math.ceil((roomarea / area_of_each_board));

       
       number_of_boards = number_of_boards / 6;

       
       total_package_cost = packages_cost(number_of_boards);

       /*
        * the 2 lines below are going to print out the final lines of code expected
        * which are how many boards need with the total cost you will spend for buying
        * the packages
        */
       System.out.println("You need to buy " + number_of_boards + " packages of laminate boards .");
       System.out.println("Total cost of packages :$" + total_package_cost);

   }

   private static double packages_cost(final int number_of_packages) {
       final double cost_of_one_package = 24.99;

       return number_of_packages * cost_of_one_package;
   }

}