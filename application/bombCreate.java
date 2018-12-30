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
public class bombCreate extends Powerup{
	
	
	/**
	 * Group bomb
	 */
	private Group bomb;
	/**
	 * Bomb List 
	 */
	private ObservableList<Node> bombList;
	/**
	 * Image of Bomb
	 */
	private Image bo ;
    /**
     * Image View of Bomb
     */
    private ImageView Bview ; 
	
	/**
	 * Constructor to create Bomb
	 */
	public bombCreate() {
		bomb = new Group();
		bombList = bomb.getChildren();
		bo = new Image("/images/bomb.png");
		Bview = new ImageView(bo);
	}
	
	/**
	 * checks if two bombs overlap
	 * @param bomb ImageView as parameter
	 * @return true or false
	 */
	@Override
	public boolean generateNumber( ImageView bomb)
    {
        for(int i=0;i<bombList.size();i++){

            if(bomb.getBoundsInParent().intersects(bombList.get(i).getBoundsInParent())){
                return true;
            }

        }
        return true;
    }
	
	/**
	 * Method to get the bomb created.
	 * @return Group of Bombs
	 */
	@Override
	public Group getObject() {
		return this.bomb;
	}
	
	/**
	 * Method to get the bomblist created.
	 * @return List of Bombs
	 */
	@Override
	public ObservableList<Node>  getList() {
		return this.bombList;
	}
	
	/**
	 * Sets bomb parameters.
	 * Set List of Bomb
	 */
	@Override
	public void setList() {    
	      
	        Bview.setFitHeight(0);
	        Bview.setFitWidth(0);
	     
	        Bview.setTranslateY(200);
	        Bview.setTranslateX(200 + 700);
	        bombList.addAll( Bview );
		}
	
	/**
	 * sets y coordinate of bomb image.
	 * Set Image View of Bomb
	 */
	@Override
	public void setView() {
		Bview.setTranslateY(0);
        
	}
	
	/**
	 * method to return the bomb image.
	 * @return Return ImageView
	 */
	@Override
	public ImageView getView() {
		return this.Bview;
	}
}
