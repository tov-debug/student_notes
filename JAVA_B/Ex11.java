
/**
 *The Ex11 class provides service methods for operations in an efficient way.
 *
 * @author Tova Noyman
 * @version 18\03\25
 */
public class Ex11
{
    /**
     * Return the number at the original array based on the sum array.
     * @param b the sum array.
     * @param k the index.
     * @return the number at the original array.
     * Time complexity O(1) - depend on permanent actions.
     * Space complexity O(1)-does'nt create any new place.
     */
    public static int get(int[] b, int k)
    {
        if( k == 0  ) // case k is the first index.
            return b[0];
        return b[k] - b[k-1]; 
    }

    /**
     * Return the index which the number X in at the original array if not exsist return -1.
     * @param b the sum array.
     * @param x the num to find.
     * @return the index where the number X in if not exsist -1.
     * Time complexity O(log n) - depend on the length of the given array and useing the fact that it an orginezed array.
     * Space complexity O(1)- create place knowm number of places.
     */
    public static int find(int[] b , int x)
    {
        int left = 0, right = b.length - 1,mid;
        while(left <= right)
        {
            mid = (left+right)/2;
            if( get(b,mid) == x)// case the x is found.
                return mid;
            if( get(b,mid) < x)// case the number is lowwer than x.
                left = mid + 1 ;
            else// case the number is higher than x.
                right = mid -1 ;
        } 
        return -1;
    }

    /**
     * Return the index which .
     * @param arr.
     * @param k.
     * @return true.
     * Time complexity O(n) - depend on the length of the given array and useing the fact that it an orginezed super array.
     * Space complexity O(1)- create place foe a knowm number of places.
     */
    public static boolean superInc (int [] arr, int k)
    {
        if(k <= 0)
            return false;
        int i = arr.length-1;
        while(i >= 0 && k < arr[i])// runs backward at the array to find the first that smaller than k.
            i--;
        for( int j = i; (j >= 0)&&(k >= 0) ; j--)// keeps the runnimg while k>=0.
            if((k - arr[j]) >= 0 )// case the number at this index included at k.
                k -= arr[j];
        return k == 0;
    }
}
