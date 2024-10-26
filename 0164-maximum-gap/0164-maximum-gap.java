import java.lang.Math;
import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<=1){
            return 0;
        }

        if(nums.length<=2){
            return Math.abs(nums[0]-nums[1]);
        }

        //정렬 안 하고 O(n)만으로 풀기 위해 버킷을 도입
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        int gap = (int)Math.ceil((double)(max-min)/(double)(nums.length-1));
        //갭의 최소단위는 최대와 최소의 차이를 갯수만큼 나눈 값이겠지

        if(gap==0){//모든 값이 동일할 때
            return 0;
        }

        int bucketNumber = nums.length;
        int [] minBucket = new int [bucketNumber];
        int [] maxBucket = new int [bucketNumber];

        for(int i=0;i<bucketNumber;i++){
            minBucket[i] = Integer.MAX_VALUE;
            maxBucket[i] = Integer.MIN_VALUE;
        }

        for(int num: nums){
            int index = (num-min)/gap;//얘가 들어갈 자리를 찾아보자~~
            minBucket[index] = Math.min(minBucket[index],num);
            maxBucket[index] = Math.max(maxBucket[index],num);
        }

        int maxGap = 0;
        int prevMax = min;

        for(int i=0;i<bucketNumber;i++){
            if (minBucket[i] == Integer.MAX_VALUE) {
                continue; // 버킷이 비어 있으면 건너뜁니다
            }
            maxGap = Math.max(maxGap, minBucket[i] - prevMax);
            prevMax = maxBucket[i];
        }

        return maxGap;
    }
}