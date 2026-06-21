# Triplet Sum

## Problem Statement

You have been given a random integer array/list(ARR) and a number X. Find and
return the triplet(s) in the array/list which sum to X.

**Note**: Given array/list can contain duplicate elements.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer `N` representing the
size of the first array/list.

Second line contains `N` single space separated integers representing the
elements in the array/list.

Third line contains an integer `X`.

### Output format

For each test case, print the total number of triplets present in the
array/list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= N <= 10^3$

$0 <= X <= 10^9$

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
7
1 2 3 4 5 6 7 
12
Sample Output 1:
5
Sample Input 2:
2
7
1 2 3 4 5 6 7 
19
9
2 -5 8 -6 0 5 10 11 -3
10
Sample Output 2:
0
5

Explanation for Input 2:
Since there doesn't exist any triplet with sum equal to 19 for the first query,
we print 0.
For the second query, we have 5 triplets in total that sum up to 10. They are,
(2, 8, 0), (2, 11, -3), (-5, 5, 10), (8, 5, -3) and (-6, 5, 11)
```

## Solution

```java
import java.util.Arrays;

public class Solution 
{
    public static int tripletSum(int[] arr, int num)
    {
        //Your code goes here
        Arrays.sort(arr);
        int pairs = 0;
        int left, right, temp;
        int n = arr.length;
        // for each index, we search for two elements that form num
        for(int i = 0; i < n - 2; i++)
        {
            // we move left but reset right every iteration
            left = i + 1;
            right = n - 1;
            while(left < right)
            {
                if(arr[i] == num - arr[left] - arr[right])
                {
                    // we have at least one pair
                    pairs++;
                    temp = right - 1;
                    // but we must also count every occurrence of arr[right]
                    while(arr[temp] == arr[right] && temp > left)
                    {
                        temp--;
                        pairs++;
                    }
                    // now we can start again by incrementing left
                    left++;
                }
                else if(arr[i] > num - arr[left] - arr[right])
                {
                    right--;
                }
                else
                {
                    left++;
                }
            }
        }
        return pairs;
    }
}
```
