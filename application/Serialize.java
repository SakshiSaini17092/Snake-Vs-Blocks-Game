package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;

/**
 * @author Sakshi and Tanishka
 *
 */
public class Serialize {
	
	/**
	 * @param b Take the Leader Board to Serialize
	 */
	public static void seralizeCData( LeaderBoard b ) {

		String filename = "F:\\board.txt";
		
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);		
			out.writeObject(b);
			
			out.close();
			file.close();
		}	catch(IOException ex) {
			System.out.println("IOException is caught");
		}	
	}
	/**
	 * @return Return the Deserialized Leader Board
	 */
	public static LeaderBoard deSeralizeCData() {	
		String filename = "F:\\board.txt";
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream inp = new ObjectInputStream(file);
			
			LeaderBoard d = (LeaderBoard) inp.readObject();
			
			Collections.sort(d.data);
			inp.close();
			file.close();
			return d;
		}	catch (ClassNotFoundException ex) {
			System.out.println();
		}	catch (IOException ex) {
			System.out.println("IOException is caught");
		}
		return new LeaderBoard();
	}
	
	
	/**
	 * @param p Player to be SerialZed
	 */
	public static void seralizePlayer( Player p ) {

		String filename = "F:\\player.txt";
		
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);		
			out.writeObject(p);
			
			out.close();
			file.close();
		}	catch(IOException ex) {
			System.out.println("IOException is caught");
		}	
	}
	/**
	 * @return Desiralized player
	 */
	public static Player deSeralizeTimeLine() {
		String filename = "F:\\player.txt";
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream inp = new ObjectInputStream(file);
			
			Player d = (Player) inp.readObject();
			inp.close();
			file.close();
			return d;
		}	catch (ClassNotFoundException ex) {
			System.out.println();
		}	catch (IOException ex) {
			System.out.println("IOException is caught");
		}
		return new Player();
	}
	
}
