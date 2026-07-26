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

        ListNode curr = head;
        ListNode temp = head;
        ListNode prev = null;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head = prev;
        return head;
    }

    public ListNode findMid(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        
        ListNode mid = findMid(head);
        ListNode t1 = head;
        ListNode t2 = reverse(mid.next);
        mid.next = null;

        while(t2 != null){
            if(t1.val != t2.val)
                return false;
            t1 = t1.next;
            t2 = t2.next;
        }

        return true;
    }
}