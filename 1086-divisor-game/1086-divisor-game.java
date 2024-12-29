class Solution {
    public boolean divisorGame(int n) {
        //n의 약수인 x를 골라서 그만큼 이동한다
        //n에서 x를 뺀다
        //앨리스부터 시작해서 밥으로, 둘 다 최적의 수를 둠
        //앨리스가 이긴다면 true를 리턴함
        //움                     직일 수 없다면 진다 -> 약수가 남아있지 않다면 진다
        //앨리스가.. 가장 작은 약수를 제일 먼저 골라버리면 밥은 고를게 없어서 지지 않나?
        //약수가 하나도 없는 숫자면 앨리스가 걍 지는거야
        

        if(n%2==0)return true;
        return false;      
    }
}