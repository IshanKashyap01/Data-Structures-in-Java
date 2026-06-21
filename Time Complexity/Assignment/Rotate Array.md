# Rotate Array

## Problem Statement

You have been given a random integer array/list(ARR) of size N. Write a
function that rotates the given array/list by D elements(towards the left).

**Note**: Change in the input array/list itself.You don't need to return or
print the elements.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer `N` representing the
size of the array/list.

Second line contains `N` single space separated integers representing the
elements in the array/list.

Third line contains the value of `D` by which the array/list needs to be
rotated.

### Output Format

For each test case, print the rotated array/list in a row separated by a single
space.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^4$

$0 <= N <= 10^6$

$0 <= D <= N$

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
7
1 2 3 4 5 6 7
2
Sample Output 1:
3 4 5 6 7 1 2
Sample Input 2:
2
7
1 2 3 4 5 6 7
0
4
1 2 3 4
2
Sample Output 2:
1 2 3 4 5 6 7
3 4 1 2
```

## Solution

```java
public class Solution 
{
    public static void rotate(int[] arr, int d) 
    {
        //Your code goes here
        int n = arr.length;
        int[] rotated = new int[n];
        for(int i = 0; i < n; i++)
        {
            rotated[i] = arr[(i + d) % n];
        }
        copy(rotated, arr);
    }

    private static void copy(int[] source, int[] destination)
    {
        for(int i = 0; i < source.length; i++)
        {
            destination[i] = source[i];
        }
    }
}
```
