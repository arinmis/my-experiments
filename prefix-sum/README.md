# Why we need prefix sum algorithm?

If you have prefix sum array, you can obtain sum of any range in constant time, O(1), other wise you have to loop through array to find sum, worst case is O(n) for n size array.

    normalArray =  [5, 2, 8, 9]
    prefixArray =  [5, 7, 15, 24]

    // If we were asked to find sum of range [0, 3], array zero indexed and range inclusive, we would do this:
    sum = 0 
    for (i=0; i<=3; i++)
        sum = normalArray[i]

    // but if we had prefixArray we don't have to loop 
    sum = prefix[3]

    // in both cases sum is 24 

## Example Problem
Without using prefix sum, you cannot pass [Array Manipulation](https://www.hackerrank.com/challenges/crush/problem) problem tests on <m>HackerRank</m>. Brute force approach will fail when the number of query increase.

Java code up(Solution.java) above passed all tests.

Further information look those videos:
- https://www.youtube.com/watch?v=scD312I7kkE&ab_channel=JAVAAID-CodingInterviewPreparation
- https://www.youtube.com/watch?v=pVS3yhlzrlQ&ab_channel=JAVAAID-CodingInterviewPreparation  
- https://www.youtube.com/watch?v=hDhf04AJIRs&ab_channel=JAVAAID-CodingInterviewPreparation
