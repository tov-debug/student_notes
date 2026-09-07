
/**
 * The program receives values ​​of R S P, for the game Rock Paper Scissors, for 2 players.
 * and prints accordingly whether player 1 won or player 2 or a tie.
 * @author Tova Noyman
 */
import java.util.Scanner;
public class Game
{
    public static void main (String [] args)
    { 
        final char ROCK = 'r';
        final char PAPER = 'p';
        final char SCISSORS = 's';
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter first player's object:");
        char player1 = scan.next().charAt(0);
        System.out.println("Enter second player's object:");
        char player2 = scan.next().charAt(0);
        if ( (player1!= 'r' && player1!= 'p' && player1!= 's') || (player2!= 'r' && player2!= 'p' && player2!= 's'))// correct check.
            System.out.println("eror");
        else switch(player1)
            {
                case ROCK:
                    switch(player2)
                    {
                        case ROCK: // case both players rock.
                            System.out.println("Game ends with a tie.");
                            break;
                        case PAPER: // case player 1 rock and player2 paper.
                            System.out.println("Player 2 wins.");
                            break;
                        default: // case player 1 rock and player2 scissors.
                            System.out.println("Player 1 wins."); 
                            break;
                    }     
                    break;
                case PAPER:
                    switch(player2)
                    {
                        case ROCK:// case player 1 paper and player2 rock.
                            System.out.println("Player 1 wins.");
                            break;
                        case PAPER:// case both players paper.
                            System.out.println("Game ends with a tie.");
                            break;
                        default: // case player 1 paper and player2 scissors.
                            System.out.println("Player 2 wins."); 
                            break;
                    }   
                    break;
                default:
                    switch(player2)
                    {
                        case ROCK: // case player 1 scissors and player2 rock.
                            System.out.println("Player 2 wins.");
                            break;
                        case PAPER: // case player 1 scissors and player2 paper.
                            System.out.println("Player 1 wins.");
                            break;
                        default: // case both players scissors.
                            System.out.println("Game ends with a tie."); 
                            break;
                    }   
                    break;
            } // end of big switch.
    } // end of method main.
} //end of class Game.