package 牛客网算法题;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class SolutiTreeLinkNodeonGetNext {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        //如果这个节点有右子节点，就返回右子树的第一个被访问的节点
        if(pNode.right!=null){
            return findFirstNode(pNode.right);
        }
        //否则就查看这个节点的父节点，如果这个节点是父节点的左节点，就返回父节点
        if(pNode.next==null){
            return null;
        }
        if(pNode.next.left==pNode){
            return pNode.next;
        }
        //如果这个节点是父节点的右节点，就返回父节点的父节点
        if(pNode.next.right==pNode){
            return findFirstNode2(pNode.next);
        }
        return null;
    }
    TreeLinkNode findFirstNode(TreeLinkNode node){
        if(node.left!=null){
            return findFirstNode(node.left);
        }else{
            return node;
        }
        
    }
    //如果目标节点是父节点的右子节点，且没有任何子节点的话，
    TreeLinkNode findFirstNode2(TreeLinkNode node){
        if(node.next==null){
            return null;
        }
        if(node.next.right==node){
            return findFirstNode2(node.next);
        }
        if(node.next.left==node){
            return node.next;
        }
        return null;
        
    }
}