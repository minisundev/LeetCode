class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> once = new HashSet<String>();
        Set<String> twice = new HashSet<String>();
        //sliding window 어떻게 하더라
        //sliding window dp 가 아니면 할만하지
        //가 아니고 무식하게 서브스트링 하는 방법빆에 생각안나 지금.. 
int k =10;
        int left =0;
        int right = k; 
        while(right<=s.length()){
            String sub = s.substring(left,right);
            if(!twice.contains(sub)){
                if(!once.contains(sub)){
                    once.add(sub);
                }else{
                    once.remove(sub);
                    twice.add(sub);
                }
            }
            left++;
            right++;
            
        }

        return new ArrayList(twice);
    }
}