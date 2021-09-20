class Trie {
    
    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> childs = new HashMap<>();
        public TrieNode() {
            
        }
        public TrieNode(boolean isWord) {
            this.isWord = isWord;
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.childs.containsKey(c)) {
                TrieNode node = new TrieNode();
                cur.childs.put(c, node);
                cur = node;
            } else {
                cur = cur.childs.get(c);
            }
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.childs.containsKey(c)) {
                return false;
            }
            cur = cur.childs.get(c);
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.childs.containsKey(c)) {
                return false;
            }
            cur = cur.childs.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */