package Tree;

import java.util.*;

public class Construct {

	class node {
		int val;
		node left;
		node right = null;
	}

	private node root = null;
	Scanner scn;

	public Construct(String str) {
		scn = new Scanner(str);
		root = construct(null, false);
	}

	public node construct(node root, boolean lc) {

		if (root == null) {
			System.out.println("enter the value for root node");

		} else {
			if (lc == true) {
				System.out.println("enter the value for left child of " + root.val);
			} else {
				System.out.println("enter the value for right child of " + root.val);
			}
		}
		node nn = new node();
		nn.val = scn.nextInt();
		System.out.println(nn.val + " has left child ?");
		boolean hlc = scn.nextBoolean();
		if (hlc == true) {
			nn.left = construct(nn, true);
		}
		System.out.println(nn.val + " has right child?");
		boolean hrc = scn.nextBoolean();
		if (hrc == true) {
			nn.right = construct(nn, false);
		}

		return nn;

	}

	public void display() {
		display(root);
	}

	public void display(node root) {
		if (root == null)
			return;

		String str = "";
		if (root.left != null) {
			str += root.left.val + " <- " + root.val + " -> ";
		} else {
			str += "." + " <- " + root.val + " -> ";
		}
		if (root.right != null) {
			str += root.right.val;
		} else {
			str += ".";
		}
		System.out.println(str);
		display(root.left);
		display(root.right);

	}

	public int size() {
		return size(root);
	}

	public int size(node root) {
		if (root == null)
			return 0;
		int l = size(root.left);
		int r = size(root.right);
		return l + r + 1;

	}

	public int height() {
		return height(root);
	}

	public int height(node root) {
		if (root == null)
			return -1;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}

	public boolean find(int trgt) {
		return find(root, trgt);
	}

	public boolean find(node root, int trgt) {
		if (root == null)
			return false;
		if (root.val == trgt)
			return true;
		boolean left = find(root.left, trgt);
		if (left == true)
			return true;
		boolean right = find(root.right, trgt);
		return left || right;
	}

	public int max() {
		return max(root);
	}

	public int max(node root) {
		if (root == null)
			return 0;
		int l = max(root.left);
		int r = max(root.right);
		return Math.max(l, Math.max(r, root.val));
	}

	public void preOrder() {
		preOrder(root);
	}

	public void preOrder(node root) {

		if (root == null)
			return;
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder() {
		postOrder(root);
	}

	public void postOrder(node root) {

		if (root == null)
			return;
		System.out.println(root.val);
		postOrder(root.left);
		postOrder(root.right);
	}

	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(node root) {

		if (root == null)
			return;
		System.out.println(root.val);
		inOrder(root.left);
		inOrder(root.right);
	}

	public void levelOrder() {
		LinkedList<node> q = new LinkedList();
		q.addLast(root);
		q.addLast(null);
		while (!q.isEmpty()) {
			node temp = q.removeFirst();
			if (temp == null) {
				System.out.println();
				if (q.isEmpty())
					break;
				q.addLast(null);
				continue;
			}
			System.out.print(temp.val);
			if (temp.left != null) {
				q.addLast(temp.left);
			}
			if (temp.right != null) {
				q.addLast(temp.right);
			}

		}
	}

	public void leftView() {
		LinkedList<node> q = new LinkedList();
		q.addLast(root);
		while (!q.isEmpty()) {
			node temp = q.removeFirst();
			System.out.println(temp.val);
			if (temp.left != null) {
				q.addLast(temp.left);
			}

		}
	}

	public void rightView() {
		LinkedList<node> q = new LinkedList();
		q.addLast(root);
		while (!q.isEmpty()) {
			node temp = q.removeFirst();
			System.out.println(temp.val + "1");
			if (temp.right != null) {
				q.addLast(temp.right);
			}

		}
	}

//	end

}
