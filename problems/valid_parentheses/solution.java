class Solution {
    
    private final Map<Character, Character> parentheses = Map.of('(', ')', '{', '}', '[', ']');
    
    public boolean isValid(String s) {
        Deque<Character> lefts = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (isLeft(c)) {
                lefts.push(c);
            } 
            
            if(lefts.isEmpty()) {
                return false;
            }
            
            if (isRight(c)) {
                Character l = lefts.pop();
                if (!parentheses.get(l).equals(c)) {
                    return false;
                }
            } 
        }
        return lefts.isEmpty();
    }
    
    private boolean isLeft(Character l) {
        return Objects.nonNull(l) && parentheses.containsKey(l);
    }
    
    private boolean isRight(Character r) {
        return Objects.nonNull(r) && parentheses.containsValue(r);
    }
}