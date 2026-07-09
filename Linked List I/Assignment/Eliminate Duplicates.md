# Eliminate Duplicates

## Problem Statement

You have been given a singly linked list of integers where the elements are
sorted in ascending order. Write a function that removes the consecutive
duplicate values such that the given list only contains unique elements and
returns the head to the updated list.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements
(in ascending order) of the singly linked list separated by a single space.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element.

### Output format

For each test case/query, print the resulting singly linked list of integers in
a row, separated by a single space.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^5$

Time Limit: $1 sec$

Where `M` is the size of the singly linked list.

```ltf
Sample Input 1:
1
1 2 3 3 3 3 4 4 4 5 5 7 -1
Sample Output 1:
1 2 3 4 5 7 
Sample Input 2:
2
10 20 30 40 50 -1
10 10 10 10 -1
Sample Output 2:
10 20 30 40 50
10
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> removeDuplicates(Node<Integer> head) 
    {
        //Your code goes here
        Node<Integer> prev = head;
        Node<Integer> next;
        while(prev != null)
        {
            next = prev.next;
            while(next != null && next.data.equals(prev.data))
            {
                next = next.next;
            }
            prev.next = next;
            prev = next;
        }
        return head;
    }
}
```

**Note**: Do not use `==` to compare `Integer`. It *will* work for `Integer`s
ranging from $-128$ to $127$ as those numbers are cached by Java. But two
`Integer`s outside that range will not point to the same object
