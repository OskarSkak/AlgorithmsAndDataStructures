package Data_Structures;

public class UnbalancedBinaryTree {
    private Node root;
    private int[] orderedTree;
    private int treeSize = 0;
    private boolean treeInitiated;

    public void insert(int k) {
        this.treeSize++;

        Node z = new Node(k);
        Node y = null;
        Node x = this.root;

        while(x != null){
            y = x;
            if(z.getKey() < x.getKey()) x = x.getLeft();
            else x = x.getRight();
        }

        z.setParent(y);
        if (y == null) this.root = z;
        else if (z.getKey() < y.getKey()) y.setLeft(z);
        else y.setRight(z);
    }


    public int[] orderedTraversal() {
        int[] ordered = this.inorderTreeWalk(this.root);
        this.treeSize = ordered.length;
        this.treeInitiated = false; //If orderedTraversel is called again on the same tree, the treesize has to be adjusted again
        return ordered;
    }

    private int[] inorderTreeWalk(Node x){
        if (treeInitiated == false){
            this.orderedTree = new int[treeSize];
            this.treeInitiated = true;
        }
        if (x != null){
            inorderTreeWalk(x.getLeft());
            this.orderedTree[this.orderedTree.length - this.treeSize--] = x.getKey();
            inorderTreeWalk(x.getRight());
        }
        return this.orderedTree;
    }

    public boolean search(int k) {
        if (treeSearch(this.root, k) == null) return false;
        return true;
    }

    private Node treeSearch(Node x, int k){
        if((x == null) || k == x.getKey()) return x;
        if (k < x.getKey()) return treeSearch(x.getLeft(), k);
        else return treeSearch(x.getRight(), k);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

class Node{
    private Node left, right, parent;
    private int key;

    public Node(int key){
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        this.left.setParent(this);
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        this.right.setParent(this);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getKey() {
        return key;
    }
}
