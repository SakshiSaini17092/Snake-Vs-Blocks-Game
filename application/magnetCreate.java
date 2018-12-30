package application;

//import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Sakshi and Tanishka
 *
 */

public class magnetCreate extends Powerup{
		
	/**
	 * Group of Magnet
	 */
	private Group magnet;
	/**
	 * List of Magnet 
	 */
	private ObservableList<Node> magnetList;
	/**
	 * Image of Magnet
	 */
	
	private Image mg ;
    /**
     * ImageView of Magnet
     */
    private ImageView Mview ; 
	
	/**
	 * Constructor to create Magnet image
	 */
	public magnetCreate() {
		magnet = new Group();
		magnetList = magnet.getChildren();
		mg = new Image("/images/magnet.png");
		Mview = new ImageView(mg);
	}
	
	/**
	 * checks it two magnets overlap.
	 * @param trap Take Image View and check weather it overlaps with other Objects
	 * @return true or false
	 */
	@Override
	public boolean generateNumber( ImageView trap)
    {
        for(int i=0;i<magnetList.size();i++){

            if(trap.getBoundsInParent().intersects(magnetList.get(i).getBoundsInParent())){
                return true;
            }
        }
        return true;
    }
	
	/**
	 * method to get magnet
	 * @return Group of Magnet
	 */
	@Override
	public Group getObject() {
		return this.magnet;
	}
	
	/**
	 * method to get magnet list created.
	 * @return List of Magnets 
	 */
	@Override
	public ObservableList<Node>  getList() {
		return this.magnetList;
	}
	
	/**
	 * Set parameters for the magnets generated in the list.
	 */
	@Override
	public void setList() {    
	      
	        Mview.setFitHeight(0);
	        Mview.setFitWidth(0);
	     
	        Mview.setTranslateY(640);
	        Mview.setTranslateX(200 + 700);
	        magnetList.addAll( Mview );
		}
	
	/**
	 * Sets y coordinate of the magnet image.
	 */
	@Override
	public void setView() {
		Mview.setTranslateY(0);
        
	}
	
	/**
	 * method to get magnet image.
	 * @return Image View of Magnet
	 */
	@Override
	public ImageView getView() {
		return this.Mview;
	}
}

