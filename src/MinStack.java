
/* Design a stack that supports push, pop, top, and retrieving 
 * the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack. */

public class MinStack {

	Node head = null;

	class Node {

		int value;
		// the min value when this node is pushed on top of stack
		int minByNow;
		Node next;

		public Node(int val) {
			this.value = val;
			this.next = null;
			this.minByNow = val;
		}
	}

	public void push(int x) {
		Node newNode = new Node(x);
		if (head == null) {
			head = newNode;
		} else {
			newNode.minByNow = Math.min(head.minByNow, x);
			newNode.next = head;
			head = newNode;
		}
	}

	public void pop() {
		if (head == null)
			return;
		else
			head = head.next;
	}

	public int top() {
		if (head == null)
			return Integer.MAX_VALUE;
		else
			return head.value;
	}

	public int getMin() {
		if (head == null) {
			return Integer.MAX_VALUE;
		} else {
			return head.minByNow;
		}
	}
}
