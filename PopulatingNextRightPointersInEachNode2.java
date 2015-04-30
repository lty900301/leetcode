/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * 
 * <code>
 *  * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * </code>
 * 
 * @author joshluo
 * 
 */
public class PopulatingNextRightPointersInEachNode2 {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode node = root.next;
        while (node != null) {
            if (node.left != null) {
                node = node.left;
                break;
            }
            if (node.right != null) {
                node = node.right;
                break;
            }
            node = node.next;
        }
        if (root.right != null) {
            root.right.next = node;
            node = root.right;
        }
        if (root.left != null) {
            root.left.next = node;
        }
        connect(root.right); // We need to establish the right subtree first
        connect(root.left);
    }

}
