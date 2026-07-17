# Delete Every N Nodes

## Problem Statement

You have been given a singly linked list of integers along with two integers,
`M,` and `N.` Traverse the linked list such that you retain the `M` nodes, then
delete the next `N` nodes. Continue the same until the end of the linked list.
Indexing starts from 1.

To put it in other words, in the given linked list, you need to delete N nodes
after every M nodes.

**Note**: No need to print the list, it has already been taken care. Only
return the new head to the list. You can return null in case where all nodes
will be deleted.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly
linked list separated by a single space.

The second line of input contains two integer values `M,` and `N,`
respectively. A single space will separate them.

Remember while specifying the list elements for input, -1 indicates the end of
the singly linked list and hence, would never be a list element

### Output format

For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= P <= 10^5$

Where `P` is the size of the singly linked list.

$0 <= M <= 10^5$

$0 <= N <= 10^5 $

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1:
1 2 5 6
Sample Input 2:
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2:
1 2 6 7

Explanation of Sample Input 2:
For the first query, we delete one node after every zero elements hence
removing all the items of the list. Therefore, nothing got printed.

For the second query, we delete three nodes after every two nodes, resulting
in the final list, 1 -> 2 -> 6 -> 7.
```

## Solution

```java
public class Solution
{
    /*
    At the beginning of each iteration, we are either in the skipping phase, or
    the deletion phase.

    In the skipping phase, we do nothing but move through elements, remembering
    the last element we encountered

    In the deletion phase, we move through elements until the last element of the
    phase.
    
    Then we make the last element encountered in the previous phase, point to the
    next element.
    */
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int m, int n)
    {
        Node<Integer> dummy = new Node<>(0);
        dummy.next = head;
        Node<Integer> lastFromSkip = dummy;
        Node<Integer> curr = head;
        while(curr != null)
        {
            // skip through elements, but keep the last one encountered
            for(int i = 0; curr != null && i < m; i++)
            {
                lastFromSkip = curr;
                curr = curr.next;
            }
            // move through elements to be deleted
            for(int i = 0; curr != null &&  i < n; i++)
            {
                curr = curr.next;
            }
            // now make the deletions
            lastFromSkip.next = curr;
        }
        // After the loop, all deletions have been made
        return dummy.next;
    }
}
```
