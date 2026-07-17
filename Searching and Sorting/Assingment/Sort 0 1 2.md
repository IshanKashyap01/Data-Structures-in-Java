# Sort 0 1 2

## Problem Statement

You are given an integer array/list(ARR) of size N. It contains only 0s, 1s and
2s. Write a solution to sort this array/list in a *single scan*.

*Single Scan* refers to iterating over the array/list just once or to put it in
other words, you will be visiting each element in the array/list just once.

**Note**: You need to change in the given array/list itself. Hence, no need to
return or print anything.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer `N` representing the
size of the array/list.

Second line contains `N` single space separated integers(all 0s, 1s and 2s)
representing the elements in the array/list.

### Output Format

For each test case, print the sorted array/list elements in a row separated by
a single space.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= N <= 10^1$

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
7
0 1 2 0 2 0 1
Sample Output 1:
0 0 0 1 1 2 2 
Sample Input 2:
2
5
2 2 0 1 1
7
0 1 2 0 1 2 0
Sample Output 2:
0 1 1 2 2 
0 0 0 1 1 2 2
```

## Solution

```java
public class Solution 
{
    public static void sort012(int[] arr, int n)
    {
        // two jails of known values with the unknowns living in between
        int zeroJail = -1;
        int twoJail = n;
        // one detective to investigate the unknown
        int detective = 0;
        // beginning from the very start to the boundary of the 2 jail
        while(detective < twoJail)
        {
            // whatever comes back from left side is already a known
            if(arr[detective] == 0)
            {
                swap(arr, ++zeroJail, detective++);
            }
            // what comes back from the right side isn't
            else if(arr[detective] == 2)
            {
                swap(arr, --twoJail, detective);
            }
            // 1 belongs in the middle so let it be
            else
            {
                detective++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```
