package Tree;

import java.util.Scanner;

public class TreeApp {

	NodeApp root;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] nums = new int[5];

		for (int i = 0; i < nums.length; i++) {
			System.out.print("input your value:");
			nums[i] = sc.nextInt();
		}
		TreeApp treeApp = new TreeApp(nums);
		
		System.out.println("Create binary tree success") ;

	}

	public TreeApp(int[] nums) {

		for (int value : nums) {
			addNodeToTree(value);
		}
	}

	private void addNodeToTree(int value) {

		NodeApp current = root;

		if (root == null) {
			root = new NodeApp(value);
		} else {

			while (true) {
				// left
				if (value < current.value) {
					if (current.leftChild == null) {
						current.leftChild = new NodeApp(value);
						return;
					} else {
						current = current.leftChild;
					}
					// right
				} else {
					if (current.rightChild == null) {
						current.rightChild = new NodeApp(value);
						return;
					} else {
						current = current.rightChild;
					}
				}

			}

		}

	}

}

class NodeApp {

	public int value;

	public NodeApp leftChild;

	public NodeApp rightChild;

	public NodeApp(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
}
