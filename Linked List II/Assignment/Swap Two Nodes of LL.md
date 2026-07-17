# Swap Two Nodes of Linked List

## Problem Statement

You have been given a singly linked list of integers along with two integers,
`i,` and `j`. Swap the nodes that are present at the `i`th and `j`th
positions and return the new head to the list.

**Note**:

1. Remember, You need to swap the nodes, not only the data.

2. Indexing starts from 0.

3. No need to print the list, it has already been taken care.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly
linked list separated by a single space.

The second line of input contains two integer values `i` and `j` respectively.
A single space will separate them.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output format

For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^5$

$0 <= i < M$

$0 <= j < M$

Where `M` is the size of the singly linked list.

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
3 4 5 2 6 1 9 -1
3 4
Sample Output 1:
3 4 5 6 2 1 9 
Sample Input 2:
2
10 20 30 40 -1
1 2
70 80 90 25 65 85 90 -1
0 6
Sample Output 2:
10 30 20 40 
90 80 90 25 65 85 70 
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j)
    {
        // edge case: list is empty or both point to the same node
        if(head == null || i == j)
        {
            return head;
        }
        // dummy node to bypass edge cases where either node is head
        Node<Integer> dummy = new Node<>(0);
        dummy.next = head;
        // get previous of both
        Node<Integer> p1 = get(dummy, i - 1);
        Node<Integer> p2 = get(dummy, j - 1);
        // edge case: at least one of the nodes doesn't exist
        if(p1 == null || p1.next == null || p2 == null || p2.next == null)
        {
            return head;
        }
        swap(p1, p2);
        return dummy.next;
    }
    /*
    * Time complexity  : O(1)
    * Space complexity : O(1)
    */
    private static void swap(Node<Integer> p1, Node<Integer> p2)
    {
        Node<Integer> c1 = p1.next;
        Node<Integer> c2 = p2.next;
        // p1 -> c1 -> c2 -> next
        if(c1 == p2)
        {
            p1.next = c2;
            c1.next = c2.next;
            c2.next = c1;
        }
        // p2 -> c2 -> c1 -> next
        else if(c2 == p1)
        {
            p2.next = c1;
            c2.next = c1.next;
            c1.next = c2;
        }
        // nodes are not consecutive
        else
        {
            p1.next = c2;
            p2.next = c1;
            Node<Integer> temp = c1.next;
            c1.next = c2.next;
            c2.next = temp;
        }
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    private static Node<Integer> get(Node<Integer> head, int index)
    {
        Node<Integer> temp = head;
        for(int i = -1; temp != null && i < index; i++)
        {
            temp = temp.next;
        }
        return temp;
    }
}
```
