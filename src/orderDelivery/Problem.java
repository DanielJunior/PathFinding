/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDelivery;

import java.util.List;
import orderDelivery.models.Position;
import orderDelivery.models.Product;
import orderDelivery.models.Robot;
import orderDelivery.models.Station;
import orderDelivery.models.Status;

/**
 *
 * @author danieljunior
 */
public class Problem {

    private State initialState;

    public List<Position> deliver(Robot robot, Product product, Station station) {
        throw new UnsupportedOperationException("Falta implementar ação deliver!");
    }

    public State moveForward(int newTime) {
        throw new UnsupportedOperationException("Falta implementar ação moveForward!");
    }

    public State result(State actualState, Position nextPosition) {
        throw new UnsupportedOperationException("Falta implementar modelo de transição result!");
    }

    public boolean test(State state) {
        if (state.getOrdersToDeliver().isEmpty()) {
            for (Robot r : state.getRobots()) {
                if (!r.getStatus().equals(Status.IDLE)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
