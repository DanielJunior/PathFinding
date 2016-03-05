/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDelivery;

import java.util.List;
import orderDelivery.models.Order;
import orderDelivery.models.Robot;

/**
 *
 * @author danieljunior
 */
public class State {

    private List<Robot> robots;
    private List<Order> ordersToDeliver;
    private int time;
    private State parent;

    public State(List<Robot> robots, List<Order> ordersToDeliver, int time) {
        this.robots = robots;
        this.ordersToDeliver = ordersToDeliver;
        this.time = time;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }

    public List<Order> getOrdersToDeliver() {
        return ordersToDeliver;
    }

    public void setOrdersToDeliver(List<Order> ordersToDeliver) {
        this.ordersToDeliver = ordersToDeliver;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public State getParent() {
        return parent;
    }

    public void setParent(State child) {
        this.parent = child;
    }

}
