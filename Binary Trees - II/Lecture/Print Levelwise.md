# Print Levelwise

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
        if(root == null)
        {
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode<Integer> curr;
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            printNode(curr);
            if(curr.left != null)
            {
                queue.add(curr.left);
            }
            if(curr.right != null)
            {
                queue.add(curr.right);
            }
        }
    }

    private static void printNode(BinaryTreeNode<Integer> node)
    {
        int left = node.left != null ? node.left.data : -1;
        int right = node.right != null ? node.right.data : -1;
        System.out.println(node.data + ":" + "L:" + left + ",R:" + right);
    }
    
}
```
