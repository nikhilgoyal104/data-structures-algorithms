package priorityqueues;


import lombok.Data;

@Data
class Node {
  int data;
  // lower values indicate higher priority
  int priority;
  Node next;
}


// linked list implementation time complexities => peek = O(1), push = O(n), pop = O(1)
// binary heap implementation time complexities => peek = O(1), push = O(logn), pop = O(logn)
@Data
public class PriorityQueueUsingLinkedList {
  public static void main(String[] args) {
    
  }
}
