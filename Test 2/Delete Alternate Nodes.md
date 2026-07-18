# Delete Alternate Nodes

## Problem Statement

Given a Singly Linked List of integers, delete all the alternate nodes in the
list.

**Note**: The head of the list will remain the same. Don't need to print or
return anything.

## Detailed Explanation

### Input format

The first and the only line of input will contain the elements of the Singly
Linked List separated by a single space and terminated by -1.

### Output Format

The only line of output will contain the updated list elements.

### Input Constraints

$1 <= N <= 10^6$

Time Limit: $1 sec$

Where `N` is the size of the Singly Linked List

```ltf
Sample Input 1:
1 2 3 4 5 -1
Sample Output 1:
1 3 5
Explanation of Sample Input 1:
2, 4 are alternate nodes so we need to delete them 
Sample Input 2:
10 20 30 40 50 60 70 -1
Sample Output 2:
10 30 50 70 
```

## Solution

```java
public class Solution 
{
    public static void deleteAlternateNodes(Node<Integer> head) 
    {
        // edge case: if list is empty, do nothing
        if(head == null)
        {
            return;
        }
        Node<Integer> curr = head;
        // at the beginning of each iteration, all previous nodes to be deleted have been
        // deleted. The next node to be deleted is right after the current one.
        while(curr != null && curr.next != null)
        {
            // remove the next in line
            curr.next = curr.next.next;
            // prepare for the next iteration
            curr = curr.next;
        }
    }
}
```
