import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class BestSum {
  public static void main(String ... args) {
      System.out.println(howSum(10, List.of(1, 2, 3)));
      System.out.println(howSum(7, List.of(2, 3, 4, 7)));
      System.out.println(howSum(300, List.of(1, 25, 50)));
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

    List<Integer> bestSum = null;
    for(Integer n : nums) {
      int remainder = targetSum - n;
      List<Integer> remainderResult = howSum(remainder, nums, memo);
      if (remainderResult != null ) {
        List<Integer> combination = new ArrayList<>(remainderResult);
        combination.add(n);
        if (bestSum == null || combination.size() < bestSum.size()) {
          bestSum = combination;
        }
      }
    }
    
    memo.put(targetSum, bestSum);

    return bestSum;
  }
}
