class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();

        for(; i<abbr.length(); i++){
            char c1 = abbr.charAt(i);
            //숫자일때
            if(c1>='0'&&c1<='9'){
                if(sb.length()==0 && c1=='0'){
                    //System.out.println("leading zero false");
                    return false;
                } 
                sb.append(c1);
                continue;
            }
            //글자일때
            //숫자가 있다면 그만큼 flush 진행
            if(sb.length()>0){
                int skip = Integer.parseInt(sb.toString());
                sb=new StringBuilder();
                idx += skip;
            }
            if(idx>=word.length()){
                return false;
            } 
            char c2 = word.charAt(idx);
            if(c1!=c2){
                //System.out.println("("+i+","+idx +")"+"("+c1+","+c2+ ") false");
                return false;
            } 
            idx++;
        }

        if(sb.length()>0){
            int skip = Integer.parseInt(sb.toString());
            idx += skip;
            if(idx!=word.length()){
                //System.out.println("idx>word.length()-1 false");
                return false;
            }
        }

        if(idx<=word.length()-1){
            return false;
        }

        return true;
    }
}