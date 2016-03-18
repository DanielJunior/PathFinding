/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.orderDelivery.models;

import java.util.List;

/**
 *
 * @author danieljunior
 */
public class State {

    private List<Robot> robots;
    private List<Order> ordersToDeliver;
    private int time;
    private State parent;

    public State() {
    }

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

    public Order getOrder(Station station, Product product) {
        for (Order o : ordersToDeliver) {
            if (o.getProduct().equals(product) && o.getStationDeliver().equals(station)) {
                return o;
            }
        }
        return null;
    }

    public int numberOfOnDeliveryRobots() {
        int resp = 0;
        for (Robot r : robots) {
            resp++;
        }
        return resp;
    }

    public String toString() {
        String robotToString = "";
        for (Robot r : robots) {
            robotToString += r.toString() +"\n";
        }
        String ordersToString = "";
        for (Order o : ordersToDeliver) {
            ordersToString += o.toString()+"";
        }
        return "Orders:" + ordersToString + "\n\nRobots:\n" + robotToString + "\nCurrentTime: " + getTime()+"\n";
    }
}
