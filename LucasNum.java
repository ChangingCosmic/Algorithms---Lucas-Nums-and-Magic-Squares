public class LucasNum {
    private int[] usedLucasNums;
    private int successiveCalcsNums = 0;

    /**
     * Calculates and returns the Lucas number for a given value, the "launcher"
     * @param x is the number given
     * @return the Lucas number of the original X
     */
    public int recursiveLucasNumbers(int x, boolean willPrint) {
        usedLucasNums = new int[x+1];
        return recursiveLucasNumbers(x, true, willPrint);
    }

    /**
     * Calculates and returns the Lucas number for a given value, the actual implementation
     * @param x is the number given, isFirstCall checks if this is the first call made
     * @return the Lucas number of the x
     */
    private int recursiveLucasNumbers(int x, boolean isFirstCall, boolean willPrint) {
        long startTime, endTime, duration;

        // If the Lucas number is already computed, return whatever value is there bc it's already been calculated
        if (usedLucasNums[x] != 0) {
            // for ratio calculations
            successiveCalcsNums++;
            return usedLucasNums[x];
        }

        // checks if it's the first call made
        if (isFirstCall) {
            if(willPrint){
                startTime = System.nanoTime();
                System.out.println("L(0) = 2\nL(1) = 1");
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("\tThat took " + duration/1000000.0 + " miliseconds.");
            }
            successiveCalcsNums++;
        }

        // computes the return value
        if (x == 0 || x == 1) {
            // for ratio calculations
            successiveCalcsNums++;
            return x == 0 ? 2 : 1;
        } else {
            int lucasTot = 0;
            if (willPrint) {
                startTime = System.nanoTime();

                lucasTot = recursiveLucasNumbers(x - 1, false, willPrint) + recursiveLucasNumbers(x - 2, false, willPrint);
                System.out.println("L(" + x + ") = " + lucasTot);

                endTime = System.nanoTime();
                duration = (endTime - startTime);
                System.out.println("\tThat took " + duration + " nanoseconds.");
            } else {
                lucasTot = recursiveLucasNumbers(x - 1, false, willPrint) + recursiveLucasNumbers(x - 2, false, willPrint);
            }

            // store that into the array
            usedLucasNums[x] = lucasTot;

            // for ratio calculations
            successiveCalcsNums++;
            return lucasTot;
        }
    }

    public void ratioSuccessiveCalcsAndTime(int x) {
        long startTime, endTime, durationXPlus1, durationX;

        // start and end time for L(n + 1)
        startTime = System.nanoTime();
        recursiveLucasNumbers(x + 1, false);
        endTime = System.nanoTime();

        // calculates the time duration for L(n + 1)
        durationXPlus1 = endTime - startTime;

        // gets the successive calculation number and set it to zero for the next use
        int calculationsXPlus1 = successiveCalcsNums;
        successiveCalcsNums = 0;

        // start and end time for L(n)
        startTime = System.nanoTime();
        recursiveLucasNumbers(x, false);
        endTime = System.nanoTime();

        // calculates the time duration for L(n)
        durationX = endTime - startTime;
        int calculationsX = successiveCalcsNums;

        successiveCalcsNums = 0;

        // calculates the ratios
        double timeRatio = durationXPlus1 / (double) durationX;
        double calculationRatio = calculationsXPlus1 / (double) calculationsX;

        // Print results
        System.out.println("For x = " + x + ":");
        System.out.println("  Ratio of successive calculations: " + calculationsXPlus1 + " / " + calculationsX + " = " + calculationRatio);
        System.out.println("  Ratio of successive calculation time: " + durationXPlus1 + " ns / " + durationX + " ns = " + timeRatio + " ns");
    }

    public int myRecursiveFunct(int x, boolean isFirstCall) {
        return myRecursiveFunct(x, isFirstCall, new int[x + 1]);
    }

    private int myRecursiveFunct(int x, boolean isFirstCall, int[] usedNums) {
        if (usedNums[x] != 0) {
            return usedNums[x];
        }

        if (isFirstCall) {
            System.out.println("L(0) = 6\nL(1) = 8");
        }

        int myTot;
        if (x == 0) {
            successiveCalcsNums++;
            myTot = 6;
        } else if (x == 1) {
            successiveCalcsNums++;
            myTot = 8;
        } else {
            successiveCalcsNums++;
            myTot = myRecursiveFunct(x - 1, false, usedNums) + myRecursiveFunct(x - 2, false, usedNums);
            System.out.println("L(" + x + ") = " + myTot);
        }

        usedNums[x] = myTot;
        return myTot;
    }
}