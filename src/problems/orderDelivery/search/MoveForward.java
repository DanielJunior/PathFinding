/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.orderDelivery.search;

import java.util.ArrayList;
import problems.orderDelivery.models.Robot;
import problems.orderDelivery.models.State;
import problems.orderDelivery.models.Status;
import search.models.Action;

/**
 *
 * @author danieljunior
 */
public class MoveForward implements Action {

    private int newTime;

    public MoveForward(int newTime) {
        this.newTime = newTime;
    }

    public MoveForward() {
    }

    public int getNewTime() {
        return newTime;
    }

    public void setNewTime(int newTime) {
        this.newTime = newTime;
    }

    @Override
    public State go(State parent) {
        for (Robot r : parent.getRobots()) {
            if (r.getUsedTime() <= newTime) {
                r.setStatus(Status.IDLE);
                r.setUsedTime(newTime);
            }
        }
        State resp = new State(new ArrayList<>(parent.getRobots()), new ArrayList<>(parent.getOrdersToDeliver()), newTime);
        return resp;
    }

    @Override
    public int stepCost(State parent) {
        return Math.abs(getNewTime() - parent.getTime());
    }

}
