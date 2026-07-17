# Delete Node Recursively

## Problem Statement

Given a singly linked list of integers and position `i`, delete the node
present at the `i`'th position in the linked list recursively.

**Note**: Assume that the Indexing for the linked list always starts from 0.

No need to print the list, it has already been taken care. Only return the new
head to the list.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly
linked list separated by a single space.

The second line of input contains a single integer depicting the value of `i`.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output format

For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= M <= 10^5$

$0 <= i < M$

Where `M` is the size of the singly linked list.

Time Limit:  $2 sec$

```ltf
Sample Input 1:
1
3 4 5 2 6 1 9 -1
3
Sample Output 1:
3 4 5 6 1 9
Sample Input 2:
2
30 -1
0
10 20 30 50 60 -1
4
Sample Output 2:
10 20 30 50
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) 
    {
        // edge case: if head is null but we're not at the right place yet
        if(head == null && pos > 0)
        {
            return head;
        }
        // base case: if we are at the right place
        if(pos == 0)
        {
            return head != null ? head.next : head;
        }
        // assume recursion provides the correct list
        head.next = deleteNodeRec(head.next, pos - 1);
        return head;
    }
}
```
