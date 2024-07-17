class Solution {

    int maxS = 0;
    int maxE = 0;
    char [] arr;

    public String longestPalindrome(String s) {
        arr = s.toCharArray();

        for(int start = 0; start<s.length(); start++){
            for(int end = s.length()-1; end>=0; end--){
                if(verifyPalindrome(start, end)){
                    if(end-start>maxE-maxS){
                        maxS = start;
                        maxE = end;
                    }
                    break;
                }
            }
        }
        return makeString(maxS,maxE);
    }

    boolean verifyPalindrome(int start, int end){
        while(start<=end){
            char left = arr[start];
            char right = arr[end];
            if(left!=right){
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }

    String makeString(int start, int end){
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<=end; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}