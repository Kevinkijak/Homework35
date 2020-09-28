// My attempt at writing GameZone.
import java.util.Random;
import java.util.Scanner;

public class GameZone {
public static Random rand;
public static Scanner scan;


public static void RockPaperScissors(){

   final int Q = rand.nextInt(3)+1;
   final int L = rand.nextInt(3)+1;

   
   System.out.println("You played "+getItem(Q)
           +", and the computer played "+getItem(L));
  
   if(Q == L){
   System.out.println("It was a tie.");
   }
   
   else if((Q==1 && L==2) || (Q==2 && L==3) || (Q==3 && L==1)){
   System.out.println("You won.");
   }
   else{
   System.out.println("You lost.");
   }
}
public static String getItem(final int A){
   if(A == 1){
   return "Paper";
   }
   else if(A == 2){
   return "Rock";
 }
   return "Scissors";
}



public static void TwentyOne(){
   int user = 0;
   
   String L = "";
   
   do{
   final int draw = rand.nextInt(11)+1;
   System.out.println("You drew "+draw+".");
   user = user+draw;
   System.out.println("Your current total is "+user+".");
   if(user == 21){
       System.out.println("You won!");
       return;
   }
   
   if(user > 21){
       System.out.println("You lost.");
       return;
   }
  
   System.out.print("Do you want to draw another card? ");
   L = scan.nextLine();
   }while(L.compareToIgnoreCase("n")!=0);
    final int comp = rand.nextInt(8)+13;
   System.out.println("The computer drew "+comp+".");
    if(comp <= user){
   
      System.out.println("You won!");
   }
   else{
  
   System.out.println("You lost.");
   }
}

public static void main(final String[] args){
   rand = new Random();
   
   scan = new Scanner(System.in);
   
   System.out.println("*****************************************");
   
   System.out.println("*\tWelcome to the Game Zone\t*");
   
   System.out.println("*****************************************");

   int Userchoice = 0;
   
   do{
   
   System.out.println("What would you like to play?");
   
   System.out.println("1. Twenty-one");
   
   System.out.println("2. Rock Paper Scissors");
   
   System.out.println("3. Neither - I'm done!");
   
   System.out.print("Please enter the number of your choice: ");
   
   Userchoice = Integer.parseInt(scan.nextLine());

   
   switch(Userchoice){
       case 1:
       TwentyOne();
       break;
       case 2:
       RockPaperScissors();
       break;
       default:
       break;
   }
   }
   while(Userchoice != 3);
   scan.close();
   System.out.println("Thank you for playing GameZone");
}
}

