# Level Order Traversal

```Java
import java.util.LinkedList;
import java.util.Queue;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void printLevelWise(BinaryTreeNode<Integer> root) 
    {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        BinaryTreeNode<Integer> breaker = new BinaryTreeNode<>(-1);
        queue.add(root);
        queue.add(breaker);
        BinaryTreeNode<Integer> curr;
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            if(curr != breaker)        
            {
                System.out.print(curr.data + " ");
                if(curr.left != null)
                {
                    queue.add(curr.left);
                }
                if(curr.right != null)
                {
                    queue.add(curr.right);
                }
            }
            else if(queue.isEmpty())
            {
                break;
            }
            else
            {
                System.out.println();
                queue.add(breaker);
            }
        }
    }    
}
```
