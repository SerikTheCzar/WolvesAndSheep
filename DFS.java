package WolvesAndSheep;

import java.util.Stack;

/*

	DFS traversal for Cannibals and Missionaries problem
	DFS uses a Stack, unlike BFS which uses a Queue,
	
	DFS is less efficient than BFS, because DFS has to retrace steps

*/

public class DFS {
    StateNode root;

    public DFS() {
        root = null;
    }

    public StateNode generate() {
        root = new StateNode(3, 3, 1);

        Stack<StateNode> stateStack = new Stack<StateNode>();

		//Push the root node to the stack first, it should be the first thing to happen
        stateStack.push(root);

        StateNode success = null;

        while(success == null) {
            System.out.println("Checking tree...");
            while(!stateStack.isEmpty()) {
                StateNode current = stateStack.pop();
    
                /*
                System.out.println("Testing DFS layer: " + current.depth_check);
                System.out.println("Number of Children of node: " + current.children.size());
                System.out.println("Wolves: " + current.getWolves() + "\nSheep: " + current.getSheep() + "\nBoat: " + current.getBoat());
                //*/
				
				//Check for a Winner

                if(current.isSuccessCase()) {
                    success = current;
                    break;
                }
    
                if(current.children.isEmpty() == false) {
                    for(StateNode n : current.children) {
                        if(n.isSuccessCase()) {
                            success = n;
                            break;
                        }
                        stateStack.push(n);
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
						 
					// Decide which direction the boat is heading towards
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
									//If the state added would fail the problem we don't want to consider that for our tree, we also do not want the Nodes to repeat
                                    if(temp.isFailCase() == false && root.searchForMatch(temp) == null && (temp.getWolves() <= 3 && temp.getWolves() >= 0) && (temp.getSheep() <= 3 && temp.getSheep() >= 0)) {
                                        current.addChild(temp);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            stateStack.push(root);
        }

        return success;
    }
}
