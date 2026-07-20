# Valid Pairs

## Problem Statement

Given an array of integers and numbers k and m, write a function that returns
true if given array can be divided into pairs such that the sum of every pair
gives remainder m when divided by k.

## Detailed Explanation

### Input format

Integer N

N integers separated be a single space

Integer K

Integer M

### Output Format

Boolean

### Constraints

$1 <= N <= 10^4$

$1 <= M < K <= 10^2$

```ltf
Sample Input:
4
2 1 5 7
9
3
Sample Output:
true
Explanation:
Pairs will be (2,1) and (5,7)
```

## Solution

```java
import java.util.*;

public class solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    public static boolean CheckSumPairs(int[] arr, int n, int k, int m) 
    {
        // a % k + b % k = m also works the same
        int[] remainders = new int[n];
        for(int i = 0; i < n; i++)
        {
            remainders[i] = arr[i] % k;
        }
        // now its a problem of pair sum with the remainders
        HashMap<Integer, Integer> freqMap = getFrequencyMap(remainders);
        // if the numbers are smaller than k, individual modulo won't work
        for(int key : freqMap.keySet())
        {
            // if the pair doesn't exist, we're done
            if(!freqMap.containsKey((m - key + k) % k))
            {
                return false;
            }
            // if the number pairs with itself, its frequency should be even
            if(key == m - key && freqMap.get(key) % 2 != 0)
            {
                return false;
            }
            // otherwise, their frequencies should match
            if(freqMap.get(key) != freqMap.get((m - key + k) % k))
            {
                return false;
            }
        }
        return true;
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    private static HashMap<Integer, Integer> getFrequencyMap(int[] arr)
    {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr)
        {
            if(freqMap.containsKey(num))
            {
                freqMap.put(num, freqMap.get(num) + 1);
            }
            else
            {
                freqMap.put(num, 1);
            }
        }
        return freqMap;
    }
}
```
