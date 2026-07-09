# Delete a Node from Linked List

## Problem Statement

You have been given a linked list of integers. Your task is to write a function
that deletes a node from a given position, `pos`.

**Note**: Assume that the Indexing for the linked list always starts from 0.

If the position is greater than or equal to the length of the linked list, you
should return the same linked list without any change.

## Detailed Explanation

### Input format

The first line contains the elements of the linked list separated by a single
space.

The second line contains the integer value of `pos`. It denotes the position in
the linked list from where the node has to be deleted.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output format

Print the resulting linked list of integers in a row, separated by a single
space.

**Note**: You are not required to print the output, it has already been taken
care of. Just implement the function.

### Constraints

$0 <= N <= 10^5$

$POS >= 0$

Time Limit: $1 sec$

Time Complexity: $O(n)$

Space Complexity: $O(1)$

```ltf
Sample Input 1:
3 4 5 2 6 1 9 -1
3
Sample Output 1:
3 4 5 6 1 9

Explanation of Sample Output 1:
The data in the node with index 3 is 2 which has been removed.

Sample Input 2:
3 4 5 2 6 1 9 -1
0
Sample Output 2:
4 5 2 6 1 9
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> deleteNode( Node<Integer> head, int pos) 
    {
        // Write your code here.
        if(head == null)
        {
            return head;
        }
        if(pos == 0)
        {
            return head.next;
        }
        Node<Integer> prev = head;
        for(int i = 0; i < pos - 1 && prev != null; i++)
        {
            prev = prev.next;
        }
        if(prev != null && prev.next != null)
        {
            prev.next = prev.next.next;
        }
        return head;
    }
}
```
