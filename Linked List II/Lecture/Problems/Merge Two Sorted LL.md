# Merge Two Sorted Linked List

## Problem Statement

You have been given two sorted(in ascending order) singly linked lists of
integers.

Write a function to merge them in such a way that the resulting singly linked
list is also sorted(in ascending order) and return the new head to the list.

**Note**: Try solving this in $O(1)$ auxiliary space.

No need to print the list, it has already been taken care.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the first
sorted singly linked list separated by a single space.

The second line of the input contains the elements of the second sorted singly
linked list separated by a single space.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output

For each test case/query, print the resulting sorted singly linked list,
separated by a single space.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t = 10^2$

$0 <= N <= 10 ^ 4$

$0 <= M <= 10 ^ 4$

Where `N` and `M` denote the sizes of the singly linked lists.

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
2 5 8 12 -1
3 6 9 -1
Sample Output 1:
2 3 5 6 8 9 12 
Sample Input 2:
2
2 5 8 12 -1
3 6 9 -1
10 40 60 60 80 -1
10 20 30 40 50 60 90 100 -1
Sample Output 2:
2 3 5 6 8 9 12 
10 10 20 30 40 40 50 60 60 60 80 90 100
```

## Solution

```java
public class Solution
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2)
    {
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> tail = dummy;
        Node<Integer> h1 = head1;
        Node<Integer> h2 = head2;
        // At the beginning of each iteration, all previous nodes have been merged
        while(h1 != null && h2 != null)
        {
            // decide the current node of which of the two list should come next in line
            // Move forward in that list
           if(h1.data < h2.data)
           {
               tail.next = h1;
               h1 = h1.next;
           }
           else
           {
               tail.next = h2;
               h2 = h2.next;
           }
           // Update the tail to get ready for the next iteration
           tail = tail.next;
        }
        // After the loop, one of the list is exhausted. Join the other one to the merged list
        tail.next = h1 != null ? h1 : h2;
        // node next to the dummy is the head of the merged list
        return dummy.next;
    }
}
```
