/*Created by 
 * Name : Arushee_Garg
 * Project : Compilers_Building the Parser
 * Project description : Creates the LR parser LR(0) and LR(1) and parses given input strings.
 * Due Date : April26 2017
 * Course Number : CS 59000 -002
  */
//package compilers.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Creates the StateTable from dfa for corresponding Parser.
 * Pass the int parameter(int parser) in the constructor for StateTable to choose either for LR(0) or LR(1) parser
 * For eg : Creating StateTable for LR(0) parser : StateTable statetable0 = new StateTable(0)
 */ 
public class StateTable {
    Map<String, ArrayList<Integer>> statetable;

    public StateTable(int parser){
        if(parser == 0) {
            this.statetable = new HashMap<>();
            statetable.put("Input", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
            statetable.put("i", new ArrayList<Integer>(Arrays.asList(5, -1, -1, 5, -1, -1, 5, -1, -1,-1)));
            statetable.put("(", new ArrayList<Integer>(Arrays.asList(6, -1,-1, 6, -1,-1, 6, -1,-1,-1)));
            statetable.put(")", new ArrayList<Integer>(Arrays.asList(-1,-1, -1,-1,-1,-1,-1,8, -1,-1)));
            statetable.put("+", new ArrayList<Integer>(Arrays.asList(-1, 3, -1,-1,-1,-1,-1, 3,-1,-1)));
            statetable.put("$", new ArrayList<Integer>(Arrays.asList(-1, 2, -1,-1, -1,-1,-1, -1,-1,-1)));
            statetable.put("S", new ArrayList<Integer>(Arrays.asList(-1, -1,-1, -1,-1,-1,1, -1,-1,-1)));
            statetable.put("E", new ArrayList<Integer>(Arrays.asList(1, -1,-1, -1,-1,-1,7, -1,-1,-1)));
            statetable.put("T", new ArrayList<Integer>(Arrays.asList(9, -1,-1, 4, -1,-1,9, -1,-1,-1)));
            statetable.put("State_cond", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 1, 2, 2, 1, 1, 2,2)));
            // State_cond : 0 = initial , 1 = NonAccepting, 2 = Accepting, 3 = Initial and Accepting
        }
        else if(parser == 1){
            this.statetable = new HashMap<>();
            statetable.put("Input", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
            statetable.put("i", new ArrayList<Integer>(Arrays.asList(5, -1, -1, 5, -1, -1, 5, -1, -1,-1, -1, -1 ,-1)));
            statetable.put("(", new ArrayList<Integer>(Arrays.asList(6, -1,-1, 6, -1,-1, 6, -1,-1,-1, -1, -1,-1)));
            statetable.put(")", new ArrayList<Integer>(Arrays.asList(-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,10)));
            statetable.put("+", new ArrayList<Integer>(Arrays.asList(-1, 3, -1,-1,-1,-1,-1, -1,-1,-1,-1,-1,3)));
            statetable.put("*", new ArrayList<Integer>(Arrays.asList(-1, -1, -1,-1,-1,-1,-1, 8,-1,-1,-1,8,-1)));
            statetable.put("$", new ArrayList<Integer>(Arrays.asList(-1, 2, -1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1)));
            statetable.put("S", new ArrayList<Integer>(Arrays.asList(-1, -1, -1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1)));
            statetable.put("E", new ArrayList<Integer>(Arrays.asList(1, -1, -1,-1,-1,-1,12, -1,-1,-1,-1,-1,-1)));
            statetable.put("T", new ArrayList<Integer>(Arrays.asList(7, -1, -1,11,-1,-1,7, -1,-1,-1,-1,-1,-1)));
            statetable.put("F", new ArrayList<Integer>(Arrays.asList(4, -1, -1,4,-1,-1,4, -1,9,-1,-1,-1,-1)));
            statetable.put("State_cond", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 1, 2, 2, 1, 1, 1,2,1,1,2)));
        }
    }

    public void print(){
        for(Map.Entry<String, ArrayList<Integer>> entry : statetable.entrySet()) {
            System.out.printf( "%10s",entry.getKey());
            System.out.print(" | ");
            System.out.print( entry.getValue());//Returns the list of values
            System.out.println();
        }
    }

    public static void main(String[] args){
        System.out.println("State Table for Grammar(0)\n");
        StateTable st1 = new StateTable(0);
        st1.print();
        System.out.println();

        System.out.println("State Table for Grammar(1)\n");
        StateTable st2 = new StateTable(1);
        st2.print();
    }
}
