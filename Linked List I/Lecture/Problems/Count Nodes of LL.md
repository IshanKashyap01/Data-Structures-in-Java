# Count Nodes of Linked List

## Problem Statement

Given the head of a singly linked list of integers, find and return its length.

Example:

![linked list with 4 items](https://files.codingninjas.in/untitled-diagram-6494.png)

The length of the list is 4. Hence we return 4.

**Note**: Exercise caution when dealing with edge cases, such as when the head
is NULL. Failing to handle these edge cases appropriately may result in a
runtime error in your code.

## Detailed Explanation

### Input format

The first and only line contains elements of the singly linked list separated
by a single space, -1 indicates the end of the singly linked list and hence,
would never be a list element.

### Output format

Return a single integer denoting the length of the linked list.

### Constraints

$0 <= N <= 10^5$

Time Limit: $1 sec$

Expected Time Complexity: Try to do this in $O(n)$.

```ltf
Sample Input 1:
3 4 5 2 6 1 9 -1
Sample Output 1:
7
Sample Input 2:
10 76 39 -3 2 9 -23 9 -1
Sample Output 2:
8
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static int length(Node head)
    {
        //Your code goes here
        int count = 0;
        Node temp = head;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
```

Node class:

```java
class Node
{
    public int data;
    public Node next;

    Node()
    {
        this.data = 0;
        this.next = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
```
