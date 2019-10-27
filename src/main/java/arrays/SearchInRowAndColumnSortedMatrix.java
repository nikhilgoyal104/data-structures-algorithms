package arrays;

public class SearchInRowAndColumnSortedMatrix {
  
  private static int[][] a = {{11, 21, 31, 41, 51}, {12, 22, 32, 42, 52}, {13, 23, 33, 43, 53},
      {14, 24, 34, 44, 54}, {15, 25, 35, 45, 55}};
  
  private static int element = 23;
  
  public static void main(String[] args) {
    // top right element indices
    int rowPtr = 0;
    int colPtr = a[0].length - 1;
    
    while (colPtr > 0 && element < a[rowPtr][colPtr]) {
      colPtr--;
    }
    while (rowPtr < a.length && element > a[rowPtr][colPtr]) {
      rowPtr++;
    }
    if (a[rowPtr][colPtr] == element) {
      System.out.println("Element found at indices " + rowPtr + ',' + colPtr);
    } else {
      System.out.println("Element not found");
    }
  }
}
