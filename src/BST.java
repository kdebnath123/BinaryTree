import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Kirin Debnath
 * @version: April 2nd, 2024
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // Use helper
        return search(this.getRoot(), val);
    }

    public boolean search(BSTNode node, int val) {

        if(node == null) {
            return false;
        }

        if(node.getVal() == val) {
            return true;
        }

        if(val < node.getVal()) {
            return search(node.getLeft(), val);
        }

        return search(node.getRight(), val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();

        this.getInorder(list, this.getRoot());

        return list;
    }

    public void getInorder(ArrayList<BSTNode> list, BSTNode node) {
        if (node == null){
            return;
        }

        getInorder(list, node.getLeft());
        list.add(node);
        getInorder(list, node.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();

        this.getPreorder(list, this.getRoot());

        return list;
    }

    /** Overloaded helper function for preorder
     *  Adds nodes to array list from given root of BST
     * @param list ArrayList of added nodes
     * @param node node on BST
     */
    public void getPreorder(ArrayList<BSTNode> list, BSTNode node) {
        // No further nodes
        if (node == null){
            return;
        }

        // Add current node
        list.add(node);
        // Recurse onto left/right branch
        getInorder(list, node.getLeft());
        getInorder(list, node.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();

        this.getPostorder(list, this.getRoot());

        return list;
    }

    /** Overloaded helper function for postorder
     *  Adds nodes to array list from given root of BST
     * @param list ArrayList of added nodes
     * @param node node on BST
     */
    public void getPostorder(ArrayList<BSTNode> list, BSTNode node) {
        // No further nodes
        if (node == null){
            return;
        }

        // Recurse onto left/right branch
        getInorder(list, node.getLeft());
        getInorder(list, node.getRight());
        // Add current node
        list.add(node);
    }



    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        this.setRoot(insert(root, val));

    }

    /**
     *
     *
     * @param node current BST node
     * @param val value to insert
     * @return Root BST node
     */
    public BSTNode insert(BSTNode node, int val) {

        // Add the value to the tree if at end
        if (node == null) {
            node = new BSTNode(val);
            return node;
        }

        // Recurse down needed branch
        else if (val < node.getVal())
            node.setLeft(insert(node.getLeft(), val));
        else if (val > node.getVal())
            node.setRight(insert(node.getRight(), val));


        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);



        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
