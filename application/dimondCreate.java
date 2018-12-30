package application;

//import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Sakshi saini and Tanishka
 *
 */
public class dimondCreate extends Powerup{
	
	
	/**
	 * Group of Diamond 
	 */
	private Group dimond;
	/**
	 * List of Diamond to be displayed
	 */
	private ObservableList<Node> dimondList;
	/**
	 * Image of Diamond
	 */
	private Image di ;
	/**
	 * ImageView of Diamond
	 */
	private ImageView Dview ; 
	
	/**
	 * Constructor to Create Diamond
	 */
	public dimondCreate() {
		dimond = new Group();
		dimondList = dimond.getChildren();
		di = new Image("/images/dimond.png");
		Dview = new ImageView(di);
	}
	
	/**
	 * Checks if two diamond images overlap.
	 * @param dimond ImageView to be added
	 * @return true and false
	 */
	@Override
	public boolean generateNumber( ImageView dimond)
  {
      for(int i=0;i<dimondList.size();i++){

          if(dimond.getBoundsInParent().intersects(dimondList.get(i).getBoundsInParent())){
              return true;
          }
      }
      return true;
  }
	
	/**
	 * Method to get diamond.
	 * @return Group of Diamond
	 */
	@Override
	public Group getObject() {
		return this.dimond;
	}
	
	/**
	 * Method to get diamond list.
	 * @return List of Diamond 
	 */
	@Override
	public ObservableList<Node>  getList() {
		return this.dimondList;
	}
	
	/**
	 * Sets the parameters if the Diamond image.
	 * Set List of Diamond 
	 */
	@Override
	public void setList() {    
	      
	        Dview.setFitHeight(0);
	        Dview.setFitWidth(0);
	   
	        Dview.setTranslateY(200);
	        Dview.setTranslateX(200 + 700);
	        dimondList.addAll( Dview );
		}
	
	/**
	 * Sets y coordinate of the diamond image.
	 * Set View of Diamond
	 */
	@Override
	public void setView() {
		Dview.setTranslateY(0);
      
	}
	
	/**
	 * method to get diamond image.
	 * @return Return ImageView of Diamond
	 */
	@Override
	public ImageView getView() {
		return this.Dview;
	}
}
