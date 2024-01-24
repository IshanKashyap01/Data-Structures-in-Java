# Kruskal's Algorithm

It is a **greedy algorithm** used to build an MST of a graph

## Steps in the Algorithm

1. Sort the edges in the ascending order of weight

2. Pick an edge and check if it adds a cycle to the MST

3. If it does not add a cycle, then add it to the graph

## Union Find Algorithm (for Cycle Detection)

1. It keeps track of a parent array where initially, each vertex is its own parent

2. For **v - 1** edges, if the two vertices have different **root** parents, the
edge can be added
    - Loop for the parent until you reach a vertex with its parent as itself

3. Now, update one of their **root parent's parent** as the that of the other

If the vertices of an edge have same *root parent*, adding this edge will create
a cycle in our MST

## Complexity Analysis

|Operation           |Time Complexity|Space Complexity|
|--------------------|---------------|----------------|
|Sort edge list      |        O(logE)|            O(E)|
|Make parent array   |           O(V)|            O(V)|
|Union Find Algorithm|          O(EV)|            O(1)|
|Final Complexity    |          O(EV)|            O(V)|
