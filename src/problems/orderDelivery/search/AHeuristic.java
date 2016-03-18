/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.orderDelivery.search;

import problems.orderDelivery.models.State;
import search.models.Heuristic;
import search.models.Node;

/**
 *
 * @author danieljunior
 */
public class AHeuristic implements Heuristic<Node> {

    @Override
    public double function(Node node) {
        State s = (State) node.getState();
        int numberOfRobots = s.numberOfOnDeliveryRobots();
//        return Math.sqrt(numberOfRobots);
        return 0;
    }

}
