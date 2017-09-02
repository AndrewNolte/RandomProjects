/*
 * Name: Andrew Nolte
 * Version 1.0
 * Assignment: Text Lab 2
 * Description: this program will take both integers and 
 * doubles and display the total and averages
 */
public class TextLab02st
{
	public static void main(String args[])
	{
		System.out.println("Text Lab 02");
		System.out.println();
		
		int num1 = 543;
		int num2 = 54;
		int num3 = 86;
		int num4 = 12;
		int num5 = 6780;
		System.out.println("1st integer: " + num1);
		System.out.println("2nd integer: " + num2);
		System.out.println("3rd integer: " + num3);
		System.out.println("4th integer: " + num4);
		System.out.println("5th integer: " + num5);
		System.out.println("--------------------");
		int t = num1 + num2 + num3 + num4 + num5;
		System.out.println("Int Total: " + t);
		int a = t / 5;
		System.out.println("Int Average: " + a);
		System.out.println();
		
		double d1 = 65.694;
		double d2 = 665.6;
		double d3 = 322.45;
		double d4 = 89.564;
		double d5 = 999.999;
		System.out.println("1st real num: " + d1);
		System.out.println("2nd real num: " + d2);
		System.out.println("3rd real num: " + d3);
		System.out.println("4th real num: " + d4);
		System.out.println("5th real num: " + d5);
		System.out.println("--------------------");
		double t2 = d1 + d2 + d3 + d4 + d5;
		System.out.println("Real Total: " + t2);
		double a2 = t2 / 5;
		System.out.println("Real Average: " + a2);
		System.out.println();
	}
}

