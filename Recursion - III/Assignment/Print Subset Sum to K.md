# Print Subset Sum to K

```Java
import java.util.ArrayList;
/*
 * Time complexity  : O(2^n^2)
 * Space complexity : O(n)
 */
public class solution 
{
    public static void printSubsetsSumTok(int input[], int k) 
    {
        hepler(input, new ArrayList<>(), 0, k);
    }

    private static void hepler(int[] arr, ArrayList<Integer> subset, int index, int k)
    {
        if(k == 0)
        {
            for(int i : subset)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else if(index != arr.length)
        {
            if(arr[index] <= k)
            {
                ArrayList<Integer> list = new ArrayList<>(subset);
                list.add(arr[index]);
                hepler(arr, list, index + 1, k - arr[index]);
            }
            hepler(arr, subset, index + 1, k);
        }
    }
}
```
