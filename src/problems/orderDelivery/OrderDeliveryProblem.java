/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.orderDelivery;

import java.util.ArrayList;
import java.util.List;
import search.models.Action;
import problems.orderDelivery.search.Deliver;
import problems.orderDelivery.search.MoveForward;
import problems.orderDelivery.models.Order;
import problems.orderDelivery.models.Robot;
import problems.orderDelivery.models.State;
import problems.orderDelivery.models.Status;
import search.models.Problem;

/**
 *
 * @author danieljunior
 */
public class OrderDeliveryProblem extends Problem<State, Action> {

    public OrderDeliveryProblem(List<Action> actions, State initialState, State solution) {
        super(actions, initialState, solution);
    }

    public OrderDeliveryProblem() {
        super(null, null, null);
    }

    @Override
    public List<Action> actions(State state) {
        List<Action> resp = new ArrayList<>();
        List<Deliver> deliveries = new ArrayList<>();
        List<MoveForward> moves = new ArrayList<>();
        for (Order o : state.getOrdersToDeliver()) {
            for (Robot r : state.getRobots()) {
                if (r.getStatus().equals(Status.IDLE)) {
                    Deliver d = new Deliver(r, o.getProduct(), o.getStationDeliver());
                    boolean in = false;
                    for (Deliver aux : deliveries) {
                        if (aux.getRobot().equals(d.getRobot()) && aux.getProduct().equals(d.getProduct()) && aux.getStation().equals(d.getStation())) {
                            in = true;
                            break;
                        }
                    }
                    if (!in) {
                        deliveries.add(d);
                    }
                } else if (r.getStatus().equals(Status.ON_DELIVERY)) {
                    MoveForward m = new MoveForward(r.getUsedTime());
                    boolean in = false;
                    for (MoveForward aux : moves) {
                        if (m.getNewTime() == aux.getNewTime()) {
                            in = true;
                        }
                    }
                    if (!in) {
                        moves.add(m);
                    }
                }
            }
        }
        resp.addAll(deliveries);
        resp.addAll(moves);
        return resp;
    }

    @Override
    public State result(State state, Action action) {
        return action.go(state);
    }

    @Override
    public boolean isFinal(State state) {
        for (Robot r : state.getRobots()) {
            if (r.getStatus().equals(Status.ON_DELIVERY)) {
                return false;
            }
        }
        return state.getOrdersToDeliver().isEmpty();
    }

    @Override
    public int stepCost(State parent, Action action) {
        return action.stepCost(parent);
    }

}
