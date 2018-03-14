package 牛客网算法题;

import org.junit.Test;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 *
 */
public class deleteDuplication {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode deleteDuplication(ListNode pHead) { // 如果第一个节点和第二个节点内容相同
		if (pHead == null) {
			return null;
		}
		int val = pHead.val;
		boolean flag = false;
		while (pHead.next != null) {
			if (val == pHead.next.val) {
				pHead = pHead.next;
				flag = true;
			} else {
				val = pHead.next.val;
				if (flag) {
					pHead = pHead.next;
					flag = false;
				} else {
					break;
				}
			}
			if (pHead.next == null && flag) {
				pHead = null;
				return pHead;
			}
		}

		ListNode node = pHead;
		flag = false;
		if (node.next != null) {
			val = node.next.val;
		} else {
			return pHead;
		}
		while (node.next != null && node.next.next != null) {
			if (val == node.next.next.val) {
				node.next = node.next.next;
				flag = true;
			} else {
				if (flag) {
					node.next = node.next.next;
					flag = false;
				} else {
					node = node.next;
				}
				val = node.next.val;
			}
			if (node.next.next == null && flag) {
				node.next = null;
				return pHead;
			}
		}
		return pHead;
	}

	@Test
	public void test() {
		// ListNode pHead=new ListNode(1);
		// pHead.next=new ListNode(2);
		// pHead.next.next=new ListNode(3);
		// pHead.next.next.next=new ListNode(3);
		// pHead.next.next.next.next=new ListNode(4);
		// pHead.next.next.next.next.next=new ListNode(4);
		// pHead.next.next.next.next.next.next=new ListNode(5);

		ListNode pHead = new ListNode(1);
		pHead.next = new ListNode(1);
		pHead.next.next = new ListNode(2);
		pHead.next.next.next = new ListNode(3);
		pHead.next.next.next.next = new ListNode(3);
		pHead.next.next.next.next.next = new ListNode(4);
		pHead.next.next.next.next.next.next = new ListNode(5);
		pHead.next.next.next.next.next.next.next = new ListNode(5);
		// pHead.next.next.next.next.next.next.next.next = new ListNode(1);
		PointWay obj = new PointWay();
		obj.deleteDuplication(pHead);
	}

	/**
	 * 这里我们再尝试用指针来解决这个问题：
	 */
	class PointWay {
		public ListNode deleteDuplication(ListNode pHead) {
			if (pHead == null) {
				return null;
			}
			ListNode left = pHead, right = pHead;
			ListNode pre = pHead;
			// pre.next = pHead;
			boolean flag = false;
			while (right != null && right.next != null) {
				if (left.val == right.next.val) {
					right = right.next;
					flag = true;
				}
				if (right.next == null || left.val != right.next.val) {
					if (pHead == left) {
						if (flag) {
							pHead = right.next;
						}
						pre = right;
					} else {
						if (flag) {
							pre.next = right.next;
						} else {
							pre = right;
						}
					}
					flag = false;
					left = right.next;
					right = right.next;
				}
			}
			return pHead;
		}
	}
}