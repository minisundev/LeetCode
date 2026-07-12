class Solution {
    public double separateSquares(int[][] squares) {
        // bottom left (xi, yi)
        // top right(x2는 상관이없겠네 세로만 보면 됨, yi+li) 
        // the line -> x축에 평행하니까 y=y2 의 선
        // -> minimum y2를 구해야 하는 문제
        // 아아 사각형 하나하나마다 구하는게 아니고 전체 사각형에 대해서 구하는거구나 아아

        // 음 뭔가 누적합 문제일 것 같기도~
        // 해당 x 범위에 해당하는거 1씩 누적합으로 해두고? 
        // 이분탐색으로 총누적합의 절반이 되는 곳을 찾으러 가는것이지...
        // -> 저장할거 너무많겠는데 range로 처리해야하나...
        // 근데 range처리는 이분탐색?이 될수도~ 어차피 인덱스니깐~
        // 넣을때마다 이분탐색해서 넣고 업뎃치기 해야하나~ range로 한다면~
        // 아님 해쉬맵으로 넣고나서 맨 나중에 꺼내서 정렬하고 누적합 계산하고 찾을때만 이분탐색하기~

        //그냥 배열 정렬해서 누적합 처리하면 되지 도대체 무슨소리해요?
        // 중간까지 가야할 것 같아~
        // 저게 정렬이 되어있는 squares인지~ 의문~
        // 정렬해야할듯~
        // o1[1] - o2[1]는 값이 크면 오버플로가 날 수 있음~
        // Arrays.sort(squares, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        //double [] sums = new double[squares.length];
        
        double maxY2 = 0.0;
        double minY1 = Double.MAX_VALUE;

        double sum = 0.0;
        for(int i=0; i<squares.length; i++){
            int [] arr = squares[i];
            int y1 = arr[1]; // yi
            int l1 = arr[2]; // li
            int y2 = y1+l1; // yj = yi+li
            
            sum += 1.0*(y2-y1)*l1; // area를..구해보아용~
            //sums[i] = sum;
            maxY2 = Math.max(maxY2, y2); // 이분탐색 상한용~
            minY1 = Math.min(minY1, y1); // 이분탐색 하한용~
        }

        /*
        //upperbound로 half보다 같거나 작은 최소 윗변 찾으면 되는거잖아 지금; 
        double half = sum/2;
        int high = sums.length-1;
        int low = 0;

        while(low<high){
            int mid = (high+low)/2;
            if(sums[mid]>half){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        //이제 low를 어찌해야하리오...
        */

        //인덱스가 아닌 이분탐색은 태어나서 처음 봐요 흑흑 이게 미디엄이라니~
        //그리고 이 방식대로 무식하고 심플하게 이분탐색 돌리려면... 누적합 배열도 정렬도 할 필요가 없어짐...
        double half = sum/2;
        double high = maxY2;
        double low = minY1;

        //lowerbound로 잠긴 넓이가 half보다 같거나 커지는 최소 y 찾으면 되는거잖아 지금; (인덱스 말고 y값을 탐색~)
        for(int iter=0; iter<60; iter++){
            double mid = (high+low)/2;
            double total = 0.0;
            for(int [] arr : squares){
                // 선 y=mid 아래 잠긴 높이만~ 0이상 l이하로 잘라서~
                total += Math.min(Math.max(mid-arr[1], 0.0), arr[2]) * arr[2];
            }
            if(total>=half){
                high = mid;
            }else{
                low = mid; // 실수라 +1 없음~
            }
        }
        return high;
    }
}