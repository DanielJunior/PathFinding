/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.models;

/**
 *
 * @author danieljunior
 */
public class Solution {

    private Node last;

    public Solution(Node last) {
        this.last = last;
    }

    public void print() {
        System.out.println(auxPrint(last));
    }

    private String auxPrint(Node last) {
        if (last == null) {
            return "";
        } else if (last.getParent() == null && last.getAction() == null) {
            return "Node State:\n"+last.getState().toString()+"\nPathCost: "+last.getPathCost()+"\n\n";
        } else {
            return (auxPrint(last.getParent()) + "\n\nNode State:\n" + last.getState().toString() + "Action: " + last.getAction().toString() + "\nPathCost: " + last.getPathCost());
        }
    }
}
