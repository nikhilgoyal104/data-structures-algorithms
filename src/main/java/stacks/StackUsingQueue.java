package stacks;


import java.util.LinkedList;
import java.util.Queue;

// Two Queues, push - O(1), pop O(n)
class StackUsingQueue1 {
  
  private Queue<Integer> queue1 = new LinkedList<>();
  // the last inserted element could be removed only after all elements, except it, have been
  // removed. For this reason we need to maintain additional queue q2, which will serve as a
  // temporary storage to enqueue the removed elements from q1
  private Queue<Integer> queue2 = new LinkedList<>();
  
  // 1 enq operation hence push = O(1)
  public void push(int data) {
    queue1.add(data);
  }
  
  // n dqs from q1 and n-1 enqs to q2, which gives 2n-1 operations, hence pop = O(n)
  public Integer pop() {
    // leave one element in q1 and push others to q2
    while (queue1.size() > 1) {
      queue2.add(queue1.poll());
    }
    // fetch the one element left in q1
    Integer top = queue1.poll();
    // we swap q1 with q2 to avoid copying all elements from q2 to q1
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    return top;
  }
}


// Two Queues, push - O(n), pop O(1)
class StackUsingQueue2 {
  
  private Queue<Integer> queue1 = new LinkedList<>();
  private Queue<Integer> queue2 = new LinkedList<>();
  
  // n+1 enqs to q2 and n dqs from q1, which gives 2n+1 operations , hence push = O(n)
  public void push(int data) {
    queue2.add(data);
    while (!queue1.isEmpty()) {
      queue2.add(queue1.poll());
    }
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
  }
  
  public Integer pop() {
    return queue1.poll();
  }
  
}


// One Queue, push - O(n), pop O(1)
class StackUsingQueue3 {
  
  private Queue<Integer> queue = new LinkedList<>();
  
  // n+1 enqs and n dqs, which gives 2n+1 operations, hence push = O(n)
  public void push(int data) {
    int size = queue.size();
    queue.add(data);
    // pop (or dequeue) all previous elements and put them after current element
    for (int i = 0; i < size; i++) {
      // this will add front element into rear of queue
      queue.add(queue.poll());
    }
  }
  
  public Integer pop() {
    return queue.poll();
  }
  
}


class StackUsingQueue {
  // Driver method
  public static void main(String[] args) {
    StackUsingQueue3 stackUsingQueue = new StackUsingQueue3();
    stackUsingQueue.push(1);
    stackUsingQueue.push(2);
    stackUsingQueue.push(3);
    System.out.println(stackUsingQueue.pop());
    System.out.println(stackUsingQueue.pop());
    stackUsingQueue.push(4);
    System.out.println(stackUsingQueue.pop());
    System.out.println(stackUsingQueue.pop());
    System.out.println(stackUsingQueue.pop());
  }
}
