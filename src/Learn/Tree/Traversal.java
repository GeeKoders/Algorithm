package Tree;

public class Traversal {

	public static void main(String[] args) {
		int[] num = { 7, 4, 1, 5, 16, 8, 11, 12, 15, 9, 2 };

		System.out.println("origin matrix:");
		for (int i : num) {
			System.out.print(i + " ");
		}

		BinaryTree tree = new BinaryTree();
		System.out.println();
		System.out.println("binary search tree");
		for (int i : num)
			tree.addNode(i);

		System.out.println("inOrder:");
		tree.inOrder(tree.root);
		System.out.println();
		System.out.println("preOrder:");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("postOrder:");
		tree.postOrder(tree.root);
	}

}

class Node {

	public int value;

	public Node leftChild;

	public Node rightChild;

	public Node(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

}

class BinaryTree {

	public Node root;

	public void addNode(int value) {

		if (root == null) {
			root = new Node(value);
		} else {

			Node current = root;

			while (true) {

				if (value < current.value) {

					if (current.leftChild == null) {
						current.leftChild = new Node(value);
						return;
					} else {
						current = current.leftChild;
					}

				} else {

					if (current.rightChild == null) {
						current.rightChild = new Node(value);
						return;
					} else {
						current = current.rightChild;
					}

				}

			}
		}

	}

	public void inOrder(Node node) {

		if (node != null) {
			inOrder(node.leftChild);
			System.out.print(node.value + " ");
			inOrder(node.rightChild);
		}
	}

	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}

	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.print(node.value + " ");
		}
	}

}
