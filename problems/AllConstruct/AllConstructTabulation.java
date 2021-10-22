import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AllConstructTabulation {
  public static void main(String ... args) {
    System.out.println(allConstruct("helloalex", List.of("hello", "alex")));
    System.out.println(allConstruct("programming", List.of("pr", "rog", "og", "ing", "ra", "am")));
    System.out.println(allConstruct("helloalex", List.of("he", "llo", "al", "ex", "hello", "alex")));
    System.out.println(allConstruct("eeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
  }

  private static List<List<String>> allConstruct(String target, List<String> words) {
    List[] table = new List[target.length() + 1];
    for(int i = 0; i <= target.length(); i++) {
      table[i] = new ArrayList<List<String>>();
    }
    table[0].add(new ArrayList<String>());
    for(int i = 0; i <= target.length(); i++) {
      for(String word : words) {
        if(target.substring(i).startsWith(word)) {
          final int index = i + word.length();
          table[i].stream()
            .map(list -> {
              List<String> withWord = new ArrayList<>();
              withWord.addAll((List<String>)list);
              withWord.add(word);
              return withWord;
            })
            .forEach(list -> table[index].add(list));
        }
      }
    }
    return table[target.length()];
  }
 }
