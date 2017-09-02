/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s542046
 */
public class TestingStuff {
    private static AndrewsRobot robot;

    static{
        try {
            robot = new AndrewsRobot();
        } catch (AWTException ex) {
            Logger.getLogger(TestingStuff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {



    }
      
}
