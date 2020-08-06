import java.util.Scanner;

class ElectricityBill
{
	int consumerNo;
	String consumerName;
	int prevMonth;
	int currMonth;
	String type;
	int totUnits;
	float tariff;

	ElectricityBill()
	{
		consumerNo = 0;
		
		consumerName = "XXX";	

		prevMonth = 0;

		currMonth = 0;

		type = "XXX";

		totUnits = 0;

		tariff = 0;
	}

	void calcBill()
	{
		totUnits=currMonth-prevMonth;		
		
		tariff=0;

		if(type.compareTo("domestic")==0)
		{
			if(totUnits<=100)
				tariff+=(totUnits*1);

			else if((totUnits>100)&&(totUnits<=200))
				tariff+=((100*1)+(totUnits-100)*2.5);
	
			else if((totUnits>200)&&(totUnits<=500))
				tariff+=((100*1)+(totUnits-100)*2.5+(totUnits-300)*4);
	
			else if(totUnits>500)
				tariff+=((100*1)+(totUnits-100)*2.5+(totUnits-300)*4+(totUnits-500)*6);
		}

		else if(type.compareTo("commercial")==0)
		{
			if(totUnits<=100)
				tariff+=(totUnits*2);

			else if((totUnits>100)&&(totUnits<=200))
				tariff+=((100*2)+(totUnits-100)*4.5);
	
			else if((totUnits>200)&&(totUnits<=500))
				tariff+=((100*2)+(totUnits-100)*4.5+(totUnits-300)*6);
	
			else if(totUnits>500)
				tariff+=((100*2)+(totUnits-100)*4.5+(totUnits-300)*6+(totUnits-500)*7);
		}
	}

	void getBill()
	{

		System.out.println("");
		System.out.println("**********************************");		
		System.out.println("\tELECTRICITY BILL");
		System.out.println("**********************************");		

		System.out.println("Consumer Number:  " +consumerNo);

		System.out.println("Consumer Name:    " +consumerName);

		System.out.println("Connection Type : " +type);

		System.out.println("Previous Reading: " +prevMonth);

		System.out.println("Current Reading:  " +currMonth);

		System.out.println("\t\t------------");	
	
		System.out.println("Total Units:      " +totUnits);

		System.out.println("\t\t------------");

		System.out.println("");

		System.out.println("**********************************");		
		System.out.println("\tTARRIF: " +tariff);	
		System.out.println("**********************************");
		
	}
}

public class EB
{
	public static void main(String[] args)
	{
		ElectricityBill e = new ElectricityBill();

		Scanner input = new Scanner(System.in);
		Scanner str = new Scanner(System.in);

		System.out.println("CONNECTION DETAILS");
		System.out.println("");
		
		System.out.print("Enter Consumer Number: ");
		e.consumerNo = input.nextInt();

		System.out.print("Enter Consumer Name: ");
		e.consumerName = str.nextLine();	

		System.out.print("Enter the number of units consumed in the previous month: ");
		e.prevMonth = input.nextInt();

		System.out.print("Enter the number of units consumed this month: ");
		e.currMonth = input.nextInt();

		System.out.print("Enter Connection type(domestic/commercial): ");
		e.type = str.nextLine();

		e.calcBill();

		e.getBill();	
		
	}
}
