package application;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Sakshi and Tanishka
 *
 */
public class Player implements Serializable , Comparable<Object>{
	
	/**
	 * Version UID
	 */
	private static final long serialVersionUID = -7884314732042904087L;

	/**
	 * Current Score
	 */
	private int currentScore;
	/**
	 * Snake Length
	 */
	private int snakeLength;
	/**
	 * Is Game Ended or Not
	 */
	public boolean end;
	
	/**
	 * Date at which Player if playing
	 */
	private Date date;
	
	/**
	 * Constructor to Initialize player, where its score is 0 and initial snake length 6.
	 */
	public Player() {
		currentScore = 0;
		snakeLength = 6;
		date = new Date();
	}
	
	/**
	 * method to get current score of player.
	 * @return Current Score of Player
	 */
	public int getScore() {
		return this.currentScore;
	}
	
	/**
	 * method to get the date on which the game is being played.
	 * @return Date of Playing Game
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * Method to get current snake length.
	 * @return Length of Snake 
	 */
	public int getLength() {
		return this.snakeLength;
	}
	
	/**
	 * set snake's length.
	 * @param l Set length of Snake to L 
	 */
	public void setLength(int l ) {
		this.snakeLength = l;
	}
	
	/**
	 * increases the current score by n.
	 * @param n Increase Score of Player
	 */
	public void inScore( int n ) {
		this.currentScore = this.currentScore + n;
	}
	
	/**
	 * decreases current score by n.
	 * @param n Decrease Score of Player
	 */
	public void deScore( int n ) {
		this.currentScore = this.currentScore - n;
		if(this.currentScore<0)this.currentScore=0;
	}


	@Override
	public int compareTo(Object o) {
		
		int score = ((Player) o ).getScore();
		
		return score - this.currentScore;
	}
}
