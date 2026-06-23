# Theoretical Analysis: Binary Search (Recursive)

```java
public static int binarySearch(int[] arr, int target, int start, int end,)
{
    if(start > end)
    {
        return -1;
    }
    int mid = (end - start + 1) + start;
    if(arr[mid] == target)
    {
        return mid;
    }
    if(arr[mid] > target)
    {
        return binarySearch(arr, target, start, mid - 1);
    }
    return binarySearch(arr, target, mid + 1, end);
}
```

## Time Complexity

- The *recurrence relation* for the above recursive code will be:

$$
T(n) = k + T(n / 2)
$$

- Extrapolating this, we get the following equations:

$$
T(n / 2) = k + T(n / 4)\\
T(n / 4) = k + T(n / 8)\\
.\\
.\\
T(1) = k
$$

- Adding all of these equations, we get:

$$
T(n) = k\cdot{\log_2{n}}
$$

- Therefore, the time complexity of binary search in big O notation will be:

$$O(\log_2{n})$$

## Space Complexity

- The function uses only one additional variable `mid` leading to a constant
space use

$$
S(n) = k + S(n - 1)
$$

- However, due its recursive nature, there will be $\log{n}$ functions stacked
in the call stack at peak memory usage

$$
S(n) = k\cdot{\log_2{n}}
$$

- Therefore, the space complexity of binary search will be:

$$
O(\log{n})
$$
