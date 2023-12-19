# Stock Span

```Java
import java.util.Stack;
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static int[] stockSpan(int[] prices) 
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] spans = new int[prices.length];
        spans[0] = 1;
        for(int i = 1; i < prices.length; i++)
        {
            while(!stack.isEmpty() && prices[stack.peek()] < prices[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                spans[i] = i + 1;
            }
            else
            {
                spans[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return spans;
    }
}
```
