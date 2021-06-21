import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BigInteger[] arr = new BigInteger[n];
        for (int i=0; i<arr.length; i++)
            arr[i] = BigInteger.ZERO;
        int m = input.nextInt();
        // read and perform queries
        for (int i=0; i<m; i++)  {
            int a  = input.nextInt();
            int b  = input.nextInt();
            int k  = input.nextInt();
            performOperation(arr, a - 1, b - 1, k); // one base to zero base index
        }
        BigInteger max = findMax(arr);
        System.out.println(max);
    }

    // ith element is sum of [0, ith] numbers
    public static void performOperation(BigInteger[] arr, int a, int b, int k) {
        arr[a] = arr[a].add(new BigInteger(String.valueOf(k)));
        if (b !=  arr.length - 1)
            arr[b + 1] = arr[b + 1].subtract(new BigInteger(String.valueOf(k)));
    }

    // assign the real value of index, compare with the max
    public static BigInteger findMax(BigInteger[] arr) {
        BigInteger max = arr[0];
        BigInteger sum = arr[0];
        for (int i=1; i<arr.length; i++) {
            sum = sum.add(arr[i]);
            arr[i] = sum;
            if (max.compareTo(arr[i]) == -1)
                max = arr[i];
        }
        return max; 
    }
}
