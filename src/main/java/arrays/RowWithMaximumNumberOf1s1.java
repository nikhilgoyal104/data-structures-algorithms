package arrays;

// boolean 2D array, where each row is sorted
// Time complexity = O(mlogn)

public class RowWithMaximumNumberOf1s1 {
  
  private static int[][] a = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
  
  public static void main(String[] args) {
    int maxOneCount = 0, rowNumber = 0, rowWithMaximumNumberOfOnes = 0;
    for (int[] row : a) {
      // use binary search to get the number of ones in each row O(logn)
      int oneCount = getOneCount(row);
      if (oneCount > maxOneCount) {
        maxOneCount = oneCount;
        rowWithMaximumNumberOfOnes = rowNumber;
      }
      rowNumber++;
    }
    System.out.println("Maximum number of ones " + maxOneCount);
    System.out.println("Row with maximum number of ones " + rowWithMaximumNumberOfOnes);
  }
  
  /**
   * This function uses binary search to get the number of ones by finding the first occurrence of 1
   * 
   * @param row array
   * @return number of ones in row array
   */
  private static int getOneCount(int[] row) {
    int firstOccurrenceIndex = -1;
    int low = 0;
    int high = row.length - 1;
    while (low <= high) {
      int middle = (low + high) / 2;
      if (1 < row[middle]) {
        high = middle - 1;
      } else if (1 > row[middle]) {
        low = middle + 1;
      } else {
        // last time we found our element
        firstOccurrenceIndex = middle;
        high = middle - 1;
      }
    }
    if (firstOccurrenceIndex != -1) {
      return row.length - firstOccurrenceIndex;
    }
    return 0;
  }
}
