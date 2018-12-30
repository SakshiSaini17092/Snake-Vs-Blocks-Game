package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Sakshi and Tanishka
 *
 */
public class LeaderBoard implements Serializable {
	
	/**
	 * Version UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * List of Player 
	 */
	public ArrayList<Player> data;
	
	/**
	 * Constructor of Leader Board
	 */
	public LeaderBoard(){
		data= new ArrayList<Player>();
	}
	
	/**
	 * @return List of Player
	 */
	public ArrayList<Player> getData(){
		return this.data;
	}
	
	/**
	 * Display the Data
	 */
	public void display() {
		
		Collections.sort(data);
		for ( int i =0 ; i< data.size() ; i++ ) {
			
			System.out.println(" Score : " + data.get(i).getScore() + " Date : "  + data.get(i).getDate().toString() );
			
		}
	}
	
	/**
	 * @param p Accepts a Player to be added in List
	 */
	public void add( Player p ) {

		Collections.sort(data);
		
		if ( data.size() == 0 )
			data.add(p);
		
		else if ( data.get(data.size()-1).getScore() < p.getScore() ) {
			
			if ( data.size() ==10 ){
				data.remove(data.size()-1);
				data.add(p);	
			}
			else
				data.add(p);	
		}
	}
	
	
}
