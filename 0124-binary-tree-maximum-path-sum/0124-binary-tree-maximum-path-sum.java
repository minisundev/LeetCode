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

        cal(root);
        return max;
    }

    void cal(TreeNode tn){
        
        if(tn.left!=null){
            cal(tn.left);
        }
        if(tn.right!=null){
            cal(tn.right);
        }

        int l_max;
        int r_max;
        if(tn.left==null){
            l_max = 0;
        }else{
            l_max = tn.left.val;
        }
        if(tn.right==null){
            r_max = 0;
        }else{
            r_max = tn.right.val;
        }

        int val = tn.val;
        tn.val = Math.max(l_max+val, r_max+val);
        tn.val = Math.max(tn.val, val);//0으로 끊으시면 안되시고 지금 val로 끊어야 할 것 같음

        max = Math.max(max,l_max+val+r_max);
        max = Math.max(max,tn.val);
    }
}