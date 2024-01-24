# Dijkstra's Algorithm

- It is a **greedy algorithm** used to build an MST of a graph

- However, unlike other algorithms, it cannot work with **negative weights**

- It is a **single source shortest path** algorithm

- It keeps track of the following for each vertex:

    1. **Total distance** required to reach it from the source, and

    2. Whether it is **visited** or not

## Steps in the Algorithm

0. Initialise all pre-requisite variables, pick any vertex as the **source** and
set:

    - its distance to itself as zero, and

    - its distance to the rest as infinity

1. Pick an unvisited vertex with the **least distance** from source and mark it
visited

2. For each of its unvisited adjacent vertex:

    - If its distance to source via the current vertex is less than the present
    value:

        - Update the present distance

3. Repeat the above two steps for all unvisited vertices minus the last

## Complexity Analysis

|Operation       |Time Complexity|Space Complexity|
|----------------|---------------|----------------|
|Step 0          |           O(V)|            O(V)|
|Step 1          |           O(V)|            O(1)|
|Step 2          |           O(V)|            O(1)|
|Step 3          |         O(V^2)|            O(1)|
|Final Complexity|         O(V^2)|            O(V)|
