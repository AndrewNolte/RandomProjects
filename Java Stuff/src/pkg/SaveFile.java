/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.awt.Point;
import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s542046
 */
public class SaveFile {

    private Formatter formatter;
    private static String dataSeparator = "###";
    private ArrayList<String> keys = new ArrayList<String>();
    private String filePath;
    private ArrayList<String> lines = new ArrayList<String>();
    private File file;

    public SaveFile(String name) throws FileNotFoundException {
        //make the file first
        filePath = name + ".txt";
        file = new File(filePath);
        if (file.exists()) {
            processFile();

        }else{
            openFile();
            formatter.close();
        }

        //now make the scanner for it
    }

    public void saveData(String key, ArrayList arr) throws FileNotFoundException {
        int lineNum = keys.indexOf(key);
        if (lineNum == -1) {
            keys.add(key);
            lineNum = keys.size() - 1;
        }
        String data = key + "=";
        if (arr != null) {
            if (!arr.isEmpty()) {
                data += arr.get(0).toString();
                for (int i = 1; i < arr.size(); i++) {
                    data += dataSeparator;
                    data += arr.get(i).toString();
                }
            }
        }
        replaceLine(lineNum, data);
    }

    public ArrayList getData(String key, DataManip p) throws FileNotFoundException {
        readLines();
        String sData = "";
        for (int i = 0; i < keys.size(); i++) {
            String currentLine = lines.get(i);
            if (i == keys.indexOf(key)) {
                sData = currentLine.substring(key.length() + 1);
                break;
            } else if (i == keys.size() - 1) {
                System.out.println("Key Not Found");
                return null;
            }
        }
        ArrayList arr = new ArrayList();
        for (String s : (sData.split(dataSeparator))) {
            arr.add(p.stringToData(s));
        }
        return arr;
    }

    public void replaceLine(int lineNum, String data) throws FileNotFoundException {
        readLines();
        openFile();
        //System.out.println("replacing line: " + lineNum + " with: " + data);
        for (int i = 0; i < keys.size(); i++) {
            if (i < lines.size()) {
                String currentLine = lines.get(i);
                if (i == lineNum) {
                    formatter.format("%s", data);
                } else {
                    formatter.format("%s", currentLine);
                }
            } else {
                formatter.format("%s", data);
            }
            formatter.format("%s", System.getProperty("line.separator"));
        }
        formatter.close();
    }

    private void openFile() throws FileNotFoundException {
        formatter = new Formatter(file);
    }

    public void readLines() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        lines.clear();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            lines.add(s);
        }

    }

    private void processFile() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        lines.clear();
        keys.clear();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            keys.add(s.substring(0, s.indexOf("=")));
            lines.add(s);
        }
    }

    @FunctionalInterface
    public interface DataManip<E> {

        public E stringToData(String s);
    }

    public ArrayList<String> getStringData(String key) throws FileNotFoundException {
        return this.getData(key, new DataManip<String>() {
            public String stringToData(String s) {
                return s;
            }
        });
    }

    public ArrayList<Double> getDoubleData(String key) throws FileNotFoundException {
        return this.getData(key, new DataManip<Double>() {
            public Double stringToData(String s) {
                return Double.valueOf(s);
            }
        });
    }

    //java.awt.Point[x=260,y=669]
    public ArrayList<Point> getPointData(String key) throws FileNotFoundException {
        return this.getData(key, new DataManip<Point>() {
            public Point stringToData(String s) {
                String x = s.substring(s.indexOf("x=") + 2, s.indexOf(","));
                String y = s.substring(s.indexOf("y=") + 2, s.length() - 1);
                return new Point(Integer.valueOf(x), Integer.valueOf(y));
            }
        });
    }

}
