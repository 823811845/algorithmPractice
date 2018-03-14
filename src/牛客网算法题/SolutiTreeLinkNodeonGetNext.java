package ţ�����㷨��;

/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
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
        //�������ڵ������ӽڵ㣬�ͷ����������ĵ�һ�������ʵĽڵ�
        if(pNode.right!=null){
            return findFirstNode(pNode.right);
        }
        //����Ͳ鿴����ڵ�ĸ��ڵ㣬�������ڵ��Ǹ��ڵ����ڵ㣬�ͷ��ظ��ڵ�
        if(pNode.next==null){
            return null;
        }
        if(pNode.next.left==pNode){
            return pNode.next;
        }
        //�������ڵ��Ǹ��ڵ���ҽڵ㣬�ͷ��ظ��ڵ�ĸ��ڵ�
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
    //���Ŀ��ڵ��Ǹ��ڵ�����ӽڵ㣬��û���κ��ӽڵ�Ļ���
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