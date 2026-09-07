
/**
 * Two recursion operations.
 *
 * @author (Tova Noyman)
 * @version (29/04/25)
 */
public class Ex13
{
/**
 * for a given array and number, cheks how many ways there are to split the array into 2,
 * arrays that their difference in summary and number of elements in an array are equals the given number,
 * and prints the the couples who meet the requirements.
 * @param the array to check.
 * @param the number that represent the difference.
 * @return number of ways to split.
 */
    public static int countEqualDiff (int [] arr, int diff) 
    {
        return countEqualDiff(arr,diff,0,0,0,0,0,"{","{");// send the arr and diff, and restart 2 sum 2 count and 2 print for each array after the slips.
    }
   // helps to find the solutions.
    private static int countEqualDiff (int [] arr, int diff,int i,int sum1,int count1,int sum2, int count2, String print1, String print2)
    {
        if(i == arr.length)// stopping condition.
        {
            if(abs(sum1-sum2) == diff && abs(count1-count2) == diff)// case the split meets the conditions.
            {
                System.out.println( print1+"} sum = " + sum1 + " count = " + count1+ "\n" + print2 +  "} sum = " + sum2 + " count = " + count2 + "\n" );// prints the splits arrays.
                return 1;// add one to the count.
            }
            return 0;// case the split does'nt meet the conditions.
        }
        return countEqualDiff (arr ,diff ,i+1 ,sum1+arr[i], count1+1, sum2, count2,  print1 +  "" + arr[i]+" " , print2)
        + countEqualDiff (arr,diff,i+1,sum1, count1, sum2 + arr[i],  count2+1,  print1,  print2 + "" + arr[i]+" ");
        // for each number at the original array try beeing once at the first array and once at the second, which giving us the all combinitions there are.
    }
//return the absulote given number.
private static int abs(int number)
{
    return number >= 0? number: -number;
}
    /**
     * for a given matrix return the minimal positive possible number that can go trow the array and stay positive,
     * while In each position subtract the number from the number.
     * @param the matrix to check.
     * @return the minimal number.
     */
    public static int minPoints(int [][] m)
    {
        return minPoints(m,m.length-1,m[m.length-1].length-1);// send the mat, restart the indexs to the last cube.
    }
    //helps to find the number
    private static int minPoints(int [][] m, int i,int j)
    {
        if(i < 0 || j < 0)// case went outside the boundaries of the array.
            return Integer.MAX_VALUE;// keeps the right solutions smaller.
        if(i == 0 && j == 0) // case we raeched the end of way - the starting cube.
            return Math.max(1,1-m[0][0]);// return the minimun number that big enugh to go trew.
        return Math.max(1, Math.min(minPoints(m, i-1, j), minPoints(m, i, j-1)) - m[i][j]);// return the minimun number that big enugh to go trew, btween going the way up or left.
    }
   
}

