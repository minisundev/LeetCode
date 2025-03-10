class Solution {
    public int[] findBuildings(int[] heights) {
        //나보다 큰게 오른쪽에 있었아면 안 되는거임
        Stack<Integer> stack = new Stack();
        Integer [] view = new Integer[heights.length];

        for(int i=0; i<heights.length; i++){
            int height = heights[i];
            while(!stack.isEmpty()&&heights[stack.peek()]<=height){
                view[stack.pop()] = i;
            }
            stack.add(i);
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<view.length; i++){
            if(view[i]==null){
                list.add(i);
            }
        }

        int [] answer = new int [list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}