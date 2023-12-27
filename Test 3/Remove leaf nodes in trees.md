# Remove leaf nodes in trees

```Java
import java.util.ArrayList;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) 
    {
        if(root == null)
        {
            return null;
        }
        // base case
        if(root.children.isEmpty())
        {
            return null;
        }
        // set leaf children to null
        int n = root.children.size();
        for(int i = 0; i < n; i++)
        {
            root.children.set(i, removeLeafNodes(root.children.get(i)));
        }
        // remove all null values
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
        root.children.removeAll(list);

        return root;
    }
}
```
