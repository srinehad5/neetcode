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
        
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            Node newnode = new Node(temp.val);
            map.put(temp, newnode);

            temp = temp.next;
        }
        for(Node node : map.keySet()){
            Node dup = map.get(node);
            dup.next = map.get(node.next);
            dup.random = map.get(node.random);
        }

        Node newhead = map.get(head);

        return newhead;
    }
}
