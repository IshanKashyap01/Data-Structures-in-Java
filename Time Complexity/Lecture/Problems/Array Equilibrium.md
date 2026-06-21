# Array Equilibrium

## Problem Statement

For a given array/list(ARR) of size `N`, find and return the *Equilibrium
Index* of the array/list.

Equilibrium Index of an array/list is an index `i` such that the sum of
elements at indices `[0 to (i - 1)]` is equal to the sum of elements at indices
`[(i + 1) to (N-1)]`. One thing to note here is, the item at the index `i` is
not included in either part.

If more than one equilibrium indices are present, then the index appearing
first in left to right fashion should be returned. Negative one(-1) if no such
index is present.

## Detailed Explanation

### Input Format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains an integer `N` representing
the size of the first array/list.

The second line contains `N` single space separated integers representing the
elements of the array/list

### Output Format

For each test case, print the *Equilibrium Index*.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= N <= 10^6$

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
5
1 4 9 3 2
Sample Output 1:
2
Sample Input 2:
2
3
1 4 6
3
1 -1 4
Sample Output 2:
-1
2
```

## Solution

```java
public class Solution 
{
    public static int arrayEquilibriumIndex(int[] arr)
    {
        // edge case
        if(arr.length <= 1)
        {
            return -1;
        }
        int rightSum = sumOfArray(arr);
        int leftSum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            rightSum -= arr[i];
            if(leftSum == rightSum)
            {
                return i;
            }
            else
            {
                leftSum += arr[i];
            }
        }
        return -1;
    }

    private static int sumOfArray(int[] arr)
    {
        int sum = 0;
        for(int num : arr)
        {
            sum += num;
        }
        return sum;
    }
}
```
