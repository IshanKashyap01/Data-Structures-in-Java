# Heap

A Heap is a **complete binary tree** that follows the **heap order property**

## Complete Binary Tree (CBT)

- Internally, it uses an ```ArrayList``` to store elements in level-order

- The index of left and right children is always $2i + 1$ and $2i + 2$ respectively

- Similary, the parent index will always be $i - 1 \over 2$

## Properties of a CBT

1. All levels should be completely filled except the last one

2. In each level, elements should be entered left to right

3. Similarly, deletion should be done right to left

Hence, the height will always remain $log_2n$

## Heap Order Property

- It states that a parent must always have a **higher precedence** than its children

- However, the order among the children doesn't matter

- A heap can be either a **min heap** or a **max heap**

- Precedence *increases* in *descending* order in a *min heap* and in *ascending* order
in a *max heap*
