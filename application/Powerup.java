package application;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Powerup {
	public void setView() {
	}
	public ImageView getView() {
		return null;
	}
	public void setList() {
	}
	public boolean generateNumber( ImageView x)
    {
		return false;
		
    }
	public Group getObject() {
		return null;
		
	}
	public ObservableList<Node>  getList() {
		return null;
		
	}
}
