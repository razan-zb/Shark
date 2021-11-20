
/**
 * 
 * @author Rawaby
 * 
 */

package Model;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;



import Utils.DifficultyLevel;


public class SysData {

	private static SysData instance = null;
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	/**
	 * Using this singleton instance to access data structures and methods
	 * 
	 * @return - SysData Class Instance
	 */
	public static SysData getInstance() {
		if (instance == null) 
		{ 
			instance = new SysData(); 
		}
		return instance;
	}

	/**
	 * Question DataStructure
	 * 
	 */
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}



	/**
	 * Adding Question To Questions DataStructure
	 * 
	 * @param question to add
	 */
	public void addQuestion(Question q) {

		if (q != null) 
			this.getQuestions().add(q);

	}

	/**
	 * removing question from Questions DataStructure
	 * 
	 * @param id - id of question to be removed
	 */
	public void removeQuestion(int id) {

		int i = -1;
		int iterator = 0;

		for (Question q : this.getQuestions()) {
			if (q.getId() == id) {
				i = iterator;
				break;
			}
			iterator++;
		}
		if (i != -1) {
			this.getQuestions().remove(i);
		}
	}

	/**
	 * 
	 * @param id - id of the question to be updated
	 * @param updated_question - new question containing all updated details
	 */
	public void editQuestion(int id, Question updated_question) {

		for (Question q : this.getQuestions()) {

			if (q.getId() == id) {
				q.setId(id);
				q.setContent(updated_question.getContent());
				q.setDifficulty(updated_question.getDifficulty());
			}
		}
	}
	
	/**
	 * Writing Questions To File Including Updated Questions
	 */
	public void WriteQuestions() {

	}

	/**
	 * Loading Questions From JSON File
	 */
	public void LoadQuestions() {

		// empty data structure before loading
		this.questions.clear();

	}
}
