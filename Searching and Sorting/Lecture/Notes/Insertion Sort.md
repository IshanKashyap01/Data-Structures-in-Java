# Insertion Sort

- It inserts each element of an unsorted list into its correct position in a
sorted portion

- A single number is already sorted so it assumes the first element the sorted
portion

- It begins with the second element and swaps it with the first element if it
should come before

- Each pass it moves to the next element and swaps it until the element reaches
its correct position in the sorted portion

- Therefore, for an array of size `n`, it takes `n - 1` passes to finish

Suppose we have the following array: 32 15 34 23 12 19

First pass:

**15** 32 | 34 23 12 19

Second pass:

15 32 34 | 23 12 19

Third pass:

15 32 **23** 34 | 12 19

15 **23** 32 34 | 12 19

Fourth pass:

15 23 32 **12** 34 | 19

15 23 **12** 32 34 | 19

15 **12** 23 32 34 | 19

**12** 15 23 32 34 | 19

Fifth pass:

12 15 23 32 **19** 34 |

12 15 23 **19** 32 34 |

12 15 **19** 23 32 34 |
