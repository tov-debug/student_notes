
/**
 * 20454
 * 2025B
 * StudentTester Ex11 
 *
 */

public class Ex11StudentTester
{
    public static void main(String[] args){
        System.out.println ("********** Question 1A **********\n");
        int[] a1 = {4, -1, 5, 7, 2};
        int[] b1 = {4, 3, 8, 15, 17};
        int k = 3;
        System.out.println("Checking method 'get(int[] b, int k)' on array "+toString(b1)+" and k = " + k);      
        int studentResult1A = Ex11.get(b1,k);
        System.out.println("Result is: "+ studentResult1A+" must be: "+a1[k]);
        System.out.println();
        
        System.out.println ("********** Question 1B **********\n");
        int[] a2 = {4, 5, 5, 6, 7, 7, 15};
        int[] b2 = {4, 9, 14, 20, 27, 34, 49};
        
        int x = 5;
        System.out.println("Checking method 'find(int[] b, int x)' on array "+toString(b2)+" and x = " + x);      
        int studentResult1B = Ex11.find(b2, x);
        System.out.println("Result is: "+ studentResult1B+" must be: 1 or 2");
        System.out.println();

        System.out.println ("********** Question 2 **********\n");
        int[] arr = {2, 3, 8, 27};
        k = 30;
        System.out.println("Checking method 'superInc' on array " + toString(arr)+" and k ="+k);
        boolean studentResult2 = Ex11.superInc(arr, k);
        System.out.println("Result is: "+studentResult2+" must be TRUE");
        System.out.println();
        k = 7;
        System.out.println("Checking method 'superInc' on array " + toString(arr)+" and k ="+k);
        studentResult2 = Ex11.superInc(arr, k);
        System.out.println("Result is: "+studentResult2+" must be FALSE");
        System.out.println();
 
    }

    private static String toString(int[] arr)
    {
        String s = "{";
        for(int i=0; i<arr.length-1; i++)
            s+=arr[i]+", ";
        return s+arr[arr.length-1]+"}";
    }

}
