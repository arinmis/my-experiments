/**
 * 
 * Performance experiment between binary and linear search
 * to find middle left element of 100 billion length sorted array
 * @author mustafa arinmis
 * @since 04.12.2020
 */

public class Main {
    public static void main(String[] main) {
        
        int[] arr = new int[100000000]; // array contain 100,000,000 element
        for(int i=0; i<arr.length; i++) //0 to 99,999,999
            arr[i] = i;
        
        //calling binary search
        long start = System.currentTimeMillis(); // start timing
        int binIndex = binSearch(arr, 0, arr.length, 49999999);
        long end = System.currentTimeMillis(); // end time
        System.out.printf("Value 49,999,999 founded in index %d, operation took %d milisecond\n", binIndex, end - start);
        
        // calling linear search
        start = System.currentTimeMillis(); // start timing
        int linIndex = linearSearch(arr,49999999);
        end = System.currentTimeMillis(); // end time
        System.out.printf("Value 49,999,999 founded in index %d, operation took %d milisecond\n", linIndex, end - start);


    }

    public static int binSearch(int[] arr, int low, int high, int value) {

        if(low > high)
            throw new IllegalArgumentException();

        int mid = (high + low)/2;

        if(value == arr[mid] )
            return mid; // value founded

        if(high - low <= 1)
            return - 1; // value does not found in array


        if(value > arr[mid]) {
            return binSearch(arr, mid, high, value);
        }else
            return binSearch(arr, low, mid, value);
    }

    public static int linearSearch(int[] arr, int value ) {
        for(int i=0; i<arr.length; i++) {
            if(value == arr[i])
                return i;
        }

        return -1;
    }
}