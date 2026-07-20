# Two Sum

## Problem Statement

You are given an array of integers `ARR` of length `N` and an integer Target.
Your task is to return all pairs of elements such that they add up to Target.

**Note**: We cannot use the element at a given index twice.

**Follow Up**: Try to do this problem in O(N) time complexity.

## Detailed Explanation

### Input Format

The first line of input contains an integer `T` denoting the number of test
cases to run. Then the test case follows.

The first line of each test case contains two single space-separated integers
`N` and `target` denoting the number of elements in an array and the Target,
respectively.

The second line of each test case contains `N` single space-separated integers,
denoting the elements of the array.

### Output Format

For each test case, print a single line containing space-separated integers
denoting all pairs of elements such that they add up to the target.

A pair `(a, b)` and `(b, a)` is the same, so you can print it in any order.

Each pair must be printed in a new line. If no valid pair exists, print a pair
of `(-1, -1)`. Refer to sample input/output for more clarity.

**Note**: You do not need to print anything; it has already been taken care of.
Just implement the given function.

### Constraints

$1 ≤ n ≤ 105$

$1 ≤ arr[i] ≤ 105$

Time Limit: $1 sec$

```ltf
Sample Input 1:
2
4 9
2 7 11 13
5 1
1 -1 -1 2 2
Sample Output 1:
2 7
-1 2
-1 2

Explanation for Sample 1:
For the first test case, we can see that the sum of  2 and 7 is equal to 9 and
it is the only valid pair.

For the second test case, there are two valid pairs (-1,2) and (-1,2), which
add up to 1.

Sample Input 2:
1
4 16
2 7 11 13
Sample Output 2:
-1 -1
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
    public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) 
    {
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
        // frequency map to find pairs of elements
        HashMap<Integer, Integer> map = getFrequencyMap(arr);
        int numOfPairs;
        for(int key : map.keySet())
        {
            if(map.containsKey(target - key))
            {
                // add all the pairs that can be made from these two numbers
                if(key == target - key)
                {
                    for(int i = 0; i < map.get(key) / 2; i++)
                    {
                        pairs.add(new Pair<>(key, key));
                    }
                }
                else
                {
                    numOfPairs = Math.min(map.get(key), map.get(target - key));
                    for(int i = 0; i < numOfPairs; i++)
                    {
                        pairs.add(new Pair<>(key, target - key));
                    }
                    // remove the pair so it cannot be used again
                    map.put(key, 0);
                }
            }
        }
        if(pairs.isEmpty())
        {
            pairs.add(new Pair<>(-1, -1));
        }
        return pairs;
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    private static HashMap<Integer, Integer> getFrequencyMap(ArrayList<Integer> arr)
    {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr)
        {
            if(freqMap.containsKey(num))
            {
                freqMap.put(num, freqMap.get(num) + 1);
            }
            else
            {
                freqMap.put(num, 1);
            }
        }
        return freqMap;
    }
}
```
