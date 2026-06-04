# Bubble Sort

- It repeatedly swaps adjacent elements if they're in the wrong order until all
elements are in the correct place

- For an array of size `n`, it takes `n - 1` passes to finish sorting

- It starts with the first element of the array and compares it with the next

- If the next element should come before, it swaps the elements, otherwise it
moves to the next index

- Each pass, one element will reach its correct position starting from the last
index to the first

Suppose we have the following array: 32 15 34 23 12 19

First pass:

15 **32** 34 23 12 19 |

15 32 **34** 23 12 19 |

15 32 23 **34** 12 19 |

15 32 23 12 **34** 19 |

15 32 23 12 19 **34** |

Second pass:

15 **32** 23 12 19 | 34

15 23 **32** 12 19 | 34

15 23 12 **32** 19 | 34

15 23 12 19 **32** | 34

Third pass:

15 **23** 12 19 | 32 34

15 12 **23** 19 | 32 34

15 12 19 **23** | 32 34

Fourth pass:

**12** 15 19 | 23 32 34

12 **15** 19 | 23 32 34

Fifth pass:

**12** 15 | 19 23 32 34
