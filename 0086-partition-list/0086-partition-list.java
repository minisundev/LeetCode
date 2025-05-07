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
    public ListNode partition(ListNode head, int x) {
        //타겟보다 작은것들을 싹 앞으로 빼오면 됨 타겟과 같거나 크면 앞으로 계속이동
        //이거를 그냥 두개의 리스트노드에 줄줄이 달았다가 합쳐서 돌려보내면 빨리 할 수 있을거같아
        ListNode lt = new ListNode(-1);
        ListNode gte = new ListNode(-1);

        ListNode answer = lt;
        ListNode gteStart = gte;

        ListNode pointer = head;

        while(pointer!=null){
            if(pointer.val<x){
                lt.next=pointer;
                lt = lt.next;
            }else{
                gte.next = pointer;
                gte = gte.next;
            }
            pointer = pointer.next;
        }

        //check(gte,"gte");
        //check(lt,"lt");
        
        lt.next = gteStart.next;
        gte.next = null;
        answer = answer.next;
        return answer;
    }

    void check(ListNode list,String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s).append(':');
        while(list!=null){
            sb.append(list.val).append(' ');
            list = list.next;
        }
        System.out.println(sb);
    }
}