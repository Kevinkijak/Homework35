


public class QuestionPrinter {
    
    public static String printQuestion(Question question){
        String qsn = question.question + "\n"
                + "a. " + question.choices.get(0) + "\n"
                + "b. " + question.choices.get(1) + "\n"
                + "c. " + question.choices.get(2) + "\n"
                + "d. " + question.choices.get(3) + "\n"
                + "Type the letter of your choice: ";
        
        return qsn;
    }
}
