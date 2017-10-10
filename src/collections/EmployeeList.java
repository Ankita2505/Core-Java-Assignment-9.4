package collections;
/*
 * a class employee and to display salary, designation and names in sorted order
 */
//Importing Java Utility packages for Collection, Comparator and array list
import java.util.Comparator;

import java.util.TreeSet;

import java.util.SortedSet;
class Employee
{
	private String name;
	private String designation;
	private double salary;

	//Getter and setter methods for name variable
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	//Getter and setter methods for designation variable
	public String getDesignation() 
	{
		return designation;
	}
	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}

	//Getter and setter methods for salary variable
	public double getSalary() 
	{
		return salary;
	}
	public void setSalary(double salary) 
	{
		this.salary = salary;
	}
	//Generating Constructor with fields
	public Employee(String name, String designation, double salary) 
	{

		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	public String toString(){
		return name+" : "+designation+" : "+salary;
	}

}


//EmployeeComparator Class looks for Comparing Employee objects on basis on salary, name, designation
class EmployeeComparator implements Comparator<Employee> 
{
	@Override
	//defining compare method to compare employee objects on basis of name, salary, designation
	public int compare(Employee emp1, Employee emp2) 
	{

		if(emp1.getSalary()>emp2.getSalary())  

			return 1;

		else if(emp1.getSalary()<emp2.getSalary())  

			return -1;
		else 
		{
			//if salary is same,compare by name
			int nameDiff=emp1.getName().compareTo(emp2.getName());
			//if name is same compare by designation
			if(nameDiff==0)

				return emp1.getDesignation().compareTo(emp2.getDesignation());

			return nameDiff;

		}
	}
}

public class EmployeeList 
{
	public static void main(String[] args) //Start of Main Class
	{
		//Creating TreeSet for Employee
		SortedSet<Employee> ts = new TreeSet<Employee>(new EmployeeComparator());
		//Creating Objects of Employee
		Employee e1=new Employee("Ram", "Engineer",25000);
		Employee e2=new Employee("Shyam", "Engineer",25000);
		Employee e3=new Employee("Rohit", "Doctor",15000);
		Employee e4=new Employee("Rohit", "Lawyer",25000);


		//Adding objects of employee to objects of TreeSet
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		ts.add(e4);
		System.out.println("Tree Set of Employees before sorting");
		System.out.println(ts);
		//Using collections sort method to sort HDTV objects according to their size
		//Collections.sort(ts, new EmployeeComparator());
		System.out.println("NAME"+ " " + "Designation" + " "+ "Salary" );
		for (Employee e :ts ) 
		{
			System.out.println(e.getName() + " " + e.getDesignation()+ " " + e.getSalary() );//Displaying employee objects in sorted order of name,designation, salary
		}

	}
}



