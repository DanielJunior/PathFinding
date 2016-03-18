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
        auxPrint(last);
    }

    private void auxPrint(Node last) {
        if (last == null) {
            return;
        }
//        System.out.println(auxPrint(last)"");
    }
}
