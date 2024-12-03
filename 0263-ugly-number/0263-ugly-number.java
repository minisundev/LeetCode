class Solution {
    public boolean isUgly(int n) {
        //2로 나눠질때까지 나누고 
        //3으로 나눠질때까지 나누고
        //5로 나눠질때까지 나누고 -> 해서 마지막이 1인지 보면 되는 문제인 거 아냐...?
        while(n>1){
            if(n%2==0){
                n=n/2;
            }else{
                break;
            }
            System.out.println(n);
        }
        while(n>1){
            if(n%3==0){
                n=n/3;
            }else{
                break;
            }
            System.out.println(n);
        }
        while(n>1){
            if(n%5==0){
                n=n/5;
            }else{
                break;
            }
            System.out.println(n);
        }
        if(n==1){
            return true;
        }
        return false;
    }
}