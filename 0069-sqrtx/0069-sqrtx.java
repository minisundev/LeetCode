import java.lang.Math;

class Solution {
    public int mySqrt(int x) {
        if(x==1){
            return 1;
        }

        int low = 1;
        int high = x/2;
        int max = 0;

        //upperbound
        while(low<=high){
            int mid = (low+high)/2;

            long square = (long)mid*mid;//overflow나는거 잡으려고 계산시부터 long으로 casting 해줌
            
            
            if(square<x){//작거나 같으면 올려라
                low = mid+1;
                 max = Math.max(max,mid);
            }else if(square>x){
                high = mid-1;
            }else{//같으면 넣고 나가라....
                max = mid;
                break;
            }
        }
        return max;
    }
}