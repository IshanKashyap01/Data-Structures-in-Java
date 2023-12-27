# Pair Sum in a BST

```Java
import java.util.ArrayList;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{    
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int num) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        toList(root, list);
        int sum;
        for(int i = 0, j = list.size() - 1; i < j;)
        {
            sum = list.get(i) + list.get(j);
            if(sum == num)
            {
                System.out.println(list.get(i++) + " " + list.get(j--));
            }
            else if(sum < num)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
    }

    private static void toList(BinaryTreeNode<Integer> root, ArrayList<Integer> list)
    {
        if(root != null)
        {
            toList(root.left, list);
            list.add(root.data);
            toList(root.right, list);
        }
    }
}
```
