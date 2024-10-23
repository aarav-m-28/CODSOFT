package CODSOFT;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public
class number_guess_game
{

public
    static void main(String[] args)
    {
        String playagain;
        Scanner scanner = new Scanner(System.in);
        do
        {
            Random rand = new Random();

            int i = 1;
            int guesses = 0;
            int number = rand.nextInt(100) + 1;
            int guess = 0;
            int score = 11;

            System.out.println("\t\t\t\t\t\t\t\tWELLCOME TO NUMBER GUESSING GAME\ntry to guess the number between 1-100, you only have 10 attempts\n");

            while (guess != number && i <= 10)
            {

                boolean valid = false;
                while (!valid)
                {
                    System.out.print("guess the number:");
                    try
                    {
                        guess = scanner.nextInt();
                        valid = true;
                        guesses++;
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("ENTER A NUMBER\n\n");
                        scanner.next();
                    }
                }
                if (guess < number)
                {
                    System.out.println("guess higher.");
                }
                else if (guess > number)
                {
                    System.out.println("guess lower.");
                }
                else
                {
                    System.out.println("CORRECT!!!\nnumber of guesses taken:" + guesses);
                }
                i++;
                score--;
            }

            if (guesses == 10 && guess != number)
            {
            	score=0;
                System.out.println("you ran out of attempts\nthe number was:" + number);
            }
            System.out.println("your score is" + score + "/10");
            System.out.println("HOPE YOU ENJOYED THE GAME. TYPE YES TO PLAY AGAIN:");
            playagain = scanner.next().toUpperCase();

        } while (playagain.equals("YES"));
        System.out.println("thankyou for playing!!!");
        scanner.close();
    }
}