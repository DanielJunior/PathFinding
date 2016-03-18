/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.models;

import problems.orderDelivery.models.State;

/**
 *
 * @author danieljunior
 * @param <TState>
 * @param <TAction>
 */
public class Node<TState, TAction> {

    private TState state;
    private Node parent;
    private TAction action;
    private int pathCost;

    public Node(TState state, Node parent, TAction action, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
    }

    public Node childNode(Problem<TState, TAction> problem, Node parent, TAction action){
        State result = (State) problem.result((TState) parent.getState(), action);
        int problemCost = problem.stepCost((TState) parent.state, action);
        int cost = parent.pathCost + problemCost;
        return new Node(result, parent, action, cost);
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public TState getState() {
        return state;
    }

    public void setState(TState state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public TAction getAction() {
        return action;
    }

    public void setAction(TAction action) {
        this.action = action;
    }

}
