package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Model.Answer;
import Model.Player;
import Model.Question;
import Utils.DifficultyLevel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


public class TheGame implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static TheGame thegame = null;
	private static int numberOfQuestion = 0;
	
	private HashMap<Integer,Question> questionList;
	private List<Player> playersHistory;
	
	public static TheGame getInstance() {
	        
	        if(thegame == null){
	        	thegame =  new TheGame();
	        }
	        return thegame;
	     
	    }



	public TheGame()
	{
		System.out.println("H");
		questionList = new HashMap<>();
		playersHistory = new ArrayList<>();
		numberOfQuestion = 0;
		
	}
	
	 public static void updateCurrentInstance(TheGame shared){
	      
		 thegame=shared;
       
     }



	public static TheGame getThegame() {
		return thegame;
	}



	public HashMap<Integer,Question> getQuestionList() {
		return (HashMap<Integer,Question>) questionList;
	}



	public static void setThegame(TheGame thegame) {
		TheGame.thegame = thegame;
	}



	public void setQuestionList(HashMap<Integer, Question> questionList) {
		this.questionList = questionList;
	}
	
	
	
	public List<Player> getPlayersHistory() {
		return playersHistory;
	}



	public void setPlayersHistory(List<Player> playersHistory) {
		this.playersHistory = playersHistory;
	}
	
	



	public static int getNumberOfQuestion() {
		return numberOfQuestion;
	}



	public static void setNumberOfQuestion(int numberOfQuestion) {
		TheGame.numberOfQuestion = numberOfQuestion;
	}



	//to Add question to the game
	public boolean add_player_to_theHistory(Player p) {
		if(p== null)
			return false;
		else
			playersHistory.add(p);
		return true;
	}
	
	
	public void editQuestionByID(int id, Question updated_question) {
	
        Question q=this.questionList.get(id);
		if (q.getId() == id) {
			q.setId(id);
			q.setContent(updated_question.getContent());
			q.setDifficulty(updated_question.getDifficulty());
			q.updateAnswers(updated_question.getAnswers());
		}
	
	return;
	}
	
	/**
	 * Writing Questions To File Including Updated Questions
	 */
	public void WriteQuestions() {
		
		int correct = 0;
		int difficulty = 0;
		JsonArray questions = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		
		for (Question ques : this.questionList.values()) {
			JsonObject question = new JsonObject();
			JsonArray answerArray = new JsonArray();
			for (Answer ans : ques.getAnswers().values()) {
				if (ans.isCorrect())
					correct = ans.getId();
				answerArray.add(ans.getContent());
			}
			
			if (ques.getDifficulty().equals(DifficultyLevel.EASY)) {
				difficulty = 1;
			} else if (ques.getDifficulty().equals(DifficultyLevel.MEDIUM)) {
				difficulty = 2;
			} else if (ques.getDifficulty().equals(DifficultyLevel.HARD)) {
				difficulty = 3;
			}

			question.addProperty("question", ques.getContent());
			question.add("answers", answerArray);
			question.addProperty("correct_ans", String.valueOf(correct));

			question.addProperty("level", String.valueOf(difficulty));
			question.addProperty("team", "animal");

			questions.add(question);

		}

		jsonObject.add("questions", questions);

		//Write JSON file
		try {
			Writer writer = new FileWriter("QuestionsFormat.json");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(jsonObject, writer);
			writer.flush();
			writer.close();
			System.out.println("Done Successfully!");
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Loading Questions From JSON File
	 */
	public void LoadQuestions() {
		
		// empty data structure before loading
		this.questionList.clear();
		
		Gson gson = new Gson();
		JsonReader reader = null;
		try {
			reader = new JsonReader(new FileReader("QuestionsFormat.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();
		final JsonArray data = jsonObject.getAsJsonArray("questions");

		for (JsonElement element : data) {
			Question q;
			String content = ((JsonObject) element).get("question").getAsString();

			// question answers
			JsonArray answersArray = (((JsonObject) element).getAsJsonArray("answers"));

			@SuppressWarnings("unchecked")
			ArrayList<String> answers = gson.fromJson(answersArray, ArrayList.class);
		
			int difficulty = ((JsonObject) element).get("level").getAsInt();
			int correct = ((JsonObject) element).get("correct_ans").getAsInt();
			String team = ((JsonObject) element).get("team").getAsString();
			if (this.questionList.values().size() > 0) {
				q = new Question(this.numberOfQuestion+1, content, null,new HashMap<Integer,Answer>(), team);
			} else {
				q = new Question(1, content, null, new HashMap<Integer,Answer>(), team);
			}
			DifficultyLevel diff_level;
			if (difficulty == 1) {
				diff_level = DifficultyLevel.EASY;
			} else if (difficulty == 2) {
				diff_level = DifficultyLevel.MEDIUM;
			} else {
				diff_level = DifficultyLevel.HARD;
			}

			q.setDifficulty(diff_level);

			int correctAnswer_Checker = 0;

			HashMap<Integer,Answer> theAnswers=new HashMap<Integer,Answer>();
			for (String s : answers) {
				correctAnswer_Checker++;
				Answer a = null;

				if (correctAnswer_Checker == correct) {
					a = new Answer(correctAnswer_Checker, s, true);
				} else {
					a = new Answer(correctAnswer_Checker, s, false);
				}
				theAnswers.put(correctAnswer_Checker,a);
				q.addAnswer(a);
			}
			
			addQuestion(q);
		}
	}

	
	//to Add question to the game
		public boolean addQuestion(Question q) {
			if(q== null)
				return false;
			else {
				questionList.put(q.getId(),q);
				update_numberOfQuestion1(1);
			}
				
			return true;
		}
		
		public boolean removeQuestion(Question q)
		{
			if(q == null)
				return false;
			else {
				if(questionList.remove(q.getId(), q))
					update_numberOfQuestion1(-1);
					
				
			}
			
			return true;

		}
		
		
		public void update_numberOfQuestion1(int i) {
			numberOfQuestion+=i;
		}
		
		public Question get_Question_by_Id(int i) {
			return questionList.get(i);
		}




}
