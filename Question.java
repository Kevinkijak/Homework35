
import java.util.ArrayList;




public class Question {

    String question;
    String answer;
    ArrayList<String> choices;

    public Question(String question, String answer) {
        choices = new ArrayList();
        this.answer = answer;
        this.question = question;
    }

    public void addChoice(String choice) {
        choices.add(choice);
    }

    public boolean checkAnswer(String choice) {

        if (choice.equalsIgnoreCase(answer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Sorry. The correct answer is " + answer);
            return false;
        }
    }

    public String printWithAnswer() {
        String str = answer + " " + question;
        return str;
    }

    public String askQsn() {
        return QuestionPrinter.printQuestion(this);
    }
}
