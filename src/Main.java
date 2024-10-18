import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random gen = new Random();
        Scanner in = new Scanner(System.in);

        int die1, die2, dieSum;
        boolean done = false;
        String continueYN;

        do {
            System.out.println("Die1\tDie2\tDieSum");
            System.out.println("--------------------------------------");

            die1 = gen.nextInt(6) + 1;
            die2 = gen.nextInt(6) + 1;
            dieSum = die1 + die2;

            System.out.printf("%6d\t%6d\t%6d\n", die1, die2, dieSum);

            if (dieSum == 2 || dieSum == 3 || dieSum == 12)
            {
                System.out.println("Craps! You lost!");
                done = true;
            }
            else if (dieSum == 7 || dieSum == 11)
            {
                System.out.println("You got a natural! You win!");
                done = true;
            }
            else
            {
                int point = dieSum;
                System.out.println("The point is now: " + point);

                while (!done) {
                    System.out.println("Die1\tDie2\tDieSum");
                    System.out.println("--------------------------------------");

                    die1 = gen.nextInt(6) + 1;
                    die2 = gen.nextInt(6) + 1;
                    dieSum = die1 + die2;

                    System.out.printf("%6d\t%6d\t%6d\n", die1, die2, dieSum);
                    System.out.println("Trying for point...");

                    if (dieSum == point)
                    {
                        System.out.println("Made point! You win!");
                        done = true;
                    }
                    else if (dieSum == 7)
                    {
                        System.out.println("Got a seven! You lost!");
                        done = true;
                    }
                }
            }

            System.out.print("Do you want to play again? [Y/N]: ");
            continueYN = in.nextLine();
            if (continueYN.equalsIgnoreCase("n"))
            {
                done = true;
            }
            else
            {
                done = false;
            }

        } while (!done);
    }
}
