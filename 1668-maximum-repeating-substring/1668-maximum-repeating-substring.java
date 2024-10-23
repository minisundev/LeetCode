import java.lang.Math;

class Solution {
    public int maxRepeating(String sequence, String word) {
        int max = 0;
        //int [] memo = new int [word.length];
        int index = 0;

        for(int i=0; i<sequence.length(); i++){
            int count = 0;
            int cur = i;
            while(cur<sequence.length() && sequence.charAt(cur)==word.charAt(index) ){
                //System.out.println("cur"+cur+"index"+index);
                index++;
                cur++;
                if(index==word.length()){
                    index = 0;
                    count++;
                }
            }
            index = 0;
            max = Math.max(max,count);
        }

        return max;

    }
}