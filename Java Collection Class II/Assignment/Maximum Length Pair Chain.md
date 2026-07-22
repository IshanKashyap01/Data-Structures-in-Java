# Maximum Length Pair Chain

## Problem Statement

You are given `N` pairs of integers in which the first number is always smaller
than the second number i.e in pair (a,b) -> a < b always. Now we define a pair
chain as the continuous arrangement of pairs in which a pair (c,d) can follow
another pair (a,b) only when b < c.

Find the length of the longest pair chain that can be formed using the given
pairs.

**Example**:

Given Pairs =  [3,4], [1,2], [2,3].

The length of the maximum chain will be 2. The longest chain is [1,2] -> [3,4].

**Note**:

1. You can select a pair only once.

2. You needn’t use up all the given pairs.

3. You can select pairs in any order.

## Detailed Explanation

### Input Format

The first line of the input contains an integer `T` denoting the number of test
cases.

The first line of each test case contains a single positive integer `N`
denoting the total number of the pairs.

Next `N` lines of each test case contain two space-separated integers `a` and
`b` denoting the elements of the pair.

### Output Format

For each test case, return a positive integer denoting the maximum length of
the pair chain that can be possible while satisfying the given condition.

The output of each test case will be printed in a separate line.

**Note**: You don’t need to print anything, it has been already taken care of.
Just implement the given function.

### Constraints

$1 <= T <= 100$

$1 <= N <= 10^4$

$-10^9 <= a,b <= 10^9$

Where `a` and `b` is the elements of the pair.

Time Limit: $1 sec$

```ltf
Sample Input 1:
2
3
5 8 
3 4
3 4
2
2 3
-1 2
Sample Output 1:
2
1

Explanation for Sample Output 1:
In test case 1, The max length pair chain will be [3,4], -> [5,8] as 4 < 5 that
means we can join these two pairs and form a chain of length two.

In test case 2, To join two pairs (a,b), (c,d) we need b < c but this condition
is not satisfied by the given pairs in the input hence the max length will be 1
and the max length pair chain will be [2,3] or [-1,2].

Sample Input 2:
2
1
10 20
4
4 6
2 3
9 12
15 20
Sample Output 2:
1
4

Explanation for Sample Output 2:
In test case 1, The max length pair chain will be [10,20] form a chain of
length one.

In test case 2, The max length pair chain will be:
[2,3] -> [4,6] -> [9,12] -> [15,20]
that means we can join these two pairs as it satisfies the condition and form a
chain of length four.
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
    public static int maxLengthChain(int[][] p, int n) 
    {
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++)
        {
            pairs[i] = new Pair(p[i][0], p[i][1]);
        }
        Arrays.sort(pairs);
        int chain = 1;
        Pair prev = pairs[0];
        for(int i = 1; i < n; i++)
        {
            if(prev.isBefore(pairs[i]))
            {
                chain++;
                prev = pairs[i];
            }
        }
        return chain;
    }
}

class Pair implements Comparable<Pair>
{
    private int a;
    private int b;

    public Pair(int a, int b)
    {
        // a is always less than b
        this.a = a;
        this.b = b;
    }
    public boolean isBefore(Pair pair)
    {
        // given pair must start after this one ends
        return pair.a > this.b;
    }

    @Override
    public int compareTo(Pair pair)
    {
        return this.b - pair.b;
    }
}
```
