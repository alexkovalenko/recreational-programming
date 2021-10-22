import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CanConstruct {
  public static void main(String ... args) {
    System.out.println(canConst("helloalex", List.of("hello", "alex")));
    System.out.println(canConst("programming", List.of("pr", "rog", "og", "ing", "ra", "am")));
    System.out.println(canConst("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
  }

  private static boolean canConst(String target, List<String> words) {
    System.out.print(String.format("Can we build %s from %s? ", target, words));
    Map<String, Boolean> memo = new HashMap<>();
    return canConstruct(target, words, memo);
  }

  private static boolean canConstruct(String target, List<String> words, Map<String, Boolean> memo) {
    if (target.isEmpty()) {
      return true;
    }
    if(memo.containsKey(target)) {
      return memo.get(target);
    }

    for(String word : words) {
      if (target.startsWith(word)) {
        String newTarget = target.substring(word.length());
        Boolean newTargetResult = canConstruct(newTarget, words, memo);
        if (newTargetResult) {
          memo.put(target, true);
          return true;
        }
      }
    }
    memo.put(target, false);
    return false;
  }
}
