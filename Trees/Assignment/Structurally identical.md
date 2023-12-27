# Structurally identical

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2)
    {
        if(root1 != null && root2 != null)
        {
            if(root1.data != root2.data)
            {
                return false;
            }
            if(root1.children.size() != root2.children.size())
            {
                return false;
            }
            for(int i = 0; i < root1.children.size(); i++)
            {
                if(!checkIdentical(root1.children.get(i), root2.children.get(i)))
                {
                    return false;
                }
            }
            return true;
        }
        return root1 == root2;
    }
}
```
