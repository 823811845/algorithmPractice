package 树的基础练习;

//代码一定要能够复用，否则就不能称之为好的代码
//这个代码可以随便改
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

    // 横向遍历一棵树：
    public String toString() {
        return root.treeToString();
    }

    //public static void main(String[] args) {
    //MultiwayTree<String> ss=new MultiwayTree<>();
    //ss.root.sonNodes.get(0).
    //}
}
