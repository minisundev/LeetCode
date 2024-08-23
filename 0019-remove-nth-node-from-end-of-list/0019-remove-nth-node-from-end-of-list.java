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

import java.util.*;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);//edge case 처리 쉽게 하기
        dummy.next = head;

        ListNode nBefore = dummy;
        ListNode now = dummy;

        for(int i=0; i<n; i++){
            if(now == null) return head;
            now = now.next;
        }

        while(now.next!=null){
            nBefore = nBefore.next;
            now = now.next;
        }

        nBefore.next = nBefore.next.next;

        return dummy.next;//head이면 안됨 그게 삭제되었을수도 있어
    }
}