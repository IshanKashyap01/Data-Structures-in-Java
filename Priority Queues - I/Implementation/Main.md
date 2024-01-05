# Main

```Java
import java.util.ArrayList;
import java.util.Collections;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Testing the minimum priority queue");
        test(false);
        System.out.println("Testing the maximum priority queue");
        test(true);
    }

    private static void test(boolean isMax)
    {
        testInteger(isMax);
        testCharacter(isMax);
    }

    private static void testInteger(boolean isMax)
    {
        System.out.println("Testing with integers");
        PriorityQueue<Integer> queue = new PriorityQueue<>(isMax);
        System.out.print("Adding numbers from 1 to 10 in jumbled order: ");
        int[] nums = {7, 3, 1, 9, 5, 8, 2, 6, 10, 4};
        for(int i : nums)
        {
            queue.add(i, i);
            System.out.print(i + " ");
        }
        System.out.println();
        printQueue(queue);
    }

    private static void testCharacter(boolean isMax)
    {
        System.out.println("Testing with characters");
        PriorityQueue<Character> queue = new PriorityQueue<>(isMax);
        System.out.print("Adding characters from a to z in jumbled order: ");
        ArrayList<Character> characters = new ArrayList<>();
        for(char ch = 'a'; ch <= 'z'; ch++)
        {
            characters.add(ch);
        }
        Collections.shuffle(characters); 
        for(char ch : characters)
        {
            queue.add(ch, ch - 'a' + 1);
            System.out.print(ch + " ");
        }
        System.out.println();
        printQueue(queue);
    }

    private static <T> void printQueue(PriorityQueue<T> queue)
    {
        while (!queue.isEmpty()) 
        {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
```
