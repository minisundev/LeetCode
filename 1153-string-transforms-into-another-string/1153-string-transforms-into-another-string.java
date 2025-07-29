class Solution {
    public boolean canConvert(String str1, String str2) {
        //결국 패턴이 같은 것을 찾는 이야기입니다~
        //나오는 알파벳의 인덱스를 MAP CHAR-LIST<INTEGER>리스트로 저장하고?
        //첫글자 리스트부터 비교하면? 된다 입니다...? 
        //아 뭔가 저렇게하면 자료구조 너무 많이쓸거같기도? 하고요?
        //일단해봄
        //이건 두개를 같은 알파벳으로 바꾸는 패턴이 안되어버림~~~
        // Map<Character,Integer> charNo1 = new HashMap<>();
        // Map<Character,Integer> charNo2 = new HashMap<>();
        // Map<Integer,List<Integer>> pattern1 = new HashMap<>();
        // Map<Integer,List<Integer>> pattern2 = new HashMap<>();

        // for(int i=0; i<str1.length(); i++){
        //     char c1 = str1.charAt(i);
        //     char c2 = str2.charAt(i);

        //     int no1 = charNo1.getOrDefault(c1,-1);
        //     if(no1==-1){
        //         no1 = charNo1.size();
        //         charNo1.put(c1,no1);
        //     }
        //     List<Integer> list1 = pattern1.getOrDefault(no1,new ArrayList());
        //     list1.add(i);
        //     pattern1.put(no1,list1);

        //     int no2 = charNo2.getOrDefault(c2,-1);
        //     if(no2==-1){
        //         no2 = charNo2.size();
        //         charNo2.put(c2,no2);
        //     }
        //     List<Integer> list2 = pattern1.getOrDefault(no2,new ArrayList());
        //     list2.add(i);
        //     pattern2.put(no2,list2);
        // }

        // if(pattern1.size()!=pattern2.size()) return false;
        // for(int i=0; i<pattern1.size(); i++){
        //     List<Integer> list1 = pattern1.getOrDefault(i,new ArrayList());
        //     List<Integer> list2 = pattern2.getOrDefault(i,new ArrayList());
        //     if(list1.size()!=list2.size()) return false;
        //     for(int j=0; j<list1.size(); j++){
        //         if(list1.get(j)!=list2.get(j)) return false;
        //     }
        // }
        // return true;
        //그래서 또 생각한것이 이제는? 그거다~
        //스트링 길이만큼 인티저 배열 만들어놓고
        //몇번 글자인지 기록을 하기~
        //그리고 그거 오셀로처럼 뒤집어가지고~ 같게 만들수 있다면 되는것임...아 저거 재활용을 할까 그냥?
        //리스트가 더 짧으면 다른거 갖다 붙여가지고 같은 리스트 되는지 조합을 해봐? => 몇개가 들어갈줄 알고 그렇게 합니까!
        //1인것을 3으로 바꾸고? 약간 이런식으로,,다가,,,?
        //아니면 완전 더 간단하게 처음부터 끝까지 훑으면서 aa로 만들기위해 c => a 매핑해두고 그거 다 바꾸는것임 근데 글자 매핑이 2번째가 되게 되면...
        //하나를 바꿔야되는게 2개가 되거나 바꾼게 틀리거나 하면 바로 FALSE를 반환하는것임
        //이게 더 말이 되네~ 이렇게 풀자 더 간단하고 좋은거같기도...
        Map<Character, Character> map = new HashMap<>();
        if (str1.length() != str2.length())
            return false;

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 == c2) {
                map.put(c1, c2);
                continue;
            }

            char replacement = map.getOrDefault(c1, ' ');
            
            if (replacement == ' ') {//처음 나온 항목이면
                map.put(c1, c2);//등록시키고 킵고잉함
                continue;
            }

            //처음 나온 항목이 아니면 
            if (replacement != c2) {
                return false;
            }
        }
        if (new HashSet<>(Arrays.asList(str2.split(""))).size() == 26) {
            return str1.equals(str2);
        }
        return true;
    }
}