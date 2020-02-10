package queues;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {
  
  private Queue<Integer> reverse(Queue<Integer> queue) {
    if (queue.isEmpty()) {
      return queue;
    }
    int data = queue.poll();
    // not catching the return value and just using reverse(queue) will also work
    queue = reverse(queue);
    // add element stored in the function call stack to the queue while coming down the recursive
    // function calls
    queue.add(data);
    return queue;
  }
  
  public static void main(String[] args) {
    ReverseQueueUsingRecursion reverseQueueUsingRecursion = new ReverseQueueUsingRecursion();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(3);
    queue.add(5);
    queue.add(7);
    queue.add(9);
    System.out.println(queue);
    System.out.println(reverseQueueUsingRecursion.reverse(queue));
  }
}
