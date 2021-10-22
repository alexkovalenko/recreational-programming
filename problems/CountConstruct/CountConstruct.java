import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CountConstruct {
  public static void main(String ... args) {
    System.out.println(countConst("helloalex", List.of("hello", "alex")));
    System.out.println(countConst("programming", List.of("pr", "rog", "og", "ing", "ra", "am")));
    System.out.println(countConst("helloalex", List.of("he", "llo", "al", "ex", "hello", "alex")));
    System.out.println(countConst("eeeeeeeeee", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
  }

  private static int countConst(String target, List<String> words) {
    System.out.print(String.format("count the number of ways we can build %s from %s: ", target, words));
    Map<String, Integer> memo = new HashMap<>();
    return countConstruct(target, words, memo);
  }

  private static int countConstruct(String target, List<String> words, Map<String, Integer> memo) {
    if (target.isEmpty()) {
      return 1;
    }
    if(memo.containsKey(target)) {
      return memo.get(target);
    }

    int count = 0;

    for(String word : words) {
      if (target.startsWith(word)) {
        String newTarget = target.substring(word.length());
        int newTargetResult = countConstruct(newTarget, words, memo);
        if (newTargetResult > 0) {
          count += newTargetResult;
        }
      }
    }
    memo.put(target, count);
    return count;
  }
}
