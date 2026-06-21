# Big O Notation

- Suppose we have an algorithm with the following theoretical time complexity:

$$
k_1 + k_2n + k_3n^2 + k_4\log{n}
$$

- In this equation, as `n` increases:

    1. $k_1$ remains the same

    2. $k_2n$ rise linearly

    3. $k_4\log{n}$ rise logarithmically

    4. $k_3n^2$ rise quadratically

- In *Big O notation*, we consider the term that increase the steepest and in
it, we ignore the coefficient

- In the above example, $k_3n^2$ increases the fastest, where $k_3$ is a
constant

- Therefore, the algorithm will be represented as $n^2$ in Big O notation

- In other words, it represents the worse case time complexity of an algorithm
