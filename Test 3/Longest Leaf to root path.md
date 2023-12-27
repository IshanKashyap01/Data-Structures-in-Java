# Longest Leaf to root path

```Java
import java.util.ArrayList;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{    
    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root)
    {
        if(root == null)        
        {
            return new ArrayList<>();
        }
        // get path to leaves from both subtrees
        ArrayList<Integer> path;
        ArrayList<Integer> left = longestRootToLeafPath(root.left);
        ArrayList<Integer> right = longestRootToLeafPath(root.right);
        // store the longer path and add the current node to it
        path = left.size() > right.size() ? left : right;
        path.add(root.data);
        return path;
    }
}
```
