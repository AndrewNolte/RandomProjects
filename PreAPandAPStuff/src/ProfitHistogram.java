import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

public class ProfitHistogram
{

	public static void main(String args[]) throws IOException
	{
		createHistogram();

	}


	public static void createHistogram() throws IOException
	{
            File    file = new File("profits.txt");
            Scanner sc = new Scanner(file);

            int length = sc.nextInt();
            int[] profitArray = new int[length];
            int[] monthNum = new int[length];
            String[] m = {"January","February","March","April","May","June","July","August","September","October","November","December"};
            int largest = 0;
            String bestMonth = "";


            for(int i = 0; i < length; i++){
                profitArray[i] = sc.nextInt();
                monthNum[i] = i+1;
                if(profitArray[i] > largest){
                    largest = profitArray[i];
                    bestMonth = m[i];
                }
            }

            System.out.println("            Profit Histogram");

            char[] line = new char[length * 4];
            

            for(int i = largest; i > 0; i--){
                String percent = String.valueOf(i);
                System.out.print(percent + "%");
                char[] spaces = new char[4-(percent.length()+1)];
                System.out.print(spaces);
                for(int j = 0; j < length; j++){
                    if(profitArray[j] == i){
                        line[j*4] = '|';
                    }
                }
                System.out.println(line);
            }
            Arrays.fill(line, '-');

            System.out.print("----");
            System.out.println(line);
            System.out.print("    ");
            for(int i = 0; i < length; i++){
                String percent = String.valueOf(monthNum[i]);
                System.out.print(percent);
                char[] spaces = new char[4-(percent.length())];
                System.out.print(spaces);
            }
            System.out.println();
            System.out.println();
            for(int i = 0; i < length; i++){
                String percent = String.valueOf(monthNum[i]);
                System.out.print(percent + ":");
                char[] spaces = new char[4-(percent.length()+1)];
                System.out.print(spaces);
                System.out.println(m[i]);
            }
            System.out.println();
            System.out.println("Best Month: " + bestMonth);



	}



}