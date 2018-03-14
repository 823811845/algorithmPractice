package ���Ļ�����ϰ;

public class MultiwayTree<T extends Comparable<T>> {
	// Integer sonNum;
	protected MultiwayNode<T> root;

	public MultiwayTree(T val) {// MultiwayNode root){
		// this.sonNum=sonNum;
		root = new MultiwayNode<T>(val);
	}

	public MultiwayTree() {
		root = new MultiwayNode<T>(null);

	}

	MyQueue<MultiwayNode<T>> queue = new MyQueue();
	MyQueue<MultiwayNode<T>> queue2 = new MyQueue();
	boolean flag, flag2;

	// �����������һ������
	public String toString() {
		int maxDepth = 6;
		String str = "";
		if (root == null) {
			return "null";
		}

		// ��ʼ����
		queue.add(root);
		MultiwayNode<T> node = root;
		int depth = 0;
		while (!queue.isEmpty() || !queue2.isEmpty()) {
			depth++;
			// ÿ��֮ǰ�Ŀո�
			for (int i = 0; i < (Math.pow(2, maxDepth - depth))*node.sonNodes.size()/2; i++) {
				str += " ";
			}
			while (!queue.isEmpty()) {
				node = queue.poll();
				if (node == null) {
					queue2.add(null);
					queue2.add(null);
					str += "#";
				} else {
					for(int i=0;i<node.sonNodes.size();i++){
						queue2.add(node.sonNodes.get(i));
					}
					str += node.toString();
				}
				// ÿ���м�Ŀո�
				for (int i = 0; i < (Math.pow(2, maxDepth - depth + 1) - 1)*node.sonNodes.size()/2; i++) {
					str += " ";
				}
			}
			str += "\n";
			MyQueue<MultiwayNode<T>> tempQueue = queue;
			queue = queue2;
			queue2 = tempQueue;
		}
		return str;
	}

	// public static void main(String[] args) {
	// MultiwayTree<String> ss=new MultiwayTree<>();
	// ss.root.sonNodes.get(0).
	// }
}
