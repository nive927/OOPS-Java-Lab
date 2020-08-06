import myPack.CurrConvertor;

import java.io.*;
import java.util.*;
import java.lang.*;

public class TestCurrConvertor
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		int choice;
		String amount;
		double amt, amtINR;

		CurrConvertor c = new CurrConvertor();

		do
		{
			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("MENU for Currency Conversion");
			System.out.println("------------------------------");
			System.out.println("1. DOLLAR to INR");
			System.out.println("2. YEN to INR");
			System.out.println("3. EURO to INR");
			System.out.println("4. EXIT");
			System.out.println("------------------------------");

			System.out.print("Enter choice: ");
			choice = input.nextInt();

			switch(choice)
			{
				case 1: System.out.print("Enter DOLLAR amount: ");
						amount = reader.readLine();

						try
						{
							amt = Double.parseDouble(amount);
							amtINR = c.dollarToINR(amt);

							System.out.println("1 Dollar equals 71.81 INR");
							System.out.println("INR Equivalent: "+amtINR);
						}

						catch(NumberFormatException e)
						{
							System.out.println("INVALID Format of Input Currency !\nTRY AGAIN !");
						}

						break;

				case 2: System.out.print("Enter YEN amount: ");
						amount = reader.readLine();

						try
						{
							amt = Double.parseDouble(amount);
							amtINR = c.yenToINR(amt);

							System.out.println("1 YEN equals 0.67 INR");
							System.out.println("INR Equivalent: "+amtINR);
						}

						catch(NumberFormatException e)
						{
							System.out.println("INVALID Format of Input Currency !\nTRY AGAIN !");
						}

						break;

				case 3:	System.out.print("Enter EURO amount: ");
						amount = reader.readLine();

						try
						{
							amt = Double.parseDouble(amount);
							amtINR = c.euroToINR(amt);

							System.out.println("1 EURO equals 79.39 INR");
							System.out.println("INR Equivalent: "+amtINR);
						}

						catch(NumberFormatException e)
						{
							System.out.println("INVALID Format of Input Currency !\nTRY AGAIN !");
						}

						break;

				case 4: return;
			}
		}while(choice <4);
	}
}