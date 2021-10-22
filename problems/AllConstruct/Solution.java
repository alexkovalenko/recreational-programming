import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Solution {
  public static void main(String ... args) {
    Solution solution = new Solution();
    System.out.println(solution.allConst("helloalex", List.of("hello", "alex")));
    System.out.println(solution.allConst("programming", List.of("pr", "rog", "og", "ing", "ra", "am")));
    System.out.println(solution.allConst("helloalex", List.of("he", "llo", "al", "ex", "hello", "alex")));
    System.out.println(solution.allConst("eeeeeeeeee", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
  }

  public List<List<String>> allConst(String target, List<String> words) {
    System.out.print(String.format("all the number of ways we can build %s from %s: ", target, words));
    Map<String, List<List<String>>> memo = new HashMap<>();
    return allConstruct(target, words, memo);
  }

  public List<List<String>> allConstruct(String target, List<String> words, Map<String, List<List<String>>> memo) {
    if (target.isEmpty()) {
      List<List<String>> allList = new ArrayList<>();
      allList.add(new ArrayList<String>());
      return allList;
    }
    
    if (memo.containsKey(target)) {
      return memo.get(target);
    }
    
    List<List<String>> allWays = new ArrayList<>();

    for(String word : words) {
      if (target.startsWith(word)) {
        String suffix = target.substring(word.length());
        List<List<String>> suffixWays = allConstruct(suffix, words, memo);
        suffixWays.stream()
          .map(list -> {
            List<String> withTarget = new ArrayList<>();
            withTarget.add(word);
            withTarget.addAll(list);
            return withTarget;
          })
          .forEach(list -> allWays.add(list));
      }
    }
    memo.put(target, allWays);
    return allWays;
  }
}
