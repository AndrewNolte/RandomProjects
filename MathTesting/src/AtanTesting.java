/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Formatter;

/**
 *
 * @author s542046
 */
public class AtanTesting {

    /**
     * @param args the command line arguments
     */
    private static String fileName = "DefaultName";
    private static Formatter formatter;
    private static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        //System.out.println("Enter File Name: ");
        fileName = "will this work";
        try{
            formatter = new Formatter(fileName + ".txt");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Start Input:");
        while(true){
            String input = sc.next();
            if(input.equals("stop")){
                break;
            }
            if(input.equals("newline")){
		formatter.format("%s", System.getProperty("line.separator"));
            }else{
                formatter.format("%s", input + " ");
            }
        }
        formatter.close();
    }
    
}
