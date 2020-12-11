
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class QuizApp {

    private static ArrayList<Question> questions;
    private static ArrayList<Question> asked;

    public static void main(String[] args) throws Exception {
        System.out.println(""
                + "*          What could possibly be more fun than this?           *\n"
                + "*****************************************************************\n"
                + "*               OOP Theory and Concept Questions                *\n"
                + "*****************************************************************\n"
                + "*          Nothing. Nothing at all. Nope. Nada. Nunca.          *\n");
        Scanner sc = new Scanner(System.in);
        questions = QuestionReader.read(sc);
        asked = new ArrayList();
        

        boolean done = false;

        while (!done) {
            int input = menu(sc);
            switch (input) {
                case 1:
                    Quizzer.askQuestions(sc, questions, asked);
                    break;
                case 2:
                    displayWithAnswers();
                    break;
                case 3:
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        System.out.println("*****************************************************************\n"
                + "*               Thank you for taking CPSC 24500                 *\n"
                + "*****************************************************************");
    }

    public static int menu(Scanner sc) {
        System.out.print("Here are your choices: \n"
                + "1. Take a quiz.\n"
                + "2. See questions and answers\n"
                + "3. Exit\n"
                + "Enter the number of your choice: ");

        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public static void displayWithAnswers() {
        for (Question q : questions) {
            System.out.println(q.printWithAnswer());
        }
    }
}
