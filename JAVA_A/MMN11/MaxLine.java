
/**
 * A program that receives X and Y values​for 3 points,
 * that together form a triangle.
 * The program checks the length of the lines between any 2 points,
 * and prints the largest line.
 * In case that there are more than one large line,
 * the program will print the values of the first pair of points entered.
 * @author Tova Noyman
 */
import java.util.Scanner;
public class MaxLine
{
    public static void main (String [] args)
    {
        final int SQUARE = 2;
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter first point coordinates:");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        System.out.println ("Enter second point coordinates:");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        System.out.println ("Enter third point coordinates:");
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();
        double lineOf1_2 = Math.sqrt(Math.pow(x1-x2, SQUARE) + Math.pow(y1-y2, SQUARE));
        double lineOf1_3 = Math.sqrt(Math.pow(x1-x3, SQUARE) + Math.pow(y1-y3, SQUARE));
        double lineOf2_3 = Math.sqrt(Math.pow(x2-x3, SQUARE) + Math.pow(y2-y3, SQUARE)); 
        if ((lineOf1_2 > lineOf1_3) && (lineOf1_2 > lineOf2_3)) // case lineOf1_2 is the biggest.
            System.out.println("Max line created by the following points: " + "(" + x1 + "," + y1 + ")" + "," + " " + "(" + x2 + "," + y2 +")" +".");
        else // case lineOf1_2 is not the biggest.
        {
            if(lineOf1_3 > lineOf2_3) // case lineOf1_3 is the biggest.
                System.out.println("Max line created by the following points: " + "(" + x1 + "," + y1 + ")" + "," + " " + "(" + x3 + "," + y3 +")" +".");
            else // case lineOf1_3 is not the biggest.
            {
                if(lineOf2_3 > lineOf1_3) // case lineOf2_3 is the biggest.
                    System.out.println("Max line created by the following points: " + "(" + x2 + "," + y2 + ")" + "," + " " + "(" + x3 + "," + y3 +")" +".");
                else // if there are more than 1 large line.
                    System.out.println("Max line created by the following points: " + "(" + x1 + "," + y1 + ")" + "," + " " + "(" + x2 + "," + y2 +")" +".");
            } // end of second else.
        } // end of first else. 
    } // end of method main.
} // end of class MaxLine.
