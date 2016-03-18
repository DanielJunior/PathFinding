/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.models;

import java.util.Comparator;

/**
 *
 * @author danieljunior
 */
public class NodeComparator implements Comparator {

    Heuristic<Node> heuristic;

    public NodeComparator(Heuristic<Node> heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Node first = (Node) o1;
        Node second = (Node) o2;
        if ((first.getPathCost() + heuristic.function(first)) > (second.getPathCost() + heuristic.function(second))) {
            return 1;
        } else if ((first.getPathCost() + heuristic.function(first)) < (second.getPathCost() + heuristic.function(second))) {
            return -1;
        } else {
            return 0;
        }
    }

}
