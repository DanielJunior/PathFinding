/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import search.models.Node;
import java.util.Collection;
import java.util.List;
import search.models.Problem;

/**
 *
 * @author danieljunior
 * @param <TState>
 * @param <TAction>
 */
public abstract class GenericSearch<TState, TAction> {

    Collection<Node<TState, TAction>> frontier;
    Collection<Node> exploredSet;

    public Node solution(Problem<TState, TAction> problem) throws CloneNotSupportedException {
        initializeFrontierAndExploredSet();
        addNodeToFrontier(new Node<>(problem.getInitialState(), null, null, 0));
        while (true) {
            if (frontier.isEmpty()) {
                return null;
            }
            Node<TState, TAction> node = retrieveNode();
            if (problem.isFinal(node.getState())) {
                return node;
            }
            exploredSet.add(node);
            List<TAction> actions = problem.actions(node.getState());
            for (TAction action : actions) {
                Node<TState, TAction> child = node.childNode(problem, node, action);
                if (!exploredSet.contains(node) && !frontier.contains(node)) {
                    addNodeToFrontier(child);
                }
            }

        }
    }

    protected abstract Node<TState, TAction> retrieveNode();

    protected abstract void initializeFrontierAndExploredSet();

    protected abstract void addNodeToFrontier(Node<TState,TAction> State);

}
