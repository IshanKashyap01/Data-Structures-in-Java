# Binary Search (Recursive)

## Problem Statement

Given an integer sorted array (sorted in increasing order) and an element x,
find the x in given array using binary search. Return the index of x.

## Detailed Statement

### Input Format

Array size

Array elements (separated by space)

x (element to be searched)

## Output Format

Return -1 if x is not present in the given array.

**Note**: If given array size is even, take first mid.

```ltf
Sample Input :
6
2 3 4 5 6 8 
5 
Sample Output:
3 
```

**Hint**: Use helper function to solve this question.

## Solution

```java
public class solution 
{
    public static int binarySearch(int input[], int element) 
    {
        // Write your code here
        return helper(input, element, 0, input.length - 1);
    }

    private static int helper(int[] input, int element, int start, int end)
    {
        // base case: if start has crossed end, the number isn't present
        if(start > end)
        {
            return -1;
        }
        // check if the number is at the midpoint
        int mid = start + (end - start) / 2;
        if(input[mid] == element)
        {
            return mid;
        }
        // if not, assume the function can find it in the smaller half
        if(element > input[mid])
        {
            return helper(input, element, mid + 1, end);
        }
        return helper(input, element, start, mid - 1);
    }
}
```
