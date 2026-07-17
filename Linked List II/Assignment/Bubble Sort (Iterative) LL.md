# Bubble Sort (Iterative) Linked List

## Problem Statement

Given a singly linked list of integers, sort it using 'Bubble Sort'.

**Note**: No need to print the list, it has already been taken care. Only
return the new head to the list.

## Detailed Explanation

### Input format

The first and the only line of each test case or query contains the elements of
the singly linked list separated by a single space.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output format

For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a separate line.

### Constraints

$0 <= M <= 10^3$

Where `M` is the size of the singly linked list.

Time Limit: $1 sec$

```ltf
Sample Input 1:
10 9 8 7 6 5 4 3 -1
Sample Output 1:
 3 4 5 6 7 8 9 10 
 Sample Input 2:
10 -5 9 90 5 67 1 89 -1
Sample Output 2:
-5 1 5 9 10 67 89 90 
```

## Solution

```java
public class Solution
{
    /*
    * Time complexity  : O(n^2)
    * Space complexity : O(1)
    */
    public static Node<Integer> bubbleSort(Node<Integer> head)
    {
        int n = size(head);
        Node<Integer> curr;
        for(int i = 0; i < n; i++)
        {
            curr = head;
            for(int j = 0; j < n - i && curr.next != null; j++)
            {
                if(curr.data > curr.next.data)
                {
                    swapData(curr, curr.next);
                }
                curr = curr.next;
            }
        }
        return head;
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    private static int size(Node<Integer> head)
    {
        int size = 0;
        while(head != null)
        {
            size++;
            head = head.next;
        }
        return size;
    }

    private static void swapData(Node<Integer> n1, Node<Integer> n2)
    {
        int temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }
}
```
