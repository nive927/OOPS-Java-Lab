import java.io.*;
import java.util.*;

class Author
{
	private String name;
	private String email;
	private char gender;

	public Author()
	{
		name = "XXX";
		email = "@@@";
		gender = 'U';
	}

	public Author(String name, String email, char gender)
	{
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String getName()
	{
		return name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public char getGender()
	{
		return gender;
	}
}

class Book
{
	private String name;
	private Author author;
	private double price;
	private int qty = 0;

	Book(String name, Author author, double price)
	{
		this.name = name;
		this.author = author;
		this.price = price;
		qty = 1;
	}

	public Book(String name, Author author, double price, int qty)
	{
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}

	public String getName()
	{
		return name;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public double getPrice()
	{
		return price;
	}

	public void setQty(int qty)
	{
		this.qty = qty;
	}

	public int getQty()
	{
		return qty;
	}

	public String getAuthorName()
	{
		return author.getName();
	}

	public String getAuthorEmail()
	{
		return author.getEmail();
	}
}

public class Tester
{
	public static void main(String [] args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String Aname = new String();
		String email;
		char gender;

		String Bname = new String();
		double price;
		int qty = 0;

		int N, choice = 1, ch = 1;

		System.out.println("");
		System.out.print("Enter number of Book records: ");
		N = input.nextInt();

		Book[] book = new Book[N];

		do
		{
			System.out.println("");
			System.out.println("---------------------------------------");
			System.out.println("MENU for Book Records");
			System.out.println("---------------------------------------");
			System.out.println("1. Enter the Book Details");
			System.out.println("2. Display Book Records and Author Details");
			System.out.println("3. Reset Details");
			System.out.println("4. Exit");
			System.out.println("---------------------------------------");
			System.out.println("");

			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch(choice)
			{
				case 1:	for(int i=0; i<N; i++)
					{
						System.out.println("");
						System.out.println("---------------------------------------");
						System.out.println("New Book Details");
						System.out.println("---------------------------------------");
						System.out.print("Enter Book Name: ");
						Bname = reader.readLine();

						System.out.print("Enter Book Price: ");
						price = input.nextDouble();

						System.out.print("Enter Book Quantity: ");
						qty = input.nextInt();

						System.out.println("---------------------------------------");
						System.out.println("New Author Details");
						System.out.println("---------------------------------------");
						System.out.print("Enter Author Name: ");
						Aname = reader.readLine();

						System.out.print("Enter Author Email: ");
						email = reader.readLine();

						System.out.print("Enter Author Gender(M/F): ");
						gender = input.next().charAt(0);
						System.out.println("---------------------------------------");

						Author author = new Author(Aname, email, gender);

						book[i] = new Book(Bname, author, price, qty);
					}

					break;

				case 2:	for(int i=0; i<N; i++)
					{
						Author author = new Author();
						author = book[i].getAuthor();

						System.out.println("");
						System.out.println("---------------------------------------");
						System.out.println("Book Details Method Tests");
						System.out.println("---------------------------------------");
						System.out.println("Name: "+book[i].getName());
						System.out.println("Price: "+book[i].getPrice());
						System.out.println("Quantity: "+book[i].getQty());
						System.out.println("---------------------------------------");
						System.out.println("Author Details Method Tests from BOOK");
						System.out.println("---------------------------------------");
						System.out.println("Name: "+book[i].getAuthorName());
						System.out.println("Email: "+book[i].getAuthorEmail());
						System.out.println("Gender: "+author.getGender());
						System.out.println("---------------------------------------");

						/*System.out.println("");
						System.out.println("Author Details Method Tests");
						System.out.println("Name: "+author.getName());
						System.out.println("Email: "+author.getEmail());
						System.out.println("Gender: "+author.getGender());*/
					}



					break;

				case 3:	System.out.println("RESET 1:Author Details 2: Book Details");
					System.out.print("Enter your choice: ");
					ch = input.nextInt();

					if(ch == 1)
					{
						for(int i=0; i<N; i++)
						{	System.out.println("");
							System.out.println("Author of Book"+(i+1));
							System.out.println("");
							System.out.print("RE-SETTING Author Email: ");
							email = reader.readLine();

							Author author = new Author();
							author = book[i].getAuthor();
							author.setEmail(email);
							book[i].setAuthor(author);

							System.out.println("");

							System.out.println("After Email Reset for the AUTHOR");
							System.out.println("Name: "+author.getName());
							System.out.println("Email: "+author.getEmail());
							System.out.println("Gender: "+author.getGender());
						}
					}

					else if(ch == 2)
					{
						for(int i=0; i<N; i++)
						{
							Author author = new Author();
							author = book[i].getAuthor();

							System.out.println("");
							System.out.println("Book"+(i+1));
							System.out.println("");
							System.out.print("RE-SETTING Book Price: ");
							price = input.nextDouble();
							book[i].setPrice(price);
							System.out.print("RE-SETTING Book Qty: ");
							qty = input.nextInt();
							book[i].setQty(qty);

							System.out.println("");
							System.out.println("After Price and Qty Reset for the BOOK");
							System.out.println("Book Name: "+book[i].getName());
							System.out.println("Book Price: "+book[i].getPrice());
							System.out.println("Book Quantity: "+book[i].getQty());
							System.out.println("");
							System.out.println("Author Details Method Tests from BOOK");
							System.out.println("Author Name: "+book[i].getAuthorName());
							System.out.println("Author Email: "+book[i].getAuthorEmail());
							System.out.println("Author Gender: "+author.getGender());


						}
					}

					else
						System.out.println("INVALID OPTION! Try Again");

					break;

				case 4:	return;

				default: System.out.println("INVALID CHOICE! Try Again");
			}
		}while(choice!=4);
	}
}














