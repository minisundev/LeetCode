import java.util.*;
import java.lang.Math;

class Solution {
    public int hIndex(int[] citations) {
        int max=0;
        //값이 h인게 h번 이상 나와야 함
        
        int low=0;
        int high = citations.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(citations[mid]>=citations.length-mid){
                max=Math.max(max,citations.length-mid);
                high=mid-1;
            }else{
                low= mid+1;
            }
            //System.out.println("high"+high+"low"+low);
        }

        return max;
    }
}