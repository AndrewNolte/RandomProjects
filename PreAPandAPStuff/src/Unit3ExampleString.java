/*
 * Name: Andrew Nolte
 * Version 1.0
 * Assignment: String class project
 * Description: this program will explain String
 */

import java.io.*;
import java.util.*;

public class Unit3ExampleString
{
	public static void main (String args[])
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int i = kb.nextInt();
		System.out.println("Enter another integer: ");
		int j =kb.nextInt();
		System.out.println(i + " + " + j + " = " + (i + j));
		
		//Strings: primitive data type
		//Strings are words
		String firstName = "Darth";
		String lastName = "Vader";
		System.out.println("firstName + lastName ");
		Scanner kbString = new Scanner(System.in);
		System.out.println("Enter a String");
		String s = kbString.nextLine();
		System.out.println("Here is my String: " + s);
		//you can't change the value of a string; immutable
		//arithmetic shortcuts
		//incrementing
		double d1 = 4;
		d1 = d1 +1;
		System.out.println(d1);
		d1++;
		System.out.println(d1);
	}
}


