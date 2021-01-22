// Fig. 21.17: Tree.java
// TreeNode and Tree class declarations for a binary search tree.
//package com.deitel.datastructures;

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
    /**
     * leftNode in a object with Type <T>
     *and will store the node from the left subtree
     * */
    TreeNode<T> leftNode;
    /**
     * data is of type T and stores the value at the node
     */
    T data;
    /**
     * Right node stores the nodes from the right subtree
     */
    TreeNode<T> rightNode;



    /**
     * constructor initializes data and makes this a leaf node
     * @param nodeData
     */
    public TreeNode(T nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }



    /**
     * locate insertion point and insert new node; ignore duplicate values
     * @param insertValue
     */
    public void insert(T insertValue) {
        // insert in left subtree
        if (insertValue.compareTo(data) < 0) {
            // insert new TreeNode
            if (leftNode == null)
                leftNode = new TreeNode<T>(insertValue);
            else // continue traversing left subtree recursively
                leftNode.insert(insertValue);
        }
        // insert in right subtree
        else if (insertValue.compareTo(data) > 0) {
            // insert new TreeNode
            if (rightNode == null)
                rightNode = new TreeNode<T>(insertValue);
            else // continue traversing right subtree recursively
                rightNode.insert(insertValue);
        }
    }
} // end class TreeNode


/**
 * class Tree definition
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {

    /**
     * root variable stores the location and value of the root of the tree
     */
    private TreeNode<T> root;
    /**
     * variable spaces stores the number of spaces from the previous node
     */
    private int spaces;



    /**
     * gettter method for the root of the tree
     * @return
     */
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * setter method for the root of the tree
     * @param root
     */
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }




    /**
     * onstructor initializes an empty Tree of integers
     */
    public Tree() {
        root = null;
    }



    /**
     * insert a new node in the binary search tree
     * @param insertValue
     */
    public void insertNode(T insertValue) {
        if (root == null)
            root = new TreeNode<T>(insertValue); // create root node
        else
            root.insert(insertValue); // call the insert method
    }



    /**
     *  begin preorder traversal
     */
    public void preorderTraversal() {
        preorderHelper(root);
    }


    /**
     * recursive method to perform preorder traversal
     * @param node
     */
    private void preorderHelper(TreeNode<T> node) {
        if (node == null)
            return;

        System.out.printf("%s ", node.data); // output node data
        preorderHelper(node.leftNode); // traverse left subtree
        preorderHelper(node.rightNode); // traverse right subtree
    }


    /**
     * begin inorder traversal
     */
    public void inorderTraversal() {
        inorderHelper(root);
    }



    /**
     * recursive method to perform inorder traversal
     * @param node
     */
    private void inorderHelper(TreeNode<T> node) {
        if (node == null)
            return;

        inorderHelper(node.leftNode); // traverse left subtree
        System.out.printf("%s ", node.data); // output node data
        inorderHelper(node.rightNode); // traverse right subtree
    }



    /**
     * begin postorder traversal
     */
    public void postorderTraversal() {
        postorderHelper(root);
    }



    /**
     * recursive method to perform postorder traversal
     * @param node
     */
    private void postorderHelper(TreeNode<T> node) {
        if (node == null)
            return;

        postorderHelper(node.leftNode); // traverse left subtree
        postorderHelper(node.rightNode); // traverse right subtree
        System.out.printf("%s ", node.data); // output node data
    }

    /**
     * Output Helper method uses recursion to print right and left subtree in a tree diagram
     * adding five spaces between the previous value form the previous node
     * @param node
     * @param spaces
     */
    private void outPutTreeHelper(TreeNode<T> node, int spaces){

        //While reference to the current node is not null
        if (node == null) {
            return;
        }

            //recursively call outputTree wiht the right subtree of the current node + 5 spaces
            outPutTreeHelper(node.rightNode,  spaces + 5);


            //for loop to print out spaces
            for (int i = 1; i < spaces; i++) {
                   System.out.printf(" ");

            }
            //print out data value of current node
            System.out.printf(node.data.toString()+"\n");


        //recursively calls output helper method on the left tree now
            outPutTreeHelper(node.leftNode,  spaces +5);



        }

    /**
     * output tree method calls outPutTreeHelper with the root of the node
     * @param root
     */
    public void outPutTree(TreeNode<T> root) {

        outPutTreeHelper(root, spaces);
    }
    // end class Tree
}
/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
