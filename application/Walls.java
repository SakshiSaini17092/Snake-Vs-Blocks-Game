package application;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Sakshi and Tanishka
 *
 */
public class Walls {
	/**
	 * Group of wall
	 */
	private Group wall;
	/**
	 * List of Walls
	 */
	private ObservableList<Node> wallList;
	
	/**
	 * Constructor of walls Class
	 */
	public Walls() {
		wall = new Group();
		wallList = wall.getChildren();
	}
	
	
	/**
	 * method to get wall.
	 * @return Group of Walls
	 */
	public Group getWall() {
		return this.wall;
	}
	
	/**
	 * method to get list of walls.
	 * @return List of Walls
	 */
	
	public ObservableList<Node> getWallList(){
		return this.wallList;
	}
	
	/**
	 * set wall list with initially 3 elements and sets its parameters and y coordinate.
	 * @param Blocks take Blocks as Input 
	 */
	public void setWallList(blocks Blocks  ) {
        Rectangle trap1;
        Rectangle trap2;
        Rectangle trap3;
        
        
        double y,x;
        boolean over=false;
        for(int i=0;i<2;i++){
           trap1=new Rectangle();
           trap2=new Rectangle();
           trap3=new Rectangle();
          
           while (!over) {
        	   y =0;
        	   x=10;
               if(i==0)y=42;
               if(i==1)y=532;
               trap1.setTranslateY(y);
               trap1.setTranslateX(x);
               over = Blocks.generateNumber(trap1);
               
               
               y =0;
        	   x=390;
               if(i==0)y=42;
               if(i==1)y=532;
               trap2.setTranslateY(y);
               trap2.setTranslateX(x);
               over = Blocks.generateNumber(trap2);
               
               y =0;
        	   x=380;
               if(i==0)y=42;
               if(i==1)y=532;
               trap3.setTranslateY(y);
               trap3.setTranslateX(x);
               over=generateNumber2(trap3);
               
           }
           over=false;
           wallList.addAll(trap1 , trap2 , trap3);
        }
    }
	
	/**
	 * checks if two rectangular walls overlap
	 * @param wall Rectangle and check weather it overlap with other wall or not
	 * @return true or false 
	 */
	public boolean generateNumber2( Rectangle wall){
        for(int i=0;i<wallList.size();i++){

            if(wall.getBoundsInParent().intersects(wallList.get(i).getBoundsInParent())){
                return false;
            }
        }
        return true;
    }
	
	/**
	 * generates wall and sets its parameter.
	 * @return Random wall
	 */
	public Node getWall1() {
		Rectangle temp=new Rectangle();
        
        Random ro = new Random();
        
        int[] dist = {76,156,236,316,396};
        int index = ro.nextInt(5);
        
        temp.setFill(Color.GREY);
        temp.setStroke(Color.BLACK);
        temp.setStrokeWidth(2.0f);
       
        temp.setTranslateX(dist[index]);
        temp.setTranslateY(0);
        temp.setWidth(10);
        temp.setHeight(60);
        
        return temp;
	}


	
}
