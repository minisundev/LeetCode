class LockingTree {

    Tree head = new Tree(0);
    Map<Integer, Tree> map = new HashMap<>();

    public LockingTree(int[] parent) {

        // 1. 모든 노드를 먼저 생성
        for (int i = 0; i < parent.length; i++) {
            map.put(i, new Tree(i));
        }

        head = map.get(0);

        // 2. 부모와 자식 연결
        for (int i = 1; i < parent.length; i++) {
            Tree child = map.get(i);
            Tree p = map.get(parent[i]);

            child.parent = p;
            p.kids.add(child);
        }
    }

    public boolean lock(int num, int user) {
        Tree t = map.get(num);

        if (t == null) {
            //System.out.println("t is null");
            return false;
        }

        // unlock 상태여야 함
        if (t.user == 0) {
            t.user = user;
            //System.out.println("num:"+num+" user:"+user+" lock true");
            return true;
        }
        //System.out.println("num:"+num+" user:"+user+" t.user:"+t.user+" lock false");
        return false;
    }

    public boolean unlock(int num, int user) {
        //lock 상태여야함, 동일한 user에 의해서만
        Tree t = map.get(num);

        if (t == null) {
            //System.out.println("t is null");
            return false;
        }

        if (t.user == user) {
            t.user = 0;
            //System.out.println("num:"+num+" user:"+user+" t.user:"+t.user+" unlock true");
            return true;
        }
        //System.out.println("num:"+num+" user:"+user+" t.user:"+t.user+" unlock false");
        return false;
    }

    public boolean upgrade(int num, int user) {
        Tree t = map.get(num);

        if (t == null) {
            //System.out.println("t is null");
            return false;
        }

        // unlock 상태여야 함
        if (t.user != 0) {
            //System.out.println("num:"+num+" user:"+user+" t.user:"+t.user+" upgrade false: locked");
            return false;
        }

        // does not have any locked ancestors
        Tree h = t.parent;

        while (h != null) {
            if (h.user != 0) {
                return false;
            }
            h = h.parent;
        }

        // at least one locked descendant 

        Stack<Tree> stack = new Stack<>();
        List<Tree> list = new ArrayList<>();

        if (!t.kids.isEmpty()) {
            for (Tree kid : t.kids) {
                stack.add(kid);
            }
        }

        while (!stack.isEmpty()) {
            Tree t1 = stack.pop();
            if (t1.user != 0) {
                list.add(t1);
            }

            if (!t1.kids.isEmpty()) {
                for (Tree kid : t1.kids) {
                    stack.add(kid);
                }
            }
        }

        if(list.isEmpty()){
            //System.out.println("num:"+num+" user:"+user+" t.user:"+t.user+" upgrade false: no descendant locked");
            return false;
        }

        // 위의 모든 케이스가 아닐 경우, 잠긴 자손들을 다 unlock하고 t를 lock함
        for(Tree tree : list) {
            tree.user = 0;
        }
        
        t.user = user;
        return true;
    }
}

class Tree {
    public List<Tree> kids = new ArrayList<>();
    public Tree parent = null;
    public int number = 0;//열려있어야함~
    public int user = 0;//0이면 unlock, 잠근 user가 있으면 user(int) 넣음, user 가 1부터이기 때문임

    public Tree(int n) {
        number = n;
    }

    public Tree add(int n) {
        Tree kid = new Tree(n);
        kids.add(kid);
        return kid;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */