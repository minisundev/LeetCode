/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //왼쪽길, 오른쪽길로 나눠서 쭉 위로 연결시키고 지금 value를 더해서 max를 업데이트 쳐야해요~
        //this.max = min(l.max+this.val , this.val+r.max, l.max+this.val+r.max) 
        Node head = new Node();
        copy(root,head);

        return max;
    }

    void copy(TreeNode tn, Node n){
        
        if(tn.left!=null){
            n.left = new Node();
            copy(tn.left, n.left);
        }
        if(tn.right!=null){
            n.right = new Node();
            copy(tn.right, n.right);
        }

        cal(tn,n);
    }

    void cal(TreeNode tn,Node n){
        int l_max;
        int r_max;
        if(n.left==null){
            l_max = 0;
        }else{
            l_max = n.left.max;
        }
        if(n.right==null){
            r_max = 0;
        }else{
            r_max = n.right.max;
        }

        //왼쪽길, 오른쪽길로 나눠서 쭉 위로 연결시키고 지금 value를 더해서 max를 업데이트 쳐야해요~
        //this.max = min(l.max+this.val , this.val+r.max) 
        //혹은 저것들이 다 0보다 작다면 아예 포함 안 하고 끊어버려서 0으로 만들어버리는 방법이 있습니다
        n.max = Math.max(l_max+tn.val, r_max+tn.val);
        n.max = Math.max(n.max, tn.val);//0으로 끊으시면 안되시고 지금 val로 끊어야 할 것 같음

        max = Math.max(max,l_max+tn.val+r_max);
        max = Math.max(max,n.max);
    }
}

class Node{
    public int max = 0;
    public Node left;
    public Node right;
    public Node(){}
}