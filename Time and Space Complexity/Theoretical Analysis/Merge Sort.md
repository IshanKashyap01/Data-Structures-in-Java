# Theoretical Analysis: Merge Sort

```java
public static void mergeSort(int[] arr)
{
    if(arr.length <= 1)
    {
        return;
    }
    int mid = arr.length / 2;
    int left = createSubsetOfArray(arr, 0, mid);
    int right = createSubsetOfArray(arr, mid + 1, arr.length - 1);
    mergeSort(left);
    mergeSort(right);
    merge(arr, left, right);
}
```

- The *recurrence relation* for this code will be:

$$
T(n) = k_1 + k_2\cdot{n} + 2T(n / 2) + k_3\cdot{n}\\
\implies{T(n) = k\cdot{n} + 2T(n / 2)}
$$

- Similarly,

$$
2T(n / 2) = k\cdot{n} + 4T(n / 4)\\
4T(n / 4) = k\cdot{n} + 8T(n / 8)\\
.\\
.\\
T(1) = k
$$

- Adding all the equations above, we get:

$$
T(n) = k\cdot{n}\cdot{\log_2{n}}
$$

- Therefore, the time complexity of merge sort in big O notation will be:

$$
O(n\log{n})
$$

## Space Complexity

- Merge sort creates two arrays, both half the size of the original

$$
S(n) = n + S(n / 2)
$$

- Similarly:

$$
S(n / 2) = n / 2 + S(n / 4)\\
S(n / 4) = n / 4 + S(n / 8)\\
.\\
.\\
S(1) = k\cdot{1}
$$

- Adding all the above equations, we get:

$$
S(n) = n + n / 2 + n / 4 + ... + 1\\
\implies S = n(1 + 1 / 2 + 1 / 4 + ... + 1)\\
\implies S = k\cdot{n}
$$

- Therefore, the space complexity of merge sort in big O notation will be:

$$
O(n)
$$
