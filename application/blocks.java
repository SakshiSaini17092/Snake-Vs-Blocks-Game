package application;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author Sakshi and Tanishka
 *
 */
public class blocks {
	
	/**
	 *  Group of Traps aka blocks
	 */
	private Group trap;
	/**
	 * A list of Blocks o be displayed on Scene
	 */
	private ObservableList<Node> trapList;
	
	/**
	 * Constructor that initialize the Block Group and Block List 
	 */
	public blocks() {
		trap = new Group();
		trapList = trap.getChildren();
	}
	
	/**
	 * A method that set the Initial Traps (Blocks) list
	 */
	public void setTrapList() {
        Rectangle trap1;
        Rectangle trap2;
        Rectangle trap3;
        Rectangle trap4;
        Rectangle trap5;
        Rectangle trap6;
        
        
        double y,x;
        boolean over=false;
        for(int i=0;i<3;i++){
           trap1=new Rectangle();
           trap2=new Rectangle();
           trap3=new Rectangle();
           trap4=new Rectangle();
           trap5=new Rectangle();
           trap6=new Rectangle();
           
           while (!over) {
        	   y =0;
        	   x=10;
               if(i==0)y=0;
               if(i==1)y=260;
               if(i==2)y=490;
               trap1.setTranslateY(y);
               trap1.setTranslateX(x);
               
               over=generateNumber(trap1);
               
               
               y =0;
        	   x=390;
               if(i==0)y=0;
               if(i==1)y=260;
               if(i==2)y=490;
               trap2.setTranslateY(y);
               trap2.setTranslateX(x);
               
               over=generateNumber(trap2);
               
               y =0;
        	   x=380;
               if(i==0)y=0;
               if(i==1)y=260;
               if(i==2)y=490;
               trap3.setTranslateY(y);
               trap3.setTranslateX(x);
               
               over=generateNumber(trap3);
               
               y =0;
        	   x=351;
               if(i==0)y=0;
               if(i==1)y=260;
               if(i==2)y=490;
               trap4.setTranslateY(y);
               trap4.setTranslateX(x);
               
               over=generateNumber(trap4);
               
               y =0;
        	   x=352;
               if(i==0)y=0;
               if(i==1)y=260;
               if(i==2)y=490;
               trap5.setTranslateY(y);
               trap5.setTranslateX(x);
               
               over=generateNumber(trap5);
               
               y =0;
        	   x=353;
               if(i==0)y=0;
               if(i==1)y=260;
               if(i==2)y=490;
               trap6.setTranslateY(y);
               trap6.setTranslateX(x);
               
               over=generateNumber(trap6);
           }
           over=false;
           trapList.addAll(trap1 , trap2 , trap3, trap4,trap5,trap6);
        }
    }
	
	/**
	 * Checks if two StackPane overlaps
	 * @param trap It takes StackPane as input to check weather it overlaps with the Other traps or not 
	 * @return Return true if overlaps else False
	 */
	public boolean generateNumber( StackPane trap)
    {
        for(int i=0;i<trapList.size();i++){

            if(trap.getBoundsInParent().intersects(trapList.get(i).getBoundsInParent())){
                return false;
            }
        }
        return true;
    }
	/**
	 * Checks if two Rectangle overlaps
	 * @param trap It takes Rectangle as input to check weather it overlaps with the Other traps or not
	 * @return Return true if overlaps else False
	 */
	public boolean generateNumber( Rectangle trap)
    {
        for(int i=0;i<trapList.size();i++){

            if(trap.getBoundsInParent().intersects(trapList.get(i).getBoundsInParent())){
                return false;
            }
        }
        return true;
    }
	
	/**
	 * Method to get group of traps
	 * @return Return a Group of traps.
	 */
	public Group getBlocks() {
		return this.trap;
	}
	
	/**
	 * Method to get list of blocks
	 * @return List of Traps.
	 */
	public ObservableList<Node> getBlockList(){
		return this.trapList;
	}
	
	
	/**
	 * Generates a new block and returns it
	 * @return A random block to be added in Scene
	 */
	public StackPane getBlock() {
		Rectangle temp=new Rectangle();
        
        Color[] op = {Color.CORAL,Color.CRIMSON,Color.DARKGOLDENROD,Color.DARKORANGE};//,Color.CORNFLOWERBLUE,Color.BURLYWOOD,Color.DARKGREY,Color.DEEPPINK,Color.YELLOW,Color.YELLOWGREEN,Color.FIREBRICK,Color.GOLDENROD,Color.HOTPINK};
      
        Random ro = new Random();
        int id = ro.nextInt(10);
        String ids = Integer.toString(id+1);
        final Text text = new Text(ids);
        text.setStroke(Color.BLACK);
        StackPane stack = new StackPane();
        
        stack.getChildren().addAll(temp , text);
        int ig = ro.nextInt(4);
        temp.setFill(op[ig]);
        temp.setStroke(Color.BLACK);
        temp.setStrokeWidth(2.0f);
        stack.setTranslateY(0);
        
        stack.setId(ids);
        temp.setWidth(80);
		  temp.setHeight(40);
		  temp.setArcWidth(20.0);
		  temp.setArcHeight(30.0);
        
		  return stack;
	}
	
}
