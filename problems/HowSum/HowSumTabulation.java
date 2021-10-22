import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class HowSumTabulation {
  public static void main(String ... args) {
    System.out.println(canSum(7, List.of(3, 4, 5)));
  }

  private static List<Integer> canSum(int target, List<Integer> nums) {
    List[] sums = new List[target + 1];
    sums[0]  = new ArrayList<>();
    for(int i = 0; i < target + 1; i++) {
      if (sums[i] != null) {
        for (int n : nums) {
          int index = n + i;
          if (index <= target) sums[index] = merge(n, sums[i]);
        }
      }
    }
    System.out.println(Arrays.deepToString(sums));
    return sums[target];
  }

  private static List<Integer> merge(int n, List<Integer> sum) {
    List<Integer> merged = new ArrayList<>();
    merged.addAll(sum);
    merged.add(n);
    return merged;
  }
}
