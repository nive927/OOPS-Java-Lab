import java.io.*;
import java.util.*;

class Person
{
	private String name;
	private String address;

	public Person(String name, String address)
	{
		this.name = name;
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
}

class Employee extends Person
{
	private String empid;
	private String dept;
	private float basic;

	Employee(String name, String address, String empid, String dept, float basic)
	{
		super(name, address);
		this.empid = empid;
		this.dept = dept;
		this.basic = basic;
	}

	public String getEmpid()
	{
		return empid;
	}

	public String getDept()
	{
		return dept;
	}

	public void setDept(String dept)
	{
		this.dept = dept;
	}

	public void setBasic(int basic)
	{
		this.basic = basic;
	}

	public float getBasic()
	{
		return basic;
	}

	public float calSalary()
	{	
		float grosspay = basic + (0.6f * basic) + (0.1f * basic);
		float deductions = (0.085f * basic) + (0.08f * basic);
		return grosspay - deductions;
	}
}

class Faculty extends Employee
{
	private String designation;
	private String course;

	public Faculty(String name, String address, String empid, String dept, float basic, String desig, String course)
	{
		super(name, address, empid, dept, basic);
		designation = desig;
		this.course = course;
	}

	public String getDesig()
	{
		return designation;
	}

	public void setDesig(String desig)
	{
		designation = desig;
	}

	public String getCourse()
	{
		return course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}

	public float calSalary()
	{
		float basic = getBasic();		
		float grosspay = basic + (0.6f * basic) + (0.1f * basic);
		float deductions = (0.085f * basic) + (0.08f * basic);
		return grosspay - deductions;
	}
}

interface Student
{
	public float[] getMarks();
	public float calcGPA();
}

class ResearchAssisstant extends Employee implements Student
{
	private float[] marks = new float[3];
	private String project;
	private String course;
	
	public ResearchAssisstant(String name, String address, String empid, String dept, float basic, float marks[], String project, String course)
	{
		super(name, address, empid, dept, basic);
		this.marks = marks;
		this.project = project;
		this.course = course;
	}

	public String getProject()
	{
		return project;
	}

	public String getCourse()
	{
		return course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}

	public float [] getMarks()
	{
		return marks;
	}

	public float calcGPA()
	{
		float total = 0;

		for(int i=0; i<3; i++)
		{
			total += marks[i];
		}

		return total/300*10;

	}

	public float calSalary()
	{	
		float basic = getBasic();
		float grosspay = basic + (0.6f * basic) + (0.1f * basic);
		float deductions = (0.085f * basic) + (0.08f * basic);
		return grosspay - deductions;
	}

}

public class TesterInterface
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		String name;
		String address;

		String empid;
		String dept;
		float basic;

		String designation;
		String course;

		float[] marks = new float[3];

		String project;
		//course

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Employee Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Name: ");
		name = reader.readLine();
		System.out.print("Enter Address: ");
		address = reader.readLine();
		System.out.print("Enter Employee ID: ");
		empid = reader.readLine();
		System.out.print("Enter Department: ");
		dept = reader.readLine();
		System.out.print("Enter Basic: ");
		basic = input.nextInt();
		System.out.println("---------------------------------------");

		Employee e = new Employee(name, address, empid, dept, basic);

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Faculty Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Name: ");
		name = reader.readLine();
		System.out.print("Enter Address: ");
		address = reader.readLine();
		System.out.print("Enter Employee ID: ");
		empid = reader.readLine();
		System.out.print("Enter Department: ");
		dept = reader.readLine();
		System.out.print("Enter Basic: ");
		basic = input.nextInt();
		System.out.print("Enter Designation: ");
		designation = reader.readLine();
		System.out.print("Enter Course: ");
		course = reader.readLine();
		System.out.println("---------------------------------------");

		Faculty f = new Faculty(name, address, empid, dept, basic, designation, course);

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Research Assisstant Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Name: ");
		name = reader.readLine();
		System.out.print("Enter Address: ");
		address = reader.readLine();
		System.out.print("Enter Employee ID: ");
		empid = reader.readLine();
		System.out.print("Enter Department: ");
		dept = reader.readLine();
		System.out.print("Enter Basic: ");
		basic = input.nextInt();
		System.out.print("Enter Project: ");
		project = reader.readLine();
		System.out.print("Enter Course: ");
		course = reader.readLine();
		System.out.println("Enter Marks Obtained");
		
		for(int j=0; j<3; j++)
		{
			System.out.print("Enter Mark"+(j+1)+": ");
			marks[j] = input.nextFloat();
		}

		System.out.println("---------------------------------------");

		ResearchAssisstant ra = new ResearchAssisstant(name, address, empid, dept, basic, marks, project, course);

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("DISPLAY Employee Details");
		System.out.println("---------------------------------------");
		System.out.println("Name: "+e.getName());
		System.out.println("Address: "+e.getAddress());
		System.out.println("Employee ID: "+e.getEmpid());
		System.out.println("Department: "+e.getDept());
		System.out.println("Basic Pay: "+e.getBasic());
		System.out.println("Salary: "+e.calSalary());
		System.out.println("---------------------------------------");

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("DISPLAY Faculty Details");
		System.out.println("---------------------------------------");
		System.out.println("Name: "+f.getName());
		System.out.println("Address: "+f.getAddress());
		System.out.println("Employee ID: "+f.getEmpid());
		System.out.println("Department: "+f.getDept());
		System.out.println("Basic Pay: "+f.getBasic());
		System.out.println("Designation: "+f.getDesig());
		System.out.println("Course: "+f.getCourse());
		System.out.println("Salary: "+f.calSalary());
		System.out.println("---------------------------------------");

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("DISPLAY Research Assisstant Details");
		System.out.println("---------------------------------------");
		System.out.println("Name: "+ra.getName());
		System.out.println("Address: "+ra.getAddress());
		System.out.println("Employee ID: "+ra.getEmpid());
		System.out.println("Department: "+ra.getDept());
		System.out.println("Basic Pay: "+ra.getBasic());
		System.out.println("Project: "+ra.getProject());
		System.out.println("Course: "+ra.getCourse());
		marks = ra.getMarks();
		System.out.println("Marks Obtained: " +marks[0] +" " +marks[1] +" " +marks[2]);
		System.out.println("GPA: "+ra.calcGPA());
		System.out.println("Salary: "+ra.calSalary());
		System.out.println("---------------------------------------");
	}
}
