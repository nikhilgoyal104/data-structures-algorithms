package bits;

public class TotalBitsInANumber1 {
  
  public static void main(String[] args) {
    int n = 7;
    int totalBits = (int) (Math.log(n) / Math.log(2)) + 1;
    System.out.println(totalBits);
  }
}
