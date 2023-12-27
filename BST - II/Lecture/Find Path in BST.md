# Find Path in BST

```Java
import java.util.ArrayList;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int target)
    {
        if(root == null)
        {
            return null;
        }
        ArrayList<Integer> path;
        if(root.data == target)
        {
            path = new ArrayList<>();
        }
        else if(target < root.data)
        {
            path = getPath(root.left, target);
        }
        else
        {
            path = getPath(root.right, target);
        }
        if(path != null)
        {
            path.add(root.data);
        }
        return path;
    }
}
```
