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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode h = new ListNode();
        h.next=head;
        
        int n=0;
        
        while(h.next!=null){
            h=h.next;
            n++;
        }

        if(k==0 || n==0 || n==1) return head;

        k = k%n;

        if(k==0) return head;      
        
        int cnt = 0;
        h = new ListNode(0);
        h.next = head;
        ListNode tail =h;
        ListNode newTail=h;
        ListNode newHead= h;
        
        while(tail.next!=null){

            if(cnt==n-k){
                newTail=tail;
                newHead=newTail.next;
            }

            cnt++;
            tail=tail.next;
        }
        tail.next= h.next;
        newTail.next=null;
        h.next=newHead;
        
        return h.next;
        
    }
}