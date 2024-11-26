class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s : strings){
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            for(int i=1; i<s.length(); i++){
                //a-z 넘어갈때 안 되고 있는데 모듈로 처리를 어케해야하지
                int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
                //System.out.println(s.charAt(i)+"-"+s.charAt(i-1)+" diff:"+diff);
                sb.append(diff).append(".");
            }
            String number = sb.toString();
            //System.out.println("number: "+number);
            List<String> element = map.getOrDefault(number,new ArrayList<>());
            element.add(s);
            map.put(number,element);
        }

        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}