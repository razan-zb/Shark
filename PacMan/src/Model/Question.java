package Model;

import java.io.Serializable;
import java.util.HashMap;

import Utils.DifficultyLevel;

public class Question implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int id;
	private String content;
	private DifficultyLevel difficulty;
	private HashMap<Integer,Answer> answers;
	private String team;
	
	/**
	 * Question class constructor
	 * @param id - question ID
	 * @param content - question's content
	 * @param difficulty - difficulty of the question
	 * @param answers - collection of answers
	 */
	public Question(int id, String content, DifficultyLevel difficulty, HashMap<Integer,Answer> answers) {
		super();
		this.id = id;
		this.content = content;
		this.difficulty = difficulty;
		this.answers = answers;
	}
	
	/**
	 * Question class constructor
	 * @param id - question ID
	 * @param content - question's content
	 * @param difficulty - difficulty of the question
	 * @param answers - collection of answers
	 */
	public Question(int id, String content, DifficultyLevel difficulty, HashMap<Integer,Answer> answers,String team) {
		super();
		this.id = id;
		this.content = content;
		this.difficulty = difficulty;
		this.answers = answers;
		this.team=team;
	}


	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the difficulty
	 */
	public DifficultyLevel getDifficulty() {
		return difficulty;
	}

	/**
	 * @param difficulty - the difficulty to set
	 */
	public void setDifficulty(DifficultyLevel difficulty) {
		this.difficulty = difficulty;
	}


	/**
	 * @return the answers
	 */
	public HashMap<Integer,Answer> getAnswers() {
		return answers;
	}
	
	/**
	 * 
	 * @param answer
	 * 
	 */
	
	public void setAnswerById(Integer id,String content) {
		answers.get(id).setContent(content);
		
	}
	
	
	public void editAnswer(Integer id,String content,boolean isCorrect) {
		answers.get(id).setContent(content);
		answers.get(id).setCorrect(isCorrect);
		
	}
	
	public Boolean addAnswer(Answer answer) {
		if(answer != null) {
		   this.answers.put(answer.getId(),answer);
		   return true;
		}
		return false;
		
	}
	
	
	/**
	 * 
	 * @param answer
	 * @return true if answer removed successfully, false otherwise
	 */
	@SuppressWarnings({ "unlikely-arg-type" })
	public Boolean removeAnswer(Answer answer) {
		if(answer != null) {
		      this.answers.remove(answer);
		      return true;
		}
		return false;
		
	}
	
	/**
	 * Used to update answers
	 * @param updatedAnswers
	 */
	public void updateAnswers(HashMap<Integer,Answer> updatedAnswers) {
		this.answers.values().clear();		
		for(Answer a : updatedAnswers.values()) {
			this.addAnswer(a);
		}
	}
	

	
	/**
	 * returns the correct answer
	 * @return answer-the correct answer of the question
	 * @throws Exception 
	 */
	public Answer getCorrectAnswer() throws Exception {
		for(Answer a : answers.values()) {
			if (a.isCorrect()==true) {
				return a;
			}
		}
		throw new Exception("The question doesn't have correct answer");
		
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", difficulty=" + difficulty + ", answers=" + answers
				+ "]";
	}

}
