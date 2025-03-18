class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        if(s.length()%2==0){
            for(Map.Entry<Character,Integer> entry: map.entrySet()){
                if(entry.getValue()%2!=0) return false;
            }
        }else{
            int odd = 0;
            for(Map.Entry<Character,Integer> entry: map.entrySet()){
                if(entry.getValue()%2!=0) odd++;
                if(odd>1) return false;
            }
        }
        return true;
    }

}