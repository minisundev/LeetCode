class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //monotonic stack 같은데
        Stack<Integer> stack = new Stack<>();
        int [] arr = new int [nums.length];
        Arrays.fill(arr,-1);
        int index = 0;
        while(index<nums.length*2){
            int num = nums[index%nums.length];
            while(!stack.isEmpty() && nums[stack.peek()%nums.length]<num){
                arr[stack.pop()%nums.length] = num;
            }
            stack.push(index);
            index++;
        }
        return arr;
    }
}