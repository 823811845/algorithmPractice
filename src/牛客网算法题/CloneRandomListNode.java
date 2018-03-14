package 牛客网算法题;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，
 * 输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
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
        //现在开始添加自由节点，
        node =pHead;
        node2 =pHead2;
        RandomListNode nodeRan;
        RandomListNode node2Ran;
        while(node2!=null){
            if(node.random!=null){
                //遍历整个列表，寻找这个指针到底指向那个节点
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
        //在被复制的链表中找到这个节点，并且赋值
        RandomListNode tempNode=pHead2;
        for(int i=0;i<index;i++){
            tempNode=tempNode.next;
        }
        node2.random=tempNode;
    }
}