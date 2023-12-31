# Check redundant brackets

```Java
import java.util.Stack;
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static boolean checkRedundantBrackets(String exp) 
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++)
        {
            switch(exp.charAt(i))
            {
                case ')':
                {
                    if(!stack.isEmpty() && hasSignificantCharacters(stack))
                    {
                        break;
                    }
                    return true;
                }
                default: stack.push(exp.charAt(i));
            }
        }
        return false;
    }

    private static boolean hasSignificantCharacters(Stack<Character> stack)
    {
        int count = 0;
        while(!stack.isEmpty())
        {
            if(stack.pop() != '(')
            {
                count++;
            }
            else
            {
                break;
            }
        }
        return count > 1;
    }
}
```
