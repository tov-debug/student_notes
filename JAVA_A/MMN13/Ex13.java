
/**
 * The Ex13 class provides utility methods for operations on matrices and arrays,
 * such as checking sorting,comparing arrays, and performing circular shifts.
 * 
 * @author Tova Noyman 
 * @version 20/01/2025
 */
//2:
public class Ex13
{
    /**
     * Checks if a specific row in a 2D array is strictly sorted in ascending order.
     * @param The 2D array to check.
     * @param The index of the row to verify.
     */
    public static boolean isRowSorted(int[][] mat, int row)
    {
        for(int i = 0 ; i < mat[row].length -1; i++) // run on the mat at the given row.
            if(mat[row][i] >= mat[row][i+1]) // case the index position at the mat is'nt small than the next one in the row.
                return false;
        return true; // case each index at the row was smaller than the next one.
    }
    /**
     * Checks if a specific column in a 2D array is strictly sorted in ascending order.
     * @param The 2D array to check.
     * @param The index of the col to verify.
     */
    public static boolean isColSorted(int[][] mat, int col)
    {
        for(int i = 0 ; i < mat.length -1; i++)// run on the mat at the given col.
            if(mat[i][col] >= mat[i+1][col])// case the index position at the mat is'nt small than the next one in the col.
                return false;
        return true; // case each index at the col was smaller than the next one.
    }
    /**
     * Checks if all rows and columns in a matrix are strictly sorted in ascending order.
     * @param The 2D array to check.
     * @return true if the matrix is ranked, false otherwise.
     */
    public static boolean isRankedMatrix(int[][] mat)
    {
        for(int i = 0 ; i < mat.length; i++) // run on the mat's cols.
            if(!isRowSorted(mat,i)) 
                return false;
        for(int i = 0 ; i < mat[0].length ; i++) // run on the mat's rows.
            if(!isColSorted(mat,i))
                return false;
        return true; // case the whole mat is both row and col stored.
    }
    //3:
    /**
     * Compares two arrays for equality in size and content.
     * @param a: The first array.
     * @param b: The second array.
     * @return true if the arrays are equal, false otherwise.
     */
    public static boolean arraysEquality(int[] a, int[] b)
    {
        if(a.length != b.length) // case the arrays' length is'nt the same.
            return false;
        for(int i = 0; i < a.length; i++)// run on the arrays.
            if(a[i] != b[i])// case the current index is'nt the same.
                return false;
        return true;// case the arrays equals.
    }
/**
 * Performs a circular right shift by one position on an array.
 * @param arr: The array to shift.
 * @return void.
 */
    public static void shiftOneRight(int[] arr)
    {
        int num = arr[arr.length -1];// keep the last index of the arr.
        for(int i = arr.length - 1 ; i > 0 ; i--)// run from the back on the arr.
            arr[i] = arr[i -1];//insert each index to the one next to at it's right.
        arr[0] = num; // insert the keepen index at the first place.
    }
/**
 * Determines the minimum number of right circular shifts needed to make one array equal to another.
 * @param a: The tagret array.
 * @param b: The array to shift.
 * @return The number of shifts required, or -1 if not possible.
 */
    public static int shiftRightSize(int[] a, int[] b)
    {
        for(int i = 0; i < a.length; i++) // run over the a array.
        {
            if(arraysEquality(a,b))
                return i;
            shiftOneRight(b);
        }
        return -1;//case thr arrays arn't posible to be the same after any shift to right.
    }
}//end of class.