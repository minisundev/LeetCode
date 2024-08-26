import java.lang.Math;

class Solution {
    public int trap(int[] height) {

        if(height.length==1) return 0;

        int water = 0;

        int left = 0;
        int right = height.length-1;

        while(height[left]<=height[left+1] && left+1<height.length-1){
            left++;
        }

        while(height[right]<=height[right-1] && right>1){
            right--;
        }


        int lLevel = height[left];
        int rLevel = height[right];

        //굳이 저렇게 복잡하게 풀 필요 있었나 left와 right의 min 만큼 채우면서 이동하면 될 것 같은데

        while(left<right){

            lLevel = Math.max(height[left],lLevel);
            rLevel = Math.max(height[right],rLevel);
            int level = Math.min(lLevel,rLevel);
            //아 각 자리의 수심이 뭔지 모르는데 좌우 길이대로 곱해서 위로 올려서 area 하시면 안 됩니다

            if(height[left]<=height[right]){
                
                water += Math.max(level-height[left],0);
                left++;
            }else{
                water += Math.max(level-height[right],0);
                right--;
            }
        }
        return water;
    }
}