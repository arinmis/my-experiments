# Why we need prefix sum algorithm?

If you have prefix sum array, you can obtain sum of any range in constant time, O(1), other wise you have to loop through array to find sum,worst case O(n) for n size array.

    normalArray =  [5, 2, 8, 9]
    prefixArray =  [5, 7, 15, 24]

    // If we asked sum of range [0, 3], array zero indexed and range inclusive, we should do this:
    sum = 0 
    for (i=0; i<=3; i++)
        sum = normalArray[i]

    // but if we would have prefixArray we don't have to loop 
    sum = prefix[3]

    // in both case sum is 24 


