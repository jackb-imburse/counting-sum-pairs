import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CountingSumPairs {
    public static void main(String[] args) {

        List<Integer> arrayFirstExample = new ArrayList<>();
        arrayFirstExample.add(3);
        arrayFirstExample.add(4);
        arrayFirstExample.add(5);
        arrayFirstExample.add(6);

        int xFirstExample = 1;

        List<Integer> arraySecondExample = new ArrayList<>();
        arraySecondExample.add(0);
        arraySecondExample.add(15);
        arraySecondExample.add(32);
        arraySecondExample.add(2000);
        arraySecondExample.add(15000);
        int xSecondExample = 15;

        List<Integer> arrayThirdExample = new ArrayList<>();
        arrayThirdExample.add(1);
        arrayThirdExample.add(1);
        arrayThirdExample.add(10);
        arrayThirdExample.add(32);
        arrayThirdExample.add(41);
        int xThirdExample = 42;

        int matchingPairs = countOfPairsThatEqualX(arrayFirstExample, xFirstExample);
        System.out.println("Matching Pairs: " + matchingPairs);

        matchingPairs = countOfPairsThatEqualX(arraySecondExample, xSecondExample);
        System.out.println("Matching Pairs: " + matchingPairs);

        matchingPairs = countOfPairsThatEqualX(arrayThirdExample, xThirdExample);
        System.out.println("Matching Pairs: " + matchingPairs);
    }

    private static int countOfPairsThatEqualX(List<Integer> numberList, int x) {

        List<Integer> uniqueNumberList = new ArrayList<>(new HashSet<>(numberList));
        Collections.sort(uniqueNumberList);

        int matchingPairs = 0;

        for (int i = 0; i < uniqueNumberList.size(); i++) {
            // if list is in ascending order and i is equal to x or greater than x or then there will be no more matching pairs
            if (uniqueNumberList.get(i) > x || uniqueNumberList.get(i) == x) {
                return matchingPairs;
            }
            for (int j = i + 1; j < uniqueNumberList.size(); j++) {
                // if i + j are greater than x then break second loop and move onto next in list
                // we do not break from all loops as first and last number may be greater than x whilst second and third number are equal to x
                if (uniqueNumberList.get(i) + uniqueNumberList.get(j) > x) {
                    break;
                }

                if (uniqueNumberList.get(i) + uniqueNumberList.get(j) == x) {
                    matchingPairs += 1;
                }
            }
        }
        return matchingPairs;
    }
}
