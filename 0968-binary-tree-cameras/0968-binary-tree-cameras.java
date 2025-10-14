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

    public int minCameraCover(TreeNode root) {
        /*트리 dp 골조 만들기~*/
        TreeNode head = root;
        Node node = new Node();
        copy(head, node, 1);

        return Math.min(node.c, node.i);

    }

    void cal(Node n) {
        int l_c;
        int l_n;
        int l_i;
        int r_c;
        int r_n;
        int r_i;

        if (n.left == null) {
            l_c = 0;
            l_n = Integer.MAX_VALUE/2;
            l_i = 1;
        } else {
            l_c = n.left.c;
            l_n = n.left.n;
            l_i = n.left.i;
        }
        if (n.right == null) {
            r_c = 0;
            r_n = Integer.MAX_VALUE/2;
            r_i = 1;
        } else {
            r_c = n.right.c;
            r_n = n.right.n;
            r_i = n.right.i;
        }

        n.c = Math.min(l_i+r_i,Math.min(l_i+r_c,l_c+r_i));
        n.n =l_c+r_c;
        n.i = Math.min(Math.min(l_i,l_c),l_n)+Math.min(r_i,Math.min(r_c,r_n))+1;
    }

    //dfs로 돌아야 한다면 어떻게 해야할까~?
    void copy(TreeNode head, Node node, int depth) {
        if (head.left != null) {
            node.left = new Node();
            copy(head.left, node.left, depth + 1);
        }
        if (head.right != null) {
            node.right = new Node();
            copy(head.right, node.right, depth + 1);
        }
        cal(node);
    }
}

class Node {

    public Node left = null;
    public Node right = null;
    public int c = 0; //cover
    public int n = Integer.MAX_VALUE/2; //noCover
    public int i = 1; //install


    public Node() {
    }
}