# Merge Sort Linked List

## Problem Statement

Given a singly linked list of integers, sort it using `Merge Sort`.

**Note**: No need to print the list, it has already been taken care. Only
return the new head to the list.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of
the singly linked list separated by a single space.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output format

For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^5$

Where `M` is the size of the singly linked list.

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
10 9 8 7 6 5 4 3 -1
Sample Output 1:
3 4 5 6 7 8 9 10 
Sample Input 2:
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2:
-5 1 5 9 10 67 89 90 
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(nlogn)
    * Space complexity : O(logn)
    */
    public static Node<Integer> mergeSort(Node<Integer> head)
    {
        // base case: list is empty or just a single item
        if(head == null || head.next == null)
        {
            return head;
        }
        // divide the list into two halves
        Node<Integer> left = head;
        Node<Integer> mid = getMidPoint(head);
        Node<Integer> right = mid.next;
        mid.next = null;
        // assume recursion can sort both of them
        left = mergeSort(left);
        right = mergeSort(right);
        // merge them back together
        return merge(left, right);
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    private static Node<Integer> getMidPoint(Node<Integer> head)
    {
        // if the list is empty, there cannot be a mid point
        if(head == null)
        {
            return head;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    private static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2)
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
