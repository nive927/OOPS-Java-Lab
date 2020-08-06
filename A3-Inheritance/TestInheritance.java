import java.io.*;
import java.util.*;

class Person
{
	private int aadhaar;
	private String name;
	private String address;
	private char gender;

	public Person(int aadhaar, String name, String address, char gender)
	{
		this.aadhaar = aadhaar;
		this.name = name;
		this.address = address;
		this.gender = gender;
	}

	public String getName()
	{
		return name;
	}

	public String getAddress()
	{
		return address;
	}

	public char getGender()
	{
		return gender;
	}

	public int getAadhaar()
	{
		return aadhaar;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
}

class Student extends Person
{
	private String program;
	private int year;
	private float totalmark;

	public Student(int aadhaar, String name, String address, char gender, String program, int year, float total)
	{
		super(aadhaar, name, address, gender);
		this.program = program;
		this.year = year;
		totalmark = total;
	}

	public String getProgram()
	{
		return program;
	}

	public int getYear()
	{
		return year;
	}

	public float getTotal()
	{
		return totalmark;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public void setTotal(float tot)
	{
		totalmark = tot;
	}

	public float calGPA()
	{
		/*if(totalmark>=60 && totalmark<=100)
			return 4;

		else if(totalmark>=55 && totalmark<=59)
			return float(3.5);

		else if(totalmark>=50 && totalmark<=54)
			return 3;

		else if(totalmark>=43 && totalmark<=49)
			return float(2.5);

		else if(totalmark>=35 && totalmark<=42)
			return 2;

		else if(totalmark>=0 && totalmark<=34)
			return 0;*/

		return ((totalmark/500) * 10); 
	}
}

class Faculty extends Person
{
	private String designation;
	private String department;
	private float basicpay;

	public Faculty(int aadhaar, String name, String address, char gender, String designation, String dept, float pay)
	{
		super(aadhaar, name, address, gender);

		this.designation = designation;
		department = dept;
		basicpay = pay;
	}

	public String getDesig()
	{
		return designation;
	}

	public void setDesig(String desig)
	{
		designation = desig;
	}
	
	public String getDept()
	{
		return department;
	}
	
	public void setBasic(float basic)
	{
		basicpay = basic;
	}

	public float getBasic()
	{
		return basicpay;
	}

	public float calSalary()
	{
		float grosspay = basicpay + (0.6f * basicpay) + (0.1f * basicpay);
		float deductions = (0.085f * basicpay) + (0.08f * basicpay);
		return grosspay - deductions;
	}
}

public class TestInheritance
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		int aadhaar;
		String name;
		String address;
		char gender;
		String program; 
		int year;
		float total;

		String designation;
		String dept;
		float pay;

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Student Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Aadhaar ID: ");
		aadhaar = input.nextInt();
		System.out.print("Enter Name: ");
		name = reader.readLine();
		System.out.print("Enter Address: ");
		address = reader.readLine();
		System.out.print("Enter Gender: ");
		gender = input.next().charAt(0);
		System.out.print("Enter Program: ");
		program = reader.readLine();
		System.out.print("Enter Year: ");
		year = input.nextInt();
		System.out.print("Enter Total: ");
		total = input.nextFloat();
		System.out.println("---------------------------------------");

		Student s = new Student(aadhaar, name, address, gender, program, year, total);

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("INPUT Faculty Details");
		System.out.println("---------------------------------------");
		System.out.print("Enter Aadhaar ID: ");
		aadhaar = input.nextInt();
		System.out.print("Enter Name: ");
		name = reader.readLine();
		System.out.print("Enter Address: ");
		address = reader.readLine();
		System.out.print("Enter Gender: ");
		gender = input.next().charAt(0);
		System.out.print("Enter Designation: ");
		designation = reader.readLine();
		System.out.print("Enter Department: ");
		dept = reader.readLine();
		System.out.print("Enter Pay: ");
		pay = input.nextFloat();
		System.out.println("---------------------------------------");

		Faculty f = new Faculty(aadhaar, name, address, gender, designation, dept, pay);

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("DISPLAY Student Details");
		System.out.println("---------------------------------------");
		System.out.println("Aadhaar ID: "+s.getAadhaar());
		System.out.println("Name: "+s.getName());
		System.out.println("Address: "+s.getAddress());
		System.out.println("Gender: "+s.getGender());
		System.out.println("Program: "+s.getProgram());
		System.out.println("Year: "+s.getYear());
		System.out.println("Total: "+s.getTotal());
		System.out.println("GPA: "+s.calGPA());
		System.out.println("---------------------------------------");

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("DISPLAY Faculty Details");
		System.out.println("---------------------------------------");
		System.out.println("Aadhaar ID: "+f.getAadhaar());
		System.out.println("Name: "+f.getName());
		System.out.println("Address: "+f.getAddress());
		System.out.println("Gender: "+f.getGender());
		System.out.println("Designation: "+f.getDesig());
		System.out.println("Department: "+f.getDept());
		System.out.println("Basic Pay: "+f.getBasic());
		System.out.println("Salary: "+f.calSalary());
		System.out.println("---------------------------------------");
	

		
	}
}
