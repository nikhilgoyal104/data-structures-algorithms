package arrays;

// boolean 2D array, where each row is sorted
// Time complexity = O(m+n)

public class RowWithMaximumNumberOf1s2 {
  private static int[][] a = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
  
  public static void main(String[] args) {
    // top right element indices
    int rowPtr = 0;
    int colPtr = a[0].length - 1;
    int maxOneCount = 0, rowWithMaximumNumberOfOnes = 0;
    
    while (rowPtr < a.length) {
      // till the element is 1 we keep moving left
      while (colPtr >= 0 && a[rowPtr][colPtr] == 1) {
        colPtr--;
        maxOneCount++;
        rowWithMaximumNumberOfOnes = rowPtr;
      }
      rowPtr++;
    }
    System.out.println("Maximum number of ones " + maxOneCount);
    System.out.println("Row with maximum number of ones " + rowWithMaximumNumberOfOnes);
  }
}
