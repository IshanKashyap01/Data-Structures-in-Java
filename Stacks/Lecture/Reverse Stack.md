# Reverse Stack

```Java
import java.util.Stack;
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static void reverseStack(Stack<Integer> input, Stack<Integer> helper) 
    {
        if(!input.isEmpty())
        {
            int temp = input.pop();
            reverseStack(input, helper);
            switchStacks(input, helper);
            input.push(temp);
            switchStacks(helper, input);
        }
    }

    // pops all the elements in input to helper
    private static void switchStacks(Stack<Integer> input, Stack<Integer> helper)
    {
        while(!input.isEmpty())
        {
            helper.push(input.pop());
        }
    }
}
```
