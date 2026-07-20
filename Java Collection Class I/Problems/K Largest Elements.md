# K Largest Elements

## Problem Statement

You are given with an integer k and an array of integers that contain numbers
in random order. You have to find k largest numbers from given array. You need
to save them in an array and return it.

Note:

1. Time complexity should be $O(n\log{k})$ and space complexity should not be
more than O(k).

2. Order of elements in the output is not important.

## Detailed Explanation

### Input Format

The first line of input contains an integer, that denotes the value of the size
of the array. Let us denote it with the symbol N.

The following line contains N space separated integers, that denote the value
of the elements of the array.

The following contains an integer, that denotes the value of k.

### Output Format

The first and only line of output contains k largest elements.

### Constraints

$1 ≤ k ≤ n ≤ 105$

$1 ≤ arr[i] ≤ 106$

```ltf
Sample Input 1:
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output 1:
12 16 20 25
```

## Solution

```java
import java.util.*;

public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    public static ArrayList<Integer> kLargest(int n, int[] input, int k)
    {
        // put everything in a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : input)
        {
            pq.add(i);
        }
        // k'th largest element would be k positions from the last element
        for(int i = 0; i < n - k; i++)
        {
            pq.remove();
        }
        // now only k largest elements remain in the priority queue
        ArrayList<Integer> arr = new ArrayList<>();
        while(!pq.isEmpty())
        {
            arr.add(pq.poll());
        }
        return arr;
    }
}
```
