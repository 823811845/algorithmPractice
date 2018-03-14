package 生成哈夫曼树;

import 树的基础练习.MultiwayNode;
import 树的基础练习.MultiwayTree;

/**
 * 这里我们建立一个字典树
 */
@SuppressWarnings("hiding")
public class TrieTree extends 树的基础练习.MultiwayTree<Character> {
	public void addWord(String str) {
		MultiwayNode<Character> proot = root;
		for (int i = 0; i < str.length(); i++) {
			Character a = str.charAt(i);
//			System.out.println(this.toString());
			if (proot.sonNodes.size() == 0) {
				proot.sonNodes.add(0, new MultiwayNode<Character>(a));
				proot = proot.sonNodes.get(0);
				continue;
			}
			for (int j = 0; j < proot.sonNodes.size(); j++) {
				// 这段代码可能会有问题
				int result = a.compareTo(((proot.sonNodes.get(j)).val));
				if (result == 0) {
					proot = proot.sonNodes.get(j);
					break;
				}
				if (result > 0) {
					proot.sonNodes.add(j, new MultiwayNode<Character>(a));
					proot = proot.sonNodes.get(j);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		TrieTree tree = new TrieTree();
		tree.addWord("1234");
		tree.addWord("4355");
		System.out.println(tree.toString());
	}
}
