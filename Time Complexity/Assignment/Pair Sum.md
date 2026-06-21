# Pair Sum in Array

## Problem Statement

You have been given an integer array/list(ARR) and a number `num`. Find and
return the total number of pairs in the array/list which sum to `num`.

**Note**: Given array/list can contain duplicate elements.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer `N` representing the
size of the first array/list.

Second line contains `N` single space separated integers representing the
elements in the array/list.

Third line contains an integer `num`.

### Output format

For each test case, print the total number of pairs present in the array/list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= N <= 10^4$

$0 <= num <= 10^9$

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
9
1 3 6 2 5 4 3 2 4
7
Sample Output 1:
7
Sample Input 2:
2
9
1 3 6 2 5 4 3 2 4
12
6
2 8 10 5 -2 5
10
Sample Output 2:
0
2

Explanation for Input 2:
Since there doesn't exist any pair with sum equal to 12 for the first query, we
print 0.

For the second query, we have 2 pairs in total that sum up to 10. They are,
(2, 8) and (5, 5).
```

## Solution

```java
import java.util.Arrays;

public class Solution 
{
    public static int pairSum(int[] arr, int num) 
    {
        //Your code goes here
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        int left = 1, right = 1;
        int pairs = 0;
        while(start < end)
        {
            if(arr[start] == num - arr[end])
            {
                // if both numbers are same, the formula will be n * (n - 1) / 2
                if(arr[start] == arr[end])
                {
                    return pairs + (end - start + 1) * (end - start) / 2;
                }
                // count both halves of the pairs
                for(int i = start + 1; i < end; i++)
                {
                    if(arr[i] != arr[start])
                    {
                        break;
                    }
                    left++;
                }
                start += left;
                for(int i = end - 1; i > start; i--)
                {
                    if(arr[i] != arr[end])
                    {
                        break;
                    }
                    right++;
                }
                end -= right;
                // multiply their count to find the total number of pairs
                pairs += left * right;
                left = right = 1;
            }
            else if(arr[start] < num - arr[end])
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return pairs;
    }
}
```
