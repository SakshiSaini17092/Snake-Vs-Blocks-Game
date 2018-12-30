package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Sakshi saini and Tanishka
 *
 */
public class Balls {
	
	/**
	 *  A Circle that is head of snake
	 */
	private Circle ball;
	
	/**
	 * Color of the snake that can be changed with button
	 */
	public static Color c = Color.GREENYELLOW;	
	/**
	 * It takes the value for y coordinate of the ball as a parameter and sets the x coordinate of the ball initially at the center of the screen but can be changed later.   
	 * @param y Constructor that takes parameter y that is the y coordinate on y axis at which ball would be present
	 */
	public Balls( int y ) {
		 
		ball = new Circle();
		
		ball.setRadius(15);
        ball.setLayoutY(y);
        ball.setLayoutX(230);
        ball.setFill(c);
        ball.setStrokeWidth(1.3f);
        ball.setStroke(Color.BLACK);
	}
	
	/**
	 * Method to get the ball created.
	 * @return Returns the Ball to be added in the snake.
	 */
	public Circle getBall() {
		return ball;
	}

}
