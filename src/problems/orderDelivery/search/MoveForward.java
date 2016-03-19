/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.orderDelivery.search;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import problems.orderDelivery.models.Order;
import problems.orderDelivery.models.Position;
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
        List<Robot> robots = new ArrayList<>();
        for (Robot r : parent.getRobots()) {
            if (r.getUsedTime() <= newTime) {
                int usedTime = r.getUsedTime() - newTime;
                if (usedTime <= 0) {
                    usedTime = 0;
                }
                robots.add(new Robot(r.getName(), Status.IDLE, new Position(r.getPosition().getX(), r.getPosition().getY()), usedTime));
            } else {
                robots.add(new Robot(r.getName(), r.getStatus(), new Position(r.getPosition().getX(), r.getPosition().getY()), r.getUsedTime()));
            }
        }
        State resp = new State(robots, cloneOrderList(parent.getOrdersToDeliver()), newTime);
        return resp;
    }

    @Override
    public int stepCost(State parent) {
        return Math.abs(getNewTime() - parent.getTime());
    }

    public String toString() {
        return "MoveForward => " + newTime;
    }

    public static List<Robot> cloneRobotList(List<Robot> list) {
        List<Robot> clone = new ArrayList<Robot>(list.size());
        for (Robot item : list) {
            clone.add((Robot) item.clone());
        }
        return clone;
    }

    public static List<Order> cloneOrderList(List<Order> list) {
        List<Order> clone = new ArrayList<Order>(list.size());
        for (Order item : list) {
            clone.add((Order) item.clone());

        }
        return clone;
    }

    @Override
    public Action clone() {
        return new MoveForward(newTime);
    }

}
