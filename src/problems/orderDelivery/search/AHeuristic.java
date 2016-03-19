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
        int numberOfDeliveryRobot = s.numberOfOnDeliveryRobots();
        int numberOfIdleRobots = s.getRobots().size() - numberOfDeliveryRobot;
        int numberOfOrdersToDelivery = s.getOrdersToDeliver().size();
        return Math.sqrt(Math.pow(numberOfIdleRobots,2)+Math.pow(numberOfOrdersToDelivery,2));
    }

}
