# Binary Search with Recursion

- In binary search, we divide the array into two halves and search the half
we're likely to find our target in

- In other words, we repeat the same work on increasingly smaller inputs until
we're done

- Which is why, binary search can also be implemented using recursion

## Algorithm

1. Base case: if start has crossed end, the number isn't present

2. Check if the number is at the midpoint

3. if not, assume the function can find it in the smaller half
