class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0) return 0;
        if(k==0&&num%10!=0) return -1;
        if(k%2==0 && num%2!=0) return -1;

        //뒷자리로 num의 뒷자리가 일치하는 숫자를 만들고... 그 갯수를 돌려보내면 되지 않나? 10의자리든 100의자리든은 알아서 다 분배되었다고 가정하면 됨
        //만드는동안 num의 뒷자리가 되는 수를 만드는동안 앞자리들이 num을 넘어버리면 망한거임
        int sum = 0;
        int count = 0;
        while(sum<num){
            sum += k;
            count++;
            if(sum%10==num%10)break;
        }
        //System.out.println(sum+","+count);
        if(sum<=num) return count;
        return -1;
    }
}