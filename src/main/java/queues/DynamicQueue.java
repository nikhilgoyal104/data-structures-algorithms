package queues;

import lombok.Data;


interface IDynamicQueue {
  void add(int data);
  
  Integer poll();
  
  boolean isEmpty();
  
  void display();
  
  int size();
}


@Data
// add amortized O(1) poll O(n)
class DynamicQueueUsingArray implements IDynamicQueue {
  private int[] nums;
  private int rear = -1;
  private int capacity;
  
  public DynamicQueueUsingArray(int capacity) {
    this.capacity = capacity;
    this.nums = new int[capacity];
  }
  
  public void add(int data) {
    if (isFull()) {
      increaseCapacity();
    }
    nums[++rear] = data;
  }
  
  private void increaseCapacity() {
    // create new array with double capacity
    createNewArray(capacity * 2);
  }
  
  private void createNewArray(int capacity) {
    // set the new capacity
    this.capacity = capacity;
    // create a temp array
    int[] temp = new int[capacity];
    // copy elements from nums to temp array
    for (int i = 0; i < rear + 1; i++) {
      temp[i] = nums[i];
    }
    // point nums to temp array
    nums = temp;
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
  
  private boolean isFull() {
    return rear + 1 == capacity;
  }
}


@Data
// add amortized O(1) poll O(1)
class DynamicQueueUsingCircularArray implements IDynamicQueue {
  private int[] nums;
  private int front, rear = -1, size, capacity;
  
  public DynamicQueueUsingCircularArray(int capacity) {
    this.capacity = capacity;
    this.nums = new int[capacity];
  }
  
  public void add(int data) {
    if (isFull()) {
      increaseCapacity();
    }
    rear = (rear + 1) % capacity;
    nums[rear] = data;
    size++;
  }
  
  private void increaseCapacity() {
    // create new array with double capacity
    createNewArray(capacity * 2);
  }
  
  private void createNewArray(int capacity) {
    // set the new capacity
    this.capacity = capacity;
    // create a temp array
    int[] temp = new int[capacity];
    // copy elements from nums to temp array
    for (int i = 0; i < rear + 1; i++) {
      temp[i] = nums[i];
    }
    // point nums to temp array
    nums = temp;
  }
  
  public Integer poll() {
    if (isEmpty()) {
      System.out.println("Can't poll an element from queue, as it is already empty.");
      return null;
    }
    int data = nums[front];
    front = (front + 1) % capacity;
    return data;
  }
  
  public boolean isEmpty() {
    return size == 0;
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
  
  private boolean isFull() {
    return size == capacity;
  }
}


class DynamicQueue {
  public static void main(String[] args) {
    // DynamicQueueUsingArray queue = new DynamicQueueUsingArray(5);
    DynamicQueueUsingCircularArray queue = new DynamicQueueUsingCircularArray(5);
    queue.add(4);
    queue.add(5);
    queue.add(7);
    queue.add(3);
    queue.add(9);
    queue.add(11);
    queue.add(42);
    queue.add(64);
    System.out.println(queue);
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue);
    queue.add(100);
    System.out.println(queue);
  }
}
