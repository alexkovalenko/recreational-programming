import java.util.Map;
import java.util.HashMap;


public class Solution {

  public static void main(String ... args) {
    Solution solution = new Solution();
    System.out.println(solution.canSum(7, new int[]{2, 3}));
    System.out.println(solution.canSum(30000, new int[]{7, 14}));
  }

  public boolean canSum(int targetSum, int[] nums) {
    Map<Integer, Boolean> memo = new HashMap<>();
    return canSum(targetSum, nums, memo);
  }

  private boolean canSum(int targetSum, int[] nums, Map<Integer, Boolean> memo) {
    if (memo.containsKey(targetSum)) return memo.get(targetSum);
    if (targetSum == 0) return true;
    if (targetSum < 0) return false;
    for(int n : nums) {
      int remainder = targetSum - n;
      if (canSum(remainder, nums, memo)) return true;
    }
    memo.put(targetSum, false);
    return false;
  }
}
