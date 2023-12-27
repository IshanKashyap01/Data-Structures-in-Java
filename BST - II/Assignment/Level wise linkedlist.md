# Level wise linkedlist

```Java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root)
    {
        // base case
        if(root == null)
        {
            return null;
        }
        // queue to store tree nodes level-wise
        Queue<BinaryTreeNode<Integer>> queue = getQueue(root);
        // initialise the current level and the levels
        BinaryTreeNode<Integer> curr;
        LL level = new LL();
        ArrayList<LinkedListNode<Integer>> levels = new ArrayList<>();
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            if(curr.data == -1)
            {
                // add the current level to levels
                levels.add(level.head);
                level = new LL();
                // if there are no more levels
                if(queue.isEmpty())
                {
                    break;
                }
                queue.add(curr);
            }
            else
            {
                // add the current node and its children (if any) to the queue
                addNodes(queue, level, curr);
            }
        }
        return levels;
    }

    private static Queue<BinaryTreeNode<Integer>> getQueue(BinaryTreeNode<Integer> root)
    {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        // add the root and a breaker node to signify end of a level
        queue.add(root);
        queue.add(new BinaryTreeNode<>(-1));
        return queue;
    }

    private static void addNodes(Queue<BinaryTreeNode<Integer>> queue, LL level, BinaryTreeNode<Integer> node)
    {
        level.add(node.data);
        if(node.left != null)
        {
            queue.add(node.left);
        }
        if(node.right != null)
        {
            queue.add(node.right);
        }
    }
}

class LL
{
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;

    public void add(int item)
    {
        if(head == null)
        {
            head = tail = new LinkedListNode<>(item);
        }
        else
        {
            tail.next = new LinkedListNode<>(item);
            tail = tail.next;
        }
    }
}
```
