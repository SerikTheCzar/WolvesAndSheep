package WolvesAndSheep;

import java.util.ArrayList;
import java.util.Vector;

public class StateNode {

    public StateNode parent;

    public Vector<Integer> stateVector;

    public ArrayList<StateNode> children = new ArrayList<StateNode>();

    public int depth_check = 1;

    //Simple Node search to find the first match
    public StateNode searchForMatch(StateNode search) {
        if(this.EqualsTo(search)) {
            return this;
        }
        
        for(StateNode n : children) {
            return n.searchForMatch(search);
        }

        return null;
    }

    // Constructor
    public StateNode(int w, int s, int b) {
        stateVector = new Vector<Integer>();
        stateVector.add(0, w);
        stateVector.add(1, s);
        stateVector.add(2, b);
    }

    //Some getters, we don't really need a setter per-say
    
    public int getWolves(){
        return stateVector.get(0);
    }

    public int getSheep() {
        return stateVector.get(1);
    }

    public int getBoat() {
        return stateVector.get(2);
    }

    // We made this StateNode copy method thinking we were going to need it, we didn't actually use this
    public StateNode copy() {
        return new StateNode(getWolves(), getSheep(), getBoat());
    }

    //A comparator method to check for a match
    public boolean EqualsTo(StateNode comparator) {
        int compW = comparator.getWolves(), compS = comparator.getSheep(), compB = comparator.getBoat();

        return (getWolves() == compW && getSheep() == compS && getBoat() == compB);
    }

    
    //Another thing we didn't end up using to add Vectors
    public void addVector(int w, int s, int b) {
        stateVector.set(0, stateVector.get(0) + w);
        stateVector.set(1, stateVector.get(1) + s);
        stateVector.set(2, stateVector.get(2) + b);
    }
    
    //The meat and potatoes: A fail case check
    //NOTE: This returns true if the Node breaks the rule of the game
    public boolean isFailCase() {
        int w_left = getWolves();
        int s_left = getSheep();

        //The case fails if there are more wolves than we started with, or if we somehow got negative wolves
        if(w_left > 3 || w_left < 0) {
            return false;
        }

        //Likewise for the sheep
        if(s_left > 3 || s_left < 0) {
            return false;
        }

        //Checking the island on the other side is important
        int w_right = 3 - w_left;
        int s_right = 3 - s_left;

        //Case for the left island and right islands
        boolean case_left = (s_left > 0 && w_left > s_left);
        boolean case_right = (s_right > 0 && w_right > s_right);

        //If both left and right cases are true, then this case fails.
        if(case_left && case_right) {
            return true;
        }
        
        return false;
    }

    //A simple check for a win case: All 3 values in the vector are 0
    public boolean isSuccessCase() {
        int wolves = getWolves();
        int sheep = getSheep();
        int boat = getBoat();

        if(wolves == 0 && sheep == 0 && boat == 0) {
            return true;
        }

        return false;
    }

    //Adding children to the Node, as well as increasing their depth
    public void addChild(StateNode child) {
        children.add(child);
        child.parent = this;
        child.depth_check = this.depth_check + 1;
    }

}
