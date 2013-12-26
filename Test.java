
public class Test {
	public static void main(String args[]) {
		reverseNodesInKGroupTest();
	}
	
	private static void reverseNodesInKGroupTest() {
		int k = 2; // Set up for the k
		// Initial set up 1->2->3->4->5->6->7
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(4);
		ListNode h5 = new ListNode(5);
		ListNode h6 = new ListNode(6);
		ListNode h7 = new ListNode(7);
		h1.next = h2; h2.next = h3; h3.next = h4; h4.next = h5; h5.next = h6;
		h6.next = h7; h7.next = null;
		
		ReverseNodesInKGroup test = new ReverseNodesInKGroup();
		ListNode result = test.reverseKGroup(h1, k);
		while(result != null) {
			if(result.next != null)System.out.print(result.val + "->");
			else System.out.print(result.val);
			result = result.next;
		}
	}
}
