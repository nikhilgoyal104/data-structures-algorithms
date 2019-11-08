package linkedList.operations;

class Node {
  
  int data;
  Node next;
  
  Node(int data) {
    this.data = data;
  }
}


class LinkedList {
  
  Node head;
  
  /**
   * Adds element to the end of the linked list
   *
   * @param data value to be added
   */
  void insertAtEnd(int data) {
    Node node = new Node(data);
    if (head == null) {
      head = node;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = node;
    }
  }
  
  /**
   * Prints the list elements
   *
   * @param head of the linked list
   */
  void display(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }
  
  
  /**
   * Reverses the linked list using recursion and only one pointer
   *
   * @param node in the list
   * @return address of last node
   */
  Node reverseRecursivelyUsingOnePointer(Node node) {
    // this will return the address of last node
    if (node == null || node.next == null) {
      return node;
    }
    // head recursion
    Node temp = reverseRecursivelyUsingOnePointer(node.next);
    node.next.next = node;
    // break the current link
    node.next = null;
    return temp;
  }
  
  /**
   * Acts as a wrapper for reverse
   */
  Node reverseRecursively() {
    // if the linked list is empty or has only one element return
    if (head == null || head.next == null) {
      return head;
    }
    return reverse(head, head.next);
  }
  
  /**
   * Reverses the linked list using recursion and two pointers
   *
   * @param p1 current node
   * @param p2 next node
   * @return address of last node
   */
  private Node reverse(Node p1, Node p2) {
    if (p2 == null) {
      head.next = null;
      head = p1;
      return head;
    }
    Node temp = p2.next;
    p2.next = p1;
    p1 = p2;
    p2 = temp;
    // tail recursion
    return reverse(p1, p2);
  }
  
  
  /**
   * Reverses the linked list iteratively
   * 
   * @return address of last node
   */
  Node reverseIteratively() {
    // if the linked list is empty or has only one element return
    if (head == null || head.next == null) {
      return head;
    }
    Node p1 = head;
    Node p2 = head.next;
    while (p2 != null) {
      Node temp = p2.next;
      p2.next = p1;
      p1 = p2;
      p2 = temp;
    }
    head.next = null;
    head = p1;
    return head;
  }
}


public class LinkedListOperations {
  
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.insertAtEnd(1);
    linkedList.insertAtEnd(2);
    linkedList.insertAtEnd(3);
    linkedList.insertAtEnd(4);
    linkedList.insertAtEnd(5);
    linkedList.display(linkedList.head);
    linkedList.head = linkedList.reverseRecursivelyUsingOnePointer(linkedList.head);
    linkedList.display(linkedList.head);
    linkedList.head = linkedList.reverseRecursively();
    linkedList.display(linkedList.head);
    linkedList.head = linkedList.reverseIteratively();
    linkedList.display(linkedList.head);
  }
}
