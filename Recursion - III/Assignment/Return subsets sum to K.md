# Return subsets sum to K

```Java
/*
 * Time complexity  : O(2^n^3)
 * Space complexity : O(n)
 */
public class solution 
{
    public static int[][] subsetsSumK(int input[], int k) 
    {
        return helper(input,k,0);
    }
    
    private static int[][] helper(int input[], int k, int index)
    {
        // base case: if we reached the end of array
       if (index == input.length)
        {
            if (k==0)
            {
                return new int[1][0];
            }
            return new int[0][0];
        }
        int[][] include = helper(input, k - input[index], index+1);
        int[][] exclude = helper(input, k, index + 1);
        int[][] total = new int[include.length + exclude.length][];
        // add all subsets that didn't include the current index
        int curr = 0;
        for (int i = 0; i < exclude.length; i++)
        {
            total[curr++] = exclude[i];
        } 
        // Add all subsets from include
        for(int i = 0; i < include.length; i++, curr++)
        {
            // Add current element it in front of all subsets
            total[curr] = new int[1 + include[i].length];
            total[curr][0] = input[index];
            
            for(int j = 1; j < total[curr].length; j++)
            {
                total[curr][j] = include[i][j - 1];
            }
        }
        return total;
    }
}
```
