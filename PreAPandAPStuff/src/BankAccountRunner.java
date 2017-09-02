
public class BankAccountRunner {

	
	public static void main(String[] args) {

		Bank_Account bk1 = new Bank_Account();
		Bank_Account bk2 = new Bank_Account();
		Bank_Account bk3 = new Bank_Account("John Doe", 456, 500);

		bk1.setName("Andrew Nolte");
		bk1.setNum(69696969);
		bk1.setBal(500);
		
		bk2.setName("Bald Idiot");
		bk2.setNum(18001234);
		bk2.setBal(1000);	
		
		bk1.print();
		bk2.print();
		bk3.print();

	}

}
