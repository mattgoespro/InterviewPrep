package datastructures.customimplementations.trees;

class BinaryTree<V> {
  BinaryNode<V> root;

  @Override
  public String toString() {
    return this.getTreeNodeString(this.root, "");
  }

  public String getTreeNodeString(BinaryNode<V> node, String line) {
    if (node.left == null && node.right == null) {
      line += " " + node.value;
      return line;
    }

    line += "\t";
    line += this.getTreeNodeString(node.left, line + "-");
    line += this.getTreeNodeString(node.right, line + "-");
    return line;
  }

  public void printInOrderTraversal() {
    this.inOrderTraversal(this.root);
  }

  public void printPreOrderTraversal() {
    this.preOrderTraversal(this.root);
  }

  public void printPostOrderTraversal() {
    this.postOrderTraversal(this.root);
  }

  private void inOrderTraversal(BinaryNode<V> node) {
    if (node.left != null) {
      this.inOrderTraversal(node.left);
    }

    System.out.println(node.value);

    if (node.right != null) {
      this.inOrderTraversal(node.right);
    }
  }

  private void preOrderTraversal(BinaryNode<V> node) {
    System.out.println(node.value);

    if (node.left != null) {
      this.preOrderTraversal(node.left);
    }

    if (node.right != null) {
      this.preOrderTraversal(node.right);
    }
  }

  private void postOrderTraversal(BinaryNode<V> node) {
    if (node.left != null) {
      this.preOrderTraversal(node.left);
    }

    if (node.right != null) {
      this.preOrderTraversal(node.right);
    }

    System.out.println(node.value);
  }
}
