import java.lang.Math;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] LIS = new int [nums.length];
        int top = 0;

        for(int num : nums){
            int low = 0;
            int high = top;

            //lowerbound를 찾아서 그거 맨 앞을 바꿔주면 될 것 같아
            while(low<high){
                int mid = (low+high)/2;
                
                if(LIS[mid] < num){ // 같으면 올림
                    low = mid+1;
                }else{
                    high = mid;
                }
            }

            //그렇게 찾아낸 삽입될 인덱스에 넣어본다.... 더 작은 값으로 대체해봄
            if(low == top){
                LIS[top++] = num;
            }else{
                LIS[low] = num;
            }

            //print(LIS);
        }

        return top;
    }

    void print(int [] arr){
        for(int i : arr){
            System.out.print(i +",");
        }
        System.out.println();
    }
}