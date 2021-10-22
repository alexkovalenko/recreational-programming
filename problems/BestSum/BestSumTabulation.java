import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BestSumTabulation {
  public static void main(String ... args) {
    System.out.println(canSum(100, List.of(2, 1, 5, 25)));
  }

  private static List<Integer> canSum(int target, List<Integer> nums) {
    List[] sums = new List[target + 1];
    sums[0]  = new ArrayList<>();
    for(int i = 0; i < target + 1; i++) {
      if (sums[i] != null) {
        for (int n : nums) {
          int index = n + i;
          if (index <= target && (sums[index] == null || sums[index].size() > sums[i].size() + 1)) {
            sums[index] = merge(n, sums[i]);
          }
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
