/// Java program for different tree traversals
 
/* Class containing left and right child of current
   DFS and key value*/
class DFS {
    StateNode sn;
    int key;
    DFS left, right;
 
    public DFS(StateNode s)
    {
        sn = s;
        //key = item;
        left = right = null;
    }
}
 
class BinaryTree {
    // Root of Binary Tree
    DFS root;
 
    BinaryTree() {
        root = null;
    }
 
    /* Given a binary tree, print its DFSs in inorder*/
    void printInorder(DFS DFS)
    {
        if (DFS == null)
            return;
 
        /* first recur on left child */
        printInorder(DFS.left);
 
        /* then print the data of DFS */
        System.out.print(DFS.key + " ");
 
        /* now recur on right child */
        printInorder(DFS.right);
    }
 
    // Wrappers over above recursive functions
    void printInorder() { printInorder(root); }
 
    // Driver code
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new DFS(1);
        tree.root.left = new DFS(2);
        tree.root.right = new DFS(3);
        tree.root.left.left = new DFS(4);
        tree.root.left.right = new DFS(5);
 
          // Function call
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();
    }
}