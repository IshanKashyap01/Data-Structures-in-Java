# Introduction to Huffman Coding

- It supports **variable length codes** to achieve low space utilisation

- For example, the string **abeec** will take 40 b of space, 8 b for each character

- In Huffman coding, each character will have a different code with varying sizes

- The characters with *less frequency* will get *more space* while ones with *more*
*frequency* will get *less space*

- Hence, the overall storage will be reduced a lot

## Example

- Suppose we have the following characters and their frequencies:
  - a: 30
  - b: 10
  - c: 8
  - d: 15
  - g: 25
  - x: 4
  - z: 2

- We will take *two* characters *with least frequency* to form a node; here it will
be **x, 4** and **z, 2**

- Make a *combination* of these two nodes and form a *dummy node* with the *sum of their
frequencies* as **6**

- Now, the two nodes with least frequencies will be 6 and **c** (8)

- Make the node **c, 8** and add the two with the parent node **14**

- Repeat this for b and d to create a *tree like structure* with a root of **39**

- Again, the least frequency is of **a** and **g** so they will form the nodes **a, 30**
and **g, 25** with parent node **55**

- Then 55 and 39 will be have a parent node of **94**

- Now our tree is complete and we only need a code for each character

- As our tree is a *binary tree*, we can code left nodes as **0** and right nodes as
**1**

- Moreover, each character node will be a leaf node

- Now, we can traverse the tree to different characters and track the path

- As "a" and "g" are at the top, their paths will be **00** and **01**

- While the path for **x** and **z** will be 1000 0 and 1000 1

- We can use these paths as the code for the characters

## How to Implement

- To store frequencies of characters, we should use a Hashmap

- For finding the characters with least frequencies, priority queues are the best

- While, for creating the tree, we should use a binary tree

- The paths can then again be stored in a Hashmap with characters and their paths
in **bits**

- Here, we can have *two hashmaps*, one with characters as key and other with their
path as a key

- The former will be used for *compression* while latter for *decompression*

## Decompression

- As each character node is a leaf, no two characters will have the same prefix

- That is, if **a** is coded as **00** no other character will start with 00

- Hence, we can find the string in just one traversal of the code
