package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Sakshi and Tanishka
 *
 */
public class meController {
	
	/**
	 * Button Blue color
	 */
	@FXML
	public Button blue;
	
	/**
	 * Button Orange color
	 */
	@FXML
	public Button orange;
	
	/**
	 * Button Green color
	 */
	@FXML
	public Button green;
	
	/**
	 * Button Red color
	 */
	@FXML
	public Button red;
	
	/**
	 * Button to go Back
	 */
	@FXML
	public Button back;
	
	/**
	 * @param e Action Event to set Blue Color
	 */
	@FXML
	public void blue(ActionEvent e) {
		Balls.c = Color.CORNFLOWERBLUE;
		snakeCreate.c = Color.CORNFLOWERBLUE;
	}
	
	/**
	 * @param e Action event to change color to Orange
	 */
	@FXML
	public void orange(ActionEvent e) {
		Balls.c = Color.ORANGE;
		snakeCreate.c = Color.ORANGE;
	}
	
	/**
	 * @param e Action event to change color to Green
	 */
	@FXML
	public void green(ActionEvent e) {
		Balls.c = Color.GREENYELLOW;
		snakeCreate.c = Color.GREENYELLOW;
	}
	
	/**
	 * @param e Action event to change color to Red
	 */
	@FXML
	public void red(ActionEvent e) {
		Balls.c = Color.CORAL;
		snakeCreate.c = Color.CORAL;
	}
	
	/**
	 * @param e Action event to go Back
	 */
	@FXML
	public void back(ActionEvent e) {
		//System.exit(0);
		
		Stage stage = (Stage) back.getScene().getWindow();
	    stage.close();
	}
	
}
