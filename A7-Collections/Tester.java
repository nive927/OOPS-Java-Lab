import java.util.*;
import java.io.*;

class ArrayList
{
	String arr[];
	int size;

	ArrayList()
	{
		arr = new String[1];
		size = 0;
	}

	void add(String str)
	{
		arr[size] = str;
		size += 1;
		arr = Arrays.copyOf(arr, size+1);
	}

	void insert(String str, int pos)
	{
		if(pos > size)
		{
			System.out.println("Position specified exceeds the array size !");
			System.out.println("Insertion FAILED !");
			return;
		}

		for(int i=size; i>pos; i--)
			arr[i] = arr[i-1];

		arr[pos] = str;
		size += 1;

		arr = Arrays.copyOf(arr, size+1);
	}

	int contains(String str)
	{
		int c = 0;

		for(int i=0; i<size; i++)
			if(arr[i].equals(str))
				c += 1;
		return c;
	}

	void display()
	{
		System.out.print("Array List: [ ");

		for(int i=0; i<size-1; i++)
			System.out.print(arr[i]+",  ");
		System.out.println(arr[size-1]+" ]");
	}

	void startsWith(char c)
	{
		ArrayList obj = new ArrayList();
		for(int i=0; i<size; i++)
			if(arr[i].charAt(0) == c)
			{
				obj.add(arr[i]);
			}

		if(obj.size == 0)
			System.out.println("Match NOT FOUND !");
		else
			obj.display();
	}

	void subString(String str)
	{
		ArrayList obj = new ArrayList();
		for(int i=0; i<size; i++)
			if(arr[i].indexOf(str)!= -1)
			{
				obj.add(arr[i]);
			}

		if(obj.size == 0)
			System.out.println("Match NOT FOUND !");
		else
			obj.display();
	}

	void replace(String str1, String str2)
	{
		for(int i=0; i<size; i++)
			if(arr[i].equals(str1))
				arr[i] = str2;
	}

	void remove(String str)
	{
		for(int i=0; i<size; i++)
			if(arr[i].equals(str))
			{
				for(; i<size-1; i++)
					arr[i] = arr[i+1];
				break;
			}

		size -= 1;
		arr = Arrays.copyOf(arr,size+1);

	}

	void duplicate()
	{
		ArrayList obj = new ArrayList();
		for(int i=0; i<size; i++)
		{
			if(obj.contains(arr[i]) == 0)
				obj.add(arr[i]);
		}
		arr = Arrays.copyOf(obj.arr,obj.size);
		size = obj.size;
	}
}

public class Tester
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		ArrayList al = new ArrayList();

		int choice, pos, n;
		String a, b;
		char c;

		do
		{
			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("MENU for String Array List");
			System.out.println("------------------------------");
			System.out.println("1.  APPEND");
			System.out.println("2.  INSERT at specific index");
			System.out.println("3.  Check occurence of element");
			System.out.println("4.  List all strings that start with a given letter");
			System.out.println("5.  List all strings with given substring");
			System.out.println("6.  REPLACE string with given string");
			System.out.println("7.  REMOVE specific element");
			System.out.println("8.  REMOVE DUPLICATE");
			System.out.println("9.  DISPLAY Array List");
			System.out.println("10. EXIT");
			System.out.println("------------------------------");

			System.out.print("Enter choice: ");
			choice = input.nextInt();

			switch(choice)
			{
				case 1:
						System.out.println();
						System.out.print("Enter number of strings to be appended: ");
						n = input.nextInt();

						for(int i=0; i<n; i++)
						{
							System.out.print("Enter String: ");
							a = reader.readLine();

							al.add(a);
						}

						System.out.println("Appended !");
						break;

				case 2:
						System.out.println();
						System.out.print("Enter index for insertion: ");
						pos = input.nextInt();

						System.out.print("Enter String: ");
						a = reader.readLine();

						al.insert(a,pos);
						System.out.println("String inserted !");
						break;

				case 3:
						System.out.println();
						System.out.print("Enter String to search: ");
						a = reader.readLine();

						pos = al.contains(a);

						if(pos==0)
							System.out.println(a+" DOESN'T OCCUR in the list");
						else
							System.out.println(a+" OCCURS "+pos+" times");
						break;

				case 4:
						System.out.println();
						System.out.print("Enter starting character of String: ");
						c = input.next().charAt(0);
						al.startsWith(c);
						break;

				case 5:
						System.out.println();
						System.out.print("Enter substring: ");
						a = reader.readLine();

						al.subString(a);
						break;

				case 6:
						System.out.println();
						System.out.print("Enter String to replace: ");
						a = reader.readLine();

						System.out.print("Enter Replacement String: ");
						b = reader.readLine();

						al.replace(a, b);
						System.out.println("String REPLACED !");
						break;

				case 7:
						System.out.println();
						System.out.print("Enter String: ");
						a = reader.readLine();

						al.remove(a);
						System.out.println("String REMOVED !");
						break;

				case 8:
						System.out.println();
						al.duplicate();
						System.out.println("Duplicates REMOVED !");
						al.display();
						break;

				case 9:
						System.out.println();
						al.display();
			}
		}while(choice!=10);
	}
}