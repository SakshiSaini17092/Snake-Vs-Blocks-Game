package application;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 * @author Sakshi and Tanishka
 *
 */
public class Main extends Application  {
	
	 /**
	 * Media Player
	 */
	private MediaPlayer Mediaplayer;
	 /**
	 * Setting to ON and OFF music
	 */
	private int set=0;
	 
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Media audio=new Media(Main.class.getResource("back (2).mp3").toExternalForm());
		
        Mediaplayer = new MediaPlayer(audio);
        Mediaplayer.setAutoPlay(true);

        Mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
    
		Pane root = new Pane();
		
		Button exit = new Button("Exit");
		
		exit.setLayoutX(300);
		exit.setLayoutY(40);

        Image image = new Image(getClass().getResourceAsStream("/images/vol1.png"));
        
        Button button1 = new Button("");
        button1.setGraphic(new ImageView(image));
        button1.setLayoutX(300);
		button1.setLayoutY(110);
        
		Button startButton = new Button("Start");
		startButton.setLayoutX(30);
		startButton.setLayoutY(350);
		
		
		Button Resume = new Button("Resume");
		Resume.setLayoutX(30);
		Resume.setLayoutY(410);
		Player player = Serialize.deSeralizeTimeLine();
		if(player.end==true) Resume.setDisable(true);
		else Resume.setDisable(false);
		Button leaderBoard = new Button("Leader Board");
		
		leaderBoard.setLayoutX(30);
		leaderBoard.setLayoutY(470);
		
		Button help = new Button("Help");
		help.setLayoutX(20);
		help.setLayoutY(40);
		
		Button me = new Button("Me");
		me.setLayoutX(30);
		me.setLayoutY(530);
		
		root.getChildren().addAll(exit , Resume ,startButton , help , me ,leaderBoard,button1);
		
		Scene scene = new Scene(root , 480, 700);
		
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        exit.setOnAction( e-> {
        	Stage stage = (Stage) exit.getScene().getWindow();
    	    stage.close();
        });
        
        startButton.setOnAction(e ->{
        	seperate s = new seperate();
        	try {
        		Mediaplayer.stop();
        		//s.end = false;
        		//check = false;
				s.start( new Stage() );
			} catch (FileNotFoundException e1) {
				System.out.println("e");
			}
        	//check = s.end;
        });
        button1.setOnAction(e ->{
        		set++;
        		if(set%2==1) {
        			Mediaplayer.stop();
        			Image image1 = new Image(getClass().getResourceAsStream("/images/vol2.png"));
        			button1.setGraphic(new ImageView(image1));
        		}
        		else {
        			Mediaplayer.play();
        			Image image2 = new Image(getClass().getResourceAsStream("/images/vol1.png"));
        			button1.setGraphic(new ImageView(image2));
        		}
				
        });
        //if(check==true) Resume.
        Resume.setOnAction(e ->{
        	seperate s = new seperate();
        	try {
        		Mediaplayer.stop();
        		s.isRestart = true;
				s.start( new Stage() );
			} catch (FileNotFoundException e1) {
				System.out.println("e");
			}
        });
        
        leaderBoard.setOnAction(e ->{
        	LeaderBoardPage p = new LeaderBoardPage();
        	try {
				p.start( new Stage() );
			} catch (FileNotFoundException e1) {
				System.out.println("e");
			} catch (Exception e1) {
			}
        });
        
        help.setOnAction(e->{
        	Stage stage = new Stage();     	    
     	    stage.setTitle("Test");
     	     help test = new help();
     	     Scene scene1 = new Scene(test, 400, 500);
     	     
     	        scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

     	     stage.setScene(scene1);
     	     stage.show();
        });
        
        me.setOnAction(e ->{
        	Stage s = new Stage();
    		
    		Parent root1 = null;
			try {
				root1 = FXMLLoader.load(getClass().getResource("ME.fxml"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    		
    		Scene scene1 = new Scene(root1);
            scene1.getStylesheets().addAll(this.getClass().getResource("meCss.css").toExternalForm());

    		s.setTitle("Me");
    		s.setScene(scene1);
    		s.show();
        });
        
		primaryStage.setTitle("Snake vs Blocks game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * @param args Main page to Launch the Application
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
