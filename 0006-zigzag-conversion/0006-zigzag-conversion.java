class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s; 
        StringBuilder sb = new StringBuilder(s.length());

        //oneway at first
        int index = 0;
        while(index<s.length()){
            sb.append(s.charAt(index));
            index += 2*numRows-2;
        }

        //roundtrip in the middle

        for(int gap = 1; gap<numRows-1; gap++){
            index = 0;
             while(index<s.length()){
                 if(index + gap< s.length()){
                     sb.append(s.charAt(index + gap));
                 }

                 if(index + 2*numRows-2-gap<s.length()){
                     sb.append(s.charAt(index + 2*numRows-2-gap));
                 }

                 index += 2*numRows-2;
             }
         }

        //oneway at the end
         index = numRows-1;
         while(index<s.length()){
             sb.append(s.charAt(index));
             index += 2*numRows-2;
         }

        return sb.toString();
    }
}