class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //합집합 - 교집합
        int area1 = (ax2-ax1)*(ay2-ay1);
        int area2 = (bx2-bx1)*(by2-by1);

        if(area1==0){
            return area2;
        }else if(area2==0){
            return area1;
        }

        //x기준으로 오른쪽과 왼쪽을 비교...
        //하드코딩

        int Y = 0;
        //a를 기준으로 봐봐
        if(ay1<=by1 && by2<=ay2){//완전히 포함된 기준인지 봐보기...
            Y = by2-by1;
        }else if(by1<=ay1 && ay2<=by2){
            Y = ay2-ay1;
        }
        else if(by1<=ay1 && ay1<by2){//y축 기준으로 사이에 껴있으면
            Y = by2-ay1;
            //System.out.println("Y1");
        }else if(ay1<=by1 && by1<ay2){
            Y = ay2-by1;
            //System.out.println("Y2");
        }

        int X = 0;
        if(ax1<=bx1 && bx2<=ax2){//완전히 포함된 기준인지 봐보기...
            X = bx2-bx1;
        }else if(bx1<=ax1 && ax2<=bx2){
            X = ax2-ax1;
        }else if(bx1<=ax1 && ax1<bx2){//x축 기준으로 사이에 껴있으면
            X = bx2-ax1;
            //System.out.println("X1");
        }else if(ax1<=bx1 && bx1<ax2){
            X = ax2-bx1;
            //System.out.println("X2");
        }
        //System.out.println(X+","+Y);

        return area1+area2-X*Y;
    }
}