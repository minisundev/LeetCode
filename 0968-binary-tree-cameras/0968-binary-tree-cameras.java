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
    Map<Integer, List<Node>> level = new HashMap<>();
    int maxLevel = 0;

    public int minCameraCover(TreeNode root) {
        /*트리 dp 골조 만들기~*/
        TreeNode head = root;
        Node node = new Node();
        addLevel(node, 1);
        copy(head, node, 1);

        /*돌면서 dp 계산하기~ */
        //둘다 null null이 들어있으면 Y=1, N=0 이어야 함~
        //이게 dfs가 성립하지가 않으시고? 레벨 순회를 하셔야 하는뎁쇼?
        //Map으로 depth관리하면서 같은 depth는 다 Map의 List에다 넣어놓고 싹 그 순서로 순회돌아?
        for (int i = maxLevel; i >= 1; i--) {
            List<Node> list = level.getOrDefault(i, new ArrayList<>());

            for (Node n : list) {
                cal(n);
            }
        }

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

        //Y = Min(L_N, L_Y) + Min(R_N,R_Y) + 1
        //N = Min(L_Y+R_N) + Min(L_N+R_Y)

        n.c = Math.min(l_i+r_i,Math.min(l_i+r_c,l_c+r_i));
        n.n =l_c+r_c;
        n.i = Math.min(Math.min(l_i,l_c),l_n)+Math.min(r_i,Math.min(r_c,r_n))+1;
    }

    //dfs로 돌아야 한다면 어떻게 해야할까~?
    void copy(TreeNode head, Node node, int depth) {
        System.out.println("copy at depth " + depth);
        if (head.left != null) {
            node.left = new Node();
            addLevel(node.left, depth + 1);
            copy(head.left, node.left, depth + 1);
        }
        if (head.right != null) {
            node.right = new Node();
            addLevel(node.right, depth + 1);
            copy(head.right, node.right, depth + 1);
        }
    }

    void addLevel(Node node, int depth) {
        List<Node> list = level.getOrDefault(depth, new ArrayList<>());
        list.add(node);
        level.put(depth, list);

        maxLevel = Math.max(maxLevel, depth);
    }
}

class Node {
    //두 자식노드와 부모노드의 관게를 보자면
    //Y = Min(N_L, Y_L) + Min(N_R,Y_R) + 1
    //N는 자식노드중 하나는 Yes가 있어야 한다고 한다
    //N = Min(Y_L+N_R) + Min(N_L+Y_R) => 그냥 이렇게 하기에도 문제인것이
    // 저러면 ... N N만 계속되면 놓쳐버리는 수가 있어요
    //두개 전까지 추적해야할거같아 ㅋ... 그걸 어케하나요 => 자식노드로 들어가는것도 문제인것이 무한히 자식노드 체크해야할듯...
    //상태가 하나 더 있어야 함...

    public Node left = null;
    public Node right = null;
    public int c = 0; //cover = 0;
    public int n = Integer.MAX_VALUE/2; //noCover = 0;
    public int i = 1; //install = 1;


    public Node() {
    }
}