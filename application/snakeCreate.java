package application;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Sakshi and Tanishka
 *
 */
public class snakeCreate {
	
	/**
	 * Group of snake 
	 */
	private Group snake;
	/**
	 * List of Circle
	 */
	private ObservableList<Node> ballList;
	/**
	 *  boolean left
	 */
	private boolean leftt;
	/**
	 * boolean right
	 */
	private boolean rightt;
	/**
	 * Snake color
	 */
	public static Color c = Color.GREENYELLOW;


	/**
	 * Constructor to create Snake
	 */
	public snakeCreate( ) {
		
		snake = new Group();
		ballList = snake.getChildren();
		
	}
	
	/**
	 * @param l Set Initial Length of snake
	 */
	public void setLenght(int l) {
		int x = 400;
		
		
		
		for ( int i =0 ; i< l ; i++ ) {
			
			if (i==0) {
				Circle ball = new Circle();
				
				ball.setRadius(15);
		        ball.setLayoutY(400);
		        ball.setLayoutX(230);
		        ball.setFill(c);
		        ball.setStrokeWidth(1.3f);
		        ball.setStroke(Color.BLACK);
		       
				ballList.add(ball);
				
			}
			else {
				ballList.add(new Balls(x).getBall());
				System.out.println(x);
			}
			x = x +25;
		}
	}
	
	/**
	 * Increase Length of Snake by one unit 
	 */
	public void incLenght() {
		int n = ballList.size();
		int x = 400 + (25*n);
			ballList.add(new Balls(x).getBall());
			System.out.println(x);
			Node b = ballList.get(ballList.size()-1);
			Node d = ballList.get(0);
			b.setTranslateX(d.getTranslateX());
	}
	
	/**
	 * @return List of Snake
	 */
	public ObservableList<Node> getSnakeList(){
		return this.ballList;
	}
	
	/**
	 * @return Group of Snake
	 */
	public Group getSnake() {
		return snake;
	}
	/**
	 * Disable Left movement of Snake
	 */
	public void disableleft() {
		leftt=true;
	}
	
	/**
	 * Disable Right movement of snake
	 */
	public void disableright() {
		rightt=true;
	}
	/**
	 * Enable Left Movement of Snake
	 */
	public void enableleft() {
		leftt=false;
	}
	/**
	 * Enable Right Movement of Snake
	 */
	public void enableright() {
		rightt=false;
	}
	 /**
	 * Move Left
	 */
	public void moveLeft() {
		 
		 for ( int i =0; i<  ballList.size(); i++) {
			 Node b = ballList.get(i);
			 
			 if(leftt==false) b.setTranslateX(b.getTranslateX()-5);
		 }
	}
	    
	    /**
	     * Move Right 
	     */
	    public void moveRight() {
	    	for ( int i =0; i<  ballList.size(); i++) {
				 Node b = ballList.get(i);
				 if(rightt==false) b.setTranslateX(b.getTranslateX() + 5);
			 }
	    }
}
