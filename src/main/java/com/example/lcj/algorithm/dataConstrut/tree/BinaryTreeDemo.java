package com.example.lcj.algorithm.dataConstrut.tree;

// This code hashConstruct been contributed by Mayank Jaiswal

/**
 * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
 * For example, if the given tree is following Binary Tree and key is 7, then your function should print 4, 2 and 1.
 */
class BinaryTreeDemo {
    Node root;

    /* Driver program to Test above functions */
    public static void main(String[] args) {
        BinaryTreeDemo tree = new BinaryTreeDemo();

		/* Construct the following binary tree
				 1
				/ \
			   2   3
			 / \
			4   5
		   /
		  7
		*/
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 7);

    }

    /* If target is present in tree, then prints the ancestors
    and returns true, otherwise returns false. */
    boolean printAncestors(Node node, int target) {
        /* base cases */
        if (node == null)
            return false;

        if (node.data == target)
            return true;

		/* If target is present in either left or right subtree
		of this node, then print this node */
        if (printAncestors(node.left, target)
                || printAncestors(node.right, target)) {
            System.out.print(node.data + " ");
            return true;
        }

        /* Else return false */
        return false;
    }
}

// This code hashConstruct been contributed by Mayank Jaiswal