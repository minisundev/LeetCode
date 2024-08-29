import java.lang.Math;

class Solution {
    public boolean isOneEditDistance(String s, String t) {

        if(s.length()==0 && t.length()==0) return false;
        if(Math.abs(s.length()-t.length())<=1 && (s.length()==0 || t.length()==0)){
            return true;
        }

        int left = 0;
        int right = 0; //뒤에서부터의 거리
        
        int pass = 0;

        if(s.length()+1 == t.length()){//delete one -> 그 다음 것부터 일치할 경우, 크기가 +1일 경우
            while(left<s.length() && right<t.length()){
                if(s.charAt(left)==t.charAt(right)){
                    left++;
                    right++;
                }else{  
                    if(pass==0){
                        pass++;
                        right++;

                    }else if(pass>=1){
                        pass++;
                        break;
                    }
                }
            }
        }
        else if(s.length()-1 == t.length()){//insert one -> 그 다음 것부터 일치할 경우, 크기가 -1일 경우
            while(left<s.length() && right<t.length()){
                if(s.charAt(left)==t.charAt(right)){
                    left++;
                    right++;
                }else{  
                    if(pass==0){
                        pass++;
                        left++;

                    }else if(pass>=1){
                        pass++;
                        break;
                    }
                }
            }

        }else if(s.length() == t.length()){//replace one -> 그 다음 것부터 일치할 경우, 크기가 같을 경우
            while(left<s.length() && right<t.length()){
                if(s.charAt(left)==t.charAt(right)){
                    left++;
                    right++;
                }else{  
                    if(pass==0){
                        pass++;
                        left++;
                        right++;

                    }else if(pass>=1){
                        pass++;
                        break;
                    }
                }
            }
        }else{
            return false;
        }
System.out.println(pass+","+left+","+right);

        if(pass==1){
            return true;
        }else if(pass==0 && (t.length()-right==1||s.length()-left==1)){
            return true;
        }else{
            return false;
        }
    }
}