/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ² m ² n ² length of list.
 * 
 * @author joshluo
 * 
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        assert (head != null && m >= 1 && n >= m);
        if (n == m)
            return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode mNodePre = pre, nNode = pre;
        for (int i = 0; i < m - 1; i++) {
            mNodePre = mNodePre.next;
        }
        for (int i = 0; i < n; i++) {
            nNode = nNode.next;
        }
        ListNode mNode = mNodePre.next;
        while (mNodePre.next != nNode) {
            ListNode temp = mNode.next;
            mNode.next = temp.next;
            temp.next = mNodePre.next;
            mNodePre.next = temp;
        }
        return pre.next;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1), l2 = new ListNode(2), l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l1 = new ReverseLinkedList2().reverseBetween(l1, 1, 3);
        while (l1.next != null) {
            System.out.print(l1.val + "->");
            l1 = l1.next;
        }
        System.out.println(l1.val);
    }
}
