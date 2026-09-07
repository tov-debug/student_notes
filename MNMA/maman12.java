import java.util.Random;
// here we gonna run the tests
public class Main 
{
    public static void main(String[] args) 
    {
        buildArray(); // edge cases
        ampiriResach(); 
    }

     public static void buildArray()
    {
          Random rand = new Random();
        
        // first test:    
        int[] testArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
         testArray( testArray);
    
         //random tests:
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[10];
        int[] array4 = {rand.nextInt(100)}; // in 1 len
        int[] array5 = {2,1,3,-7,1,2,3,-9,3,2,1,-6}; // 3 posible results
        for(int i = 0; i < 10; i++)
        {
            array1[i] = -rand.nextInt(100); //negetive
            array2[i] =  rand.nextInt(100); // positive
            array3[i] = 0; // zreos
        }
        for( i = 1; i <= 5; i++)
            testArray(array + i);
    }
    /** 
     * a nice tester for a given arrays
     * @param int[] numbers' array to test
     */
    public static void testArray(int[] arr)
    {
        System.out.print(" for the array:");
        for(int i = 0; i < arr.length-1; i++)
            System.out.print( arr[i] + ",");
        System.out.println( arr[arr.length-1]);
        System.out.println("--- Testing Kadane ---");
        print(Algorithms.kadane(arr), arr);
        System.out.println("\n--- Testing Divide & Conquer ---");
        print(Algorithms.findMaxSubArray(arr));
        System.out.println(""); 
    }
    /** 
     * print the result
     * @param int[] numbers' array to print
     * @param int[] the result values
     */
      public static void print(int[] result, int[] arr) 
    {
        System.out.println("Max Sum: " + result[0]);
        System.out.println("Start Index: " + result[1]);
        System.out.println("End Index: " + result[2]);   
        System.out.print(" the sub Array is:");
        for(int i = result[1]; i <= result[2]; i++)
            System.out.print( arr[i] + ",");
        System.out.println( arr[arr.length-1]);

    }
      /** 
     * the ampir resarch
    */
    public static void ampiriResach()
    {
        Random rand = new Random();
        for(int i = 0; i < 10; i++)
        {
             int[] array1 = new int[100];
             int[] array2 = new int[1000];
             int[] array3 = new int[10000];
             int[] array4 = new int[100000];
            for(int j = 0; j < 100; j++)
                array1[j] =  rand.nextInt(201)-100;
            for(int j = 0; j < 1000; j++)
                array2[j] =  rand.nextInt(201)-100;
            for(int j = 0; j < 10000; j++)
                array3[j] =  rand.nextInt(201)-100;
            for(int j = 0; j < 100000; j++)
                array4[j] =  rand.nextInt(201)-100;
        testTime( array1);
        testTime( array2);
        testTime( array3);
        testTime( array4);
        }
    }
    
    /** 
     * count time of preformance
     * @param int[] numbers' array to count time for
    */
    public static void testTime(int[] arr) 
    {
        long startTime = System.nanoTime();
        Algorithms.kadane(arr);
        long endTime = System.nanoTime();
        System.out.println("kadane time dartion: " +(endTime - startTime)/100000.0 + "sec");
        startTime = System.nanoTime();
        Algorithms.findMaxSubArray(arr);
        endTime = System.nanoTime();
        System.out.println(" findMaxSubArray time dartion: " +(endTime - startTime)/100000.0 + "sec");
    }
}

// here are the two Algoritms to solve the promblem
class Algorithms 
{
    /** 
     * The kadane's Algorintm that go over the array and cheks each time if there is a bigger sum of a sub array from the given array, prints the sum and the indexs of the start and the end subarray.
     * @param int[] numbers' array to cheks
     */
    public static int[] kadane(int[] array) 
    {
        int maxSum = 0, currSum = 0,tempStart =0, start = 0, end = 0;
        if(array.length > 0) //for negetive numbers
        {
            maxSum = array[0];
            currSum = array[0];
        }
        for(int i = 1; i < array.length; i++)
        {
           if (array[i] > currSum + array[i]) //the privious was negtive
           {
                currSum = array[i]; // starting over
                tempStart = i; // potaintial start
            
           }
            else  // keep going
                currSum += array[i];
            if (currSum > maxSum) // keeping max ditels
            {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }
       int[] kadaneResult = new Result(maxSum, start, end);
       return kadaneResult;
    }

    /** 
     * The recorsive Algorintm that work in 'הפרד ומשול' system
     * @param int[] numbers' array to cheks
     */
    public static int[] findMaxSubArray(int[] array) 
    {
        int[] recorsiveResult = {-1,-1,-1};
        if(array.length > 0)
             recorsiveResult = findMaxSubArray(array, 0, array.length -1);     
       return recorsiveResult; 
    }
     /** 
     * The recorsive Algorintm that work in 'הפרד ומשול' system
     * @param int[] numbers' array to cheks
     * @param int the start index to check
     * @param int the end index to check
     * @return Result a reference of the results
     */
    public static int[] findMaxSubArray(int[] array, int start, int end)
    {

      if(start == end)
         return new Result(array[start], start, end);

     int mid = (start + end)/2;

     int[]right = findMaxSubArray(array, mid + 1, end ); // go over the right half
     int[]left = findMaxSubArray(array, start, mid); // go over the left half
     int[]middle = findMiddleSum(array, start, mid, end); // go to check a cross max sum
        
     // find the largest subarray
     int leftSum = left[0];
     int rightSum = right[0];
     int midSum = middle[0];

    if (leftSum >= rightSum && leftSum >= midSum) 
        return left;

     else if (rightSum >= leftSum && rightSum >= midSum)
        return right;
     else 
        return middle;
    }
        

     /** 
     * Cheks if rhe middle part store the max sum subarray, (reamind the Kanda's algoritm)
     * @param int[] numbers' array to cheks
     * @param int the start index to check
     * @param int the end index to check
     * @return Result a reference of the results
     */
      public static int[] findMiddleSum(int[] array, int start, int mid, int end ) 
    {
        int maxLeft = array[mid], maxRight = array[mid +1], current = array[mid], right = mid + 1, left = mid;
        for(int i = mid -1 ; i >= start; i--) // left side
        {
            current += array[i];
            if(current > maxLeft) //keeping ditals
            {
                maxLeft = current;
                left = i;
            } 
        }
        current = array[mid +1];
        for(int i = mid + 2; i <= end; i++)//right side
        {
            current += array[i];
            if(current > maxRight)//keeping ditals
            {
                maxRight = current;
                right = i;
            } 
        }
        int[] arr = {(maxLeft + maxRight), left, right};
        return arr;
    }  
  
}


    

