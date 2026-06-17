/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        //하나 insert하고 두번점프하기!! 그리고 반복하기!! -> recursion?
        if(head.next!= null){
            int gcd = getGCD(head.val,head.next.val);
            ListNode middle = new ListNode(gcd, head.next);
            head.next = middle;
            insertGreatestCommonDivisors(head.next.next);
        }
        return head;
    }

    int getGCD(int a, int b){
        //유클리드 호제법~

        //큰 수에서 작은 수를 빼도 최대공약수는 변하지 않는다
        //A = G * a
        //B = G * b
        //A - B = (G * a) - (G * b)
        //A - B = G * (a - b)
        // int max = Math.max(a,b);
        // int min = Math.min(a,b);
        // //이것도 recursion일것같은데~
        // int newMax = max - min;
        // if (newMax==0){
        //     return max;
        // }
        // return getGCD(newMax,min);

        //나머지 연산도 마찬가지
        //A % B = A - (q * B)
        //= (G * a) - q * (G * b)
        //= (G * a) - (G * q * b)
        //= G * (a - q * b)
        
        // b가 0이 되면 남은 a가 최대공약수
        if (b == 0) {
            return a;
        }
        // a를 b로 나눈 나머지를 구해서 다시 재귀 호출
        return getGCD(b, a % b);
    }
}