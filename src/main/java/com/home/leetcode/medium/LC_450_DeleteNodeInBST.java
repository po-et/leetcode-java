package com.home.leetcode.medium;

/**
 * 450. Delete Node in a BST
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * @see <a href="https://leetcode.cn/problems/delete-node-in-a-bst/" />
 * @author Poet
 * @date 2020/5/4
 */
public class LC_450_DeleteNodeInBST {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {  // root.val == key
            if (root.right == null)
                return root.left;
            else if (root.left == null)
                return root.right;
            else {
                TreeNode successor = minimum(root.right);
                root.right = removeMin(root.right);

                successor.left = root.left;
                successor.right = root.right;
                return successor;
            }
        }
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = removeMin(node.left);
        return node;
    }

}
