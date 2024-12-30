class Solution {
    public int fib(int n) {

        if(n==0) return 0;
        else if(n==1) return 1;

        int n1=0;
        int n2=1;
        int n3=0;
        int count=2;

        for(int i=2;i<=n;i++){
            n3=n1+n2;
            n1=n2;
            n2=n3;
            if(count==n){
                break;
            }
        }
        return n3;
    }
}