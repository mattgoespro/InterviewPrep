package datastructures.customimplementations.trees;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BinaryNode<V> {
    V value;
    BinaryNode<V> left, right;

    BinaryNode(V value) {
        this(value, null, null);
    }

    BinaryNode(V value, BinaryNode<V> left) {
        this(value, left, null);
    }
}
