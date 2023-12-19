# Insert Node In LL

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static Node<Integer> insert(Node<Integer> head, int pos, int data)
    {
        Node<Integer> prev = head, curr = new Node<>(data);
        if(pos == 0)
        {
            curr.next = head;
            return curr;
        }
        for(int i = 0; i < pos - 1 && prev != null && prev.data != -1; i++)
        {
            prev = prev.next;
        }
        if(prev != null && prev.data != -1)
        {
            curr.next = prev.next;
            prev.next = curr;
        }
        return head;
    }
}
```
