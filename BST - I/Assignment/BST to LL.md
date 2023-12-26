# BST to LL

```Java
import java.util.LinkedList;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) 
    {
        LinkedList<Integer> list = new LinkedList<>();
        helper(root, list);
        return toLLNode(list);
    }

    private static void helper(BinaryTreeNode<Integer> root, LinkedList<Integer> list)
    {
        if(root != null)
        {
            helper(root.left, list);
            list.add(root.data);
            helper(root.right, list);
        }
    }

    private static LinkedListNode<Integer> toLLNode(LinkedList<Integer> list)
    {
        LinkedListNode<Integer> head = new LinkedListNode<>(-1), prev = head, curr;
        for(int i : list)
        {
            curr = new LinkedListNode<>(i);
            prev.next = curr;
            prev = prev.next;
        }
        return head.next;
    }
}
```
