# Types of Linked List

## Singly Linked List

- In this version, every node on the list points to the next

- The last node points to nothing (`null`)

- Although, very simple to implement, it only allows one-way traversal and
cannot be fully traversed without the head of the list

## Circular Linked List

- The tail points to the head making the list a circle

- This allows you to traverse the entire linked list with any node on the list

```java
Node<Integer> temp = head;
do
{
    ...
}while(temp.next != head);
```

- The end condition for traversal also, therefore, changes to when you reach
back to the point you started

## Doubly Linked List

- Every node contains both the next and the previous element in the list

- This allows for two-way traversal making it the most commonly used version of
linked list

## Doubly Circular Linked List

- The first and last node points to each other making the list doubly and
circular

- This leads to very fast insertions at the beginning
