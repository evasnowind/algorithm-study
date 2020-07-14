package com.prayerlaputa.datastructure.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/8/7
 */
public class BinaryTree {

    public void printNode(TreeNode node) {
        System.out.println(node);
    }

    public void preOrderTraverseTreeRecursively(TreeNode root) {
        if (null == root) {
            return;
        }

        printNode(root);
        preOrderTraverseTreeRecursively(root.left);
        preOrderTraverseTreeRecursively(root.right);
    }

    public void preOrderTraverseTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while(null != node || !stack.isEmpty()) {
            if (null != node) {
                printNode(node);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmpNode = stack.pop();
                node = tmpNode.right;
            }
        }
    }

    public void inOrderTraverseTreeRecursively(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrderTraverseTreeRecursively(root.left);
        printNode(root);
        inOrderTraverseTreeRecursively(root.right);
    }

    public void inOrderTraverseTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(null != node || !stack.isEmpty()) {
            if (null != node) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tmpNode = stack.pop();
                printNode(tmpNode);
                node = tmpNode.right;
            }
        }
    }

    public void postOrderTraverseTreeRecursively(TreeNode root) {
        if (null == root) {
            return;
        }

        postOrderTraverseTreeRecursively(root.left);
        postOrderTraverseTreeRecursively(root.right);
        printNode(root);
    }

    public void postOrderTraverseTree(TreeNode root) {
        if (null == root) {
            return;
        }

        TreeNode curNode, preNode = null;
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> output = new LinkedList<>();
        stack.push(root);
        curNode = root;
        while(null != curNode || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                output.push(curNode);
                curNode = curNode.right;
            } else {
                curNode = stack.pop();
                curNode = curNode.left;
            }
        }

        while(output.size() > 0) {
            TreeNode node = output.pop();
            printNode(node);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        return "val=" + val;
    }
}
