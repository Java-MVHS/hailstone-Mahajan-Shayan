// Shayan Mahajan
// 11/07/25
// Hailstone.java
// Working on loops and if-else blocks
// This program: displays a sequence based off the number from 1-10000 by the user
/* 
 * This program generates and displays the Hailstone sequence for any positive 
 * integer between 1 and 10,000 entered by the user. The program asks
 * for a number until the user enters -1 to quit. For each valid number, it prints 
 * the entire sequence, formatted with 10 numbers per line, and then prints 
 * how many loop were executed to reach 1.
 */
import java.util.Scanner;

public class Hailstone
{
	private int input; // the number entered by the user
	private int count; // counts how many iterations the loop executes

	// default constructor
	public Hailstone()
	{
		input = 0;
		count = 0;
	}
	
	public static void main(String[] args)
	{
		Hailstone hs = new Hailstone();
		hs.findIt();
	}
	
	// calls all subsequent methods and makes a range of 1-10000
	// Prints 3 BL's at the start and end
	// Prints the welcome statement
	public void findIt()
	{
		System.out.println("\n\n\nWelcome to Hailstone! This program uses your number"
			+ " to enter in the Hailstone sequence, first proposed by German "
			+ "mathematician Lothar Collatz");
		do
		{
			getInput();
			if(input >=1 && input <=10000)
				printSequence();
			printCount();
			count = 0;
		} while(input != -1);
		System.out.println("\n\n\n");
	}
	
	// Gets input using scanner with a prompt
	public void getInput()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("\nEnter a positive integer (1 - 10000)." 
			+ " To quit, enter -1:\t");
		input = kb.nextInt();
	}
	
	// does the actual hailstone math
	// prints 10 numbers per line, counts how many steps it takes
	// if odd, multiply by 3 and add 1, if even divide by 2
	// loop until the number is one
	public void printSequence()
	{
		int numInRow = 0;
		if (input != 1)
			count++;
		do
		{
			if (input != 1) {
				System.out.printf("%6d", input);
				numInRow++;
				if (numInRow % 10 == 0) 
					System.out.println();
			}
			if (input % 2 == 0)
				input /= 2;
			else {
				if (input != 1) {
					input = input * 3 + 1;
				}
			}
			count++;
		} while (input != 1);
		System.out.printf("%6d", input);
		numInRow++;
		if (numInRow % 10 == 0) 
			System.out.println();
	}
	
	// prints how many loops happened or says goodbye if quitting
	// also prints an error message if value is not in range
	public void printCount()
	{
		if(input == 1)
			System.out.printf("\nThe loop executed %d times.\n", count);
		else if (input == -1)
			System.out.println("Thank you for playing hailstone!");
		else
			System.out.println("\nEnter a value within the range, please!");
	}
}

