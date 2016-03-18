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
            node = frontier.pop();
            if (problem.isFinal(node.getState())) {
                return new Solution(node);
            }
            if (newNode(node, exploredSet)) {
                exploredSet.add(node);
            }
            List<TAction> actions = problem.actions(node.getState());
            for (TAction action : actions) {
                Node child = node.childNode(problem, node, action);
                Node worse = existsAWorseNode(child, heuristic);
                if (newNode(child, frontier) && newNode(child, exploredSet)) {
                    frontier.add(child);
                } else if (worse != null) {
                    frontier.remove(worse);
                    frontier.add(child);
                }
                sortFrontier(heuristic);
            }
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

    private boolean newNode(Node<TState, TAction> node, List<Node> list) {
        Node temp = (Node) node;
        State aux = (State) temp.getState();
        for (Node n : list) {
            State s = (State) n.getState();
            boolean sameOrders = s.getOrdersToDeliver().equals(aux.getOrdersToDeliver());
            boolean sameParents;
            if (aux.getParent() == null && s.getParent() == null) {
                sameParents = true;
            } else if ((aux.getParent() == null && s.getParent() != null) || (aux.getParent() != null && s.getParent() == null)) {
                sameParents = false;
            } else {
                sameParents = s.getParent().equals(aux.getParent());
            }
            boolean sameRobots = s.getRobots().equals(aux.getRobots());
            boolean sameTime = s.getTime() == aux.getTime();
            boolean sameCost = node.getPathCost() == n.getPathCost();
            if (sameCost && sameOrders && sameParents && sameRobots && sameTime) {
                return false;
            }
        }
        return true;
    }
}
