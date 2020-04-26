package queues;

import lombok.Data;

@Data
class DynamicQueueUsingArray {
  private int[] nums;
  private int front = -1, rear = -1, size, capacity;
  
  public DynamicQueueUsingArray(int capacity) {
    this.capacity = capacity;
    this.nums = new int[capacity];
  }
  
  public void add(int data) {
    if (isFull()) {
      increaseCapacity();
    }
    if (isEmpty()) {
      front++;
    }
    nums[++rear] = data;
    size++;
  }
  
  // create new array with double capacity
  private void increaseCapacity() {
    createNewArray(capacity * 2);
  }
  
  public Integer poll() {
    if (isEmpty()) {
      System.out.println("Can't poll an element from queue, as it is already empty.");
      return null;
    }
    int data = nums[front];
    shiftLeft();
    rear--;
    size--;
    // we can free up extra memory when not required
    if (isShrinkable()) {
      shrink();
    }
    // if queue becomes empty during polling then we need to reset front to -1
    if (isEmpty()) {
      front = -1;
    }
    return data;
  }
  
  // create new array with half capacity
  private void shrink() {
    createNewArray(capacity / 2);
  }
  
  private boolean isShrinkable() {
    return size == capacity / 2;
  }
  
  private void createNewArray(int capacity) {
    // set the new capacity
    this.capacity = capacity;
    // create a temp array
    int[] temp = new int[capacity];
    // copy elements from nums to temp array
    for (int i = 0; i < size; i++) {
      temp[i] = nums[i];
    }
    // point nums to temp array
    nums = temp;
  }
  
  // shift elements one position to the left
  private void shiftLeft() {
    for (int i = 0; i < size - 1; i++) {
      nums[i] = nums[i + 1];
    }
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
    for (int i = 0; i < size; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    DynamicQueueUsingArray queue = new DynamicQueueUsingArray(5);
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
