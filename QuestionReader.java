
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;




public class QuestionReader {
    
    public static ArrayList<Question> read(Scanner sc) throws Exception{
        ArrayList<Question> questions = new ArrayList();
        JSONParser parser = new JSONParser();
        String name = "";
        System.out.print("Enter name of file containing questions: ");
        name = sc.nextLine();
        JSONObject obj = (JSONObject) parser.parse(new FileReader(name));
        JSONArray array = (JSONArray) obj.get("questions");

        for (int i = 0; i < array.size(); i++) {
            JSONObject qsn = (JSONObject) array.get(i);
            Question question = new Question(qsn.get("question").toString(), qsn.get("answer").toString());
            question.addChoice(qsn.get("a").toString());
            question.addChoice(qsn.get("b").toString());
            question.addChoice(qsn.get("c").toString());
            question.addChoice(qsn.get("d").toString());
            questions.add(question);
        }
        
        return questions;
    }
}
