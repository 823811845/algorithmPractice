package ţ�����㷨��;

/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬
 * ���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 */

public class CloneRandomListNode {
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
    RandomListNode pHead;
    RandomListNode pHead2;
    public RandomListNode Clone(RandomListNode pHead)
    {
        this.pHead=pHead;
        pHead2=cloneNode(pHead);
        RandomListNode node =pHead;
        RandomListNode node2 =pHead2;
        while(node!=null){
            node=node.next;
            node2.next=cloneNode(node);
            node2=node2.next;
        }
        //���ڿ�ʼ������ɽڵ㣬
        node =pHead;
        node2 =pHead2;
        RandomListNode nodeRan;
        RandomListNode node2Ran;
        while(node2!=null){
            if(node.random!=null){
                //���������б�Ѱ�����ָ�뵽��ָ���Ǹ��ڵ�
                int index=findRandom(node.random);
                setRandom(node2,index);
            }
            node=node.next;
            node2=node2.next;
        }
        return pHead2;
    }
    public RandomListNode cloneNode(RandomListNode node){
        if(node==null){
            return null;
        }
        RandomListNode node2 =new  RandomListNode(node.label);
        return node;
    }
    public int findRandom(RandomListNode random){
        RandomListNode tempNode=pHead;
        int index=0;
        while(tempNode!=null){
            if(tempNode==random){
                 break;
            }
            tempNode=tempNode.next;
            index++;
        }
        return index;
    }
    public void setRandom(RandomListNode node2,int index){
        //�ڱ����Ƶ��������ҵ�����ڵ㣬���Ҹ�ֵ
        RandomListNode tempNode=pHead2;
        for(int i=0;i<index;i++){
            tempNode=tempNode.next;
        }
        node2.random=tempNode;
    }
}