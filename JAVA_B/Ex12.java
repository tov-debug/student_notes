
/**
 * Number of recursion operations.
 *
 * @author Tova Noyman
 * @version 01/04/25
 */
public class Ex12
{

    /**
     * Return the difference btween two given numbers.
     * @param a The first numbers.
     * @param b The second number.
     * @return the difference btween a and b.
     */
    public static int digitDiffer (int a, int b) 
    {
        if(a < 10 && b < 10)// stopping conditions.
            return 0;
        if(a < 10 || b < 10)
            return 1 + digitDiffer (a/10,b/10);// case one is single digit, add 1 and check the rest.
        return  digitDiffer (a/10,b/10);// case both are multi-digit, check the next digits.
    }

    /**
     * Returns the calculatuon of the number of ways a person can climb 'n' stairs,
     * where they can take either 1 or 2 steps at a time.
     *
     * @param n The number of stairs to climb.
     * @return The number of possible ways to climb the stairs.
     */
    public static int numWaysToClimb (int n)
    {
        if (n == 1 || n == 2) //stopping conditions.
            return n;
        if (n == 0)// edge case.
            return 1;// staying in place.
        return numWaysToClimb(n - 1) + numWaysToClimb (n - 2);// recursively calculate the ways.
    }

    /**
     * Returns the number of solutions for expressing 'num' as the sum of three integers (x1, x2, x3),
     * when each integer is between 1 and 10 ,and prints each solution found.
     * @param num to find solutions for.
     * @return The number of solutions found.
     */

    public static int solutions(int num)
    {
        if(num < 3 || num > 30 )
            return 0;// case 'num' is out of range, there are no solutions.
        return solutions(num,1,1);// start the recursive search.
    }

    // helps to find the solution.
    private static int solutions(int num, int x1, int x2) 
    {
        if (x1 > 10) // stopping conditions.
            return 0;
        if (x2 > 10) 
            return solutions(num, x1 + 1, 1);
        int x3 = num - x1 - x2;// calculate the third integer.
        if (x3 >= 1 && x3 <= 10) 
        {
            System.out.println(x1 + " + " + x2 + " + " + x3);
            return 1 + solutions(num, x1, x2 + 1);// count the solution and continue searching.
        }
        return solutions(num, x1, x2 + 1);// continue searching.
    }
}
