public class ZigzagIterator {

    List<Integer> v1;
    List<Integer> v2;
    int i1=0;
    int i2=0;
    boolean turn = true;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1=v1;
        this.v2=v2;
    }

    public int next() {
        if(i1>=v1.size()&&i2<v2.size()){
            return v2.get(i2++);
        }
        if(i2>=v2.size()&&i1<v1.size()){
            return v1.get(i1++);
        }
        if(turn){
            turn=false;
            return v1.get(i1++);

        }else{
            turn=true;
            return v2.get(i2++);
        }
    }

    public boolean hasNext() {
        if(i1<v1.size()||i2<v2.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */