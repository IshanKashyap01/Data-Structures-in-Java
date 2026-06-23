# Theoretical Analysis: Quick Sort

```java
private static void quickSort(int[] arr, int start, int end)
{
    if(start >= end)
    {
        return;
    }
    int pivot = (int) (Math.random() * (end - start + 1)) + start;
    pivot = placePivot(arr, start, end, pivot);
    partition(arr, start, end, pivot);
    quickSort(arr, start, pivot - 1);
    quickSort(arr, pivot + 1, end);
}
```

- In the above code, we're using a random pivot, which means the code will run
slightly differently each time

- Therefore, we're not likely to run into the worst case scenario every call

- Hence, we will be talking about the *average-case* instead of the worst

- For that, we will assume that our pivot lands in the middle of the array each
time

## Time Complexity

- The recurrence relation for the above code, considering our assumption, will
be:

$$
T(n) = kn + 2T(n / 2)
$$

- Which is the same recurrence relation as that of [merge sort](Merge%20Sort.md)

- Therefore, the average-case time complexity of the quick sort (using random
pivot) in big O notation will be:

$$
O(n\log{n})
$$

## Space Complexity

- In the above code, we only use one variable `pivot` therefore, only using
constant space *per call*

$$
S(n) = k + S(n / 2)
$$

- However, there will be $\log{n}$ functions in the call stack at peak memory
usage

$$
S(n / 2) = k + S(n / 4)\\
S(n / 4) = k + S(n / 8)\\
.\\
.\\
S(1) = k
$$

$$
\implies{S(n) = k\cdot{\log_2{n}}}
$$

- Therefore, our average-case space complexity for quick sort (using random
pivot) will be:

$$
O(\log{n})
$$

**Note**: even if we assume that on average, our pivot splits the array, say,
$(n / 4, 3n/4)$, the only thing that changes will be the base of the logarithm,
which still leads to the same time and space complexity.
