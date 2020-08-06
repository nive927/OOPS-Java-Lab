import java.io.*;
import java.util.*;

class AccountNotFoundException extends Exception
{
	String s;

	public AccountNotFoundException(String s)
	{
		this.s = s;
	}

	public String toString()
	{
		return s;
	}
}

class PANRequiredException extends Exception
{
	String s;

	public PANRequiredException(String s)
	{
		this.s = s;
	}

	public String toString()
	{
		return s;
	}
}

class NoEnoughMoneyException extends Exception
{
	String s;

	public NoEnoughMoneyException(String s)
	{
		this.s = s;
	}

	public String toString()
	{
		return s;
	}
}

class MinBalRequiredException extends Exception
{
	String s;

	public MinBalRequiredException(String s)
	{
		this.s = s;
	}

	public String toString()
	{
		return s;
	}
}

class Account
{
	private String cname;
	private int pan;
	private int accno;
	private String branch;
	private float balance;

	public Account()
	{

	}

	public Account(String cname, int accno, String branch, float balance)
	{
		this.cname = cname;
		this.accno = accno;
		this.branch = branch;
		this.balance = balance;
	}

	public Account(String cname, int pan, int accno, String branch, float balance)
	{
		this.cname = cname;
		this.pan = pan;
		this.accno = accno;
		this.branch = branch;
		this.balance = balance;
	}

	public String getCname()
	{
		return cname;
	}

	public int getPan()
	{
		return pan;
	}

	public int getAccno()
	{
		return accno;
	}

	public String getBranch()
	{
		return branch;
	}

	public float getBalance()
	{
		return balance;
	}

	public void setPan(int panno)
	{
		pan = panno;
	}

	public void setBalance(float amt)
	{
		balance = amt;
	}

	public void deposit(int accno, float amt) throws PANRequiredException
	{
		if(amt > 50000 && pan == 0)
			throw new PANRequiredException("FAILED: To deposit more than 50,000 PAN Number is MANDATORY !(PAN REQUIRED EXCEPTION)");

		balance += amt;
	}

	public void withdraw(int accno, float amt) throws NoEnoughMoneyException, MinBalRequiredException
	{
		if(amt > balance)
			throw new NoEnoughMoneyException("FAILED: Withdrawal is more than available Balance !(NO ENOUGH MONEY EXCEPTION)");

		else if(10000 > (balance - amt))
			throw new MinBalRequiredException("FAILED: Balance becomes lower than Minimum Requirement 10000!(MIN BAL REQUIRED EXCEPTION)");

		balance -= amt;
	}

	public String toString()
	{
		return "\n\n------------------------------"+
				"\nAccount Details"+
				"\n------------------------------"+
				"\nCustomer Name: "+cname+
				"\nPAN Number: "+pan+
				"\nAccount Number: "+accno+
				"\nBranch: "+branch+
				"\nBalance: "+balance+
				"\n------------------------------\n";
	}
}

public class Custom
{

	public static Account Search(Account acc [], int accno) throws AccountNotFoundException
	{
		for(int i=0; i<2; i++)
			if(acc[i].getAccno() == accno)
				return acc[i];

		throw new AccountNotFoundException("FAILED: Account was NOT FOUND !(ACCOUNT NOT FOUND EXCEPTION)");
	}

	public static void main(String args[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		int choice;
		int N = 2;

		String cname;
		int pan;
		int accno;
		String branch;
		float balance;

		Account acc[] = new Account[N];

		Account account = new Account();
		float amt;

		for(int i=0; i<N; i++)
		{
			System.out.println("");
			System.out.println("---------------------------------------");
			System.out.println("NEW Customer Account Details");
			System.out.println("---------------------------------------");
			System.out.print("Enter Customer Name: ");
			cname = reader.readLine();
			System.out.print("Enter Account Number: ");
			accno = input.nextInt();
			System.out.print("Enter Branch Name: ");
			branch = reader.readLine();
			System.out.print("Enter Balance: ");
			balance = input.nextFloat();
			System.out.println("Do you have a PAN Number?");
			System.out.println("1:YES 2:NO");
			System.out.print("Enter choice: ");
			choice = input.nextInt();

			if(choice == 1)
			{
				System.out.print("Enter PAN: ");
				pan = input.nextInt();
				acc[i] = new Account(cname, pan, accno, branch, balance);
			}

			else
				acc[i] = new Account(cname, accno, branch, balance);

			System.out.println("---------------------------------------");
		}

		do
		{
			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("MENU for Bank Account");
			System.out.println("------------------------------");
			System.out.println("1. WITHDRAW");
			System.out.println("2. DEPOSIT");
			System.out.println("3. VIEW Account Details");
			System.out.println("4. EXIT");
			System.out.println("------------------------------");

			System.out.print("Enter choice: ");
			choice = input.nextInt();

			switch(choice)
			{
				case 1: System.out.print("Enter Account Number to withdraw from: ");
						accno = input.nextInt();

						try
						{
							account = Search(acc, accno);
							System.out.println("Current Balance: "+account.getBalance());
							System.out.print("Enter amount to withdraw: ");
							amt = input.nextFloat();
							System.out.println("---------------------------------------");
							System.out.println("Old Balance: "+account.getBalance());
							account.withdraw(accno, amt);
							System.out.println("New Balance: "+account.getBalance());
							System.out.println("---------------------------------------");
						}

						catch(AccountNotFoundException e)
						{
							System.out.println(e);
						}

						catch(NoEnoughMoneyException e)
						{
							System.out.println(e);
							System.out.println("New Balance: "+account.getBalance());
						}

						catch(MinBalRequiredException e)
						{
							System.out.println(e);
							System.out.println("New Balance: "+account.getBalance());
						}

						break;

				case 2: System.out.print("Enter Account Number to deposit into: ");
						accno = input.nextInt();

						try
						{
							account = Search(acc, accno);
							System.out.println("Current Balance: "+account.getBalance());
							System.out.print("Enter amount to deposit: ");
							amt = input.nextFloat();
							System.out.println("---------------------------------------");
							System.out.println("Old Balance: "+account.getBalance());
							account.deposit(accno, amt);
							System.out.println("New Balance: "+account.getBalance());
							System.out.println("---------------------------------------");

						}

						catch(AccountNotFoundException e)
						{
							System.out.println(e);
						}

						catch(PANRequiredException e)
						{
							System.out.println(e);
							System.out.println("New Balance: "+account.getBalance());

							System.out.print("Enter PAN: ");
							pan = input.nextInt();

							account.setPan(pan);
						}

						break;

				case 3:	System.out.print("Enter Account Number to view Account Details: ");
						accno = input.nextInt();

						try
						{
							account = Search(acc, accno);

							System.out.println(account);

							/*System.out.println("");
							System.out.println("------------------------------");
							System.out.println("Account Details");
							System.out.println("------------------------------");
							System.out.println("Customer Name: "+account.getCname());
							System.out.println("PAN Number: "+account.getPan());
							System.out.println("Account Number: "+account.getAccno());
							System.out.println("Branch: "+account.getBranch());
							System.out.println("Balance: "+account.getBalance());
							System.out.println("------------------------------");*/
						}

						catch(AccountNotFoundException e)
						{
							System.out.println(e);
						}

						break;

				case 4: return;
			}
		}while(choice != 4);
	}
}
