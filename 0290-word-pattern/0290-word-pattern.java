class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> reverseMap = new HashMap<>();
        String [] arr = s.split(" ");

        for(int i=0;i<pattern.length();i++){
            char c1 = pattern.charAt(i);
            String str1 = map.getOrDefault(c1,null);
            if(str1==null){
                map.put(c1,arr[i]);
            }else{
                if(!str1.equals(arr[i])) return false;
            }

            String str2 = arr[i];
            char c2 = reverseMap.getOrDefault(str2,' ');

            if(c2==' '){
                reverseMap.put(arr[i],c1);
            }else{
                if(c2!=c1) return false;
            }
        }

        return true;
    }
}