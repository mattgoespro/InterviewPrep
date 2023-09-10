package datastructures.customimplementations.trees;

public class Traversal {
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.root =
        new BinaryNode(
            100,
            new BinaryNode(
                50, new BinaryNode(25, new BinaryNode(10), new BinaryNode(40)), new BinaryNode(75)),
            new BinaryNode(150, new BinaryNode(125)));
    binaryTree.printInOrderTraversal();
    System.out.println();
    binaryTree.printPreOrderTraversal();
  }
}
