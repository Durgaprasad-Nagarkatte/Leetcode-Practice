package com.leetcode.problem.linkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode tempNode;
        int countSwaps = 0;

        while(currNode != null && currNode.next != null){
            if(countSwaps == 0){
                head = currNode.next;
                countSwaps++;
            }
            // Pointer to the next node
            tempNode = currNode.next;
            // Pointer to the previous node to join back the reversed list
            if(prevNode != null){
                prevNode.next = tempNode;
            }
            // Swapping and maintaining the pointer to the node to join later
            currNode.next = tempNode.next;
            tempNode.next = currNode;
            prevNode = currNode;
            currNode = currNode.next;
        }

        return head;
    }

    public static void main(String[] args){
    }
}
