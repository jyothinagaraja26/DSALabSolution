package com.greatlearning.mentored.labsession4.quesion2;

import java.util.ArrayList;

//Creating Binary tree node
class Node {
	int nodeData;
	Node leftNode, rightNode;

	Node(int value) {
		nodeData = value;
		leftNode = rightNode = null;
	}
}

//Function to find and return the longest path

public class LongestPath {

	public static ArrayList<Integer> findLongestPath(Node root) {

		// if root is null no binary tree, return empty
		if (root == null) {
			ArrayList<Integer> path = new ArrayList<>();
			return path;
		}
		// Recursive call on root.rightnode
		ArrayList<Integer> rightNode = findLongestPath(root.rightNode);

		// Recursive call on root.leftnode
		ArrayList<Integer> leftNode = findLongestPath(root.leftNode);

		// Compare the size of the to Arraylist
		// and insert current node accordingly

		if (rightNode.size() < leftNode.size()) {
			leftNode.add(root.nodeData);
		} else {
			rightNode.add(root.nodeData);
		}

		// Return the appropriate Arraylist
		return (leftNode.size() > rightNode.size() ? leftNode : rightNode);
	}

	// Driver class
	public static void main(String[] args) {

		LongestPath tree = new LongestPath();
		Node root = new Node(100);

		Node node1 = new Node(20);
		Node node2 = new Node(130);
		Node node3 = new Node(10);
		Node node4 = new Node(50);
		Node node5 = new Node(110);
		Node node6 = new Node(140);
		Node node7 = new Node(5);

		node3.leftNode = node7;

		node1.leftNode = node3;
		node1.rightNode = node4;

		node2.leftNode = node5;
		node2.rightNode = node6;

		root.leftNode = node1;
		root.rightNode = node2;

		// prints the longest path from root
		ArrayList<Integer> longestPath = findLongestPath(root);
		int n = longestPath.size();

		System.out.println("Longest path is ");

		System.out.print(longestPath.get(n - 1));
		for (int i = n - 2; i >= 0; i--) {
			System.out.print(" -> " + longestPath.get(i));
		}
	}
}
