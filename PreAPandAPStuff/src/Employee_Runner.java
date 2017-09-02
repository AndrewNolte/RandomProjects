
public class Employee_Runner {


	public static void main(String[] args) {
		
		Employee founder = new Employee("Ebenezer Scrooge", 1);
		Employee partner = new Employee("Jacob Marley", 2);
		Employee clerk = new Employee("Bob Cratchit", 3);
		
		partner.setStatus(false);

		clerk.setSalary(2 * clerk.getSalary());



	}

}
