//this is my attempt and writting a code in java for the baseball standings assignment
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



// the code below is the main diagram/menu that the user will follow
public class BaseballStandings{
   
   public static void Welcome(){
       System.out.println("******************************************");
       System.out.println(" BASEBALL STANDING ANALYZER" );
       System.out.println("******************************************");
   }
   public static int MenuChoice(Scanner sc){
       System.out.println("Which Standings would you like to see?");
       System.out.println("1. AL East");
       System.out.println("\n2. Al Central");
       System.out.println("\n3. AL West");
       System.out.println("\n4. NL East");
       System.out.println("\n5. NL Central");
       System.out.println("\n6. NL West");
       System.out.println("\n7. Overall");
       System.out.println("\n8. Exit");
       System.out.print("Enter your choice: ");
       int choice = sc.nextInt();
       return choice;
   }
   public static double getAvg(String line){
       String[] listing = line.split("\t");
       double Played_games = (Integer.parseInt(listing[1])) + (Integer.parseInt(listing[2]));
       double average = (Integer.parseInt(listing[1])) / Played_games;
       return average;
   }
   public static void displayStats(ArrayList<String> the_standings){
       String[] listing;
       double average; 
       System.out.println("--------------------------------------------------------------------");
       System.out.println("Teams:         Wins:   Loses:    Pct:        Games Behind:" );
       System.out.println("--------------------------------------------------------------------");
       for(String standing : the_standings){
           listing = standing.split("\t");
           average = getAvg(standing);
           
           System.out.printf("%-15s%-8s%-8s%6.2f \n ", listing[0], listing[1], listing[2], average);   
       }
   }
   public static void displayStats2(ArrayList<String> the_standings){
           String[] listing;
           double average;
           System.out.println("-----------------------------");
           System.out.println("Teams:            Pct:" );
           System.out.println("-----------------------------");
           for(String standing : the_standings){
               listing = standing.split("\t");
               average = getAvg(standing);
               System.out.printf("%-15s%6.2f\n ", listing[0], average);
               
              
           }
  
       }
   public static void byAvg(ArrayList<String> teams, String line){
       double average = getAvg(line); 
       double second_average;
       int position = -1;
       for(int i =0; i < teams.size(); i++){
           second_average = getAvg(teams.get(i)); 
           if(average > second_average){
               position = i;
               break;
           }
       }
       if(position < 0){
           teams.add(line);
       } else {
           teams.add(position, line);
       }
   }
   
   public static void main(String[] args) {
      
       Scanner sc = new Scanner(System.in);
       System.out.println("Please enter the name of the file: ");
       String fname = sc.nextLine();
       // above will read the file that the user has given the lacation
       //through the path of the computer
       
       ArrayList<String> aleast = new ArrayList<String>();
       ArrayList<String> alcentral = new ArrayList<String>();
       ArrayList<String> alwest = new ArrayList<String>();
       ArrayList<String> nleast = new ArrayList<String>();
       ArrayList<String> nlcentral = new ArrayList<String>();
       ArrayList<String> nlwest = new ArrayList<String>();
       ArrayList<String> target = null;
       ArrayList<String> overall = new ArrayList<String>(); 
       
       String line, sem;
       String[] listing;
       boolean move_along;
       int user_choice;
       try{
           Scanner fsc = new Scanner(new File(fname));
           while(fsc.hasNextLine()){
               line = fsc.nextLine();
               listing = line.split("\t");
               if(listing[0].equalsIgnoreCase("LEAGUE")){
                   sem = listing[1].toUpperCase();
                   if(sem.equalsIgnoreCase("AL EAST")){
                       target = aleast;
                   } else if(sem.equalsIgnoreCase("AL CENTRAL")){
                       target = alcentral;
                   }else if(sem.equalsIgnoreCase("AL West")){
                       target = alwest;
                   }else if(sem.equalsIgnoreCase("NL EAST")){
                       target = nleast;
                   }else if(sem.equalsIgnoreCase("NL CENTRAL")){
                       target = nlcentral;
                   }else if(sem.equalsIgnoreCase("NL WEST")){
                       target = nlwest;
                   }
               } else{
                   target.add(line);
                   byAvg(overall, line);
               }
            // if the file cannot be read the code below will be put to work
           }
           Welcome(); 
           fsc.close(); 
           move_along = true;  
       } catch(Exception ex){
           System.out.println("Couldn't read the file!");
           move_along = false;      
       }
       if(move_along){
           do{
               user_choice = MenuChoice(sc);
               if(user_choice == 1){
                   displayStats(aleast);
               } else if(user_choice == 2){
                   displayStats(alcentral);
               } else if(user_choice == 3){
                   displayStats(alwest);
               } else if(user_choice == 4){
                   displayStats(nleast);
               } else if(user_choice == 5){
                   displayStats(nlcentral);
               } else if(user_choice == 6){
                   displayStats(nlcentral);
               } else if(user_choice == 7){
                   displayStats2(overall);
               }
           } while (user_choice != 8);
       }
    }
}
// the code above will dispay whatever the user chose