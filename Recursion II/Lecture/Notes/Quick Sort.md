# Quick Sort

- It is a recursive algorithm that is arguably even faster than merge sort

- Unlike merge sort, it does most of the heavy-lifting upfront

## Algorithm

1. Pick any element as a pivot

2. Move the pivot element to its correct position in the array

3. Rearrange the array around the pivot such that all elements to its left are
smaller while those to its right are larger

    - Thus dividing the array into two subsets around the pivot point

4. Call quick sort on both subsets

**hint**: count the number of elements smaller than the pivot to find its
correct position
