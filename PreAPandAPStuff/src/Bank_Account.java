//import java.util.Scanner;

public class Bank_Account {

	private String accountName;
	private int accountNum;
	private double balance;
	//private String password = "123456789";
	//Scanner sc = new Scanner(System.in);
	
	public Bank_Account(){
		accountName = "DefaultName";
		accountNum = 0;
		balance = 0;
	}
	public Bank_Account(String name, int num, double amt){
		accountName = name;
		accountNum = num;
		balance = amt;
	}
	
	
	public void deposit(double amt){
		balance += amt;
	}	
	public void withdrawl(double amt){
		balance -= amt;
	}
	
	
	public void setName(String name){
		accountName = name;
	}
	public void setNum(int num){
		accountNum = num;
	}
	public void setBal(double bal){
		balance = bal;
	}
	
	
	public String getName(){
		return accountName;
	}
	public int getNum(){
		return accountNum;
	}
	public double getBal(){
		return balance;
	}
	
	
	public  void print(){
		System.out.println("Account name: " + accountName);
		System.out.println("Account number: " + accountNum);
		System.out.println("Account balance: " + balance);
	}
	
	
	public static void main(String[] args) {

	}

}
