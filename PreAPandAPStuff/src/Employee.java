
public class Employee{
	
	private String name;
	private int order;
	private boolean isActive = true;
	private double salary;

	public Employee(String name, int order){
		this.name = name;
		this.order = order;
	}
	
	public String getName(){
		return name;
	}
	public int getOrder(){
		return order;
	}	
	public boolean isActive(){
		return isActive;
	}	
	public double getSalary(){
		return salary;
	}

	public void setStatus(boolean flag){
		isActive = flag;
	}	
	public void setSalary(double s){
		salary = s;
	}
	

	public static void main(String[] args) {

	}

}
