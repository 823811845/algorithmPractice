package ���Ļ�����ϰ;

//����һ��Ҫ�ܹ����ã�����Ͳ��ܳ�֮Ϊ�õĴ���
//��������������
public class MultiwayTree<T extends Comparable<T>> {
    protected MultiwayNode<T> root;
    private int deepth;

    public MultiwayTree(T val) {
        root = new MultiwayNode<T>(val);
    }

    public MultiwayTree() {
        root = new MultiwayNode<T>(null);

    }

    public int getDeepth() {
        return deepth;
    }

    public void setDeepth(int deepth) {
        this.deepth = deepth;
    }

    // �������һ������
    public String toString() {
        return root.treeToString();
    }

    //public static void main(String[] args) {
    //MultiwayTree<String> ss=new MultiwayTree<>();
    //ss.root.sonNodes.get(0).
    //}
}
