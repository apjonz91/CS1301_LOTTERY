import java.util.Scanner;
import java.util.Arrays;
 /*
  * Lotto program that takes a min/max of 5 inputed integer numbers;
  * compiles the inputs into a list, and compares them
  * another randomly generated list of 5 numbers.
  * User must match all five numbers in order to win the grand prize.  
  * 
  * @author Aaron Jones
  * @version 04/11/2021
  */
public class LotteryGame 
{
	//the constant size of all arrays used in program 
	static final int NUM_DIGITS = 5;
	
	public static void main (String [] args)
	{
		//Greeting message
		greetUser();
		//stores the returned array of the method; randomly generated array.
		int [] randomGeneratedLotto = getLotteryNumbers();
		//stores the returned array of the method; user inputed array.
		int [] inputedLottoPicks = getUserPicks();
		/*
		 * total count of matches found between two arrays.
		 * @param randomly generated array and the user inputed array.
		*/
		int lottoMatchCount = findMatches(inputedLottoPicks , randomGeneratedLotto);
		//print value of the randomly generated array on one line; values should be from 0 - 9
		System.out.println();
		System.out.print("Lottery Numbers: ");
		for (int i = 0; i < randomGeneratedLotto.length; i++)
		{
			System.out.print("" + randomGeneratedLotto[i] + " ");
		}
		//print total count of matches.
		System.out.println();
		System.out.println("Number of matching digits: " + lottoMatchCount);
		//prints message informing user if they are a grand prize winner.
		if (lottoMatchCount == NUM_DIGITS)
		{
			System.out.println("GRAND PRIZE WINNER!");
		}
		else
		{
			System.out.println("Sorry, you didn't win");
		}

	}
	
	/*
	 * Greeting message,welcomes user to lotto game, and explains rules.
	 */
	public static void greetUser()
	{
		System.out.println("	Welcome to the Lottery Game");
		System.out.println("You will pick 5 numbers (0 - 9) and we will");
		System.out.println("see if you are the Grand Prize Winner!");
		System.out.println();
	}
	
	/*
	 * randomly generates an array with a max size of 5, and proceeds to sort the array
	 * in chronological order.
	 * @return array of 5 randomly generated values. 
	 */
	public static int [] getLotteryNumbers()
	{
		int [] lottoNumbers = new int [NUM_DIGITS];
		for (int i = 0; i< NUM_DIGITS; i++)
		{
			lottoNumbers[i] = (int) (Math.random() * 10);
		}
		Arrays.sort(lottoNumbers);
		return lottoNumbers;
	}
	
	/*
	 * prompts user to input 5 numbers from 0 to 9; sorts values;
	 * @return array of 5 numbers inputed by user.
	 */
	public static int [] getUserPicks ()
	{
		Scanner in = new Scanner (System.in);
		int [] userPicks = new int [NUM_DIGITS];
		for (int i = 0;  i < NUM_DIGITS; i++)
		{
			System.out.print("Enter pick " + (i + 1) + " (0 - 9) ");
			userPicks[i] = in.nextInt();
			while (userPicks[i] > 9 || userPicks[i]  < 0)
			{
				System.out.print("ERROR. Please enter a number (0 - 9) ");
				userPicks[i] = in.nextInt();
			}
			
		}
		Arrays.sort(userPicks);
		return userPicks;
	}
	
	/*
	 * matches the values [i] of two arrays to each other, and tallies every time there
	 * is a match.
	 * @param inputed array list, randomly generated array list.
	 * @return total numerical count of matches
	 */
	public static int findMatches (int [] input, int [] generated)
	{
		int numberOfMatchingDigits = 0;
		for (int i = 0; i < NUM_DIGITS; i++)
		{
			if (input[i] == generated[i])
			{
				numberOfMatchingDigits++;
			}
		}
		
		return numberOfMatchingDigits;
	}

	
}
