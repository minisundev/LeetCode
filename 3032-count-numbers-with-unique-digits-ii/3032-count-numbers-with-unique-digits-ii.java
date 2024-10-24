import java.util.*;

class Solution {
    public int numberCount(int a, int b) {
        int count = 0;

        //dp로 뭐가 몇개씩 있는지 0부터 9까지 관리하면서 1이 추가가 될 때마다 생기는 번호들만 추가삭제 해주면서 싹 다 1이하만 있으면 count++하면 될 것 같기도 하고.... 바꾸면서 1 이상이 있는 것들이 생기면 int overOne 같은데에 저장해놨다가 그거 -시키고 저게 0이면 count++를 하면 될 것 같기도 하고

        for(int i=a;i<=b;i++){
            if(ifUnique(i)) count++;
        }

        return count;
    }

    boolean ifUnique(int number){
        String s = number+"";
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            int cur = s.charAt(i)-'0';
            int count = map.getOrDefault(cur,0);
            if(count!=0){
                return false;
            }
            map.put(cur,1);
        }

        return true;
    }
}