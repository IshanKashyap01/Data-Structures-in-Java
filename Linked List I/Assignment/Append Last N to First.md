# Append Last N to First

## Problem Statement

You have been given a singly linked list of integers along with an integer `N`.
Write a function to append the last `N` nodes towards the front of the singly
linked list and returns the new head to the list.

**Hint**: Identify how many pointers you require and try traversing them to
right places and connect nodes accordingly also don't forget to disconnect
what's required else it could create cycles.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly
linked list separated by a single space.

The second line contains the integer value `N`. It denotes the number of nodes
to be moved from last to the front of the singly linked list.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element.

### Output format

For each test case/query, print the resulting singly linked list of integers in
a row, separated by a single space.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^5$

$0 <= N < M$

Time Limit: $1 sec$

Where `M` is the size of the singly linked list.

```ltf
Sample Input 1:
2
1 2 3 4 5 -1
3
10 20 30 40 50 60 -1
5
Sample Output 1:
3 4 5 1 2
20 30 40 50 60 10
Sample Input 2:
1
10 6 77 90 61 67 100 -1
4
Sample Output 2:
90 61 67 100 10 6 77 

Explanation to Sample Input 2:
We have been required to move the last 4 nodes to the front of the list. Here,
"90->61->67->100" is the list which represents the last 4 nodes. When we move
this list to the front then the remaining part of the initial list which is,
"10->6->77" is attached after 100. Hence, the new list formed with an updated
head pointing to 90.
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) 
    {
        // get the index of the new head
        int m = size(head) - n;
        if(m <= 0)
        {
            return null;
        }
        // sever the element before the new head
        Node<Integer> prev = get(head, m - 1);
        Node<Integer> newHead = prev.next;
        if(newHead == null || newHead.next == null)
        {
            return head;
        }
        prev.next = null;
        // get the tail and join it to the original head
        Node<Integer> tail = newHead;
        while(tail.next != null)
        {
            tail = tail.next;
        }
        tail.next = head;
        return newHead;
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static int size(Node<Integer> head)
    {
        Node<Integer> temp = head;
        int size = 0;
        while(temp != null)
        {
            temp = temp.next;
            size++;
        }
        return size;
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> get(Node<Integer> head, int index)
    {
        Node<Integer> temp = head;
        for(int i = 0; i < index && temp != null; i++)
        {
            temp = temp.next;
        }
        return temp;
    }
}
```
