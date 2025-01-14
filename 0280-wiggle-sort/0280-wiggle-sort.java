class Solution {
    public void wiggleSort(int[] nums) {
        //일단 다 정렬하고 지그재그로 배치하는 방법밖에 모르갰는대 
        //그렇개는 o n complexity에 풀 수가 없어 모노토닉 스택 문제인가....
       // boolean [] visit = new boolean [nums.length];
        //이렇게 풀어도 시간복잡도가,, 재곱이자나
        //그리고 저렇게 그리디로 풀어서 된다는 보장이 없오
        Arrays.sort(nums);
        int left = 1;
        int right = nums.length-2;
        if(nums.length%2!=0) right = nums.length-1;
        int index= 0;
        //이렇게 풀면 참 편했겠지요... 근데 새 배열을 만들어서 돌려보낼수가 없어...
        //2칸마다 좌우 swap해야지 뭐 어떡함
        while(left<=right){
           int temp =  nums[left];
           nums[left] = nums[right];
           nums[right]= temp;
           left=left+2;
           right=right-2;
        }
        //짝수만 되는거 같으세요...지금은뭔가

    }
}