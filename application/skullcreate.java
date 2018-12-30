package application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Sakshi and Tanishka
 *
 */
public class skullcreate implements Obstacle{
	
	
	/**
	 * Group Skull
	 */
	private Group skull;
	/**
	 * Skull List 
	 */
	private ObservableList<Node> skullList;
	/**
	 * Image of Skull
	 */
	private Image sk ;
    /**
     * Image View if Skull
     */
    private ImageView Sview ; 
	
	
	/**
	 * Constructor to create skull
	 */
	public skullcreate() {
		skull = new Group();
		skullList = skull.getChildren();
		sk = new Image("/images/skull4.jpg");
		Sview = new ImageView(sk);
	}
	
	/**
	 * checks if two skulls overlap.
	 * @param trap Take ImageView and check if it overlap with other or not
	 * @return boolean True or false
	 */
	//@Override
	public boolean generateNumber( ImageView trap){
        for(int i=0;i<skullList.size();i++){

            if(trap.getBoundsInParent().intersects(skullList.get(i).getBoundsInParent())){
                return true;
            }
        }
        return true;
    }
	
	/**
	 * method to get skull
	 * @return Group of Skull
	 */
	@Override
	public Group getGroup() {
		return this.skull;
	}
	
	/**
	 * method to get the list of skull.
	 * @return List Skull
	 */
	@Override
	public ObservableList<Node>  getList() {
		return this.skullList;
	}
	
	/**
	 * Set parameters for Initial Skull List
	 */
	
	public void setskullList() {    
	      
	        Sview.setFitHeight(0);
	        Sview.setFitWidth(0);
	     
	        Sview.setTranslateY(640);
	        Sview.setTranslateX(200 + 700);
	        skullList.addAll( Sview );
		}
	
	/**
	 * Set View of Skull
	 */
	
	public void setView() {
		Sview.setTranslateY(0);
	}
	
	/**
	 * method to get skull image.
	 * @return Image View of Skull
	 */

	public ImageView getView() {
		return this.Sview;
	}
}

