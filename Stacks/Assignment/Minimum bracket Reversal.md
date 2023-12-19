# Minimum bracket Reversal

```Java
import java.util.Stack;
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution
{
    public static int countBracketReversals(String input) 
    {
        if(input.length() % 2 != 0)
        {
            return -1;
        }
        // filter out all the already balanced brackets
        Stack<Character> stack = getUnbalancedBrackets(input);
        int count = 0;
        while(!stack.isEmpty())
        {
            // if both brackets are same, only one needs to be turned
            count += stack.pop() == stack.pop() ? 1 : 2;
        }
        return count;
    }

    /*
     * only an opening bracket immediately followed by a closing bracket is
     * balanced
     */
    private static Stack<Character> getUnbalancedBrackets(String input)
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++)
        {
            switch(input.charAt(i))
            {
                case '{': stack.push('{'); break;
                case '}':
                {
                    if(!stack.isEmpty() && stack.peek() == '{')
                    {
                        stack.pop();
                    }
                    else
                    {
                        stack.push('}');
                    }
                }
            }
        }
        return stack;
    }
}
```
