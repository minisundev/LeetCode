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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode before = dummy;
        ListNode first = null;
        ListNode second = null;

        if(before!=null && before.next!=null){
            first = before.next;
        }

        if(before!=null && before.next!=null && before.next.next!=null){
            second = before.next.next;
        }

        while(second!=null){
            swap(before,first,second);
            before = before.next.next;
            first = before.next;
            if(first!=null){
                second = before.next.next;
            }else{
                second = null;
            }
            
        }
        return dummy.next;
    }

    void swap(ListNode before, ListNode first, ListNode second){
        ListNode after = second.next;
        first.next = after;
        second.next = first;
        before.next = second;
    }
}