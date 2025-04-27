import java.util.*;

class Solution {

    Map<Integer,String> map = new HashMap<>();

    public String intToRoman(int num) {
        //4나 9로 시작하지 않으면 인풋에서 나오는 가장 큰 값 선택해서 결과에 붙여라 그리고 그걸 빼고 나머지로 다시 해라 -> 그리디 코인문제 같은거네 
        //4나 9로 시작하면 subtractive form을 사용해라 하나의 심볼을 상징하는 4는 5보다 1 작으니까 IV 이게 subtractive form 이라고 한다 4랑 9로 시작하는 것들은 이렇게 쓴다고 한다 나머지는 뒤에 더하는 형식인가봄 VIII = 8
        String s = new String();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");

        int digit = 1;
        while(num>0){
            int mod = num%10;
            //System.out.println(mod+" : "+mod*digit+" : "+getNumber(mod,digit));
            s = getNumber(mod,digit) + s;
            //sb.append(getNumber(mod,digit));

            num = num/10;
            digit = digit*10;
        }

        return s;
        
    }

    String getNumber(int mod, int digit){
        StringBuilder sb = new StringBuilder();
        int num = mod*digit;
        //1,2,3 => 순서대로 붙이기
        //4 => 5*digit 에다가 1*digit 붙이기
        //5 => 붙이기
        //6,7,8 => 5붙이고 그 후에 1,2,3 붙이기
        //9=> 10*digit에다가 1*digit 붙이기
        if(mod<=3){
            String s = map.get(1*digit);
            for(int i=0;i<mod; i++){
                sb.append(s);
            }
        }else if(mod==4){
            String s = map.get(1*digit);
            sb.append(s);
            s = map.get(5*digit);
            sb.append(s);

        }else if(mod<=8){
            String s = map.get(5*digit);
            sb.append(s);
            s = map.get(1*digit);
            for(int i=0;i<mod-5; i++){
                sb.append(s);
            }
        }else if(mod==9){
            String s = map.get(1*digit);
            sb.append(s);
            s = map.get(10*digit);
            sb.append(s);
        }   

        return sb.toString();
    }
}