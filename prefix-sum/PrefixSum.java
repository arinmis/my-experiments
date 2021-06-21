import java.util.*; 

public class PrefixSum {

    public static void main(String[] args) { 
        // assume that we have this array 
        int[] array = {5, 2, 8, 9};
        // initialize array with random number
        // convert the array to prefix sum
        int[] prefixArray = getPrefixArray(array);
        // after we calculate prefix array, no loop needed anymore so it will be much faster
        int totalSum = sumRange(prefixArray, 0, array.length - 1);
        System.out.println(totalSum);

    }

    // return prefix(cumulative) sum of array
    public static int[] getPrefixArray(int[] array) {
        int[] prefixArray = new int[array.length];
        prefixArray[0] = array[0];
        for (int i=1; i<array.length; i++)
            prefixArray[i] = prefixArray[i-1] + array[i];
        return prefixArray;
    }

    public static int sumRange(int[] prefixArray, int start, int end) { 
        int sum = prefixArray[end];
        if (start > 0)
            sum -= prefixArray[start - 1];
        return sum;
    }

}
