package com.chzero.algorithm.binary_bearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 当插入的数据有序时, 二叉查找树会退化为链表, 此为局限性   红黑树解决看此问题.
 *
 * 对于二叉树，有深度遍历和广度遍历，深度遍历有前序、中序以及后序三种遍历方法，广度遍历即我们寻常所说的层次遍历
 * 二分搜索树 最小值, 最大值, 第一次出现的位置, 最后一次出现位置, 查询的数据是当前数据的第几名, 求所有数据的第多少名.
 * @author : CHZERO
 * @date   : 2019-03-20 09:56:04
 * @email  : 827348260@qq.com
 * @description : 特点, 父节点大于左孩子, 小于右孩子. 以左右孩子为跟的子树仍未二分搜索树.
 * 二分搜索树不一定是一个完全二叉树.
 */
public class BinarySearchTree {

	private Node root;
	private int  count;

	public BinarySearchTree() {
		this.root = null;
		this.count = 0;
	}

	public int size() {
		return this.count;
	}

	public boolean isEmpty() {
		return this.count == 0;
	}

	public void insert(int key, int value) {
		this.root = this._insert(this.root, key, value);
	}

	public boolean contain(int key) {
		return this._contain(this.root, key);
	}

	public int search(int key) {
		return this._search(this.root, key);
	}

	//前序遍历：根结点 ---> 左子树 ---> 右子树
	public void preErgodic() {
		this._preErgodic(root);
	}

	//中序遍历：左子树---> 根结点 ---> 右子树
	public void inErgodic() {
		this._inErgodic(root);
	}

	//后序遍历：左子树 ---> 右子树 ---> 根结点
	public void postErgodic() {
		this._postErgodic(root);
	}

	//层序遍历, 广度优先遍历  一层一层的从左往右遍历
	public void levelErgodic() {
		this._levelErgodic();
	}

	//寻找最大值
	public void minNumber() {
		assert (this.count > 0);
		Node minNode = root;
		while (minNode.left != null){
			minNode = minNode.left;
		}
		System.out.println("最小节点: " + minNode.key + " <--> " + minNode.value);
	}

	//寻找最小值
	public void maxNumber() {
		assert (this.count > 0);
		Node minNode = root;
		while (minNode.right != null){
			minNode = minNode.right;
		}
		System.out.println("最大节点: " + minNode.key + " <--> " + minNode.value);
	}

	//删除最小值节点
	public void removeMinNumber() {
		if (root != null){
			Node parentNode = root;
			Node minNode = root;
			while (minNode.left != null){
				minNode = minNode.left;
				parentNode = minNode;
			}



		}



	}
	//删除最大值节点
	public void removeMaxNumber() {

	}




	private void _preErgodic(Node root) {
		if (root != null) {
			System.out.println(root.key + " <--> " + root.value);
			this._preErgodic(root.left);
			this._preErgodic(root.right);
		}
	}

	private void _inErgodic(Node root) {
		if (root != null) {
			this._inErgodic(root.left);
			System.out.println(root.key + " <--> " + root.value);
			this._inErgodic(root.right);
		}
	}

	private void _postErgodic(Node root) {
		if (root != null) {
			this._postErgodic(root.left);
			this._postErgodic(root.right);
			System.out.println(root.key + " <--> " + root.value);
		}
	}

	public void _levelErgodic() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			System.out.println(node.key + " <--> " + node.value);
		}


	}


	//查询某个key是否存在树中
	private boolean _contain(Node root, int key) {
		if (root == null) {
			return false;
		}
		if (root.key == key) {
			return true;
		} else if (root.key > key) {
			return this._contain(root.left, key);
		} else {
			return this._contain(root.right, key);
		}
	}

	//比方: 没找到返回-1, 找到了返回具体值
	private int _search(Node root, int key) {
		if (root == null) {
			return -1;
		}
		if (root.key == key) {
			return root.value;
		} else if (root.key > key) {
			return this._search(root.left, key);
		} else {
			return this._search(root.right, key);
		}
	}


	//向以root为根节点的二叉搜索树中插入一个key-value
	//返回插入新节点后的二叉搜索树的根.
	private Node _insert(Node root, int key, int value) {
		if (root == null) { //节点不存在, 新插入
			this.count++;
			return new Node(key, value);
		}

		if (root.key == key) { //如果插入的key和节点key相同, 覆盖原值
			root.value = value;
		} else if (root.key > key) { //插入的key小于根节点key, 与左节点匹配
			root.left = this._insert(root.left, key, value);
		} else {
			root.right = this._insert(root.right, key, value);  //插入的key大于根节点key, 与右节点匹配
		}

		return root;
	}

	class Node {

		private int  key;
		private int  value;
		private Node left;
		private Node right;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	public static void main(String[] args) {
		BinarySearchTree searchTree = new BinarySearchTree();
		searchTree.insert(4, 1001);
		searchTree.insert(14, 10011);
		searchTree.insert(5, 100111);
		searchTree.insert(34, 1010);
		searchTree.insert(1, 1100);
		searchTree.insert(44, 1020);
		searchTree.insert(3, 1030);
		searchTree.insert(45, 1040);

		boolean contain = searchTree.contain(45);
		int search = searchTree.search(0);
		System.out.println(contain);
		System.out.println(search);

		System.out.println("前序遍历:");
		searchTree.preErgodic();

		System.out.println("中序遍历:");
		searchTree.inErgodic();

		System.out.println("后序遍历:");
		searchTree.postErgodic();

		System.out.println("层次遍历:");
		searchTree.levelErgodic();

		searchTree.minNumber();
		searchTree.maxNumber();

	}


}


