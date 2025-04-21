class Solution {
    StringBuilder sb = new StringBuilder();

    public int romanToInt(String s) {
        //1,5 =4 1,10 = 9
        //10,50 = 40, 10,100 = 90
        //저런식으로 가는거임 근데 1,10,100,1000의 자리가 있겠지
        //1->5랑 1->10의 패턴만 조심하면 되는것입니다...! 
        //I 1
        //II 2
        //III 3
        // IV =>4
        // V 5
        //VI 6
        // VII 7
        //VIII 8
        // IX 9 => I다음에 뭐가 나오면 안되는것임...11은 뭐야 XI 
        //그러면 더 큰 숫자가 뒤에 나오면 역순이라고 생각해서 빼버리면 되는것입니다 ㅎ
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int digit = 10000;
        int number = map.get(s.charAt(0));
        int last = number;
        int index = 1;
        while (index < s.length()) {
            char c = s.charAt(index);
            int now = map.get(c);

            //System.out.print("last: "+ last+"-> now: "+now);

            if (now > last) {
                //System.out.println(" "+number+"->"+(number - 2*last + now));
                number = number - 2 * last + now;
            } else {
                //System.out.println(" "+number+"->"+(number + now));
                number = number + now;
            }
            last = now;
            index++;
        }

        return number;

    }
}