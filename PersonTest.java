import java.time.*;

public class PersonTest{
	public static void main(String[] args){
		Person[] people = new Person[2];

		people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		people[1] = new Student("Maria Morris", "Computer science");

		for (Person p : people){
			System.out.println(p.getName() + ", " + p.getDescription());
		}
	}
}

abstract class Person{
	public abstract String getDescription();
	private String name;

	public Person(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}

class Employee extends Person{
	private double salary;
	private LocalDate hireDay;

	public Employee(String name, double salary, int year, int month, int day){
		super(name);
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}

	public LocalDate getHireDay(){
		return hireDay;
	}

	public String getDescription(){
		return String.format("an employee with a salary of $%.2f", salary);
	}

	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}

class Student extends Person{
	private String major;

	public Student(String name, String major){
		super(name);
		this.major = major;
	}

	public String getDescription(){
		return ("a student majoring in " + major);
	}
}



