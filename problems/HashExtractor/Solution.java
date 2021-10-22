import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Solution {
  
  public static void main(String[] args) {
            System.out.println(new Solution().extractHashes(List.of(
                "#first asfasd  sdf sdf sdfsdf sddd dsdfsd sdfsdf #second #first asfd sdf sdf",
                "asdf #second sdfs",
                "#third test sdfsdf #third #third #third sdfsd sdfsd #first"
        )));
  }

  private List<String> extractHashes(List<String> twits) {
    return twits.stream()
            .filter(Objects::nonNull)
            .flatMap(twit -> Stream.of(twit.split(" ")))
            .filter(word -> word.startsWith("#"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
  }

  private <T> List<T> emptyIfNull(List<T> list) {   
    return list == null || list.isEmpty() ? Collections.emptyList() : list;
  }
}
