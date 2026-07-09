# Palindrome Linked List

## Problem Statement

You have been given a head to a singly linked list of integers. Write a
function check to whether the list given is a 'Palindrome' or not.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

First and the only line of each test case or query contains the the elements of
the singly linked list separated by a single space.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element.

### Output format

For each test case, the only line of output that print `true` if the list is
Palindrome or `false` otherwise.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^5$

Time Limit: $1 sec$

Where `M` is the size of the singly linked list.

```ltf
Sample Input 1:
1
9 2 3 3 2 9 -1
Sample Output 1:
true
Sample Input 2:
2
0 2 3 2 5 -1
-1
Sample Output 2:
false
true

Explanation for the Sample Input 2:
For the first query, it is pretty intuitive that the the given list is not a
palindrome, hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome,
hence the output is 'true'.
```

## Solution

```java
import java.util.ArrayList;

public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    public static boolean isPalindrome(Node<Integer> head) 
    {
        //Your code goes here
        ArrayList<Integer> list = new ArrayList<>();
        Node<Integer> temp = head;
        while(temp != null)
        {
            list.add(temp.data);
            temp = temp.next;
        }
        return isPalindrome(list);
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    private static boolean isPalindrome(ArrayList<Integer> list)
    {
        int n = list.size();
        for(int i = 0, j = n - 1; i < j; i++, j--)
        {
            if(list.get(i) != list.get(j))
            {
                return false;
            }
        }
        return true;
    }
}
```
