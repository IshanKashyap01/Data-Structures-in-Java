# Diameter Of Binary Tree

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root)
    {
        return helper(root).diameter;
    }

    private static Pair helper(BinaryTreeNode<Integer> root)
    {
        if(root != null)
        {
            Pair left = helper(root.left);
            Pair right = helper(root.right);

            int height = 1 + Math.max(left.height, right.height);
            int dist = 1+ left.height + right.height;
            int diameter = Math.max(dist, Math.max(left.diameter, right.diameter));
            return new Pair(height, diameter);
        }
        return new Pair(0, 0);
    }
}

class Pair
{
    int height;
    int diameter;

    public Pair(int height, int diameter)
    {
        this.height = height;
        this.diameter = diameter;
    }
}
```
