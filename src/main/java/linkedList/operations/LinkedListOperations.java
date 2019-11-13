package linkedList.operations;

class Node {
  
  int data;
  Node next;
  
  Node(int data) {
    this.data = data;
  }
}


/**
 * 1. insertAtEnd 2. insertAtBeginning 3. insertAt 4. display 5. reverseRecursivelyUsingOnePointer
 * 6. reverseRecursively 7. reverseIteratively 8. delete 9. deleteAt 10. search 11. getSize
 */
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
   * Inserts node at the beginning of linked list
   * 
   * @param data to be inserted
   */
  void insertAtBeginning(int data) {
    Node node = new Node(data);
    node.next = head;
    head = node;
  }
  
  boolean insertAt(int index, int data) {
    if (index < 0 || index > getSize()) {
      return false;
    }
    Node node = new Node(data);
    Node temp = head;
    if (index == 0) {
      insertAtBeginning(data);
    } else {
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      node.next = temp.next;
      temp.next = node;
    }
    return true;
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
  Node reverseRecursivelyUsingOnePointer1(Node node) {
    // node == null handles empty list
    // this will return the address of last node
    if (node == null || node.next == null) {
      return node;
    }
    // head recursion
    Node temp = reverseRecursivelyUsingOnePointer1(node.next);
    node.next.next = node;
    // break the current link
    node.next = null;
    return temp;
  }
  
  /**
   * Reverses the linked list using recursion and only one pointer
   *
   * @param node in the list
   */
  void reverseRecursivelyUsingOnePointer2(Node node) {
    // node == null handles empty list
    // this will assign head to the address of last node
    if (node == null || node.next == null) {
      head = node;
      return;
    }
    // head recursion
    reverseRecursivelyUsingOnePointer2(node.next);
    node.next.next = node;
    // break the current link
    node.next = null;
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
  
  /**
   * Deletes a node with given value
   * 
   * @param value to be deleted
   * @return true if the value is deleted
   */
  boolean delete(int value) {
    // delete head node
    if (head.data == value) {
      head = head.next;
      return true;
    }
    
    Node temp = head;
    Node previous = head;
    while (temp != null) {
      if (temp.data == value) {
        previous.next = temp.next;
        return true;
      }
      previous = temp;
      temp = temp.next;
    }
    return false;
  }
  
  boolean deleteAt(int index) {
    if (index < 0 || index > getSize() - 1) {
      return false;
    }
    // delete head element
    if (index == 0) {
      head = head.next;
    } else {
      Node temp = head;
      Node previous = head;
      for (int i = 0; i < index; i++) {
        previous = temp;
        temp = temp.next;
      }
      previous.next = temp.next;
      return true;
    }
    return false;
  }
  
  /**
   * Searches for the value in the linked list
   * 
   * @param value to be searched
   * @return index of the value if it is present else -1
   */
  int search(int value) {
    Node temp = head;
    int index = 0;
    while (temp != null) {
      if (temp.data == value) {
        return index;
      }
      temp = temp.next;
      index++;
    }
    return -1;
  }
  
  /**
   * Calculates the size of the linked list
   * 
   * @return size of the linked list
   */
  private int getSize() {
    int size = 0;
    Node temp = head;
    while (temp != null) {
      size++;
      temp = temp.next;
    }
    return size;
  }
}


public class LinkedListOperations {
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);
    list.insertAtEnd(4);
    list.insertAtEnd(5);
    list.display(list.head);
    // list.head = list.reverseRecursivelyUsingOnePointer1(list.head);
    list.reverseRecursivelyUsingOnePointer2(list.head);
    list.display(list.head);
    list.head = list.reverseRecursively();
    list.display(list.head);
    list.head = list.reverseIteratively();
    list.display(list.head);
    print(list.search(3));
    print(list.search(5));
    print(list.delete(3));
    print(list.delete(5));
    list.display(list.head);
    print(list.delete(1));
    list.display(list.head);
    list.insertAtBeginning(5);
    list.insertAtBeginning(6);
    list.display(list.head);
    print(list.deleteAt(1));
    print(list.deleteAt(3));
    list.display(list.head);
    print(list.insertAt(1, 5));
    list.display(list.head);
    print(list.insertAt(3, 3));
    list.display(list.head);
    print(list.insertAt(5, 1));
    list.display(list.head);
  }
  
  private static void print(Object o) {
    System.out.println(o);
  }
}
