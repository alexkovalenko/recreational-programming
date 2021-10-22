import java.util.Map;
import java.util.HashMap;

public class Solution {     
    public static void main(String[] args) throws Exception { 
      Solution solution = new Solution();
      try (Timer t = new Timer()) {
        System.out.println(solution.fib(50));
      }
      try (Timer t = new Timer()) {
        System.out.println(solution.fibNoMemo(50));
      }
    } 

    static class Timer implements AutoCloseable {
      private final long startTime;

      public Timer() {
        this.startTime = System.currentTimeMillis();
        System.out.println("Start: " + this.startTime);
      }


      public void close() {
        System.out.println("Finish: " + (System.currentTimeMillis() - this.startTime) + " millis");
      }
    }

    public int fib(int n) {
      Map<Integer, Integer> memo = new HashMap<>();
      int r = fib(n, memo);
      System.out.println(memo);
      return r;
    }

    private int fib(int n, Map<Integer,Integer> memo) {
      if (memo.containsKey(n)) {
        return memo.get(n);
      }
      if (n <= 2) {
        return 1;
      }
      
      int r = fib(n - 1, memo) + fib(n - 2, memo);
      memo.put(n, r);
      return r;
    }     
    
    public int fibNoMemo(int n) {
      if (n <= 2) {
        return 1;
      }

      return fibNoMemo(n - 1) + fibNoMemo(n - 2);
    }
} 
