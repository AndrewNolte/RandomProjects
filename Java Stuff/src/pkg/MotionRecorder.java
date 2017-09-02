/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author s542046
 */
public class MotionRecorder{

    public static String fileName = "startup";
    public static SaveFile file;
    public static int count = 0;
    private static AndrewsRobot robot;
    private static ArrayList<Point> points = new ArrayList<Point>();
    static{
        try {
            robot = new AndrewsRobot();
        } catch (AWTException ex) {
            Logger.getLogger(MotionRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        file = new SaveFile(fileName);
        
        resetListener();
    }
    
    public static void resetListener(){

        Toolkit.getDefaultToolkit().addAWTEventListener(
          new Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void mouseClicked(){
        System.out.println(robot.getLocation());
        points.add(robot.getLocation());
        try {
            file.saveData("points", points);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MotionRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static class Listener implements AWTEventListener {

        public void eventDispatched(AWTEvent event) {
            if (count % 2 == 1) {
                mouseClicked();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MotionRecorder.class.getName()).log(Level.SEVERE, null, ex);
                }
                Point init = robot.getLocation();
                robot.mouseMove(561, 779);
                robot.leftClick();
                robot.mouseMove(init.x, init.y);
                
            }
            count++;
//            System.out.print(MouseInfo.getPointerInfo().getLocation() + " | ");
//            System.out.println(event);
        }

    }

}
