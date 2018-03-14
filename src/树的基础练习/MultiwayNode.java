package Ê÷µÄ»ù´¡Á·Ï°;

import java.util.ArrayList;

public class MultiwayNode<T extends Comparable<T>> {
	public T val = null;
	public double weight = 0;
	public ArrayList<MultiwayNode<T>> sonNodes = new ArrayList<>(5);

	public MultiwayNode(T val) {
		this.val = val;
	}

	public MultiwayNode(T t, double weight) {
		this.weight = weight;
		this.val = t;
	}

	public String toString() {
		if (val == null) {
			return "%";
		}
		return val.toString();
	}

	public void addSonNode(MultiwayNode node) {
		this.sonNodes.add(node);
	}
}
