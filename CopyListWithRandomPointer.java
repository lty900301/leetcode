import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the
 * list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author JoshLuo
 * 
 */
public class CopyListWithRandomPointer {

    // BFS
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> oldToNew = new HashMap<RandomListNode, RandomListNode>();
        oldToNew.put(head, new RandomListNode(head.label));

        RandomListNode runner = head;
        while (runner.next != null) {
            oldToNew.put(runner.next, new RandomListNode(runner.next.label));
            oldToNew.get(runner).next = oldToNew.get(runner.next);
            runner = runner.next;
        }

        runner = head;
        while (runner != null) {
            if (runner.random != null) {
                oldToNew.get(runner).random = oldToNew.get(runner.random);
            }
            runner = runner.next;
        }

        return oldToNew.get(head);
    }

}
