# Count Small

## Problem Statement

You are given two integer arrays A and B. For each element A[i], find the
number of elements in array B that are less than or equal to A[i].

**Note**: Array B is sorted in non-decreasing order.

## Detailed Explanation

### Input Format

The first line of input contains an integer `T` denoting the number of test
cases.

Then the test case follows:

1. The first line of each test case contains an integer `N` denoting the number
of elements in the array A.

2. The second line of each test case contains `N` space-separated integers
denoting the elements of array A.

3. The third line of each test case contains an integer `M` denoting the number
of elements in array B.

4. The second line of each test case contains `M` space-separated integers
denoting the elements of the sorted array B.

### Output format

For each test case, print N space-separated integers represent the number of
elements in array B that are smaller than the corresponding element in array A.

### Constraints

$1 <= T <= 10$

$1 <= N,M <= 104$

$-109 <= A[i], B[i] <= 109$

Time Limit: $1 sec$

```ltf
Sample Input 1:
2
3
0 2 3
2
1 5
2
2 4
3 
1 3 5
Sample Output 1:
0 0 1
1 2
Sample Input 2 :
2
2 
1 2
2 
3 3
4
4 5 6 7
2
6 7
Sample Output 2 :
0 0
0 0 1 2
```

## Solution

```java
public class Solution 
{
    public static int[] countS(int n, int m, int []arr1, int []arr2) 
    {
        // Write your code here.
        int[] result = new int[n];
        int i = 0, j = 0, count = 0, k = 0;
        while(i < n && j < m)
        {
            if(arr2[j] <= arr1[i])
            {
                j++;
                count++;
            }
            else
            {
                result[k++] = count;
                i++;
            }
        }
        while(k < n)
        {
            result[k++] = count;
        }
        return result;
    }
}
```
