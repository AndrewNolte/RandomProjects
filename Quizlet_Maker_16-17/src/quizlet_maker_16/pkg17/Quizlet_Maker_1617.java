/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizlet_maker_16.pkg17;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author s542046
 */
public class Quizlet_Maker_1617 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);//new File("vocab3.txt"));
        String currentWord = "(default word)";
        char state = 'd';
        String line = "";
        
        String defs = "";
        String syns = "";   
        String ants = "";
        String sens = "";
      
        System.out.println(sc.hasNextLine());
        
        while(sc.hasNextLine()){
            line = sc.nextLine();//.toLowerCase();
            if(line.equals("#done#")){
                System.out.println(defs + "\n" + syns + "\n" + ants + "\n" + sens);
                return;
            }
            if(line.split(" ").length == 1){
                currentWord = line;
                System.out.println(currentWord);
            }else{
                if(line.charAt(0) == '('){
                defs = defs + currentWord + ":" + line + "][";
                }else if(line.substring(0, 9).equalsIgnoreCase("synonyms:")){
                    syns = syns + currentWord + ":"+ line.substring(10) + "][";
                    state = 'y';
                }else if(line.substring(0, 9).equalsIgnoreCase("antonyms:")){
                    ants = ants + currentWord + ":"+ line.substring(10) + "][";
                    state = 'a';
                }else if(line.substring(0, 9).equalsIgnoreCase("sentence:")){
                    sens = sens + currentWord 
                    + ":"+ line.substring(10).replaceAll(currentWord, "__________").replaceAll(currentWord.toLowerCase(), "__________") + "][";
                    state = 's';
                }else if(state == 's'){
                    sens = sens + currentWord 
                    + ":"+ line.substring(10).replaceAll(currentWord, "__________").replaceAll(currentWord.toLowerCase(), "__________") + "][";
                }
//                }else if (line.contains("(") == true){
//                    if(line.contains(":")){
//                        currentWord = line.substring(0,line.indexOf(":"));
//                    }else{
//                        currentWord = line.substring(0,line.indexOf("(")-1);
//                    }
//                    defs = defs + currentWord + ":" + line.substring(line.indexOf("(")) + "][";
//                }         
                
            //}
                
            }
    
        }
        System.out.println(defs + "\n" + syns + "\n" + ants + "\n" + sens);
    }
}
