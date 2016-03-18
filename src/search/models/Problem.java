/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.models;

import java.util.List;

/**
 *
 * @author danieljunior
 * @param <TState>
 * @param <TAction>
 */
public abstract class Problem<TState, TAction> {

    private List<TAction> actions;
    private TState initialState;
    private TState currentState;
    private TState solution;

    public Problem(List<TAction> actions, TState initialState, TState solution) {
        this.actions = actions;
        this.initialState = initialState;
        currentState = initialState;
        this.solution = solution;
    }

    public Problem() {
    }
    

    public abstract List<TAction> actions(TState state);

    public abstract TState result(TState state, TAction action);

    public abstract boolean isFinal(TState state);

    public abstract int stepCost(TState state, TAction action);

    public List<TAction> getActions() {
        return actions;
    }

    public void setActions(List<TAction> actions) {
        this.actions = actions;
    }

    public TState getInitialState() {
        return initialState;
    }

    public void setInitialState(TState initialState) {
        this.initialState = initialState;
    }

    public TState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(TState currentState) {
        this.currentState = currentState;
    }

    public TState getSolution() {
        return solution;
    }

    public void setSolution(TState solution) {
        this.solution = solution;
    }

}
