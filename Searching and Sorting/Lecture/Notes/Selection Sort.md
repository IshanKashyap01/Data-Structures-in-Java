# Selection Sort

- It repeatedly selects the *smallest* element from the unsorted portion of the
array and swaps it with the *first unsorted* element

- For an array of size `n`, it takes `n - 1` passes to finish sorting

- It starts from the first index of the array and goes to the second last

- Each pass, it finds the smallest number starting from the current index

- Then it swaps said number with the one at the current index

Suppose we have the following array: 32 15 34 23 12 19

The array will be sorted in the following five passes:

**12** 15 34 23 32 19

12 **15** 34 23 32 19

12 15 **19** 23 32 34

12 15 19 **23** 32 34

12 15 19 23 **32** 34
