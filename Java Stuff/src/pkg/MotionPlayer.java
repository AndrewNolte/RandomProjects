/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.peer.RobotPeer;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.input.KeyCode;

/**
 *
 * @author S542046
 */
public class MotionPlayer {
    
    public static String fileName = "C:\\Users\\s542046\\Documents\\NetBeansProjects\\Java Stuff\\startup";
    public static AndrewsRobot robot;
    public static ArrayList<Point> list;
    public static Iterator<Point> points;
    
    public static void main(String[] args) throws FileNotFoundException, AWTException, InterruptedException {
        robot = new AndrewsRobot();
        SaveFile sv = new SaveFile(fileName);
        list = sv.getPointData("points");
        points = list.iterator();
        cycleThrough(list.size()-1);
        Thread.sleep(200);
        cycleThroughRest();
        Thread.sleep(1000);
        robot.combo(new int[]{KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_T});

    }
    
    public static void cycleThrough(int num) throws InterruptedException{
        for(int i = 0; i < num && points.hasNext(); i++){
            Point p = points.next();
            robot.mouseMove(p.x, p.y);
            robot.leftClick();
            Thread.sleep(20);
        }
    }
    
    public static void cycleThroughRest() throws InterruptedException{
        while(points.hasNext()){
            Point p = points.next();
            robot.mouseMove(p.x, p.y);
            robot.leftClick();
            Thread.sleep(20);
        }
    }
    
}
