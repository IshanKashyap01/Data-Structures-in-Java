# Return subset of an array

```Java
/*
 * Time complexity  : O(2^n^2)
 * Space complexity : O(n)
 */
public class solution 
{
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
