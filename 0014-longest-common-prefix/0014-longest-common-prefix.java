class Solution {
    String max = "";
    int n;

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        StringBuilder sb;
        n = strs.length;

        for(String s : strs){
            sb = trie.insert(s,n);
            if(sb.length()>max.length()){
                max = sb.toString();
            }
        }
        return max;
    }
}

class Trie {
    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public StringBuilder insert(String word, int n) {
        StringBuilder sb = new StringBuilder();
        Node current = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            
            current.children[index].count = current.children[index].count+1;
            if(current.children[index].count>=n){
                sb.append(c);
            }
            current = current.children[index];
        }
        return sb;
    }
}

class Node {
    Node[] children;
    int count = 0;
    
    public Node() {
        children = new Node[26];//소문자
    }
}