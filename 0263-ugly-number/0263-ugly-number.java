class Solution {
    public boolean isUgly(int n) {
        //2와 3과 5로만 이루어졌다면 ugly인데 7이 포함되거나 다른 소수가 포함되면 안됨
        //계속 나눠가지고 2랑 3이랑 5로 계속 나눠가지고 마지막에 남는게 1이 아니면 다른게 포함된거겠지...
        //2로 나눠
        if(n==0) return false;
        while(n%2==0){
            n = n/2;
        }
        //3으로 나눠
        while(n%3==0){
            n = n/3;
        }
        //5로 나눠
        while(n%5==0){
            n = n/5;
        }
        if(n==1) return true;
        return false;
    }
}