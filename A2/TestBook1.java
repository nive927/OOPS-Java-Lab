import java.io.*;
import java.util.*;

class Author
{
	private String name;
	private String email;
	private char gender;

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
	private Author[] author = new Author[5];
	private double price;
	private int qty = 0;

	Book(String name, Author author[], double price)
	{
		this.name = name;
		this.author = author;
		this.price = price;
		qty = 1;
	}

	public Book(String name, Author author[], double price, int qty)
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

	public Author[] getAuthor()
	{
		return author;
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

	public String getAuthorName(int i)
	{

		return author[i].getName();
	}

	public String getAuthorEmail(int i)
	{
		return author[i].getEmail();
	}
}

public class TestBook1
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		String Aname;
		String email;
		char gender;

		String Bname;
		double price;
		int qty = 0;

		Author author[] = new Author[5];
		int N;

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

		System.out.println("");
		System.out.print("Enter the number of authors: ");
		N = input.nextInt();
		System.out.println("");

		for(int i=0; i<N; i++)
		{
			System.out.println("---------------------------------------");
			System.out.println("Details of Author "+(i+1));
			System.out.println("---------------------------------------");
			System.out.print("Enter Author Name: ");
			Aname = reader.readLine();

			System.out.print("Enter Author Email: ");
			email = reader.readLine();

			System.out.print("Enter Author Gender: ");
			gender = input.next().charAt(0);
			System.out.println("---------------------------------------");

			author[i] = new Author(Aname, email, gender);
		}

		Book book = new Book(Bname, author, price, qty);

		/*for(int i=0; i<N; i++)
		{
			System.out.println("");
			System.out.println("Author Details Method Tests");
			System.out.println("Name: "+author[i].getName());
			System.out.println("Email: "+author[i].getEmail());
			System.out.println("Gender: "+author[i].getGender());

			System.out.println("");
			System.out.print("RE-SETTING Author Email: ");
			email = reader.readLine();
			author[i].setEmail(email);
			System.out.println("");
		}*/

		/*for(int i=0; i<N; i++)
		{
			System.out.println("After Email Reset for the AUTHOR");
			System.out.println("Name: "+author[i].getName());
			System.out.println("Email: "+author[i].getEmail());
			System.out.println("Gender: "+author[i].getGender());
		}*/

		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("Book Details");
		System.out.println("---------------------------------------");
		System.out.println("Name: "+book.getName());
		System.out.println("Price: "+book.getPrice());
		System.out.println("Quantity: "+book.getQty());

		for(int i=0; i<N; i++)
		{
			System.out.println("---------------------------------------");
			System.out.println("Details of Author "+(i+1));
			System.out.println("---------------------------------------");
			System.out.println("Name: "+author[i].getName());
			System.out.println("Email: "+author[i].getEmail());
			System.out.println("Gender: "+author[i].getGender());
		}

		System.out.println("---------------------------------------");

		/*for(int i=0; i<N; i++)
		{
			System.out.println("---------------------------------------");
			System.out.println("Details of Author "+(i+1));
			System.out.println("---------------------------------------");
			System.out.println("Name: "+book.getAuthorName());
			System.out.println("Email: "+book.getAuthorEmail());
			System.out.println("Gender: "+author.getGender());
		}

		System.out.println("---------------------------------------");*/

		/*System.out.println("");
		System.out.print("RE-SETTING Book Price: ");
		price = input.nextDouble();
		book.setPrice(price);
		System.out.print("RE-SETTING Book Qty: ");
		qty = input.nextInt();
		book.setQty(qty);
		System.out.println("");

		System.out.println("After Price and Qty Reset for the BOOK");
		System.out.println("Book Name: "+book.getName());
		System.out.println("Book Price: "+book.getPrice());
		System.out.println("Book Quantity: "+book.getQty());*/

		/*for(int i=0; i<N; i++)
		{
			System.out.println("");
			System.out.println("Author Details Method Tests from BOOK");
			System.out.println("Author Name: "+book.getAuthorName());
			System.out.println("Author Email: "+book.getAuthorEmail());
			System.out.println("Author Gender: "+author.getGender());
		}*/

	}
}