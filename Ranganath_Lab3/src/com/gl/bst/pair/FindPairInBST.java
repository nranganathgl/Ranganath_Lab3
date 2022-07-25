package com.gl.bst.pair;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Ranganath
 *
 *         This program is created to Find a pair with a given sum in Binary
 *         Search Tree
 * 
 */
public class FindPairInBST {

	static class Node {
		int data;
		Node left, right;
	}

	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	/*
	 * This method takes Node and node value as input parameters and inserts the
	 * node like in BST format and it returns the inserted node.
	 */
	public Node insert(Node root, int key) {

		try {
			if (root == null) {
				// System.out.println("root is null for key "+key);
				return newNode(key);
			}

			if (key < root.data) {
				root.left = insert(root.left, key);
			} else {
				root.right = insert(root.right, key);
			}
		} catch (Exception exc) {
			System.out.println("Exception in the insert: " + exc.getMessage());
		}

		return root;
	}

	/*
	 * This method takes Node, integer and HashSet as input paramaters then it
	 * recursively calls the same method using InOrder traversal. It returns true
	 * and and display the pair if there is any pair found where sum of the pair is
	 * equal to the input parameter sum else it returns false.
	 */
	public boolean findPairUtil(Node root, int sum, Set<Integer> set) {

		try {
			if (root == null) {
				return false;
			}

			if (findPairUtil(root.left, sum, set)) {
				return true;
			}

			if (set.contains(sum - root.data)) {
				System.out.println("Sum = " + sum);
				System.out.println("Pair is (" + (sum - root.data) + "," + root.data + ")");
				return true;
			} else {
				set.add(root.data);
			}
		} catch (Exception exc) {
			System.out.println("Exception in the findPairUtil: " + exc.getMessage());
		}

		return findPairUtil(root.right, sum, set);
	}

	/*
	 * This method takes Node and sum as input parameters then it calls the another
	 * method findPairForGivenSum if result is false then it displays a message
	 * nodes are not found.
	 */
	void findPairForGivenSum(Node root, int sum) {
		Set<Integer> set = new HashSet<>();

		if (!findPairUtil(root, sum, set)) {
			System.out.println("nodes are not found");
		}
	}

	/*
	 * This is main method of the program. It calls the methods insert to insert the
	 * data in BST and findPairForGivenSum to find the pair for given sum
	 */
	public static void main(String[] args) {

		Node root = null;
		int sum = 800;

		FindPairInBST object = new FindPairInBST();

		root = object.insert(root, 40);
		root = object.insert(root, 20);
		root = object.insert(root, 60);
		root = object.insert(root, 10);
		root = object.insert(root, 30);
		root = object.insert(root, 50);
		root = object.insert(root, 70);

		object.findPairForGivenSum(root, sum);
	}

}
