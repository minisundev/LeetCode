class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        int index = 0;
        char last = chars[0];
        int count = 1;
        for(int i=1; i<chars.length; i++){
            char c = chars[i];
            if(c==last){
                count++;
            }else{
                chars[index++] = last;
                if(count>1){
                    String number = Integer.toString(count);  
                    for (int j = 0; j < number.length(); j++) {
                        chars[index++] = number.charAt(j); 
                    }
                }

                last = c;
                count = 1;
            }
        }

        chars[index++] = last;
        if (count > 1) {
            String number = Integer.toString(count);
            for (int j = 0; j < number.length(); j++) {
                chars[index++] = number.charAt(j);
            }
        }
        
        return index;
    }
}