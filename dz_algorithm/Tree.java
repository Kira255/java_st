import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree {

    Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean res = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return res;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean res = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return res;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean res = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return res;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node res = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (res.right != null && res.right.color == Color.RED
                    && (res.left == null || res.left.color == Color.BLACK)) {
                needRebalance = true;
                res = rightSwap(res);
            }
            if (res.left != null && res.left.color == Color.RED && res.left.left != null
                    && res.left.left.color == Color.RED) {
                needRebalance = true;
                res = leftSwap(res);
            }
            if (res.left != null && res.left.color == Color.RED && res.right != null && res.right.color == Color.RED) {
                needRebalance = true;
                colorSwap(res);
            }
        } while (needRebalance);
        return res;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    class Node {
        int value;
        Color color;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color + "}";
        }
    }

    enum Color {
        RED, BLACK
    }

    public Node find(int value) {
        return find(root, value);
    }

    private Node find(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (node.value < value) {
            return find(node.right, value);
        } else {
            return find(node.left, value);
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
        } else {
            insert(root, value);
            // root = balance(root);
        }

        // root.color = BLACK;
    }

    public void insert(Node node, int value) {
        if (node.value != value) {
            if (node.value < value) {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.value = value;
                    // node.right.color = RED;
                } else {
                    insert(node.right, value);
                }
            } else {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.value = value;
                    // node.left.color = RED;
                } else {
                    insert(node.left, value);
                }
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            Tree tree = new Tree();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    try {
                        int value = Integer.parseInt(reader.readLine());
                        tree.add(value);
                        System.out.println("finish");
                    } catch (Exception ignored) {

                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
