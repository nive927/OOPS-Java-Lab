import java.util.Scanner;

class Student
{
	private int regno;
	private String name;
	private String dept;
	private float marks[] = new float[3];
	private float total;
	private char grade;

	Student(int regno, String name, String dept)
	{
		this.regno = regno;
		this.name = name;
		this.dept = dept;
	}

	private void calcTotal()
	{
		total = 0;

		for(int i=0; i<3; i++)
			total+=marks[i];
	}

	private void calcGrade()
	{
		float avg = total/3;

		if(avg<50)
			grade = 'F';

		else if((avg>=50)&&(avg<60))
			grade = 'E';

		else if((avg>=60)&&(avg<70))
			grade = 'D';

		else if((avg>=70)&&(avg<80))
			grade = 'C';

		else if((avg>=80)&&(avg<90))
			grade = 'B';

		else if((avg>=90)&&(avg<=100))
			grade = 'A';
	}

	public String getDept()
	{
		return dept;
	}

		public int getRegno()
	{
		return regno;
	}

	public void setMarks()
	{
		Scanner input = new Scanner(System.in);

		for(int j=0; j<3; j++)
		{
			System.out.print("Enter mark " +(j+1) +": ");
			marks[j] = input.nextFloat();
		}
	}

	public void showMarksheet()
	{
		calcTotal();
		calcGrade();

		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("\t\tSTUDENT MARKSHEET");
		System.out.println("-------------------------------------------------");
		System.out.println("Regno: " +regno);
		System.out.println("Name : " +name);
		System.out.println("Dept : " +dept);
		System.out.println("");

		System.out.println("Marks Obtained");
		for(int i=0; i<3; i++)
			System.out.println("Mark " +(i+1) +": " +marks[i]);

		System.out.println("-------------------------------------------------");
		System.out.println("Total: " +total);
		System.out.println("Grade: " +grade);
		System.out.println("-------------------------------------------------");
		System.out.println("");
	}

	public void getStuDetails()
	{
			calcTotal();
			calcGrade();

			System.out.println("");
			System.out.println("STUDENT DETAILS");
			System.out.println("");
			System.out.println("Regno: " +regno);
			System.out.println("Name : " +name);
			System.out.println("Dept : " +dept);
			/*System.out.println("");
			System.out.println("Marks Obtained: " +marks[0] +" " +marks[1] +" " +marks[2]);
			System.out.println("");
			System.out.println("Total: " +total);
			System.out.println("Grade: " +grade);
			System.out.println("");*/
	}
}

class ClassMark
{
	public static int searchStudent(Student s[], String dep, int n)
	{
		for(int j=0; j<n; j++)
			if((s[j].getDept()).compareTo(dep)==0)
				return j;

		return -1;
	}

	public static int searchStudent(Student s[], int rno, int n)
	{
		for(int k=0; k<n; k++)
			if((s[k].getRegno())==rno)
				return k;

		return -1;
	}

	public static void main(String[] args)
		{
			int n=0, choice, rno, pos=-1, ch =1, ws;
			String dep;

			int regno;
			String name, dept;
			float marks[] = new float[3];

			Student[] s = new Student[10];

			Scanner input = new Scanner(System.in);
			Scanner str = new Scanner(System.in);

			System.out.println("");
			System.out.print("Enter number of student records: ");
			n = input.nextInt();

			do
			{
				System.out.println("");
				System.out.println("MENU FOR STUDENT RECORDS");
				System.out.println("");
				System.out.println("1. Enter Student Details");
				System.out.println("2. Display Student Records");
				System.out.println("3. Generate Mark Sheet");
				System.out.println("4. Search a Student");
				System.out.println("5. Exit");
				System.out.println("");

				System.out.print("Enter your choice: ");
				choice = input.nextInt();

				switch(choice)
				{
					case 1:	for(int i=0; i<n; i++)
							{
								System.out.println("");
								System.out.println("STUDENT DETAILS");
								System.out.println("");

								System.out.print("Enter Register Number: ");
								regno = input.nextInt();

								System.out.print("Enter Name: ");
								name = str.nextLine();

								System.out.print("Enter Department: ");
								dept = str.nextLine();

								System.out.println("");
								System.out.println("Marks Obtained");

								s[i] = new Student(regno, name, dept);
								s[i].setMarks();

							}

							break;

					case 2:	for(int i=0; i<n; i++)
								s[i].getStuDetails();

							break;

					case 3:	System.out.println("");
							System.out.print("Enter the Register Number to obtain the marksheet: ");
							rno = input.nextInt();

							pos = searchStudent(s, rno, n);

							if(pos!=-1)
								s[pos].showMarksheet();

							else
								System.out.println("Student record NOT FOUND");

							break;
					case 4:	System.out.println("");
							System.out.println("SEARCH for student using:");
							System.out.println("");

							System.out.println("1:Register number 2:Department");
							System.out.print("Enter choice: ");
							ch = input.nextInt();

							System.out.println("");

							if(ch==1)
							{	System.out.print("Enter the Register Number to search for the student: ");
								rno = input.nextInt();

								pos = searchStudent(s, rno, n);

								if(pos!=-1)
									s[pos].getStuDetails();

								else
									System.out.println("Student record NOT FOUND");
							}

							else if(ch==2)
							{
								System.out.print("Enter the department to search for the student: ");
								dep = str.nextLine();

								pos = searchStudent(s, dep, n);

								if(pos!=-1)
									s[pos].getStuDetails();

								else
									System.out.println("Student record NOT FOUND");
							}

							else
								System.out.println("INVALID OPTIOn");

							break;

					case 5:	return;
				}

			}while(choice!=5);
	}

}
