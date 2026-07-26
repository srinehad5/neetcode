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
    public ListNode removeElements(ListNode head, int val) {
        
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            if(temp.val != val)
                list.add(temp.val);
            temp = temp.next;
        }

        head = null;
        for(int x : list){
            ListNode newnode = new ListNode(x);
            if(head == null){
                head = newnode;
                temp = head;
            }
            else{
                temp.next = newnode;
                temp = temp.next;
            }
        }

        return head;
    }
}