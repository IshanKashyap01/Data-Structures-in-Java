# Prim's Algorithm

- It is a **greedy algorithm** used to build an MST of a graph

- It keeps track of the following for each vertex:

    1. Its **parent** vertex,

    2. **Weight** of the edges

    3. Whether it is **visited** or not

## Steps in the Algorithm

0. Initialise all pre-requisite variables, pick any vertex as the **source** and
set:

    - its parent as itself (or any unreachable default value)

    - the weight of this edge as 0

    - weight of all the rest as infinity

1. Pick an *unvisited* vertex as *source* with the **least weight** and mark it
**visited**

2. *For each* vertex, if it has a direct edge to the source:

    - If the weight of this edge is less than the existing one:

        - replace source as its parent

        - Change the weight

3. Repeat the above two steps for all unvisited vertices minus the last

## Complexity Analysis

|Operation       |Time Complexity|Space Complexity|
|----------------|---------------|----------------|
|Step 0          |           O(V)|            O(V)|
|Step 1          |           O(1)|            O(1)|
|Step 2          |           O(V)|            O(1)|
|Step 3          |         O(V^2)|            O(1)|
|Final Complexity|         O(V^2)|            O(V)|
