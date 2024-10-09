package CODSOFT;

import java.util.InputMismatchException;
import java.util.Scanner;

public
class grade_calculator
{

public
    static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\n%90s", "GRADE CALCULATOR\n");

        System.out.print("enter the number of subjects:");
        int n = scanner.nextInt();
        int marks[] = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++)
        {

            boolean valid = false;
            while (!valid)
                try
                {
                    {
                        do
                        {
                            System.out.println("enter marks for subject " + (i + 1) + ":");
                            marks[i] = scanner.nextInt();
                        } while (marks[i] > 100);
                        sum += marks[i];
                        valid = true;
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println("ENTER VALID MARKS\n\n");
                    scanner.next();
                }
        }

        System.out.println("total marks are:" + sum);
        float percentage = (float)sum / n;
        System.out.println("final percentage is" + percentage + "%");
        if (percentage <= 100 && percentage >= 90)
        {
            System.out.println("GRADE:A,Very good");
        }
        else if (percentage < 90 && percentage >= 80)
        {
            System.out.println("GRDE:B,keep it up");
        }
        else if (percentage < 80 && percentage >= 70)
        {
            System.out.println("GRADE:C,not bad");
        }
        else if (percentage < 90 && percentage >= 80)
        {
            System.out.println("GRADE:D,study hard");
        }
        else if (percentage < 60)
        {
            System.out.println("GRADE:F,YOU FAILED!!!!");
        }
    }
}
