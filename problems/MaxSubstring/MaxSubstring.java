import java.util.List;
import java.util.ArrayList;

public class MaxSubstring {

  public static final void main(String ... args) {
    MaxSubstring maxSub = new MaxSubstring();
    System.out.println(maxSub.findLenOfMaxSubstring("abccdeffk"));
  }

  public int findLenOfMaxSubstring(String s) {
    int max = 0;
    if (s == null || s.isEmpty()) {
      return max;
    }
    List<Character> substringChars = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (substringChars.contains(c)) {
        System.out.println(substringChars);
        substringChars = new ArrayList<>();
      } 
      substringChars.add(c);
      max = Math.max(substringChars.size(), max);
    }
    return max;
  }
}
