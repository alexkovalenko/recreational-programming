import java.util.Map;
import java.util.HashMap;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.travel(18,18));
  }

  public long travel(int n, int m) {
    Map<GridKey, Long> memo = new HashMap<>();
    return travel(n, m, memo);
  }

  private long travel(int n, int m, Map<GridKey, Long> memo) {
    GridKey k = new GridKey(n, m);
    if (memo.containsKey(k)) {
      return memo.get(k);
    }
    if (n == 1 && m == 1) {
      return 1L;
    }
    if (n == 0 || m == 0) {
      return 0L;
    }

    long r = travel(n - 1, m, memo) + travel(n, m - 1, memo);
    memo.put(k, r);
    return r;
  }

  private static class GridKey {
    private final Integer n;
    private final Integer m;
    
    public GridKey(int n, int m) {
      this.n = n;
      this.m = m;
    }

    public boolean equals(Object o) {
      GridKey k = (GridKey) o;
      return n.equals(k.n) && m.equals(k.m);
    }

    public int hashCode() {
      return n.hashCode() ^ m.hashCode();
    }
  }
}
