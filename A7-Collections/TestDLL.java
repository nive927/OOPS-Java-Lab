import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TestDLL
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);

		LinkedList<Integer> ill = new LinkedList<Integer>();

		ill.add(15);
		ill.add(77);
		ill.add(53);
		ill.add(82);

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("List before performing any operations: "+ill);
		System.out.println("--------------------------------------------------------------------------------");

		ill.addFirst(10);
		System.out.println("After inserting 10 the first element: "+ill);

		ill.addLast(90);
		System.out.println("After inserting 90 as the last element: "+ill);
		System.out.println("--------------------------------------------------------------------------------");

		ill.add(2, 55);
		System.out.println("After inserting 55 at index 2: "+ill);
		System.out.println("--------------------------------------------------------------------------------");

		ill.removeFirst();
		System.out.println("After removing the first the element: "+ill);

		ill.removeLast();
		System.out.println("After removing the last element: "+ill);
		System.out.println("--------------------------------------------------------------------------------");

		boolean status = ill.contains(55);

		if(status)
			System.out.println("List contains the element '55' ");
		else
            System.out.println("List doesn't contain the element '55'");
		System.out.println("--------------------------------------------------------------------------------");

		LinkedList<Integer> copy = new LinkedList<Integer>(ill);
		System.out.println("Copy of List: "+copy);
		System.out.println("--------------------------------------------------------------------------------");

		Comparator<Integer> r = Collections.reverseOrder();

		Collections.sort(ill);
		System.out.println("After sorting: "+ill);

		Collections.sort(ill, r);
		System.out.println("After sorting in reverse order: "+ill);
		System.out.println("--------------------------------------------------------------------------------");

		int search = Collections.binarySearch(ill, 5);

		if(search >= 0)
			System.out.println("Search SUCCESSFUL: List contains the element '5' at "+search+" index");
		else
            System.out.println("Search FAILED: List doesn't contain the element '5'");
		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("Displaying list without algorithm in forward order: ");
		for(int i: ill)
		{
			System.out.println(i);
		}

		Collections.reverse(ill);
		System.out.println("Displaying list without algorithm in reverse order: ");
		for(int i: ill)
		{
			System.out.println(i);
		}
		Collections.reverse(ill);

		System.out.println("Displaying list with algorithm in forward order: ");
		Iterator<Integer> itr = ill.iterator();
		while (itr.hasNext())
		{
			  System.out.println(itr.next());
      	}
		System.out.println("Displaying list with algorithm in reverse order: ");
      	itr = ill.descendingIterator();
		while(itr.hasNext())
		{
            System.out.println(itr.next());
		}
		//System.out.println("Displaying list without algorithm in reverse order: ");
		System.out.println("--------------------------------------------------------------------------------");

		float sum = 0;
		int n = 0;
		for(int i: ill)
		{
			sum += i;
			n++;
		}

		System.out.println("Sum of all the elements of the list is: "+sum);
		System.out.println("Average of the elements of the list is: "+sum/n);
		System.out.println("--------------------------------------------------------------------------------");

		LinkedList<Integer> sublist = new LinkedList(ill.subList(3,ill.size()));
		System.out.println("LIST: "+ill);
		System.out.println("NEWLY CREATED LIST: The sublist with elements starting from 3rd position of first list: "+sublist);
		System.out.println("--------------------------------------------------------------------------------");

		LinkedList<Integer> ill2 = new LinkedList<Integer>();
		ill2.addAll(copy);
		ill2.addAll(sublist);

		System.out.println("Copy of List: "+copy);
		System.out.println("SUBLIST: "+sublist);
		System.out.println("NEW LIST: The list with elements of first list and sublist: "+ill2);
		System.out.println("--------------------------------------------------------------------------------");

	}
}