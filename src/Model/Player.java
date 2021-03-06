package Model;

import java.io.Serializable;

public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id=0;
	private String PlayerName;
	private int Score;
	
	
	public Player(String playerName) {
		PlayerName = playerName;
		this.Score=0;
	}
	

	
	public String getPlayerName() {
		return PlayerName;
	}
	public int getScore() {
		return Score;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	public void setScore(int score) {
		Score = score;
	}

	@Override
	public String toString() {
		return "Player [PlayerName=" + PlayerName + ", Score=" + Score + "]";
	}
	
	
	
	

}
