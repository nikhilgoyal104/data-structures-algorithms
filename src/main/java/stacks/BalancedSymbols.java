package stacks;

import java.util.Stack;

public class BalancedSymbols {
  
  private static boolean isBalanced1(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char incomingCharacter = s.charAt(i);
      if (stack.isEmpty()) {
        stack.push(incomingCharacter);
        continue;
      }
      if (isMatchingPair(stack.peek(), incomingCharacter)) {
        stack.pop();
        continue;
      }
      stack.push(incomingCharacter);
    }
    return stack.isEmpty();
  }
  
  private static boolean isBalanced2(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char incomingCharacter = s.charAt(i);
      // if the stack is empty or the pair does not match
      if (stack.isEmpty() || !isMatchingPair(stack.peek(), incomingCharacter)) {
        stack.push(incomingCharacter);
        continue;
      }
      stack.pop(); // stack.isEmpty() == true && isMatchingPair == true
    }
    return stack.isEmpty();
  }
  
  private static boolean isMatchingPair(char top, char incomingCharacter) {
    return (top == '[' && incomingCharacter == ']') || (top == '{' && incomingCharacter == '}')
        || (top == '(' && incomingCharacter == ')');
  }
  
  public static void main(String[] args) {
    String[] input =
        {"", "[]", "[[][]]", "[()]{}{[()()]()}", "{{([][])}()}", ")(", "[(])", "([)]", "[{()]"};
    for (String s : input) {
      System.out.println(s + " -> " + isBalanced1(s));
    }
    System.out.println();
    for (String s : input) {
      System.out.println(s + " -> " + isBalanced2(s));
    }
  }
}
