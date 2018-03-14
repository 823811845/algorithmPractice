package Ê÷µÄ»ù´¡Á·Ï°;
public class BinaryNode<T> {
	T val = null;
	public double weight = 0;
	public BinaryNode left = null;
	public BinaryNode right = null;

	public BinaryNode(T t, double weight) {
		this.weight = weight;
		this.val = t;
	}
	public BinaryNode(T t) {
		this.weight = 0.0;
		this.val = t;
	}

	public String toString() {
		if (val == null) {
			return "%";
		}
		return val.toString();
	}

	public static void main(String[] args) {
		BinaryNode node = new BinaryNode("A", 40.0);
		System.out.println(node.toString());
	}
}
