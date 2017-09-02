/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s542046
 */
public class StringTyper {
    private static Robot robot;
    
    public static void main(String[] args) throws InterruptedException {
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(ScreenCapturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread.sleep(2000);
        System.out.println(MouseInfo.getPointerInfo().getLocation());
        
    }

    
    private static void writeString(String s) {
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isUpperCase(c)) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }
        tap(c);
        if (Character.isUpperCase(c)) {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
}
    
    public static void tap(char c){
        robot.keyPress(Character.toUpperCase(c));
        robot.keyRelease(Character.toUpperCase(c));

    }
         
    
}
