# Queue Using Two Stacks

```Java
import java.util.Stack;
/*
 * Time complexity  : O(1)*
 * Space complexity : O(1)
 */
public class Queue<T>
{
    Stack<T> stack;
    Stack<T> helper;

    public Queue()
    {
        stack = new Stack<>();
        helper = new Stack<>()
    }

    public int size()
    {
        return stack.size();
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public void add(T item)
    {
        stack.push(item);
    }

    //*Time Complexity: O(n)
    public T remove()
    {
        switchStacks(stack, helper);
        T temp = helper.poll();
        switchStacks(helper, stack);
        return temp;
    }

    public T peek()
    {
        switchStacks(stack, helper);
        T temp = helper.peek();
        switchStacks(helper, stack);
    }

    private void switchStacks(Stack<T> stack, Stack<T> helper)
    {
        while(!stack.isEmpty())
        {
            helper.push(stack.poll());
        }
    }
}
```
