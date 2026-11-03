/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int sum = 0;
    int total = 0;
    int maxDepth = 1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        //다 순회하면서 maxDepth를 찾고 sum도 구해놓고 마지막에 마이너스를 한번에 계산하면 되자나
        // weight = maxDepth - depth + 1
        // weight * value = (maxDepth - depth + 1)*value = maxDepth*value - depth*value + value

        for(int i=0; i<nestedList.size(); i++){
            NestedInteger ni = nestedList.get(i);
            plus(ni,1);
        }

        return total + sum*maxDepth;
    }

    // list가 숫자다 → 더한다, total이랑 sum에다가 계산해서 넣는다
    // list가 list다 → 하나씩 순회한다 ,depth를 더한다
    void plus(NestedInteger ni, int depth){
        List<NestedInteger> list = ni.getList();
        maxDepth = Math.max(depth,maxDepth);
        if(list.isEmpty()){
            int value = ni.getInteger();
            total += value - depth*value;
            sum += value;
        }else{
            for(NestedInteger i: list){
                plus(i, depth+1);
            }
        }
    }
}