import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to calculate the Lucas number of: ");
        int inputNum = scanner.nextInt();
        LucasNum lucasNumOne = new LucasNum();
        System.out.println("The lucas sequence for " + inputNum + " is: " +  lucasNumOne.recursiveLucasNumbers(inputNum, true));

        // the expected order of growth for this is O(2^n)
        lucasNumOne.ratioSuccessiveCalcsAndTime(inputNum);
        System.out.println("The order of growth is O(2^n).");

        System.out.println("-------------\nMY recursive function now...");
        LucasNum myRecursion = new LucasNum();
        System.out.println("The value for my recursive function is: " + myRecursion.myRecursiveFunct(inputNum, true));

        // the expected order of growth for this is O(2^n)
        myRecursion.ratioSuccessiveCalcsAndTime(inputNum);
        System.out.println("The order of growth is O(2^n).");

        System.out.println("\n******************\n");
        MagicSquare subSquareFourCombos = new MagicSquare();
        subSquareFourCombos.subMagicSquareCombo(33, true);

        MagicSquare subSquareNoFourCombo = new MagicSquare();
        subSquareNoFourCombo.subMagicSquareCombo(33, false);

        MagicSquare allPossibleSumCombos = new MagicSquare();
        allPossibleSumCombos.subMagicSquareCountAllSums();

        // THE LAST BULLET POINT FOR PART 3 ANSWERED HERE:
        /*
            The sum that can be created with the greatest number of combinations is 66,
            which has 1364 combinations. What is interest is that 66 is double 33,
            which is the sum of a row or column of numbers.
         */

        System.out.println("The sum with the greatest number of combinations is 66, with 1364 combos!\nSuper interesting...66 is double 33...");
    }
}