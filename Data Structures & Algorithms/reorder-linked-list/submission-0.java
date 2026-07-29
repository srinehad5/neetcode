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

    public ListNode reverse(ListNode head){

        ListNode curr = head, temp = head, prev = null;

        while(curr != null){
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head = prev;
        return head;
    }

    public ListNode findMid(ListNode head){

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    

    public void reorderList(ListNode head) {
        
        ListNode mid = findMid(head);
        ListNode t1 = head;
        ListNode t2 = reverse(mid.next);
        mid.next = null;

        while(t2 != null){
            ListNode t3 = t2.next;
            t2.next = t1.next;
            t1.next = t2;

            t1 = t2.next;
            t2 = t3;
        }
    }
}
