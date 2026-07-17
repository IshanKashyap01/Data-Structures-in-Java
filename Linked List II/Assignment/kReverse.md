# kReverse

## Problem Statement

Given a singly linked list of integers, reverse the nodes of the linked list
`k` at a time and return its modified list.

`k` is a positive integer and is less than or equal to the length of the linked
list. If the number of nodes is not a multiple of `k`, then left-out nodes, in
the end, should be reversed as well.

### Example

Given this linked list:
$1 \rightarrow 2 \rightarrow 3 \rightarrow 4 \rightarrow 5$

For k = 2, you should return:
$2 \rightarrow 1 \rightarrow 4 \rightarrow 3 \rightarrow 5$

For k = 3, you should return:
$3 \rightarrow 2 \rightarrow 1 \rightarrow 5 \rightarrow 4$

**Note**: No need to print the list, it has already been taken care. Only
return the new head to the list.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly
linked list separated by a single space.

The second line of input contains a single integer depicting the value of `k`.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output format

For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^5$

$0 <= k <= M$

Where `M` is the size of the singly linked list.

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
1 2 3 4 5 6 7 8 9 10 -1
4


Sample Output 1:
4 3 2 1 8 7 6 5 10 9
Sample Input 2:
2
1 2 3 4 5 -1
0
10 20 30 40 -1
4
Sample Output 2:
1 2 3 4 5 
40 30 20 10 
```

## Solution

```java
import java.util.ArrayList;

public class Solution
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> kReverse(Node<Integer> head, int k)
    {
        // edge case: list is empty or no elements should be reversed
        if(head == null || k <= 1)
        {
            return head;
        }
        // dummy node to keep track of the head of the new list
        Node<Integer> dummy = new Node<>(0);
        dummy.next = head;
        // tail of the list k-reversed so far
        Node<Integer> tail = dummy;
        // tracker for the current element of the list
        Node<Integer> curr = head;
        ArrayList<Node<Integer>> headAndTail;
        while(curr != null)
        {
            headAndTail = reverseNextK(curr, k);
            // the new head should come after the tail
            tail.next = headAndTail.get(0);
            // the tail of the reversed list is now the tail of the processed elements so far
            tail = curr;
            // the tail of the reversed list should point to the next element in line
            curr.next = headAndTail.get(1);
            // curr should now point to the next element in line
            curr = curr.next;
        }
        // After the loop, all elements have been k-reversed
        return dummy.next;
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    private static ArrayList<Node<Integer>> reverseNextK(Node<Integer> head, int k)
    {
        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> next = head;
        for(int i = 0; curr != null && i < k; i++)
        {
            // save the next item in line first
            next = curr.next;
            // reverse this element's connection
            curr.next = prev;
            // prepare for the next iteration
            prev = curr;
            curr = next;
        }
        // After the loop, all eligible elements in the list have been reversed
        ArrayList<Node<Integer>> headAndTail = new ArrayList<>();
        headAndTail.add(prev);
        headAndTail.add(next);
        return headAndTail;
    }
}
```
