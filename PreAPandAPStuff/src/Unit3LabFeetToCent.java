/*
 * Name: Andrew Nolte
 * Version 1.0
 * Assignment: Lab: feet and inches to Centimeters 
 * Description: this program will convert an input of feet
 * and inches to centimeters
 */
import java.util.Scanner;

public class Unit3LabFeetToCent 
{

	public static void main(String[] args) 
	{
		System.out.println("This program converts feet and inches to centimeters.");
		
		System.out.println("Enter number of feet: ");
		Scanner fe = new Scanner(System.in);
		double f = fe.nextDouble();
		
		System.out.println("Enter number of inches: ");
		Scanner in = new Scanner(System.in);
		double i = in.nextDouble();
		
		double ti = 12 * f + i;
		double c = ti * 2.54;
		
		System.out.println(f + "ft " + i + "in = " + c + "cm ");
		
	}

}
