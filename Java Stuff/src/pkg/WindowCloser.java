/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 *
 * @author s542046
 */
public class WindowCloser {
    private static Robot robot;
    
    public static void main(String[] args) throws InterruptedException {
        try {
            robot = new Robot();
        } catch (AWTException ex) {
        }
        Thread.sleep(4000);
//        System.out.println(MouseInfo.getPointerInfo().getLocation());
        while(true){
            if(robot.getPixelColor(1275, 1).equals(Color.WHITE)){
                robot.mouseMove(1275, 1);
                click();
                robot.mouseMove(723, 192);
                click();
                return;
            }
        }
       
    }

    private static void click() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    
    private static Color getColor(){
        return robot.getPixelColor(getLocation().x, getLocation().x);
    }
    
    private static Point getLocation(){
        return MouseInfo.getPointerInfo().getLocation();
    }
}
