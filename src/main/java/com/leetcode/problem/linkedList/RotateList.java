package com.leetcode.problem.linkedList;

public class RotateList {
    public int getSize(ListNode head){
        ListNode temp = head;
        int size = 0;

        while(temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int size = getSize(head);
        k = k%size;

        // Return back the original list
        if(k == 0){
            return head;
        }

        int i = 0;
        ListNode fastNode = head;

        // Fast forwarding this pointer
        while(i < k){
            fastNode = fastNode.next;
            i++;
        }

        ListNode currNode = head;
        ListNode prevToFastNode = null;
        ListNode prevToCurrNode = null;

        // Finding the kth last node
        while(fastNode != null){
            prevToFastNode = fastNode;
            fastNode = fastNode.next;
            prevToCurrNode = currNode;
            currNode = currNode.next;
        }

        prevToCurrNode.next = null;
        prevToFastNode.next = head;
        head = currNode;

        return head;
    }
}
