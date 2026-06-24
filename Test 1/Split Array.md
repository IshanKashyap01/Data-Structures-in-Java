# Split Array

## Problem Statement

Given an integer array A of size N, check if the input array can be divided in
two groups G1 and G2 with following properties-

- Sum of both group elements are equal

- Group 1: All elements in the input, which are divisible by 5

- Group 2: All elements in the input, which are divisible by 3 (but not
divisible by 5).

- Elements which are neither divisible by 5 nor by 3, can be put in either
group G1 or G2 to satisfy the equal sum property.

Group 1 and Group 2 are allowed to be unordered and all the elements in the
Array A must belong to only one of the groups.

Return true, if array can be split according to the above rules, else return
false.

**Note**: **You will get marks only if all the test cases are passed.**

## Detailed Explanation

### Input Format

Integer N (size of array)

Array A elements (separated by space)

### Output Format

true or false

### Constraints

$1 <= N <= 50$

```ltf
Sample Input 1:
2
1 2
Sample Output 1:
false
Sample Input 2:
3
1 4 3
Sample Output 2:
true
```

## Solution

```java
public class solution
{
    public static boolean splitArray(int input[])
    {
        return helper(input, 0, 0, 0);
    }

    /*
    * Time complexity  : O(2^n)
    * Space complexity : O(n)
    */
    private static boolean helper(int[] input, int index, int sumA, int sumB)
    {
        // base case
        if(index == input.length)
        {
            return sumA == sumB;
        }
        int curr = input[index];
        // add current number to whichever group it belongs and
        // assume the function can calculate for remaining indices
        if(curr % 5 == 0)
        {
            return helper(input, index + 1, sumA + curr, sumB);
        }
        if(curr % 3 == 0)
        {
            return helper(input, index + 1, sumA, sumB + curr);
        }
        // if the number belongs to neither group, try adding them to both groups
        return helper(input, index + 1, sumA + curr, sumB) || helper(input, index + 1, sumA, sumB + curr);
    }
}
```
