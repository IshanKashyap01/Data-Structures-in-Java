# Max sum of children and node

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{    
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root)
    {
        return helper(root).node;
    }

    private static MaxNode helper(TreeNode<Integer> root)
    {
        if(root == null)
        {
            return new MaxNode(null, 0);
        }
        MaxNode max = new MaxNode(root), curr;
        for(TreeNode<Integer> child : root.children)
        {
            curr = helper(child);
            max = max.sum > curr.sum ? max : curr;
        }
        return max;
    }
}

class MaxNode
{
    TreeNode<Integer> node;
    int sum;
    
    public MaxNode(TreeNode<Integer> node, int sum)
    {
        this.node = node;
        this.sum = sum;
    }

    public MaxNode(TreeNode<Integer> node)
    {
        this.node = node;
        this.sum = getSumOfChildren(node);
    }

    public static int getSumOfChildren(TreeNode<Integer> node)
    {
        if(node == null)
        {
            return 0;
        }
        int sum = node.data;
        for(TreeNode<Integer> child : node.children)
        {
            sum += child.data;
        }
        return sum;
    }
}
```
