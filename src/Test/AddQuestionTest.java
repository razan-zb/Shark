package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import Controller.Main;
import Model.Answer;
import Model.Question;
import Utils.DifficultyLevel;

class AddQuestionTest {

	@Test
	void test() {
		HashMap<Integer, Answer> myMap = new HashMap<Integer, Answer>() {{
	        put(1,new Answer(00, "A1", false) );
	        put(2, new Answer(00, "A2", false));
	        put(3, new Answer(00, "A3", true));
	        put(4, new Answer(00, "A4", false));
	    }};
		Question q=null;
		q=new Question("Q5", DifficultyLevel.EASY,myMap);
		
        //Main.system=new TheGame();
        Main.main(null);
		int qNum=Main.system.getQuestionList().size()+1;
		Main.system.addQuestion(q);
		int updatedQNum=Main.system.getQuestionList().size();
		Main.system.removeQuestion(Main.system.get_Question_by_Id(q.getContent()));
		Main.system.WriteQuestions();
		assertEquals(qNum,updatedQNum);
	}

}
