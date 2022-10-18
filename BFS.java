import java.util.ArrayList;
import java.util.Vector;
class BFS {
    Vector<Integer> stateVector;
    BFS left, right;
    public BFS(Vector item)
    {
        stateVector = item;
        left = right = null;
    }
}
 
class BinaryTree {
    // Root of the Binary Tree
    BFS root;
 
    public BinaryTree() { 
        root = null; //initialize it to empty
    }
 
    
//height of the tree for LO traversal
    int height(BFS root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int leftheight = height(root.left);
            int rightheight = height(root.right);
 
            /* use the larger one */
            if (leftheight > rightheight)
                return (leftheight + 1);
            else
                return (rightheight + 1);
        }
    }
 
    //add code to assemble vec into generic tree
    //search via bfs sorta done above
    void printCurrentLevel(Vector root, int level, Vector match)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.get(level) + " ");
        if(root == match ){
            System.out.println("found a match, keeping above stack");
        }
    }
 

}