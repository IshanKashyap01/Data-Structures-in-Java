# Heap Sort

- It utilises the heap order property of heaps to sort the array

- We can just enter and remove elements from a heap to sort the array

- However, this would cause space complexity to be **O(n)**

- We can achieve **O(1)** space complexity by using *in-place* heap sort

- However, the time complexity will remain **O(nlogn)**

## In-place Heap Sort

1. Divide the array into two parts viz. max heap and array

2. The first element is the part of our heap

3. Add the next element in the array into the heap until all elements are added

4. Now, remove the max element from the heap but don't delete them from the array

5. Repeat until there are no elements in the heap

## Optimised In-place Heap Sort

1. Consider the whole array as a heap

2. Apply down heapify operation on all the non-leaf nodes to construct the heap

    - In a CBT, there are always **n/2** leaf nodes

    - Hence, there are **n - n/2**  non-leaf nodes

    - Therefore, down heapify all elements from **n/2 - 1** to **1**

3. Now, remove the max element from the heap but don't delete them from the array

4. Repeat until there are no elements in the heap

Although, the overall time complexity will remain **O(nlogn)**, the time complexity
of *building the heap* is decreased to **O(n)**
