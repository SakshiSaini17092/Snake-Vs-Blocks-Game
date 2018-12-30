package application;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

 /**
 * @author Sakshi and Tanishka
 *
 */
public class help extends StackPane {
	 
	 
    /**
     * ScrollPane 
     */
    private  ScrollPane scrollPane = new ScrollPane();
    /**
     * Virtual Box
     */
    private VBox vBox = new VBox();
     
     private String text = "\n" + 
    		 "Game Instructions:\n" + "\n" + 
    	" 1. Use right arrow key to make the snake move right while" + "\n" + "use the left arrow key to make the snake move left.\n" +
    	 " 2. Make your snake collide with the balls to increase your snakes length by the value written on the ball. \n" +
    	 " 3. If your snake collides with a block then its length decreases by the value written on the block. \n" +
    	" 4. The game gets over when the snake vanishes because of its length equating to zero. \n" +
    	" 5. The shield protects the snake for 5 seconds from the blocks but your score increases.\n" +
    	" 6. Destroy blocks destroy all blocks with a certain area and increases your score.\n" 
    	 
    	+ " 7 . Magnet collects all the balls within a area to increase your snake's length.\n"
     + " 8 . dimond adds 50 points to your score.\n"
     + " 9 . skull decreses your score by your snake current length*5 and snake's length decrease to one.\n";
     
     
     /**
     * Label 
     */
    private Label label = new Label(text);
     /**
     * Back Button
     */
    private Button button = new Button("Back");
     
     
     
     /**
     * Constructor Help
     */
    public help() {
         setMaxSize( 800, 1200);
         vBox.setMaxSize( 800, 1200);
         label.setWrapText(true);
       
         vBox.getChildren().setAll( button , label);
         scrollPane.setContent(vBox);
         scrollPane.setPrefSize( 800, 500);
         getChildren().addAll(scrollPane);
       // when button is pressed 
         button.setOnAction(e ->{
        	 Stage stage = (Stage) button.getScene().getWindow();
     	    	stage.close();
         });
     }
 }