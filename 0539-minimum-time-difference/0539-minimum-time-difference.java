class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        //모든 것들을 다 비교해야하면 정렬인가~
        //그냥 다 숫자로 바꿔서 정렬시켜서 비교하면 빠르지않을까~
        //아님 그냥 쌩정렬이 빠른가~
        // Collections.sort(timePoints, (o1,o2)->{
        //     if(o1.charAt(0)!=o2.charAt(0)){
        //         return o1.charAt(0)-o2.charAt(0);
        //     }
        //     if(o1.charAt(1)!=o2.charAt(1)){
        //         return o1.charAt(1)-o2.charAt(1);
        //     }
        //     if(o1.charAt(3)!=o2.charAt(3)){
        //         return o1.charAt(3)-o2.charAt(3);
        //     }
        //     if(o1.charAt(4)!=o2.charAt(4)){
        //         return o1.charAt(4)-o2.charAt(4);
        //     }
        //     return 0;
        // });
        Collections.sort(timePoints);


        int firstTime = 0;
        String last = null;
        int time1 = -1;
        for(String s : timePoints){

            int h2 = (s.charAt(0)-'0')*10 + (s.charAt(1)-'0');
            int m2 = (s.charAt(3)-'0')*10 + (s.charAt(4)-'0');
            int time2 = h2*60 + m2;

            if(time1 != -1){
                min = Math.min(min,time2-time1);
            }else{
                firstTime = time2;
            }

            time1 = time2;
        }

       int firstGap = (1440 - time1) + firstTime;

        if(min>=1439){
            min = min%1439+1; //["23:59","00:00"]
        }

        return Math.min(min,firstGap);
    }
}