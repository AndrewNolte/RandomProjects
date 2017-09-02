/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author s542046
 */
public class ScreenCapturer {
    public static void main(String[] args) {
        
        int num = 1;
        while(true){
            screenshot("capture" + String.valueOf(num));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ScreenCapturer.class.getName()).log(Level.SEVERE, null, ex);
            }
            num++;
        }
       
        
    }
    
    public static void screenshot(String name){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();

        Rectangle allScreenBounds = new Rectangle();
        for (GraphicsDevice screen : screens) {
            Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();

            allScreenBounds.width += screenBounds.width;
            allScreenBounds.height = Math.max(allScreenBounds.height, screenBounds.height);
        }

        Robot robot;
        BufferedImage screenShot;
        try {
            robot = new Robot();
            screenShot = robot.createScreenCapture(allScreenBounds);

            try {
                // retrieve image
                File outputfile = new File(name + ".png");
                ImageIO.write(screenShot, "png", outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (AWTException ex) {
            Logger.getLogger(ScreenCapturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
