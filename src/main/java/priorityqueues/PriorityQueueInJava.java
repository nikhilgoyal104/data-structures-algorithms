package priorityqueues;


import java.util.Comparator;
import java.util.PriorityQueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
  String name;
  double cgpa;
}


class StudentComparator implements Comparator<Student> {
  @Override
  public int compare(Student s1, Student s2) {
    return Double.compare(s2.cgpa, s1.cgpa);
  }
}


@Data
// the elements of the priority queue are ordered according to the natural ordering, or by a
// comparator provided at queue construction time, depending on which constructor is used
// the head of this queue is the least element with respect to the specified ordering.

// priority queue is like a regular queue, but each element has a “priority” associated with it
// in a priority queue, an element with high priority is served before an element with low priority
public class PriorityQueueInJava {
  
  public static void main(String[] args) {
    PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();
    priorityQueue.add(5);
    priorityQueue.add(10);
    priorityQueue.add(3);
    priorityQueue.add(20);
    priorityQueue.add(9);
    System.out.println(priorityQueue.peek());
    priorityQueue.remove();
    System.out.println(priorityQueue.peek());
    PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(new StudentComparator());
    studentPriorityQueue.add(new Student("Nikhil", 7.8));
    studentPriorityQueue.add(new Student("Ankit", 8.4));
    System.out.println(studentPriorityQueue.peek());
  }
}
