/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s542046
 */
public class AndrewsRobot extends Robot{

    Toolkit tk;
    public AndrewsRobot() throws AWTException{
        super();
                tk = Toolkit.getDefaultToolkit();

    }
    
    public void beep(){
        tk.beep();
    }
    
    public void leftClick() {
        click(InputEvent.BUTTON1_DOWN_MASK);
    }
    
    public void rightClick() {
        click(InputEvent.BUTTON3_DOWN_MASK);
    }
    
    public void click(int e){
        super.mousePress(e);
        super.mouseRelease(e);
    }
    
    public void quickClick(Point p){
        Point initial = getLocation();
        mouseMove(p);
        leftClick();
        mouseMove(initial);
    }
    
    public void quickClick(int x, int y){
        Point initial = getLocation();
        mouseMove(x,y);
        leftClick();
        mouseMove(initial);
    }
    
    
    public void mouseMove(Point p){
        mouseMove(p.x,p.y);
    }
    
    

    public Color getColor() {
        return super.getPixelColor(getLocation().x, getLocation().y);
    }

    public Point getLocation() {
        return MouseInfo.getPointerInfo().getLocation();
    }
    
    

    public void writeString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                super.keyPress(KeyEvent.VK_SHIFT);
            }
            tap(c);
            if (Character.isUpperCase(c)) {
                super.keyRelease(KeyEvent.VK_SHIFT);
            }
        }
    }
    
    public void writeStringSlow(String s) throws InterruptedException{
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                super.keyPress(KeyEvent.VK_SHIFT);
            }
            tap(c);
            if (Character.isUpperCase(c)) {
                super.keyRelease(KeyEvent.VK_SHIFT);
            }
            Thread.sleep(100);
        }
    }

    public void tap(char c) {
        click(Character.toUpperCase(c));
    }
    
    public void combo(int[] keys){
        for(int k : keys){
            super.keyPress(k);
        }
        for(int k : keys){
            super.keyRelease(k);
        }
    }
}
