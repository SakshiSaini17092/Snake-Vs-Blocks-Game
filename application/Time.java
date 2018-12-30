package application;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Sakshi and Tanishka
 *
 */
public class Time {
    /**
     * Timer
     */
    private Timer timer;
    /**
     * Boolean
     */
    boolean sh ;

    /**
     * @param seconds Timer Constructor
     */
    public Time(int seconds) {
        timer = new Timer();
        sh = true;
        timer.schedule(new RemindTask(), seconds*10);
	}
    
    class RemindTask extends TimerTask {
    	
        
        public void run() {
            System.out.println("Time's up!");
            sh = false;
            timer.cancel(); //Terminate the timer thread
            
        }
    }
}