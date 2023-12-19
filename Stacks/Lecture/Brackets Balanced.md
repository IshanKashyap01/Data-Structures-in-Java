# Brackets Balanced

```Java
import java.util.Stack;
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{

    public static boolean isBalanced(String exp) 
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++)
        {
            switch(exp.charAt(i))
            {
                case '(' : stack.push('('); break;
                case ')' :
                {
                    if(!stack.isEmpty())
                    {
                        if(stack.peek() == ('('))
                        {
                            stack.pop();
                            break;
                        }
                    }
                    return false;
                }
                default: return stack.isEmpty();
            }
        }
        return stack.isEmpty();
    }
}
```
