# Print Tree Level wise

```Java
import java.util.LinkedList;
import java.util.Queue;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void printLevelWise(TreeNode<Integer> root)
    {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> curr, breaker = new TreeNode<>(-1);
        queue.add(root);
        queue.add(breaker);
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            if(curr == breaker)
            {
                System.out.println();
                if(queue.isEmpty())
                {
                    break;
                }
                queue.add(breaker);
            }
            else
            {
                System.out.print(curr.data + " ");
                queue.addAll(curr.children);
            }
        }
    }
}
```
