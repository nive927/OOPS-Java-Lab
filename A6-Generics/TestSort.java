
class Sort<T extends Comparable<T>>
{
	private T arr[];

	public Sort(T arr[])
	{
		this.arr = arr;

		for(int i = 0 ; i < arr.length ; i++)
			for(int j = i + 1 ; j < arr.length ; j++)
				if(arr[i].compareTo(arr[j]) > 0 )
				{
					T tmp = arr[i];
					arr[i] =  arr[j];
					arr[j] = tmp;
				}
	}

	public void display()
	{
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}
}

public class TestSort
{
	public static void main(String[] args)
	{
		java.util.Scanner input = new java.util.Scanner(System.in);

        int opt = 0;
        int ch = 0;

        while(opt != 4)
        {
			System.out.println("--------------------------");
			System.out.println("\tSORT Menu");
			System.out.println("--------------------------");
            System.out.println("1. INTEGER Array");
            System.out.println("2. DOUBLE Array");
            System.out.println("3. STRING Array");
            System.out.println("4. EXIT");
            System.out.println("--------------------------");

			System.out.print("Enter your choice: ");
			opt = input.nextInt();
			System.out.println("");

			switch(opt)
			{
				case 1:	{
							int temp;
							int size;

							System.out.print("Enter the size of the array: ");
							size = input.nextInt();

							Integer arr[] = new Integer[size];

							for(int i = 0 ; i < arr.length ; i++)
							{
								System.out.print("Enter Element : ");
								arr[i] = input.nextInt();
							}

							Sort<Integer> s = new Sort<Integer>(arr);

							System.out.print("\nSORTED Array: ");
							s.display();

							break;
						}

				case 2: {
							double temp;
							int size;
							System.out.print("Enter the size of the array: ");
							size = input.nextInt();

							Double arr[] = new Double[size];

							for(int i = 0 ; i < arr.length ; i++)
							{
								System.out.print("Enter the Element : ");
								arr[i] = input.nextDouble();
							}

							Sort<Double> s = new Sort<Double>(arr);

							System.out.print("\nSORTED Array: ");
							s.display();

							break;
						}

				case 3:	{
							String temp;
							int size;

							System.out.print("Enter the size of the array: ");
							size = input.nextInt();

							String arr[] = new String[size];

							for(int i = 0 ; i < arr.length ; i++)
							{
								System.out.print("Enter the String : ");
								arr[i] = input.next();
							}

							Sort<String> s = new Sort<String>(arr);

							System.out.print("\nSORTED Array: ");
							s.display();

							break;
						}
			}
		}
	}
}