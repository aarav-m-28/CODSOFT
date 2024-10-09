

package CODSOFT;

import java.util.Scanner;

public
class quiz
{

public
    static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String questions[] = {
            "1. What is 2+2?",
            "2. What is the capital of India?",
            "3. Chemical symbol of gold?",
            "4. Which city is known as Silicon Valley of India?",
            "5. Who is the founder of CodSoft?"};

        String options[][] = {
            {"a. 1", "b. 2", "c. 3", "d. 4"},
            {"a. Bengaluru", "b. Delhi", "c. Manali", "d. Mumbai"},
            {"a. Gd", "b. Ag", "c. Au", "d. Fe"},
            {"a. Bengaluru", "b. Delhi", "c. Manali", "d. Mumbai"},
            {"a. Elon Musk", "b. Jeff Bezos", "c. Mark Elliot Zuckerberg", "d. Brian Kleinberg"}};

        String answers[] = {"d", "b", "c", "a", "d"};
        int score = 0;
        

        System.out.printf("\t\t\t\t\t\t\tWELCOME TO QUIZ GAME!!!" + "\nRULES:" + "\nYou have 10 seconds to answer each question." + "\nTo move to next question input mustbe provided" + "\nbut if input is given after 10 seconds it will not affect the score\n\n"

                          + "\n \t\t\t\t\t\t\tPress enter to start!");

        scanner.nextLine();

      
            for (int i = 0; i < 5; i++)
            {

                System.out.println(questions[i]);
                for (int j = 0; j < 4; j++)
                {
                    System.out.println(options[i][j]);
                }

                System.out.print("Choose option: ");

                long startTime = System.currentTimeMillis();
                String ans = scanner.next();

                long Time = (System.currentTimeMillis() - startTime) / 1000;

                if (Time >= 10)
                {
                    System.out.println("Time's up for this question!");
                    
                }
                else
                {
                    if (ans.equals(answers[i]))
                    {
                        System.out.printf("\nCorrect...\n\n");
                        score++;
                        continue;
                    }
                    if (!ans.equals("a") && !ans.equals("b") && !ans.equals("c") && !ans.equals("d")) {
                    	System.out.println("invalid option");
                    }
                    else
                    {
                        System.out.printf("\nwrong answer!\n\n");
                        System.out.printf("\n correct answer is %s\n\n",answers[i]);
                    }
                }
            }
        


        System.out.printf("\nYOUR SCORE IS: %d/5\n", score);
        scanner.close();
    }
}
