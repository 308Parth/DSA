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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next;
        */

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode newList = new ListNode(0);
        ListNode head = newList;

        while (temp1 != null && temp2 != null) {

            if (temp1.val < temp2.val) {
                newList.next = temp1;
                temp1 = temp1.next;
            } else {
                newList.next = temp2;
                temp2 = temp2.next;
            }

            newList = newList.next;
        }

        while (temp1 != null) {
            newList.next = temp1;
            temp1 = temp1.next;
            newList = newList.next;
        }

        while (temp2 != null) {
            newList.next = temp2;
            temp2 = temp2.next;
            newList = newList.next;
        }

        return head.next;        
    }
}