package study.practice.dataStructure.trie.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Baekjoon5052 {

    public static void run(){

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int resultSize = Integer.parseInt(br.readLine());
            String[] results = new String[resultSize];

            for (int i = 0; i < resultSize; i++) {
                int loop = Integer.parseInt(br.readLine());
                Trie trie = new Trie();
                results[i] = "YES";
                List<String> list = new ArrayList<>();
                for (int j = 0; j < loop; j++) {
                    String num = br.readLine();
                    trie.insert(num);
                    list.add(num);
                }
                for (String num : list) {
                    boolean search = trie.search(num);
                    if(!search){
                        results[i] = "NO";
                        break;
                    }
                }
            }

            for (String result : results) {
                System.out.println(result);
            }
        }catch (Exception e){
        }
    }

    public static class Node {
        HashMap<Character, Node> child;
        boolean endOfWord;

        public Node() {
            this.child = new HashMap<>();
            this.endOfWord = false;
        }
    }

    public static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String str){
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                node.child.putIfAbsent(c, new Node());
                node = node.child.get(c);
            }
            node.endOfWord = true;
        }

        public boolean search(String str){
            Node node = this.root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(node.child.containsKey(c)){
                    if(node.endOfWord){
                        return false;
                    }else{
                        node = node.child.get(c);
                    }
                }else{
                    return false;
                }
            }
            return node.endOfWord;
        }

        public boolean delete(String str){
            return delete(this.root, str, 0);
        }

        private boolean delete(Node node, String str, int index){
            char c = str.charAt(index);

            if(!node.child.containsKey(c)){
                return false;
            }

            Node cur = node.child.get(c);
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
}
