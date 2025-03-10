class Solution {
    public int[] findBuildings(int[] heights) {
        //나보다 큰게 오른쪽에 있었아면 안 되는거임
        Stack<Integer> stack = new Stack();
        int count = 0;

        for(int i=0; i<heights.length; i++){
            int height = heights[i];
            while(!stack.isEmpty()&&heights[stack.peek()]<=height){
                stack.pop();
            }
            stack.add(i);
        }

        int [] answer = new int [stack.size()];

        for(int i=stack.size()-1; i>=0; i--){
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}