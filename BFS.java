class BFS {
    int data;
    BFS left, right;
    public BFS(int item)
    {
        data = item;
        left = right = null;
    }
}
 
class BinaryTree {
    // Root of the Binary Tree
    BFS root;
 
    public BinaryTree() { root = null; }
 
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    BFSs along the longest path from the root BFS
    down to the farthest leaf BFS.*/
    int height(BFS root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    /* Print BFSs at the current level */
    void printCurrentLevel(BFS root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new BFS(1);
        tree.root.left = new BFS(2);
        tree.root.right = new BFS(3);
        tree.root.left.left = new BFS(4);
        tree.root.left.right = new BFS(5);
 
        System.out.println("Level order traversal of"
                           + "binary tree is ");
        tree.printLevelOrder();
    }
}