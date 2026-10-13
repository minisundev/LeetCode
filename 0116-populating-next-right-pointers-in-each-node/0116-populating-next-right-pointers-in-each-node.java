/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //bfs겟죠...? 순회돌면서 넣기 근데 오른쪽부터 돌아야 왼쪽에다 넣어줄수가 있겠다 ㅎ
        //스택에다가 왼쪽부터 넣기?! 오른쪽부터 나오니깐..?!
        ArrayDeque<Node> s1 = new ArrayDeque<>();
        if(root!=null){
            s1.addLast(root);
        }
       
        while(!s1.isEmpty()){
            ArrayDeque<Node> s2 = new ArrayDeque<>();
            Node next = null;
            while(!s1.isEmpty()){
                Node last= s1.pollLast();
                last.next = next;
                next = last;

                if(last.right!=null){
                    s2.addFirst(last.right);
                }
                if(last.left!=null){
                    s2.addFirst(last.left);
                }
                
            }
            s1 = s2;
        }

        return root;
    }
}