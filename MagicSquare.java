public class MagicSquare {
    final int[] magicSquare = {1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15};
    final int totalLineSum = 33;

    public void subMagicSquareCombo(int desiredSum, boolean isFourCombo) {
        int totalCombos;
        if(isFourCombo){
            totalCombos = findCombinationsInFourCombo(0, 0, 0);
        } else {
            totalCombos = findCombinationsWithoutFourCombo(0, 0, desiredSum);
        }
        System.out.println("The total number of combos for " + (isFourCombo ? "4" : "any number of ") + " combination is " + totalCombos);
    }

    // MAX COMBOS IS 4
    private int findCombinationsInFourCombo(int index, int sum, int count) {
        // our "base" case
        if (sum == totalLineSum && count == 4) {
            return 1;
        }

        // need to check if index out of bounds or too much in the count
        if (index >= magicSquare.length || count > 4) {
            return 0;
        }

        // counts combinations including the current element in the sum
        int withCurrent = findCombinationsInFourCombo(index + 1, sum + magicSquare[index], count + 1);

        // counts combinations excluding the current element from the sum
        int withoutCurrent = findCombinationsInFourCombo(index + 1, sum, count);

        // add to include and exclude the current element respectively to get EVERYTHING
        return withCurrent + withoutCurrent;
    }

    // NO MAX COMBOS
    private int findCombinationsWithoutFourCombo(int index, int sum, int desiredSum) {
        // our "base" case
        if (sum == desiredSum) {
            return 1;
        }

        // need to check if index out of bounds
        // if isFourCombo = true, then need to make sure that the combos don't exceed that
        if (index >= magicSquare.length || sum >= desiredSum) {
            return 0;
        }

        // counts combinations including the current element in the sum
        int withCurrent = findCombinationsWithoutFourCombo(index + 1, sum + magicSquare[index], desiredSum);

        // counts combinations excluding the current element from the sum
        int withoutCurrent = findCombinationsWithoutFourCombo(index + 1, sum, desiredSum);

        // add to include and exclude the current element respectively to get EVERYTHING
        return withCurrent + withoutCurrent;
    }

    // just counts the combo of all different sums
    public void subMagicSquareCountAllSums() {
        int biggestSum = totalLineSum * 4;
        int[] allSums = new int[biggestSum + 1];
        for(int i = 0; i < biggestSum; i++){
            int combo = findCombinationsWithoutFourCombo(0, 0, i);
            allSums[i] = combo;
        }

        System.out.println("number of combinations for every possible sum: ");
        for(int i = 0; i < allSums.length; i++){
            System.out.println("\t" + i + " occurs " + allSums[i] + " times.");
        }
    }
}
