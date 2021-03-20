import java.util.*;
/*
*
* @author Mustafa Arınmış
* @since 19.09.2020
*
* Problem: Write function that is return whether given arrays
*          any pairs of sum can be equal given number.
*
* */



public class Workout {
    public static void main(String[] args) {

        //test codes
        int[] numbers = {1, 4, 13, 5, 6, 2};
        // sum of 4+5=9 so it should be true
        System.out.print("Can sum of any pair be 9? " + isPossible(numbers, 9));



    }

    public static boolean isPossible(int[] nums, int givenNum) {
        ArrayList<Integer> list = new ArrayList<>();

        int temp =  1;
        for(int i=0; i<nums.length - 1; i++) {

            for(int j=temp; j<nums.length; j++){
                list.add(nums[i] + nums[j]);
            }

            temp++;
        }

        return list.contains(givenNum);
    }
}

