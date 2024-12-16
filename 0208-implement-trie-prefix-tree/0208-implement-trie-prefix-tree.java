class Node {
    Node[] children;
    boolean isEndOfWord;
    
    public Node() {
        children = new Node[26];//소문자
        isEndOfWord = false;
    }
}

class Trie {
    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node current = root;
        
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            
            current = current.children[index];
        }
        
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Node node = searchNode(word);
        return node != null && node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
    
    private Node searchNode(String str) {
        Node current = root;
        
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            
            if (current.children[index] == null) {
                return null;
            }
            
            current = current.children[index];
        }
        
        return current;
    }
}