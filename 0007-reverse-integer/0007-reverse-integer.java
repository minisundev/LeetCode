import java.lang.Math;

class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        if(x<0){
            sb.append("-");
            x = Math.abs(x);
        }else if(x==0){
            return 0;
        }
        for(int i=x; i>0;i/=10){
            sb.append(i%10);
        }
        try{
            return Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            return 0;
        }
        
    }
}