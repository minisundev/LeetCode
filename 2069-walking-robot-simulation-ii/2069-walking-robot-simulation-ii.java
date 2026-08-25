class Robot {

    int x = 0;
    int y = 0;

    int n;
    int m;
    
    int way = 0;
    int round;

    boolean first = true;
    
    int [][] dir = {
        {-1,0},//S
        {0,1},//E
        {1,0},//N
        {0,-1}//W
    };

    String [] direction = {"South","East","North","West"};

    public Robot(int width, int height) {
        n = width-1;
        m = height-1;
        round = 2*n+2*m;
    }
    
    public void step(int num) {//실제 이동
        //System.out.println("num:"+num+" "+direction[way]+" "+x+","+y);
        //호호호 값을 바꾸고 빼기를 하고 스택오버플로우를 내다니 제정신~~인가~~
        // x= n으로 만들고 나서 n-x 를 하면 영원히 망함 ㅎ
        // 시간초과가 남 하하호호 이거 걍 한번에 다음좌표 계산해야할지도...
        // 아니면 재귀를 시켜서 오버헤드생겨서 시간초과가 나는지뭔지..
        // 탱탱볼마냥 위아래로 튀긴다고 생각을 해보자~~
        // n을 넘는 순간 좌우로 왔다갔다하다가 어딘가에서 멈추겠죠~
        // 근데 n을 넘는 순간 m도 올라갔다가 멈춰야겠죠~
        // 그렇다면 한바퀴를 돌아오는 기준으로 한바퀴를 다 돌면 걍 스킵시켜버리고 나머지만 계산시키면 개빨라지겠죠~
        // 사실 더 정교하게 가자면 나머지도 계산 안 시켜도 될거같긴 한데 일단은~~

        //계산과정 더 줄여보기...
        //탱탱볼로..생각해보기..
        //아님 한바퀴 안에서 바로 좌표뽑는법을..
        //한바퀴 안에서 바로 좌표뽑기: 
        //EAST 0<number<=n의 경우
        //아 에바야 ㅎ 0,0에서만 시작하는게 아닌데
        //내일 남들은 뭘했길래 개빨리풀었는지 분석

        if(first){
            first = false;
        }

        if(num/round>0){
            step(num%round);
            return;
        }

        if(num<=0) return;

        if(
            x==0 && y==0 ||
            x==0 && y==m ||
            x==n && y==0 ||
            x==n && y==m
        ){
            way = (way+1)%dir.length;
        }

        if(way==1){//E
            int extra = num-(n-x);
            if(extra>0){
                x = n;
                step(extra);
            }else{
                x = x+num;
            }
        }else if(way==2){//N
            int extra = num-(m-y);
            if(extra>0){
                y = m;
                step(extra);
            }else{
                y = y+num;
            }
        }else if(way==3){//W -> n
            int extra = num - x;
            if(extra>0){
                x = 0;
                step(extra);
            }else{
                x = x-num;
            }
        }else{//S -> m
            int extra = num-(y);
            if(extra>0){
                y = 0;
                step(extra);
            }else{
                y = y-num;
            }
        }
    }

    public int[] getPos() {
        return new int []{x,y};
    }
    
    public String getDir() {
        if(first) return direction[1];//흑흑 하드코딩~~
        return direction[way];
        //하하하 귀찮게 South부터 모서리만나면 꺾는거 자동적용하려고 했더니
        //0,0에서 멈춰버리고 디렉션을 뽑는 미친 예제를 왜넣지~~
        
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */

