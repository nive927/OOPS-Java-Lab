import java.util.Scanner;

public class NumberGuess
{
	public static void main(String[] args)
    {
		int secretNumber;

		secretNumber = (int) (Math.random() * 99 + 1);

		Scanner input = new Scanner(System.in);

		int guess, trials=0;

		do
		{
			trials++;

			System.out.println("Key in your guess: ");

			guess = input.nextInt();

			if (guess == secretNumber)

				System.out.println("You got it in " +trials +" trials!");

			else if (guess < secretNumber)

            	System.out.println("Try higher");

            else if (guess > secretNumber)

                System.out.println("Try lower");

		} while (guess != secretNumber);

      }

}