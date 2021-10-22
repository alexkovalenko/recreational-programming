import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CountConstructTabulation {
  public static void main(String ... args) {
    System.out.println(countConstruct("helloalex", List.of("hello", "alex")));
    System.out.println(countConstruct("programming", List.of("pr", "rog", "og", "ing", "ra", "am")));
    System.out.println(countConstruct("helloalex", List.of("he", "llo", "al", "ex", "hello", "alex")));
    System.out.println(countConstruct("eeeeeeeeee", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
  }

  private static int countConstruct(String target, List<String> words) {
    int[] counts = new int[target.length() + 1];
    counts[0] = 1;
    for(int i = 0; i<= target.length(); i++) {
      if(counts[i] > 0) {
        for(String word : words) {
          if(target.substring(i).startsWith(word)) {
            counts[i + word.length()] += counts[i];  
          }    
        }
      }
    }
    return counts[target.length()];
  }
}
