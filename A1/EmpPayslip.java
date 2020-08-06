import java.util.Scanner;
import java.util.Date;

class Employee
{
	private String id;
	private String name;
	private String designation;
	private String DOB;
	private String DOJ;
	private double basic;
	private double DA;
	private double HRA;
	private double LIC;
	private double PF;
	private long noofhours;
	private double Deductions;
	private double Gross;
	private double Net;

	Employee(String id, String name, String designation, String DOB, String DOJ, double basic, double DA, double HRA, double LIC, double PF, long noofhours)
	{
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.DOB = DOB;
		this.DOJ = DOJ;
		this.basic = basic;
		this.DA = DA;
		this.HRA = HRA;
		this.LIC = LIC;
		this.PF = PF;
		this.noofhours = noofhours;
		this.Deductions = 0;
		this.Gross = 0;
		this.Net = 0;
	}

	public String getId()
	{
		return id;
	}

	private void calcPayslip()
	{
		if((designation.compareTo("Intern")==0)||(designation.compareTo("intern")==0))
		{
			Gross = noofhours * basic + DA + HRA;
			Deductions=LIC + PF;
			Net = Gross-Deductions;
		}

		else
		{
			Gross = basic + DA + HRA;
			Deductions=LIC + PF;
			Net = Gross-Deductions;
		}
	}

	public void showPayslip()
	{
		calcPayslip();

		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("\t\tEMPLOYEE PAYSLIP");
		System.out.println("-------------------------------------------------");
		System.out.println("EmpID: " +id);
		System.out.println("Name: " +name);
		System.out.println("Designation: " +designation);
		System.out.println("");
		System.out.println("DOB  : " +DOB);
		System.out.println("DOJ  : " +DOJ);
		System.out.println("");

		if((designation.compareTo("Intern")==0)||(designation.compareTo("intern")==0))
			System.out.println("HrPay: " +basic);
		else
			System.out.println("BASIC: " +basic);

		System.out.println("DA   : " +DA);
		System.out.println("HRA  : " +HRA);
		System.out.println("LIC  : " +LIC);
		System.out.println("PF   : " +PF);

		if((designation.compareTo("Intern")==0)||(designation.compareTo("intern")==0))
			System.out.println("NoHRS: " +noofhours);

		System.out.println("-------------------------------------------------");
		System.out.println("Gross: " +Gross);
		System.out.println("DED  : " +Deductions);
		System.out.println("-------------------------------------------------");
		System.out.println("");
		System.out.println("\t\tNET SALARY: " +Net);
		System.out.println("");
		System.out.println("-------------------------------------------------");
	}

	public void getEmpDetails()
	{
			calcPayslip();

			System.out.println("");
			System.out.println("EMPLOYEE DETAILS");
			System.out.println("");
			System.out.println("EmpID: " +id);
			System.out.println("Name: " +name);
			System.out.println("Designation: " +designation);
			System.out.println("");
			System.out.println("DOB  : " +DOB);
			System.out.println("DOJ  : " +DOJ);
			System.out.println("");
			System.out.println("NET SALARY: " +Net);
			System.out.println("");
	}

	public int promoteEmp()
	{
		String year, choice="y";

		Date d = new Date();

		int year1 = d.getYear();
		int last;
		last = year1+1900;
		year = DOJ.substring(6, 10);
		int first = Integer.parseInt(year);
		int years = last - first;

		Scanner str = new Scanner(System.in);
		Scanner input = new Scanner(System.in);

		if((designation.compareTo("Intern")==0)||(designation.compareTo("intern")==0))
		{
			if(years>2)
			{
				System.out.println("");
				System.out.println("PROMOTION Available from Intern to Others");
				System.out.println("Would you like to promote the employee? Y: YES N: NO");
				System.out.print("Enter your choice: ");
				choice = str.nextLine();

				if((choice.compareTo("Y")==0)||(choice.compareTo("y")==0))
				{
					designation="Others";

					System.out.println("");
					System.out.print("Enter new Basic Salary: ");
					basic = input.nextDouble();

					DA =0.3*basic;
					HRA=0.1*basic;
					PF=0.08*basic;

					return 1;
				}
			}
		}

		else if((designation.compareTo("Others")==0)||(designation.compareTo("others")==0))
		{
			if(years>5)
			{
				System.out.println("");
				System.out.println("PROMOTION Available from Others to Manager");
				System.out.println("Would you like to promote the employee? Y: YES N: NO");
				System.out.print("Enter your choice: ");
				choice = str.nextLine();

				if((choice.compareTo("Y")==0)||(choice.compareTo("y")==0))
				{
					designation="Manager";

					System.out.println("");
					System.out.print("Enter new Basic Salary: ");
					basic = input.nextDouble();

					DA =0.4*basic ;
					HRA=0.1*basic;
					PF=0.08*basic;

					return 1;
				}
			}

			else
			{	System.out.println("");
				System.out.println("PROMOTION NOT AVAILABLE");
			}
		}

		return -1;
	}
}

public class EmpPayslip
{
	public static int searchEmp(Employee e[], int ws, String ID)
	{
		for(int i=0; i<ws; i++)
			if((e[i].getId()).compareTo(ID)==0)
				return i;

		return -1;
	}

	public static void main(String[] args)
	{
		int N=0, choice, pos=-1, status;
		String ID, schoice="y";

		String id, name, designation, DOB, DOJ;
		double basic, DA = 0, HRA = 0, LIC = 0, PF = 0;
		long noofhours = 0;

		Employee[] e = new Employee[10];

		Scanner input = new Scanner(System.in);
		Scanner str = new Scanner(System.in);

		System.out.println("");
		System.out.print("Enter number of employee records: ");
		N = input.nextInt();

		do
		{
			System.out.println("");
			System.out.println("MENU for Employee Records");
			System.out.println("");
			System.out.println("1. Enter the Employee Details");
			System.out.println("2. Display Employee Records");
			System.out.println("3. Generate Payslip");
			System.out.println("4. Promote an Employee");
			System.out.println("5. Exit");
			System.out.println("");

			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch(choice)
			{
				case 1:	for(int i=0; i<N; i++)
						{
							System.out.println("");
							System.out.println("EMPLOYEE DETAILS");
							System.out.println("");

							System.out.print("Enter ID: ");
							id = str.nextLine();

							System.out.print("Enter Name: ");
							name = str.nextLine();

							System.out.println("");
							System.out.println("OPTIONS: Intern, Manager, Others");
							System.out.print("Enter Designation: ");
							designation = str.nextLine();

							System.out.println("");
							System.out.print("Enter DATE OF BIRTH in dd/mm/yyyy FORMAT: ");
							DOB = str.nextLine();

							System.out.println("");
							System.out.print("Enter DATE OF JOINING in dd/mm/yyyy FORMAT: ");
							DOJ = str.nextLine();

							System.out.println("");
							if((designation.compareTo("Intern")==0)||(designation.compareTo("intern")==0))
							{
								System.out.print("Enter Hourly wage: ");
								basic = input.nextDouble();

								System.out.print("Enter number of hours worked: ");
								noofhours = input.nextLong();
							}

							else
							{
								System.out.print("Enter Basic Pay: ");
								basic = input.nextDouble();
							}

							System.out.println("");
							System.out.println("Opt for LIC Premium? YES:y NO:n");
							System.out.print("Enter Choice: ");
							schoice = str.nextLine();

							if((schoice.compareTo("Y")==0)||(schoice.compareTo("y")==0))
							{
								System.out.print("Enter LIC Premium: ");
								LIC = input.nextDouble();
							}

							if((designation.compareTo("Intern")==0)||(designation.compareTo("intern")==0))
							{
								DA=2000;
								HRA=1000;
								PF=500;
							}

							else if((designation.compareTo("Manager")==0)||(designation.compareTo("manager")==0))
							{
								DA =0.4*basic ;
								HRA=0.1*basic;
								PF=0.08*basic;
							}

							else if((designation.compareTo("others")==0)||(designation.compareTo("others")==0))
							{
								DA =0.3*basic ;
								HRA=0.1*basic;
								PF=0.08*basic;
							}

							e[i] = new Employee(id, name, designation, DOB, DOJ, basic, DA, HRA, LIC, PF, noofhours);
							LIC = 0;
						}
						break;

				case 2:	for(int i=0; i<N; i++)
						e[i].getEmpDetails();

						break;

				case 3:	System.out.println("");
						System.out.print("Enter the employee id to obtain the payslip: ");
						ID = str.nextLine();

						pos = searchEmp(e, N, ID);

						if(pos==-1)
						{	System.out.println("");
							System.out.println("Employee Record NOT FOUND");
							System.out.println("");
						}

						else
							e[pos].showPayslip();

						break;

				case 4:	System.out.println("");
						System.out.print("Enter the employee id to check promotion possibility: ");
						ID = str.nextLine();

						pos = searchEmp(e, N, ID);

						if(pos==-1)
						{	System.out.println("");
							System.out.println("Employee Record NOT FOUND");
							System.out.println("");
						}

						else
						{	status = e[pos].promoteEmp();

							if(status!=-1)
								e[pos].showPayslip();

							else
							{	System.out.println("");
								System.out.println("Employee was NOT PROMOTED");
								System.out.println("");
							}

						}

						break;

				case 5:	return;
			}
		}while(choice!=5);
	}
}
