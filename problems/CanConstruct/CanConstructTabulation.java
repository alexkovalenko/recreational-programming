import java.util.List;
import java.util.Arrays;

public class CanConstructTabulation {
  public static void main(String ... args) {
    System.out.println(canConstruct("helloalex", List.of("hello", "alex")));
    System.out.println(canConstruct("programming", List.of("pr", "rog", "og", "ing", "ra", "am")));
    System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
  }

  private static boolean canConstruct(String target, List<String> words) {
    boolean[] combinations = new boolean[target.length() + 1];
    combinations[0] = true;
    for(int i = 0; i <= target.length(); i++) {
      if(combinations[i]) {
        for(String word : words) {
          if(target.substring(i).startsWith(word)) {
            if (i + word.length() < combinations.length) combinations[i + word.length()] = true;  
          }    
        }
      }
    }
    System.out.println(Arrays.toString(combinations));
    return combinations[target.length()];
  }
}
