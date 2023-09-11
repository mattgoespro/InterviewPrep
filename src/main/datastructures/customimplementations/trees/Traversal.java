package datastructures.customimplementations.trees;

public class Traversal {
  public static void main(String[] args) {
    BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
    binaryTree.root = new BinaryNode<Integer>(
        100,
        new BinaryNode<Integer>(
            50, new BinaryNode<Integer>(25, new BinaryNode<Integer>(10), new BinaryNode<Integer>(40)),
            new BinaryNode<Integer>(75)),
        new BinaryNode<Integer>(150, new BinaryNode<Integer>(125)));
    binaryTree.printInOrderTraversal();
    System.out.println();
    binaryTree.printPreOrderTraversal();
    System.out.println();
    binaryTree.printPostOrderTraversal();
  }
}
