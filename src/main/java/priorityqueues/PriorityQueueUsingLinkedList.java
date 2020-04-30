package priorityqueues;


import lombok.Data;

@Data
class Node {
  int data;
  int priority; // lower value indicate higher priority
  Node next;
}


// linked list impl time complexities => peek = O(1), push = O(n), pop = O(1)
// binary heap impl time complexities => peek = O(1), push = O(logn), pop = O(logn)
@Data
public class PriorityQueueUsingLinkedList {
  public static void main(String[] args) {
    
  }
}
