import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {

        if(digits.length()==0){
            return new ArrayList<>();
        }
        

        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> list = new ArrayList<>();
        int i = 0;
        if(i==0){
            int num = digits.charAt(i)-'0';
            String chars = map.get(num);
            for(int j=0; j<chars.length(); j++){
                char c = chars.charAt(j);
                list.add(c+"");
            }
        }

        List<String> next;
        for(i=1; i< digits.length(); i++){
            int num = digits.charAt(i)-'0';
            String chars = map.get(num);
            next = new ArrayList<>();

            for(String element : list){
                for(int j=0; j<chars.length(); j++){
                    char c = chars.charAt(j);
                    next.add(element+c);
                }
            }
            list = next;
            
        }

        return list;
    }
}