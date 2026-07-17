# Reverse Linked List (Recursive)

Given a singly linked list of integers, reverse it using recursion and return
the head to the modified list. You have to do this in $O(n)$ time complexity
where N is the size of the linked list.

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

For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^4$

Where `M` is the size of the singly linked list.

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
1 2 3 4 5 6 7 8 -1
Sample Output 1:
8 7 6 5 4 3 2 1
Sample Input 2:
2
10 -1
10 20 30 40 50 -1
Sample Output 2:
10 
50 40 30 20 10 
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    public static Node<Integer> reverseRec(Node<Integer> head) 
    {
        // base case: if the list is of size 0 or 1
        if(head == null || head.next == null)
        {
            return head;
        }
        // assume the function can reverse the list from the next element
        Node<Integer> newHead = reverseRec(head.next);
        // the next element is this reversed list's tail and points to null
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```
