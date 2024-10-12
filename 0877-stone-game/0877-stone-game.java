import java.util.*;

class Solution {
    public boolean stoneGame(int[] piles) {
        //plays optimally -> 지가 이길 수 있는 최선의 경우를 선택한다는 뜻인가
        PriorityQueue<Integer> pq = new PriorityQueue(
            (i1,i2) -> (int)i2-(int)i1
        );

        int sum = 0;
        for(int pile : piles){
            sum += pile;
            pq.add(pile);
        }

        int alice = 0;
        for(int i=0; i<piles.length/2; i++){
            alice += pq.poll();
        }

        if(alice>sum-alice){
            return true;
        }else{
            return false;
        }
    }
}