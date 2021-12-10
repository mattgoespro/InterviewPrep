package datastructures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class Tree {
	BinaryNode root;
	
	@Override
	public String toString() {
		return this.getTreeNodeString(this.root, "");
	}
	
	public String getTreeNodeString(BinaryNode node, String line) {
		if (node.left == null && node.right == null) {
			line += " " + node.value;
			return line;
		}
		
		line += "\t";
		line += this.getTreeNodeString(node.left, line + "-");
		line += this.getTreeNodeString(node.right, line + "-");
		return line;
	}
}

@Getter
@Setter
class BinaryTree {
	//@formatter:off
	
	int sum(BinaryNode node) {
		if (node == null) {
			return 0;
		}
		return sum(node.left) +
		       node.value +
		       sum(node.right);
	}
}
