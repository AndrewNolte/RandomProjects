/*
 * Name: Andrew Nolte
 * Version 1.0
 * Assignment: Lab: Fahrenheit to Celsius
 * Description: this program will convert a Fahrenheight 
 * input to a Celsius output
 */

import java.util.Scanner;

public class Unit3TempConversion 
{

	public static void main(String[] args) 
	{
		Scanner fa = new Scanner(System.in);
		System.out.print("Degrees in Fahrenheit: ");
		double f = fa.nextDouble();
		double c = (5*(f - 32))/9;
		System.out.print("Degrees in Celsius: " + c);
		
		/*
		 * Scanner kb = new Scanner (Systen.in);
		 * 
		 * System.out.println("This program converts F to C");
		 * System.out.println("Enter the temp in F:");
		 * double f = kb.nextDouble();
		 * double c = 5.0/9.0 * (f-32);
		 * System.out.println("Celsius temp =" + c);
		 */
	}
	
	

}
