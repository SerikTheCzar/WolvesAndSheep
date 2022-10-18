package WolvesAndSheep;

import java.util.ArrayList;
import java.util.Vector;

public class StateNode {

    public StateNode parent;

    public Vector<Integer> stateVector;

    public ArrayList<StateNode> children = new ArrayList<StateNode>();

    public int depth_check = 1;

    public StateNode(int w, int s, int b) {
        stateVector = new Vector<Integer>();
        stateVector.add(0, w);
        stateVector.add(1, s);
        stateVector.add(2, b);
    }

    public int getWolves(){
        return stateVector.get(0);
    }

    public int getSheep() {
        return stateVector.get(1);
    }

    public int getBoat() {
        return stateVector.get(2);
    }

    public void addVector(int w, int s, int b) {
        stateVector.set(0, stateVector.get(0) + w);
        stateVector.set(1, stateVector.get(1) + s);
        stateVector.set(2, stateVector.get(2) + b);
    }
    
    public boolean isFailCase() {
        int w_left = getWolves();
        int s_left = getSheep();

        int w_right = 3 - w_left;
        int s_right = 3 - s_left;

        boolean case_left = (s_left > 0 && w_left > s_left);
        boolean case_right = (s_right > 0 && w_right > s_right);

        if(case_left && case_right) {
            return true;
        }
        
        return false;
    }

    public void addChild(StateNode child) {
        children.add(child);
        child.parent = this;
    }

}
