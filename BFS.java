package WolvesAndSheep;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
 
class BFS {
    // Root of the Binary Tree
    StateNode root;
 
    public BFS() { 
        root = null; //initialize it to empty
    }
 
    
//height of the tree for LO traversal
    int height(StateNode root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            Vector<Integer> heights = new Vector<Integer>();

            for(StateNode child : root.children) {
                heights.add(height(child));
            }
 
            /* use the larger one */
            heights.sort(Collections.reverseOrder());

            return heights.get(0) + 1;
        }
    }

    public StateNode generate() {
        root = new StateNode(3, 3, 1);

		//Key difference between BFS and DFS is that BFS uses a Queue instead of a Stack
        Queue<StateNode> stateQueue = new LinkedList<StateNode>();

        stateQueue.add(root);

        StateNode success = null;

        if(success == null) {
            System.out.println("Checking tree...");
            while(!stateQueue.isEmpty()) {
                StateNode current = stateQueue.poll();
    
                /*
                System.out.println("Testing DFS layer: " + current.depth_check);
                System.out.println("Number of Children of node: " + current.children.size());
                System.out.println("Wolves: " + current.getWolves() + "\nSheep: " + current.getSheep() + "\nBoat: " + current.getBoat());
                //*/
                    
				
				//Check to see if we found our winner
                if(current.isSuccessCase()) {
                    success = current;
                    break;
                }
				
				//If this node already has children, just add the new ones to the queue
                if(current.children.isEmpty() == false) {
                    for(StateNode n : current.children) {
                        stateQueue.add(n);
                    }
                } else {
                    // Possible Combinations:
                        /*
                         * (0, 1)
                         * (1, 0)
                         * (1, 1)
                         * (0, 2)
                         * (2, 0)
                         * 
                         */
						 
					// Because the boat has to go back and forth, we know that we have to subtract and add dependent on where the boat is
                    if(current.getBoat() == 1) {
                        int w = current.getWolves(), s = current.getSheep();
    
                        for(int x = 0; x < 3; x++) {
                            for(int y = 0; y < 3; y++) {
                                if(!(x == 0 && y == 0) && !(x + y > 2)) {
                                    StateNode temp = new StateNode(w - x, s - y, 0);
                                    if(temp.isFailCase() == false && root.searchForMatch(temp) == null && (temp.getWolves() <= 3 && temp.getWolves() >= 0) && (temp.getSheep() <= 3 && temp.getSheep() >= 0)) {
                                        current.addChild(temp);
                                    }
                                }
                            }
                        }
                    } else {
                        int w = current.getWolves(), s = current.getSheep();
    
                        for(int x = 0; x < 3; x++) {
                            for(int y = 0; y < 3; y++) {
                                if(!(x == 0 && y == 0) && !(x + y > 2)) {
                                    StateNode temp = new StateNode(w + x, s + y, 1);
                                    if(temp.isFailCase() == false && root.searchForMatch(temp) == null && (temp.getWolves() <= 3 && temp.getWolves() >= 0) && (temp.getSheep() <= 3 && temp.getSheep() >= 0)) {
                                        current.addChild(temp);
                                    }
                                }
                            }
                        }
                    }
    
                    for(StateNode n : current.children) {
                        stateQueue.add(n);
                    }
                }
            }

            stateQueue.add(root);
        }

        return success;
    }

}
