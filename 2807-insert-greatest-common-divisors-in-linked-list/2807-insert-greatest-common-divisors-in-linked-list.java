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
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        //이것도 recursion일것같은데~
        int newMax = max - min;
        if (newMax==0){
            return max;
        }
        return getGCD(newMax,min);
    }
}