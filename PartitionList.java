/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * @author joshluo
 * 
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0), runner = pre, toInsert = pre;
        pre.next = head;

        // find the position where smaller value should insert
        boolean foundX = false;
        while (runner.next != null) {
            if (runner.next.val >= x) {
                foundX = true;
            } else {
                if (!foundX) {
                    toInsert = runner.next;
                } else {
                    // remove from current and insert to behind
                    ListNode temp = runner.next;
                    runner.next = temp.next;
                    temp.next = toInsert.next;
                    toInsert.next = temp;
                    toInsert = toInsert.next;
                    continue;
                }
            }
            runner = runner.next;
        }
        return pre.next;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(3), l2 = new ListNode(3), l3 = new ListNode(1), l4 = new ListNode(1), l5 = new ListNode(
                3), l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l1 = new PartitionList().partition(l1, 2);

        while (l1.next != null) {
            System.out.print(l1.val + " -> ");
            l1 = l1.next;
        }
        System.out.println(l1.val);
    }

}
