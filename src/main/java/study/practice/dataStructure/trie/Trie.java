package study.practice.dataStructure.trie;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String str){
        TrieNode node = this.root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            node.child.putIfAbsent(c, new TrieNode());
            node = node.child.get(c);
        }
        node.endOfWord = true;
    }

    public boolean search(String str){
        TrieNode node = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(node.child.containsKey(c)){
                node = node.child.get(c);
            }else{
                return false;
            }
        }
        return node.endOfWord;
    }

    public boolean delete(String str){
        return delete(this.root, str, 0);
    }

    private boolean delete(TrieNode node, String str, int index){
        char c = str.charAt(index);

        if(!node.child.containsKey(c)){
            return false;
        }

        TrieNode cur = node.child.get(c);
        index++;
        if(index == str.length()){
            if(!cur.endOfWord){
                return false;
            }

            cur.endOfWord = false;

            if(cur.child.isEmpty()){
                node.child.remove(c);
            }

        }else{
            if(!this.delete(cur, str, index)){
                return false;
            }

            if(!cur.endOfWord && cur.child.isEmpty()){
                node.child.remove(c);
            }
        }
        return true;
    }
}
