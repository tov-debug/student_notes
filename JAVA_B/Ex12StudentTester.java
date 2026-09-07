
/**
 * Write a description of class StudentTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentTester
{
    public static void main(String[] args)
    {
        if(Ex12.digitDiffer(3,3)==0) 
            System.out.println("digitDiffer test successfully passed!");
        else
            System.out.println("digitDiffer(3,3) test result should be 0!");
            
        if(Ex12.numWaysToClimb(4) == 5)
            System.out.println("numWaysToClimb test successfully passed!");
        else 
            System.out.println("numWaysToClimb(4)test result should be 5!");
        if(Ex12.solutions(2) == 0)
            System.out.println("solutions test successfully passed!");
        else
            System.out.println("solutions(2) test result should be 0!");
    }
}
