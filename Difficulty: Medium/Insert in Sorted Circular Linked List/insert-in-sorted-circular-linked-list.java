/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        
        // Inserting element at the start while retaining circular list
        if (head.data >= data) {
            newNode.next = head;
            
            Node ptr = head;
            while (ptr.next != head) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
            
            return newNode;
        }
        
        Node ptr = head;
        while (ptr.next != head && ptr.next.data <= data) {
            ptr = ptr.next;
        }
        
        newNode.next = ptr.next;
        ptr.next = newNode;
        
        return head;
    }
}