import java.util.*;

class Solution {
    public long maxWeight(int[] pizzas) {
        long answer = 0L;
        //이게 그리디인것인가?
        Arrays.sort(pizzas);
        //그렇다면 투포인터로 앞에서 3개 뒤에서 1개~앞에서2개 뒤에서 2개 이렇게 추출하는게 제일 많이먹겠지...않나?
        int left = 0;
        int right = pizzas.length-1;
        int days = pizzas.length / 4;
        int odd = (days + 1) / 2; //z
        int even = days - odd; //y

        for(int i=0; i<odd; i++){//z로 쓰기~
            left = left+3;
            answer += pizzas[right--];
        }
        for(int i=0; i<even; i++){//y로 쓰기~
            left = left+2;
            answer += pizzas[right-1];
            right -= 2;
        }

        return answer;
    }
}