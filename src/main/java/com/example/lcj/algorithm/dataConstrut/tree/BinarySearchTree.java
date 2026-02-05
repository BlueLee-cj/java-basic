package com.example.lcj.algorithm.dataConstrut.tree;

class BinarySearchTree {

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Driver function
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
			50
		  /	 \
		30	 70
	   / \   / \
	  20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        for (int i = 1; i <= 7; i++) {
            tree.kthLargest(i);
        }
    }

    // function to insert nodes
    public void insert(int data) {
        this.root = this.insertRec(this.root, data);
    }

    /* A utility function to insert a new node
    with given key in BST */
    Node insertRec(Node node, int data) {
        /* If the tree is empty, return a new node */
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }

        if (data == node.data) {
            return node;
        }

        /* Otherwise, recur down the tree */
        if (data < node.data) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    // utility function to find kth largest no in
    // a given tree

    /**
     * 想法是对BST进行反向有序遍历。 保持访问的节点数。
     * 反向有序遍历以降序遍历所有节点，即先访问右节点，然后居中，然后再向左遍历，并继续递归遍历这些节点。
     * 在进行遍历时，请跟踪到目前为止已访问的节点数。
     * 当计数等于k时，停止遍历并打印键。
     * @param k
     * @param C
     */
    void kthLargestUtil(Node node, int k, count C) {
        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (node == null || C.c >= k)
            return;

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        this.kthLargestUtil(node.right, k, C);

        // Increment count of visited nodes
        C.c++;

        // If c becomes k now, then this is the k'th largest
        if (C.c == k) {
            System.out.println(k + "th largest element is " +
                    node.data);
            return;
        }

        // Recur for left subtree
        this.kthLargestUtil(node.left, k, C);
    }

    // Method to find the kth largest no in given BST
    void kthLargest(int k) {
        count c = new count(); // object of class count
        this.kthLargestUtil(this.root, k, c);
    }

    // class that stores the value of count
    public class count {
        int c = 0;
    }
}

