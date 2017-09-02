/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s542046
 */
public class CloseEverything {
    private static AndrewsRobot robot;
    static{
        try {
            robot = new AndrewsRobot();
        } catch (AWTException ex) {
            Logger.getLogger(CloseEverything.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new CloseWindow(), 0, 1000);
        
    }
    
    public static class CloseWindow extends TimerTask{

        @Override
        public void run() {
//            if(!robot.getPixelColor(1275, 1).equals(Color.BLACK)){
//                robot.quickClick(1275, 1);
//            }
            System.out.println("I'm running!");
        }
        
    }
}
