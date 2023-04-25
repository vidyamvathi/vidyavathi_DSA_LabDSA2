package com.greatlearning.javafsd.dsa.bst;

//import javax.swing.tree.TreeNode;

public class BinarySearchTree {
	private TreeNode rootNode;

	public BinarySearchTree() {
		rootNode = null;
	}

	public void insert(Integer nodeValue) {

		rootNode = insert(rootNode, nodeValue);
	}

	TreeNode insert(TreeNode rootNode, Integer nodeValue) {

		if (rootNode == null) {

			TreeNode newNode = createNewNode(nodeValue);
			return newNode;
		} else if (nodeValue < rootNode.getData()) {

			// Left Side
			TreeNode newNode = insert(rootNode.getLeftNode(), nodeValue);
			rootNode.setLeftNode(newNode);

			return rootNode;
		} else {

			// Right Side
			TreeNode newNode = insert(rootNode.getRightNode(), nodeValue);
			rootNode.setRightNode(newNode);

			return rootNode;
		}
	}

	TreeNode createNewNode(Integer nodeValue) {

		TreeNode newNode = new TreeNode(nodeValue);
		return newNode;
	}

	public TreeNode getRootNode() {
		return rootNode;
	}
}
