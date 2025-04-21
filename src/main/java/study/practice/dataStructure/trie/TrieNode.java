package study.practice.dataStructure.trie;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> child;
    boolean endOfWord;

    public TrieNode() {
        this.child = new HashMap<>();
        this.endOfWord = false;
    }
}
