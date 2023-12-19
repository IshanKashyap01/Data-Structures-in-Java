# Triplet sum

```Java
/*
 * Time complexity  : O(n^2)
 */
public class Solution 
{
    public static int tripletSum(int[] arr, int num) 
    {
        int count = 0, pair;
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++)
        {
            pair = num - arr[i];
            count += pairSum(arr, i + 1, arr.length - 1, pair);
        }
        return count;
    }

    public static int pairSum(int[] arr, int start, int end, int num) 
    {
        int count = 0;
        while(start < end)
        {
            if(arr[start] + arr[end] < num)
            {
                start++;
            }
            else if(arr[start] + arr[end] > num)
            {
                end--;
            }
            else
            {
                if(arr[start] == arr[end])
                {
                    return count + (end - start + 1) * (end - start) / 2;
                }
                else
                {
                    int numStart = countNumber(arr, start, start, end);
                    int numEnd = countNumber(arr, end, start, end);
                    count += numStart * numEnd;
                    start += numStart;
                    end -= numEnd;
                }
            }
        }
        return count;
    }

    private static int countNumber(int[] arr, int index, int start, int end)
    {
        int count = 1;
        for(int i = start + 1; i < end; i++)
        {
            if(arr[i] == arr[index])
            {
                count++;
            }
        }
        return count;
    }

    private static void quickSort(int[] arr, int start, int end)
    {
        if(start < end)
        {
            int pivot = getPivot(arr, start, end);
            partition(arr, start, end, pivot);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static void partition(int[] arr, int start, int end, int pivot)
    {
        while(start < pivot && end > pivot)
        {
            if(arr[start] < arr[pivot])
            {
                start++;
            }
            else if(arr[end] >= arr[pivot])
            {
                end--;
            }
            else
            {
                swap(arr, start++, end--);
            }
        }
    }

    private static int getPivot(int[] arr, int start, int end)
    {
        int pos = start + (int) (Math.random() * (end - start));
        int pivot = start;
        for(int i = start; i <= end; i++)
        {
            pivot += arr[i] < arr[pos] ? 1 : 0;
        }
        swap(arr, pivot, pos);
        return pivot;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }
}
```
