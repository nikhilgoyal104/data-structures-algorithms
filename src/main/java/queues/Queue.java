package queues;

import lombok.Data;

interface IQueue {
  void add(int data);
  
  Integer poll();
  
  boolean isEmpty();
  
  boolean isFull();
  
  void display();
  
  int size();
}


@Data
// time complexities => add = O(1), poll = O(n)
class QueueUsingArray implements IQueue {
  private int[] nums;
  private int rear = -1, capacity;
  
  public QueueUsingArray(int capacity) {
    this.capacity = capacity;
    this.nums = new int[capacity];
  }
  
  public void add(int data) {
    if (isFull()) {
      System.out.println("Can't add " + data + " to queue, as it is already full.");
      return;
    }
    nums[++rear] = data;
  }
  
  public Integer poll() {
    if (isEmpty()) {
      System.out.println("Can't poll an element from queue, as it is already empty.");
      return null;
    }
    int data = nums[0];
    shiftLeft();
    rear--;
    return data;
  }
  
  // shift elements one position to the left
  private void shiftLeft() {
    for (int i = 0; i < rear; i++) {
      nums[i] = nums[i + 1];
    }
  }
  
  public boolean isEmpty() {
    return rear == -1;
  }
  
  public boolean isFull() {
    return rear + 1 == capacity;
  }
  
  public void display() {
    if (isEmpty()) {
      System.out.println("Nothing to display. Queue is empty.");
      return;
    }
    for (int i = 0; i < rear + 1; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }
  
  public int size() {
    return rear + 1;
  }
}


@Data
// time complexities => add = O(1), poll = O(1)
class QueueUsingCircularArray implements IQueue {
  private int[] nums;
  private int front, rear = -1, size, capacity;
  
  public QueueUsingCircularArray(int capacity) {
    this.capacity = capacity;
    this.nums = new int[capacity];
  }
  
  public void add(int data) {
    if (isFull()) {
      System.out.println("Can't add " + data + " to queue, as it is already full.");
      return;
    }
    rear = (rear + 1) % capacity;
    nums[rear] = data;
    size++;
  }
  
  public Integer poll() {
    if (isEmpty()) {
      // reset front and rear to initial state
      front = 0;
      rear = -1;
      System.out.println("Can't poll an element from queue, as it is already empty.");
      return null;
    }
    int data = nums[front];
    front = (front + 1) % capacity;
    size--;
    return data;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public boolean isFull() {
    return size == capacity;
  }
  
  public void display() {
    if (isEmpty()) {
      System.out.println("Nothing to display. Queue is empty.");
      return;
    }
    for (int i = front; i < front + size; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }
  
  public int size() {
    return size;
  }
}


class Queue {
  public static void main(String[] args) {
    // QueueUsingArray queue = new QueueUsingArray(5);
    QueueUsingCircularArray queue = new QueueUsingCircularArray(5);
    queue.add(4);
    queue.add(5);
    queue.add(7);
    System.out.println(queue);
    System.out.println(queue.poll());
    System.out.println(queue);
    System.out.println(queue.poll());
    System.out.println(queue);
    queue.display();
    System.out.println(queue.poll());
    System.out.println(queue);
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue);
    System.out.println(queue.poll());
    queue.add(4);
    queue.add(5);
    queue.add(7);
    queue.add(3);
    System.out.println(queue);
  }
}
