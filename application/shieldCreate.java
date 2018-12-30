package application;

import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class shieldCreate extends Powerup{
	
	
	/**
	 * Group of Shield
	 */
	private Group shield;
	/**
	 * List of Shield
	 */
	private ObservableList<Node> shieldList;
	/**
	 * Image of Shield
	 */
	private Image sh ;
    /**
     * Image View of Shield
     */
    private ImageView Iview ; 
	
	/**
	 * Constructor of Shield Create
	 */
	public shieldCreate() {
		shield = new Group();
		shieldList = shield.getChildren();
		sh = new Image("/images/shield.png");
		Iview = new ImageView(sh);
	}
	
	/**
	 * checks if two shields overlap.
	 * @param trap ImageView as a parameter and check if it overlapping with another ImageView or not  
	 * @return boolean true or false
	 */
	@Override
	public boolean generateNumber( ImageView trap){
        for(int i=0;i<shieldList.size();i++){

            if(trap.getBoundsInParent().intersects(shieldList.get(i).getBoundsInParent())){
                return true;
            }
        }
        return true;
    }
	
	/**
	 * method to get shield.
	 * @return Group of Shield
	 */
	@Override
	public Group getObject() {
		return this.shield;
	}
	
	/**
	 * method to get shield list.
	 * @return List of Shield
	 */
	@Override
	public ObservableList<Node>  getList() {
		return this.shieldList;
	}
	
	/**
	 * Set parameters of Initial Shield List
	 */
	@Override
	public void setList() {    
	      
	        Iview.setFitHeight(0);
	        Iview.setFitWidth(0);
	     
	        Iview.setTranslateY(320);
	        Iview.setTranslateX(200 + 700);
	        shieldList.addAll( Iview );
		}
	
	/**
	 * Set View of Shield created
	 */
	@Override
	public void setView() {
		Iview.setTranslateY(0);
        Random ro = new Random();
        int[] dist = {0,60,120,180,240,300};
        int index = ro.nextInt(6);
        Iview.setTranslateX(dist[index]);
        
	}
	
	/**
	 * method to get shield image.
	 * @return Image View of Shield
	 */
	@Override
	public ImageView getView() {
		return this.Iview;
	}
	
}
