package application;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

public interface Obstacle {
	public Group getGroup();
	public ObservableList<Node> getList();
}
