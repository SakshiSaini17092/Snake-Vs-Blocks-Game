package application;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * @author Sakshi saini and Tansihka Srivastava 
 * Version 5.0
 *
 */
public class BallList {
	
	
	/**
	 * Group of balls
	 */
	private Group ball;
	/**
	 * A list of Balls
	 */
	private ObservableList<Node> ballList;
	
	/**
	 * Constructor to create a new Group and Ball List
	 */
	public BallList() {
		ball = new Group();
		ballList = ball.getChildren();
	}
	
	/**To get Group of Balls
	 * @return returns the Group of balls
	 */
	public Group getBall() {
		return this.ball;
	}
	
	/** To get List of Balls to display on Screen
	 * @return returns the List of balls
	 */
	public ObservableList<Node> getBallList(){
		return this.ballList;
	}	
	
	/**
	 * Initialize Ball List with 2 Balls
	 */
	public void setBallList() {
    	Circle trap1;
    	Circle trap2;
        double y,x;
       
        boolean over=false;
        for(int i=0;i<2;i++){
           trap1=new Circle();
           trap2=new Circle();
           while (!over) {
        	   y =0;
        	   x=100;
               if(i==0)y=160;
               if(i==1)y=400;
               
               trap1.setTranslateY(y);
               trap1.setTranslateX(x);

               over=generateNumber1(trap1);
               
               y =0;
        	   x=101;
               if(i==0)y=160;
               if(i==1)y=400;
               
               trap2.setTranslateY(y);
               trap2.setTranslateX(x);

               over=generateNumber1(trap2);
          }         
           over=false;
           ballList.addAll(trap1,trap2 );
        }       
	}
	
	/**
	 * This function checks if two balls are overlapping or not
	 * @param trap take an argument Circle
	 * @return Returns a boolean if intersects with other Balls present in List.
	 */
	public boolean generateNumber1( Circle trap)
    {
        for(int i=0;i<ballList.size();i++){

            if(trap.getBoundsInParent().intersects(ballList.get(i).getBoundsInParent())){
                return true;
            }
        }
        return true;
    }
	/**
	 * Generates a ball return it
	 * @return Return a random Ball to be added in list
	 */
	public Node getBalli() {
		Circle temp=new Circle();
        
        Random ro = new Random();
        int id = ro.nextInt(5);
        String ids = Integer.toString(id+1);
        final Text text = new Text(ids);
        text.setStroke(Color.BLACK);
        StackPane stack = new StackPane();
        
        stack.getChildren().addAll(temp , text);
     
        temp.setFill(Color.GOLD);
        temp.setStroke(Color.BLACK);
        temp.setStrokeWidth(2.0f);
        stack.setTranslateY(0);       
        stack.setId(ids);       
        temp.setRadius(15);
        return stack;
	}

}
