# All Indices of X

## Problem Statement

Given an array of length N and an integer x, you need to find all the indexes
where x is present in the input array. Save all the indexes in the output array
(in increasing order).

Do this recursively. Indexing in the array starts from 0.

**Hint**: Try making a helper function with the required arguments and call the
helper function from the allIndexes function.

## Detailed Explanation

### Input Format

An Integer N i.e. size of array

N integers which are elements of the array, separated by spaces

Integer x

### Output Format

Return all the indexes in the output array (in increasing order).

### Constraints

$1 <= N <= 10^3$

```ltf
Sample Input:
5
9 8 10 8 8
8
Sample Output:
1 3 4
```

## Solution

```java
public class Solution 
{
    public static int[] allIndexes(int input[], int x) 
    {
        // in case all indices have x
        int[] indices = new int[input.length];
        int size = helper(input, indices, 0, 0, x);
        if(size == indices.length)
        {
            return indices;
        }
        // array with only the indices where x appears
        int[] result = new int[size];
        for(int i = 0; i < size; i++)
        {
            result[i] = indices[i];
        }
        return result;
    }

    /**
     * Helper function that stores all the indices where x appears and
     * returns the number of appearances.
    */
    private static int helper(int[] input, int[] indices, int i, int j, int x)
    {
        // base case
        if(i == input.length)
        {
            return 0;
        }
        // handle for current index and assume the function takes care of the rest
        if(input[i] == x)
        {
            indices[j] = i;
            return 1 + helper(input, indices, i + 1, j + 1, x);
        }
        return helper(input, indices, i + 1, j, x);
    }
}
```
