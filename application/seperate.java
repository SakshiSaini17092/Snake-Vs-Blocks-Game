package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
/**
 * @author Sakshi and Tanishkas
 *
 */
public class seperate extends Application{

	

    /**
     * Random number
     */
    private Random ro = new Random();
    /**
     * Time Line
     */
    private Timeline timeline = new Timeline();
    /**
     * List of Traps
     */
    private ObservableList<Node> trapList;
    /**
     * Object of class BallList to create Balls
     */
    private BallList ball;
    /**
     * List of Balls
     */
    private ObservableList<Node> ballList;
    /**
     * Object of walls class
     */
    private Walls wall ;
    /**
     * List of walls
     */
    private ObservableList<Node> wallList;
    /**
     * List of Shield 
     */
    private ObservableList<Node> shieldList;
    /**
     * Object of ShieldCreate
     */
    private shieldCreate shield ;
    /**
     * List of Bombs
     */
    private ObservableList<Node> bombList;
    /**
     * Object of BombCreate Class
     */
    private bombCreate bomb ;
    /**
     * List of Diamonds
     */
    private ObservableList<Node> dimondList;
    /**
     * Object of Diamond Create
     */
    private dimondCreate dimond ;
    /**
     * List of Magnet
     */
    private ObservableList<Node> magnetList;
    /**
     * Object of Magnet Create class
     */
    private magnetCreate magnet ;
    /**
     * List of skeleton Class
     */
    private ObservableList<Node> skullList;
    /**
     * Object of Skeleton class
     */
    private skullcreate skull ;
    /**
     * Scene
     */
    private Scene scene;
    /**
     * Object of Blocks 
     */
    private blocks Blocks;
    
    /**
     * Is restart if true then restart
     */
    public static boolean isRestart = false;
    
    /**
     * A boolean variable
     */
    boolean b = false;
    /**
     * Shield Timer
     */
    private Time shieldTimer = new Time(0);
    /**
     * Bomb timer
     */
    private Time bombTimer = new Time(0);
    /**
     * Magnet Timer
     */
    private Time magnetTimer = new Time(0);
    
    /**
     * Player 
     */
    private Player player ;
    /**
     * Object of Snake Create
     */
    private snakeCreate snake;
    /**
     * List of balls in a snake
     */
    private ObservableList<Node> snakeList;
    /**
     * Label to current score
     */
    private Label l ;
    /**
     * Label to current Length
     */
    private Label length ;
    
    /**
     * Media Player
     */
    private MediaPlayer Mediaplayer;
    /**
     * Leader Board Page
     */
    private LeaderBoard lBoard;  
    @Override
    public void start(Stage window) throws FileNotFoundException {	
        startGame(window);
    }
    
    /**
     * Alert on Game Over 
     */
    public void alert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	
    	Label label = new Label("Your score is "+player.getScore()+"\nIf you want to restart then press 'Ok' and go to Menu and click on Restart");
    	label.setWrapText(true);
    	alert.getDialogPane().setContent(label);
    	
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText("Game Over !");
    	
    	DialogPane dialogPane = alert.getDialogPane();
    	dialogPane.getStylesheets().add(
    	   getClass().getResource("application.css").toExternalForm());
    	dialogPane.getStyleClass().add("myDialog");
    	
    	Platform.runLater(alert::showAndWait);
    }  
    /**
     * Clean up On game Over
     */
    public void cleanup() {
    	
    	timeline.stop();
    	timeline = new Timeline();
    	lBoard.add(player);
    	lBoard.display();
    	Serialize.seralizeCData(lBoard);
    	player = new Player();
    }
    
    /**
     * @param window Stage on restart
     * @throws FileNotFoundException throws Exception
     */
    public void restart( Stage window ) throws FileNotFoundException {
    	cleanup();
    	startGame(window);
    }
    /**
     * @return Parent root 
     * @throws FileNotFoundException throws Exception
     */
    public Pane createContent() throws FileNotFoundException {
    	
    	Media audio=new Media(Main.class.getResource("back (2).mp3").toExternalForm());
        Mediaplayer=new MediaPlayer(audio);
        Mediaplayer.setAutoPlay(true);

        Mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
        lBoard = Serialize.deSeralizeCData();
    	
    	Blocks = new blocks();
        ball = new BallList();
        trapList = Blocks.getBlockList();
        
        wall = new Walls();
        shield = new shieldCreate();
        magnet = new magnetCreate();
        skull = new skullcreate();
        bomb = new bombCreate();
        dimond = new dimondCreate();
        snake = new snakeCreate();
        l = new Label("Score : 0");
        l.setMaxHeight(30);
        l.setMaxWidth(1400);
        l.setTranslateX(360);
        l.setTranslateY(10);
        
        length = new Label("Current Length : 0");
        length.setMaxHeight(30);
        length.setMaxWidth(1400);
        length.setTranslateX(300);
        length.setTranslateY(60);
        
        ballList = ball.getBallList();
        Pane root=new Pane();
        root.getChildren().addAll(  l , length, Blocks.getBlocks(),skull.getGroup() ,dimond.getObject() , shield.getObject(),magnet.getObject(),bomb.getObject() , ball.getBall() ,wall.getWall() , snake.getSnake());
        return root;
    }

    /**
     * @param window Start a new Game
     * @throws FileNotFoundException Throws exceptions
     */
    private void startGame( Stage window ) throws FileNotFoundException{
    	if (isRestart == true ) {
    		player = Serialize.deSeralizeTimeLine();
    	}
    	else {
    		player = new Player();
    	}
    		
    	Pane root = createContent();
    	
    	Menu m = new Menu("Menu");
    	MenuItem pause = new MenuItem("Pause");
        MenuItem restart = new MenuItem("Restart"); 
        MenuItem resume = new MenuItem("Resume"); 
        MenuItem mainPage = new MenuItem("Main Page");
        MenuItem exit = new MenuItem("Exit");
        MenuItem volumeoff = new MenuItem("Volume Off");
        MenuItem volumeon = new MenuItem("Volume On");
        
        m.getItems().add( volumeoff ); 
        m.getItems().add( volumeon ); 
        m.getItems().add( restart ); 
        m.getItems().add( resume ); 
        m.getItems().add( mainPage );
        m.getItems().add( pause );
        m.getItems().add( exit );
        
        MenuBar mb = new MenuBar(); 
        mb.getMenus().add(m);
        
        root.getChildren().add(mb);
        
        mainPage.setOnAction( new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent event) {
        		cleanup();
        		Main m = new Main();
        		try {
					m.start(new Stage());
				} catch (IOException e) {
				}
            }	
        });
        
        exit.setOnAction( new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent event) {
        		cleanup();
                System.exit(0);
        		
            }	
        });
        volumeoff.setOnAction( e->{Mediaplayer.stop();});
        volumeon.setOnAction( e->{Mediaplayer.play();});
        
        pause.setOnAction( new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent event) {
        		timeline.stop();
            }	
        });
        
        resume.setOnAction( new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent event) {
        		timeline.play();
            }	
        });
        
        restart.setOnAction( new EventHandler<ActionEvent>() {
        	@Override
            public void handle(ActionEvent event) {
        		try {
					restart(window);
				} catch (FileNotFoundException e) {
					System.out.println("Exception");
				}
            }	
        });
        scene=new Scene( root ,480 ,700 , Color.BLACK);
        scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());

        snake.setLenght(player.getLength());
        
        scene.setOnKeyPressed(event -> {
            switch( event.getCode()){
                case LEFT:
                	
                	snake.moveLeft();
                	break;
                case RIGHT:
                   snake.moveRight();
            }
        });
        window.setTitle("Snake Vs Blocks");
        window.setScene(scene);
        window.show();
        
         Blocks.setTrapList();
         ball.setBallList();
         wall.setWallList(Blocks);
         shield.setList();
         magnet.setList();
         skull.setskullList();
         shieldList = shield.getList();
         bomb.setList();
         dimond.setList();
         bombList = bomb.getList();
         dimondList = dimond.getList();
         magnetList = magnet.getList();
         skullList = skull.getList();
         wallList = wall.getWallList();
         snakeList = snake.getSnakeList();
         
          KeyFrame keyFrame=new KeyFrame(Duration.seconds(.011),event -> {
        	  
        	  l.setText("Score :" + player.getScore());
        	  player.setLength(snake.getSnakeList().size());
        	  length.setText("Current Length : " + snake.getSnakeList().size());
        	  snake.enableleft();
        	  snake.enableright();
        	  
        	  if ( snake.getSnakeList().size() > 22 ) {
        		  timeline.setRate(timeline.getCycleDuration().toSeconds() +  1.9);
        	  }
        	  
        	  else if ( snake.getSnakeList().size() > 17 ) {
        		  timeline.setRate(timeline.getCycleDuration().toSeconds() +  1.7);
        	  }
        	  
        	  else if ( snake.getSnakeList().size() > 12 ) {
        		  timeline.setRate(timeline.getCycleDuration().toSeconds() +  1.4);
        	  }
        	  
              for(int i=0;i<trapList.size();i++){
                 trapList.get(i).setTranslateY(trapList.get(i).getTranslateY()+ 1);	}
              
              for(int i=0;i<ballList.size();i++){
                      ballList.get(i).setTranslateY(ballList.get(i).getTranslateY() + 1);
               }
              for(int i=0;i<wallList.size();i++){
                  wallList.get(i).setTranslateY(wallList.get(i).getTranslateY() + 1);
              }
              for(int i=0;i<shieldList.size();i++){
                      shieldList.get(i).setTranslateY(shieldList.get(i).getTranslateY()+1);
               }
              for(int i=0;i<bombList.size();i++){
                  bombList.get(i).setTranslateY(bombList.get(i).getTranslateY()+1);
              }
              for(int i=0;i<dimondList.size();i++){
                  dimondList.get(i).setTranslateY(dimondList.get(i).getTranslateY()+1);
              }
              for(int i=0;i<magnetList.size();i++){
                  magnetList.get(i).setTranslateY(magnetList.get(i).getTranslateY()+1);
              }
              for(int i=0;i<skullList.size();i++){
                  skullList.get(i).setTranslateY(skullList.get(i).getTranslateY()+1);
              }
              for(int i=0;i<shieldList.size();i++){
                   if(shieldList.get(i).getTranslateY()>3500){
           
                	   shield.setView();
                	   shieldList.remove(i);
                       shieldList.add(i, shield.getView() );
                   }
                   
                   if( snake.getSnakeList().get(0).getBoundsInParent().intersects(shieldList.get(i).getBoundsInParent()) ) {
                	   shieldList.get(i).setTranslateX(2000);
                	   shieldTimer = new Time(1500);
                   }
               }
              int[] xbd = new int[7];
        	  for(int j = 0;j<7;j++) {
        		  xbd[j]=-1;
        	  }
              for(int i=0;i<bombList.size();i++){
                  if(bombList.get(i).getTranslateY()>2100){
          
               	   bomb.setView();
               	   bombList.remove(i);
                   ImageView x= bomb.getView();
              	  	int[] dist = {0,70,140,210,280,350,420};
              	  	int index = ro.nextInt(dist.length);
              	  	if(xbd[index]==-1) {
              		  x.setTranslateX(dist[index]);
              		  bombList.add(i, x);
              		  xbd[index]=0;
              	  }
              	  else {
              		  x.setTranslateX(1500+dist[index]);
              		  bombList.add(i, x);
              	  }
                   
                  }
                   if( snake.getSnakeList().get(0).getBoundsInParent().intersects(bombList.get(i).getBoundsInParent()) ) {
                	   bombList.get(i).setTranslateX(2000);
                	   bombTimer = new Time(1);
                   }
              }
              for(int i=0;i<dimondList.size();i++){
                  if(dimondList.get(i).getTranslateY()>3500){
          
               	   dimond.setView();
               	   dimondList.remove(i);
                   ImageView x= dimond.getView();
              	  	int[] dist = {0,70,140,210,280,350,420};
              	  	int index = ro.nextInt(dist.length);
              	  	if(xbd[index]==-1) {
              		  x.setTranslateX(dist[index]);
              		  dimondList.add(i, x);
              		  xbd[index]=0;
              	  }
              	  else {
              		  x.setTranslateX(1500+dist[index]);
              		  dimondList.add(i, x);
              	  }
                   
                  }
                   if( snake.getSnakeList().get(0).getBoundsInParent().intersects(dimondList.get(i).getBoundsInParent()) ) {
                	   dimondList.get(i).setTranslateX(2000);
                	   player.inScore(50);
                   }
              }
              int[] xms = new int[8];
        	  for(int j = 0;j<8;j++) {
        		  xms[j]=-1;
        	  }
              for(int i=0;i<magnetList.size();i++){
                  if(magnetList.get(i).getTranslateY()>1400){
          
               	   magnet.setView();
               	   magnetList.remove(i);
                   ImageView x= magnet.getView();
              	  	int[] dist = {10,70,130,190,250,310,370,440};
              	  	int index = ro.nextInt(dist.length);
              	  	if(xms[index]==-1) {
              		  x.setTranslateX(dist[index]);
              		  magnetList.add(i, x);
              		  xms[index]=0;
              	  }
              	  else {
              		  x.setTranslateX(1500+dist[index]);
              		  magnetList.add(i, x);
              	  }
                     
                  }
                  
                  if( snake.getSnakeList().get(0).getBoundsInParent().intersects(magnetList.get(i).getBoundsInParent()) ) {
               	   magnetList.get(i).setTranslateX(2000);
               	   magnetTimer = new Time(1);
                  }
              }
              for(int i=0;i<skullList.size();i++){
                  if(skullList.get(i).getTranslateY()>2100){
          
               	   skull.setView();
               	   skullList.remove(i);
                   ImageView x= skull.getView();
              	  	int[] dist = {10,70,130,190,250,310,370,440};
              	  	int index = ro.nextInt(dist.length);
              	  	if(xms[index]==-1) {
              		  x.setTranslateX(dist[index]);
              		  skullList.add(i, x);
              		  xms[index]=0;
              	  }
              	  else {
              		  x.setTranslateX(1500+dist[index]);
              		  skullList.add(i, x);
              	  }
                 }
                  if( snake.getSnakeList().get(0).getBoundsInParent().intersects(skullList.get(i).getBoundsInParent()) ) {
               	   skullList.get(i).setTranslateX(2000);
               	   int x = snakeList.size();
               	   player.deScore(x*5);
               	   int fd = x-1;
               	   for(int p = 0;p<fd;p++) {
               		   snakeList.remove(snakeList.size()-1);
               	   }
                  }
              }
              int[] xd = new int[6];
        	  for(int j = 0;j<6;j++) {
        		  xd[j]=-1;
        	  }
              for(int i=0;i<trapList.size();i++){
            	
                  if(trapList.get(i).getTranslateY()>700){
                	  trapList.remove(i);
                	  StackPane x = Blocks.getBlock();
                	  int[] dist = {0,80,160, 240, 320, 400};
                	  int index = ro.nextInt(6);
                	  int uj = 0;
                	  
                	  if(xd[index]==-1) {
                		  
                		  x.setTranslateX(dist[index]);
                		  trapList.add(i, x);
                		  xd[index]=0;
                	  }
                	  else {
                		 
                		  x.setTranslateX(1500+dist[index]);
                		  trapList.add(i, x);
                	  }
                  }
                  if ( bombTimer.sh == true ) {
                	  trapList.get(i).setTranslateX(1500);
                	  int fd = 0;
               	   	try {
               		   StackPane s = (StackPane) trapList.get(i);
                         	System.out.println(s.getId());
                         	String ds = s.getId();
                         	fd = Integer.parseInt(ds);
                         	player.inScore(fd);

                         	System.out.println(fd);
               	   }catch( ClassCastException e ){
               	   		}
                	                   }
                  if( snake.getSnakeList().get(0).getBoundsInParent().intersects(trapList.get(i).getBoundsInParent()) ) { //shieldTimer.sh == false){
                	  int fd = 0;
                	  try {
                		  StackPane s = (StackPane) trapList.get(i);
                  	
                		  String ds = s.getId();
                		  fd = Integer.parseInt(ds);
                  	
                		  System.out.println(fd);
                  	
                	  } catch( ClassCastException e ){
                		  
                	  }
                  	if (   shieldTimer.sh == false) {
                  		if(fd<snakeList.size()) {
                  			player.inScore(fd);
                  		
                  			trapList.get(i).setTranslateX(1500);
                  			for(int p = 0;p<fd;p++) {
                  				snakeList.remove(snakeList.size()-1);
                  			}
                  		}
                  		else {
                  			int g = snakeList.size()-1;
                  			for(int p = 0;p<g;p++) {
                  				snakeList.remove(snakeList.size()-1);
                  			}
                  			player.end = true;
                  			isRestart = false;
                  			snake.disableleft();
                  			snake.disableright();
                  			Mediaplayer.stop();
                      		timeline.stop();
                      		alert();
                      	}
                  	}
                  	if ( shieldTimer.sh == true ){
                  		player.inScore(fd);
                  		trapList.get(i).setTranslateX(1500);
                  	}
                  }
              }
              for(int i=0;i<wallList.size();i++){
            	  
                  if(wallList.get(i).getTranslateY()>700){
                	  wallList.remove(i);
                      wallList.add(i, wall.getWall1() );
                  }  
                  if( snake.getSnakeList().get(0).getBoundsInParent().intersects(wallList.get(i).getBoundsInParent()) ){
                	  snake.disableleft();
                	  snake.disableright();
                  }
                  if(snake.getSnakeList().size()>1 && snake.getSnakeList().get(1).getBoundsInParent().intersects(wallList.get(i).getBoundsInParent()) ){
                	  snake.disableleft();
                	  snake.disableright();
                  }
                  if(snake.getSnakeList().size()>2 &&  snake.getSnakeList().get(2).getBoundsInParent().intersects(wallList.get(i).getBoundsInParent()) ){
                	  snake.disableleft();
                	  snake.disableright();
                  }
              }
              int[] xb = new int[8];
        	  for(int j = 0;j<8;j++) {
        		  xb[j]=-1;
        	  }
              for(int i=0;i<ballList.size();i++){
            	  if(ballList.get(i).getTranslateY()>700){
                	   ballList.remove(i);
                 	  StackPane x = (StackPane) ball.getBalli();
                 	  int[] dist = {10,70,130,190,250,310,370,440};
                 	  int index = ro.nextInt(dist.length);
                 	  if(xb[index]==-1) {
                 		  x.setTranslateX(dist[index]);
                 		  ballList.add(i, x);
                 		  xb[index]=0;
                 	  }
                 	  else {
                 		  x.setTranslateX(1500+dist[index]);
                 		  ballList.add(i, x);
                 	  }
                   }
            	  int dd = (int) ballList.get(i).getTranslateX();
                  if ( magnetTimer.sh == true && dd!=10 && dd!=440 ) {
                	  ballList.get(i).setTranslateX(3000);
                	  int fd = 0;
               	   	try {
               		   StackPane s = (StackPane) ballList.get(i);
                         	System.out.println(s.getId());
                         	String ds = s.getId();
                         	fd = Integer.parseInt(ds);
                         	
                         	System.out.println(fd);
               	   }catch( ClassCastException e ){
               	   		}
                	  for(int p = 0;p<fd;p++) {
                     		snake.incLenght();
                	  }
                 }
                   if( snake.getSnakeList().get(0).getBoundsInParent().intersects(ballList.get(i).getBoundsInParent()) ){
                	   int fd = 0;
                	   try {
                		   StackPane s = (StackPane) ballList.get(i);
                          	System.out.println(s.getId());
                          	String ds = s.getId();
                          	fd = Integer.parseInt(ds);
                          	
                          	System.out.println(fd);
                	   }catch( ClassCastException e ){
                		   
                	   }
                   	ballList.get(i).setTranslateX(1500);
                   	for(int p = 0;p<fd;p++) {
                   		snake.incLenght();
                   	}
                  }     
               }    
              player.setLength(snake.getSnakeList().size());
              Serialize.seralizePlayer(player);
          });
          timeline.getKeyFrames().add(keyFrame);
          timeline.setCycleCount(Timeline.INDEFINITE);
          timeline.play();
    }       
}

