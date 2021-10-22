import java.util.Arrays;

public class FibTabulation {
  public static void main(String ... args) {
    System.out.println("Test: " + fib(6));
  }

  private static int fib(int n) {
    int[] fibs = new int[n];
    fibs[0] = 1;
    for (int i = 0; i < n - 1; i++) {
      fibs[i + 1] += fibs[i];
      if (i + 2 < n) fibs[i + 2] += fibs[i];
    }
    System.out.println(Arrays.toString(fibs));
    return fibs[n - 1];
  }
} 
