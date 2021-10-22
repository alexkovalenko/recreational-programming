import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class HowSum {
  public static void main(String ... args) {
      System.out.println(howSum(0, List.of(1, 2, 3)));
      System.out.println(howSum(7, List.of(2, 3, 4, 7)));
      System.out.println(howSum(300, List.of(7, 14)));
  }

  private static List<Integer> howSum(int targetSum, List<Integer> nums) {
    Map<Integer, List<Integer>> memo = new HashMap<>();
    return howSum(targetSum, nums, memo);
  }
  
  private static List<Integer> howSum(int targetSum, List<Integer> nums, Map<Integer, List<Integer>> memo) {
    if (targetSum == 0) 
      return new ArrayList<>();
    if (targetSum < 0)
      return null;
    if (memo.containsKey(targetSum))
      return memo.get(targetSum);

    for(Integer n : nums) {
      int remainder = targetSum - n;
      List<Integer> parts = howSum(remainder, nums, memo);
      if (parts != null) {
        parts.add(n);
        memo.put(targetSum, parts);
        return parts;
      }
    }

    memo.put(targetSum, null);
    return null;
  }
}
