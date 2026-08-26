class Solution {
    int [] piles;
    public int minEatingSpeed(int[] piles, int h) {
        // minimum integer k 를 찾아야 하면 이분탐색이야뭐야
        // 그리디인가
        // 일단 그리디 각나와서 그리디로 시도
        // 각각을 다 나눠가지고 몫을 구해, 
        // 그리고 나머지는 패딩해서 올려야 함 몫 + 나머지가 0이아니면 +1 의 횟수가 각각 필요해보임
        // 아 이분탐색인가 
        //max 값을 구하기 -> 각 행에 있는 max값을 쓰면 될듯
        //min 값을 구하기 -> 1번부터 시작하면 될듯 아닌가...
        this.piles = piles;
        
        int high = 1_000_000_000;
        // int high = 0;
        // for(int n: piles){
        //     high = Math.max(n,high);
        // }

        int k = high;

        int low = 1;
        // 아 lowerbound 찾는 공식이 뭐더라 
        // 같거나 크면 내린다였나 ㅎ
        //System.out.println("high:"+high+" low:"+low);
        while(low<high){
            int mid = (high+low)/2; // 이거 overflow나지 않나
            int hours = hours(mid);
            //System.out.println("high:"+high+" low:"+low+" mid:"+mid+" hours:"+hours);
            if(hours<=h){
                //hours가 더 작으면 더 줄여봐야했던듯..
                high = mid;//아 기억이 나지 않아요...
                k = Math.min(k,mid);
            }else{
                //hours가 h보다 크면 더 키워봐야 했던듯...
                low = mid+1;//얘도 기억이 나지 않아요...
            }
        }

        return k;
    }

    int hours(int k){
        int h = 0;
        for(int n : piles){
            int times = n/k;
            if(n%k==0){
                h += times;
            } else{
                h += times+1;
            }
        }
        return h;
    }
}