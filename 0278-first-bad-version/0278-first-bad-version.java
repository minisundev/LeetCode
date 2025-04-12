/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //이분탐색인가...lowerbound를 찾아야 하는 문제인거임
        int low = 1;
        int high = n;
        while(low<high){
            int mid = (low+high)/2;
            if(isBadVersion(mid)){//    내려
                high = mid;
            }else{//올려
                low = mid+1;
            }
        }
        return low;
    }
}