package application;

import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Sakshi and Tanishka 
 *
 */
public class LeaderBoardPage extends Application{
	
	/**
	 * Table View of Player
	 */
	private TableView<Player> table = new TableView<Player>();
	
	
    /**
     * List of Players
     */
    private final ObservableList<Player> d =
        FXCollections.observableArrayList(
            Serialize.deSeralizeCData().data
        );
    
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Scene scene = new Scene(new Group());
        stage.setTitle("Leader Board Page");
        stage.setWidth(540);
        stage.setHeight(550);
 
        table.setEditable(true);
 
        TableColumn Score = new TableColumn("Score");
        Score.setMinWidth(170);
        Score.setCellValueFactory(
                new PropertyValueFactory<Player, Integer>("Score"));
 
        TableColumn date = new TableColumn("Date");
        date.setMinWidth(330);
        date.setCellValueFactory(
                new PropertyValueFactory<Player, Date >("Date"));
 
       
        table.setItems(d);
        table.getColumns().addAll( Score, date);
 
        Button b = new Button("Back");
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll( table  );
        
        b.setTranslateY(420);
        b.setTranslateX(10);
        
        b.setOnAction(e ->{
        	Stage stage1 = (Stage) b.getScene().getWindow();
    	    stage1.close();
        });
        ((Group) scene.getRoot()).getChildren().addAll(b);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
	        scene.getStylesheets().addAll(this.getClass().getResource("leaderCss.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
	}

}
