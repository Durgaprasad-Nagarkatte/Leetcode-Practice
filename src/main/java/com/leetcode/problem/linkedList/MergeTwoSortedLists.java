package com.leetcode.problem.linkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, currNode = null, prevNode = null;

        while(l1 != null && l2 != null){
            currNode = new ListNode();

            if(head == null){
                head = currNode;
            }

            if(l1.val < l2.val){
                currNode.val = l1.val;
                l1 = l1.next;
            }else{
                currNode.val = l2.val;
                l2 = l2.next;
            }

            if(prevNode != null){
                prevNode.next = currNode;
            }

            prevNode = currNode;
        }

        while(l1 != null){
            currNode = new ListNode();
            if(head != null){
                head = currNode;
            }
            currNode.val = l1.val;
            if(prevNode != null){
                prevNode.next = currNode;
            }
            prevNode = currNode;
            l1 = l1.next;
        }

        while(l2 != null){
            currNode = new ListNode();
            if(head != null){
                head = currNode;
            }
            currNode.val = l2.val;
            if(prevNode != null){
                prevNode.next = currNode;
            }
            prevNode = currNode;
            l2 = l2.next;
        }

        return head;
    }

    public static void main(String[] args){
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
    }
}
