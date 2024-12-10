class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String [] arr = sentence.split(" ");

        Set<String> set = new HashSet<>();

        for(String word : dictionary){
            set.add(word);
        }
        
        for(int i=0; i<arr.length; i++){
            String s = arr[i];
                for(int end =1;end<=s.length(); end++){
                    String sub = s.substring(0, end);
                    if(set.contains(sub) && sub.length() < arr[i].length()){
                        arr[i]= sub;
                        break;
                    }
                }
        }

        for(String s : arr){
            sb.append(s).append(" ");
        }

        return sb.substring(0,sb.length()-1);
    }
}