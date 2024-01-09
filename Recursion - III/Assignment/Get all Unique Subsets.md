# Get all Unique Subsets

```Java
import java.util.ArrayList;
import java.util.HashSet;
/*
 * Time complexity  : O(2^n^2)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void printSubsets(int input[]) 
    {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        int[][] sets = subsets(input);
        for(int[] subset : sets)
        {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i : subset)
            {
                list.add(i);
            }
            set.add(list);
        }
        for(ArrayList<Integer> arr : set)
        {
            for(int i : arr)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static int[][] subsets(int arr[]) 
    {
        return helper(arr, 0);
    }

    private static int[][] helper(int[] arr, int index)
    {
        // return empty array at the end
        if(index == arr.length)
        {
            return new int[1][0];
        }
        // all subsets excluding the current element
        int[][] exclude = helper(arr, index + 1);
        int[][] total = new int[2 * exclude.length][];
        // add them to total
        int curr = 0;
        for(int i = 0; i < exclude.length; i++)
        {
            total[curr++] = exclude[i];
        }
        // now add them again with the current element at the front
        for(int i = 0; i < exclude.length; i++, curr++)
        {
            total[curr] = new int[1 + exclude[i].length];
            total[curr][0] = arr[index];
            for(int j = 0; j < exclude[i].length; j++)
            {
                total[curr][j + 1] = exclude[i][j];
            }
        }
        return total;
    }
}
```
