
import java.util.ArrayList;
import java.util.Scanner;


public class Quizzer {
    
    public static void askQuestions(Scanner sc, ArrayList<Question> questions, ArrayList<Question> asked) {
        System.out.print("How many questions would you like? ");
        int num = Integer.parseInt(sc.nextLine());
        int correct = 0;
        for (int i = 0; i < num; i++) {
            int index = (int) (Math.random() * questions.size());
            Question q = questions.remove(index);
            asked.add(q);
            System.out.println(q.askQsn());
            String choice = sc.nextLine();
            if (q.checkAnswer(choice)) {
                correct++;
            }
        }
        System.out.println("You got " + correct + " out of " + num + " correct");
        while (asked.size() > 0) {
            questions.add(asked.remove(0));
        }
    }
}
