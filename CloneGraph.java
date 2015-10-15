import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * 
 * <code>
 *      1
 *     / \
 *    /   \
 *   0 --- 2
 *        / \
 *        \_/
 * </code>
 * 
 * @author JoshLuo
 * 
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> originalToClone = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode clonedHead = new UndirectedGraphNode(node.label);
        queue.add(node);
        originalToClone.put(node, clonedHead);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                if (!originalToClone.containsKey(neighbor)) {
                    queue.add(neighbor);
                    UndirectedGraphNode clonedNeighbor = new UndirectedGraphNode(neighbor.label);
                    originalToClone.put(neighbor, clonedNeighbor);
                }
                originalToClone.get(curNode).neighbors.add(originalToClone.get(neighbor));
            }
        }
        return clonedHead;
    }

}
