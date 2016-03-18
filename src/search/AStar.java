/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import search.models.Heuristic;
import search.models.Node;
import search.models.NodeComparator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import problems.orderDelivery.models.State;
import search.models.Problem;
import search.models.Solution;

/**
 *
 * @author danieljunior
 * @param <TState>
 * @param <TAction>
 */
public class AStar<TState, TAction> {

    int pathCost = 0;
    LinkedList<Node> frontier;
    LinkedList<Node> exploredSet;

    public Solution search(Problem<TState, TAction> problem, Heuristic<Node> heuristic) {
        Node<TState, TAction> node = new Node(problem.getInitialState(), null, null, 0);
        frontier = new LinkedList<>();
        frontier.add(node);
        exploredSet = new LinkedList<>();
        while (true) {
            if (frontier.isEmpty()) {
                return null;
            }
            System.out.println("Frontier size: " + frontier.size());
            node = frontier.pop();
            System.out.println("Actual explored node state: " + node.getState().toString());
            if (node.getAction() != null) {
                System.out.println("\nAction: "+node.getAction().toString());
            }
            System.out.println("\n**************************");
            if (problem.isFinal(node.getState())) {
                return new Solution(node);
            }
            if (notIn(node, exploredSet)) {
                exploredSet.add(node);
            }
            List<TAction> actions = problem.actions(node.getState());
            for (TAction action : actions) {
                Node child = node.childNode(problem, node, action);
                Node worse = existsAWorseNode(child, heuristic);
                if (notIn(child, frontier) && notIn(child, exploredSet)) {
                    frontier.add(child);
                } else if (worse != null) {
                    frontier.remove(worse);
                    frontier.add(child);
                }
            }
            sortFrontier(heuristic);
        }
    }

    private Node existsAWorseNode(Node child, Heuristic heuristic) {
        for (Node parent : frontier) {
            if ((parent.getPathCost() + heuristic.function(parent)) > (child.getPathCost() + heuristic.function(child))) {
                return parent;
            }
        }
        return null;
    }

    private void sortFrontier(Heuristic<Node> heuristic) {
        Collections.sort(frontier, new NodeComparator(heuristic));
    }

    private boolean notIn(Node<TState, TAction> node, List<Node> list) {
        Node temp = (Node) node;
        for (Node n : list) {
            State s = (State) n.getState();
            if (temp.getState().equals(s)) {
                return false;
            }
        }
        return true;
    }
}
