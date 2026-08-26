class Solution {
    public double angleClock(int hour, int minutes) {
        //시계방향으로 재서 그거랑 360-그거중에 작은거 리턴하기~~
        if(hour==12) hour=0;
        //hour에는 minute도 반영됨 ㅎㅎ
        double h=360.0/(12)*(hour)+30.0/60.0*minutes;
        //double h=360.0/(12)*(hour);
        double m=360.0/(60)*(minutes);
        //System.out.println(h+" "+m);
        double diff= Math.abs(h-m);
        return Math.min(diff,360-diff);
        
        
    }
}