/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null)
            return head;
        
        Node temp = head;
        while(temp != null){
            Node newnode = new Node(temp.val);
            newnode.next = temp.next;
            temp.next = newnode;
            temp = newnode.next;
        }

        temp = head;
        while(temp != null){
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        
        Node dummy = new Node(-1);
        Node curr = head;
        temp = curr.next;
        dummy.next = temp;
        while(temp.next != null){
            curr.next = temp.next;
            temp.next = temp.next.next;;

            curr = curr.next;
            temp = temp.next;
        }
        curr.next = null;

        return dummy.next;
    }
}
