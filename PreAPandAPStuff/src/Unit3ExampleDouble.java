/*
 * Name: Andrew Nolte
 * Version 1.0
 * Assignment: double class project
 * Description: this program will explain doubles
 */

public class Unit3ExampleDouble 
{
	public static void main(String[] args) 
	
	{
		int a=11;
		int b=4;
		int c=a/b;
		System.out.println("a/b="+c);
		//mod
		System.out.println("a % b = " +(a%b));
		/*
		 * initialize a variable: data type name = value;
		 * names of double have d then the name
		 */
		
		//initialize a double
		double d1=0;
		double d2=10.0;
		double d3=3.333333333333333;
		//addition
		d1=d2+d3;
		System.out.println(d2 + " + " + d3 + " = " + d1);
		//subtraction
		d1=d2-d3;
		System.out.println(d2 + " - " + d3 + " = " + d1);
		//multiplication
		d1=d2*d3;
		System.out.println(d2 + " * " + d3 + " = " + d1);
		//division
		d1=d2/d3;
		System.out.println(d2 + " / " + d3 + " = " + d1);
	}
}
