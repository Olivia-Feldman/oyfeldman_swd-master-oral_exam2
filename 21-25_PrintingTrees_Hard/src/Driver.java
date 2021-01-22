


/**
 * Driver class implements Tree class and has main function
 */

public class Driver {
  /**
   * main  method in driver class
   * @param args
   */
  public static void main(String[] args) {

    /**
     * tree variable is creating a new Tree object using Integer wrapper class
     * this allows use to manipulate the Integer object
     */
    Tree<Integer> tree = new Tree<Integer>();


        //inserting the values from the textbook to display the same tree diagam solution
        tree.insertNode(49);
        tree.insertNode(28);
        tree.insertNode(18);
        tree.insertNode(11);
        tree.insertNode(19);
        tree.insertNode(32);
        tree.insertNode(44);
        tree.insertNode(83);
        tree.insertNode(97);
        tree.insertNode(99);
        tree.insertNode(92);
        tree.insertNode(71);
        tree.insertNode(72);
        tree.insertNode(69);

      //calling output tree with the root of the tree
        tree.outPutTree(tree.getRoot());




    }


}
