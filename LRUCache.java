import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * 
 * should invalidate the least recently used item before inserting a new item.
 * 
 * @author joshluo
 */
public class LRUCache {

    class DoubleLinkedListNode {
        int val;
        int key;
        DoubleLinkedListNode pre;
        DoubleLinkedListNode next;

        DoubleLinkedListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private int capacity;
    private int cacheCount;
    Map<Integer, DoubleLinkedListNode> cacheMap;
    DoubleLinkedListNode head; // cycle linked list

    public LRUCache(int capacity) {
        cacheMap = new HashMap<Integer, DoubleLinkedListNode>(capacity);
        this.capacity = capacity;
        cacheCount = 0;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            DoubleLinkedListNode latest = cacheMap.get(key);
            setNodeLatestUsed(latest);
            return latest.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (capacity <= 0)
            return;
        // Init the cycle linked list
        if (head == null) {
            initCache(key, value);
            return;
        }
        // If this key is already in the cache, set it
        if (cacheMap.containsKey(key)) {
            DoubleLinkedListNode node = cacheMap.get(key);
            node.val = value;
            setNodeLatestUsed(node);
        } else { // else, insert it
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            // if the cache has not reached it's limit
            if (cacheCount < capacity) {
                setNodeToHead(node);
                cacheMap.put(key, node);
                cacheCount++;
            } else {
                DoubleLinkedListNode tail = head.pre;
                cacheMap.remove(tail.key);
                removeNode(tail);
                setNodeToHead(node);
                cacheMap.put(key, node);
            }
        }
    }

    private void initCache(final int key, final int value) {
        head = new DoubleLinkedListNode(key, value);
        head.pre = head;
        head.next = head;
        cacheMap.put(key, head);
        cacheCount++;
    }

    private void removeNode(DoubleLinkedListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        if (node.key == head.key) {// removing the head
            head.pre.next = head.next;
            head.next.pre = head.pre;
            head = head.next;
        }
        // Above few lines of code took me too long to debug!!!
        // Was like this. I mean what were you thinking!!!
        // if(node.val == head.val) {
        // head = head.next;
        // }
    }

    private void setNodeToHead(DoubleLinkedListNode node) {
        node.pre = head.pre;
        node.next = head;
        node.pre.next = node;
        node.next.pre = node;
        head = node;
    }

    private void setNodeLatestUsed(DoubleLinkedListNode node) {
        removeNode(node);
        setNodeToHead(node);
    }

    public static void main(String[] args) {
        String testCase = "1,[get(2),set(2,1),get(2),set(3,1),get(2)]"; // Replace the string to test
        // Get the capacity
        int stringEnding = testCase.indexOf(",");
        LRUCache cache = new LRUCache(Integer.parseInt(testCase.substring(0, stringEnding)));
        testCase = testCase.substring(stringEnding + 2);
        // Operations
        StringBuilder sb = new StringBuilder("[");
        while (testCase.indexOf(")") >= 0) {
            stringEnding = testCase.indexOf(")") + 1;
            String operation = testCase.substring(0, stringEnding);
            if (operation.startsWith("set")) {
                int key = Integer.parseInt(operation.substring(operation.indexOf("(") + 1, operation.indexOf(",")));
                int value = Integer.parseInt(operation.substring(operation.indexOf(",") + 1, operation.indexOf(")")));
                cache.set(key, value);
            } else {
                int key = Integer.parseInt(operation.substring(operation.indexOf("(") + 1, operation.indexOf(")")));
                int result = cache.get(key);
                sb.append(sb.length() > 1 ? "," : "").append(result);
            }
            testCase = testCase.substring(stringEnding + 1);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
