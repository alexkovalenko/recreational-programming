import java.util.List;
import java.util.Arrays;

public class CanSumTabulation {
  public static void main(String ... args) {
    System.out.println(canSum(7, List.of(2, 4)));
  }

  private static boolean canSum(int target, List<Integer> nums) {
    boolean[] availableSums = new boolean[target + 1];
    availableSums[0] = true;
    for(int i = 0; i < target + 1; i++) {
      if (availableSums[i]) {
        for (int n : nums) {
          int index = n + i;
          if (index <= target) availableSums[index] = true;
        }
      }
    }
    return availableSums[target];
  }
}
