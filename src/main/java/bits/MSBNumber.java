package bits;

public class MSBNumber {
  
  public static void main(String[] args) {
    int num = 10;
    int numberOfBits = (int) (Math.log(num) / Math.log(2)) + 1;
    System.out.println((int) Math.pow(2, numberOfBits - 1));
  }
}
