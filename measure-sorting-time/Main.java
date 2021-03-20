import java.util.*;

//this program will measure sorting time
//of my selecsort algorithm

public class Main {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        int[] nums = arrGenetor(100000);
        
        sw.start();
        Arrays.sort(nums);
        sw.stop();
        
        System.out.println("Array sorted in " + sw.getElapsedTime()/100 + " second");

    }
    
    //find minimum of array
    //put first unsorted place
    public static int[] selecSort (int[] arr) {
        for(int i=0; i<arr.length; i++) {
            int min = arr[i];
            int minIdx = i;
            for(int j=i; j<arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            if(i % 10000 == 0)
                System.out.print("#");
            int temp = arr[i];
            arr[i] = min;
            arr[minIdx] = temp;

        }
        System.out.println();
        return arr;
    }

    public static int[] arrGenetor(int size) {
        int[] arr = new int[size];

        for(int i=0; i<size; i++) {
            arr[i] = (int)(Math.random() * 1000) + 1;
        }
        return arr;
    }
}

class  StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }


    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }


}
