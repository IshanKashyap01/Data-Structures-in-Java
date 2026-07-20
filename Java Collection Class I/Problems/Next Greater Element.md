# Next Greater Element For All

## Problem Statement

Given an array, print the Next Greater Element (NGE) for every element. The
Next greater Element for an element x, is the first greater element on right
side of x in the array. Elements for which no greater element exist, consider
next greater element as -1.

### Input format

Size of input array

Array elements (separated by space)

### Constraints

$1 <= n <= 1000000$

Time Limit: $1 sec$

```ltf
Sample Input:
5
3  8  1  2  0
Sample Output:
8 -1  2 -1 -1
```

## Solution

```java
import java.util.*;

public class solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    public static ArrayList<Integer> nextGreaterElement(ArrayList<Integer> input) 
    {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nextGreaterElements = getSameSizedArrayList(input);
        int curr;
        for(int i = input.size() - 1; i > -1; i--)
        {
            curr = input.get(i);
            while(!stack.isEmpty() && stack.peek() <= curr)
            {
                stack.pop();
            }
            nextGreaterElements.set(i, stack.isEmpty() ? -1 : stack.peek());
            stack.push(curr);
        }
        return nextGreaterElements;
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    private static ArrayList<Integer> getSameSizedArrayList(ArrayList<Integer> input)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : input)
        {
            arr.add(null);
        }
        return arr;
    }
}
```

### Explanation

For the last element, there is no greater element to the right. For the second
last element, it could be the last element. For the third last, it could only
be the last if it is not the second last element.

So every element checks its closest before moving forward.

For any given number, suppose there is no greater number on the right.

For a number preceding it, if the above number is not greater, then anything
beyond it cannot be greater either.

So we keep a stack. After everything is said and done, we put the current
number in it.

At the beginning of each iteration, all elements to the right were already
processed, only the current one need to be addressed.

For the current number, we should keep checking the stack until we find a
greater number and get rid of smaller ones as they appear.

If a greater number appears, we insert it into our output array at the same
index.

Alternatively, the stack empties and no greater number was found. So we put -1
in its place.
