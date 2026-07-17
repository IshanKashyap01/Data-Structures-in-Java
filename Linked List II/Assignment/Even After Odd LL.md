# Even After Odd Linked List

## Problem Statement

For a given singly linked list of integers, arrange the nodes such that all the
even number nodes are placed after the all odd number nodes. The relative order
of the odd and even terms should remain unchanged.

**Note**:

1. No need to print the linked list, it has already been taken care. Only
return the new head to the list.

2. Don't create a new linked list.

3. Just change the data, instead rearrange the provided list.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly
linked list separated by a single space.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output format

For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^5$

Where `M` is the size of the singly linked list.

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
1 4 5 2 -1
Sample Output 1:
1 5 4 2 
Sample Input 2:
2
1 11 3 6 8 0 9 -1
10 20 30 40 -1
Sample Output 2:
1 11 3 9 6 8 0
10 20 30 40
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> evenAfterOdd(Node<Integer> head)
    {
        Node<Integer> dummy = new Node<>(0);
        dummy.next = head;
        // Last odd number encountered and in its correct position
        Node<Integer> lastOdd = dummy;
        // moves through the list one number at a time, and decides their fate
        Node<Integer> arranger = head;
        // node right before the arranger, needed to move a node
        Node<Integer> prev = dummy;
        /* 
         * At the beginning of each iteration, all odd numbers encountered so far
         * were put in their correct position. Relative order of all even numbers
         * were unchanged.
         */
        while(arranger != null)
        {
            // If we encounter an even number, we do nothing and move on
            if(arranger.data % 2 == 0)
            {
                prev = arranger;
                arranger = arranger.next;
            }
            // If this odd number is already at its correct position
            else if(arranger == lastOdd.next)
            {
                // update last odd number encountered and move ahead
                lastOdd = arranger;
                prev = arranger;
                arranger = arranger.next;
            }
            // Otherwise, move this number right after the last odd encountered
            else
            {
                // make prev's next point to the next number first
                prev.next = arranger.next;
                // now arranger can safely point to the number after last odd
                arranger.next = lastOdd.next;
                // last odd can now safely point to this number
                lastOdd.next = arranger;
                // and now last odd can be updated
                lastOdd = lastOdd.next;
                // arranger should move to the next number in line
                arranger = prev.next;
            }
        }
        // after the loop, all numbers have been put in their correct spot
        return dummy.next;
    }
}
```
