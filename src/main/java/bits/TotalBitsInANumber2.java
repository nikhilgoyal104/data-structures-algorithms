package bits;

public class TotalBitsInANumber2 {
  
  public static void main(String[] args) {
    int n = 32;
    int totalBits = 0;
    // we wil right shift the number until it becomes zero
    while (n > 0) {
      totalBits++;
      n = n >> 1;
    }
    System.out.println(totalBits);
  }
}
