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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int last2 = head.val;
        head = head.next;
        int last1 = head.val;
        head = head.next;

        List<Integer> critical = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int index = 2;

        while(head!=null){         
            if(last2 < last1 && last1 > head.val){
                critical.add(index-1);
                if(critical.size()>=2){
                    min = Math.min(min,critical.get(critical.size()-1)-critical.get(critical.size()-2));
                }
            }
            if(last2 > last1 && last1 < head.val){
                critical.add(index-1);
                if(critical.size()>=2){
                    min = Math.min(min,critical.get(critical.size()-1)-critical.get(critical.size()-2));
                }
            }

            last2 = last1;
            last1 = head.val;
            head = head.next;
            index++;
        }

        if(critical.size()<2){
            return new int []{-1,-1};
        }
        
        int max = critical.get(critical.size()-1)-critical.get(0);
        int [] ans = new int []{min,max};
        return ans;
    }
}