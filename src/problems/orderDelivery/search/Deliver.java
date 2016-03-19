/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.orderDelivery.search;

import java.util.ArrayList;
import java.util.List;
import problems.orderDelivery.models.Order;
import problems.orderDelivery.models.Position;
import problems.orderDelivery.models.Product;
import problems.orderDelivery.models.Robot;
import problems.orderDelivery.models.State;
import problems.orderDelivery.models.Station;
import problems.orderDelivery.models.Status;
import search.models.Action;

/**
 *
 * @author danieljunior
 */
public class Deliver implements Action {

    private Robot robot;
    private Product product;
    private Station station;

    public Deliver(Robot robot, Product product, Station station) {
        this.robot = robot;
        this.product = product;
        this.station = station;
    }

    public Deliver() {
    }

    @Override
    public State go(State state) {
        ArrayList<Robot> newRobots = new ArrayList<>();
        Robot aux = null;
        for (Robot r : state.getRobots()) {
            Robot temp = (Robot) r.clone();
            newRobots.add(temp);
            if (r.equals(robot)) {
                aux = temp;
            }
        }
        aux.setStatus(Status.ON_DELIVERY);
        int timeToGetProduct = calculateUsedTime(aux.getPosition(), product.getPosition());
        int timeToGoToStation = calculateUsedTime(product.getPosition(), station.getPosition());
        aux.setUsedTime(timeToGetProduct + timeToGoToStation);
        aux.setPosition((Position) station.getPosition().clone());

        ArrayList<Order> newOrders = new ArrayList<>();
        for (Order o : state.getOrdersToDeliver()) {
            if (!state.getOrder(station, product).equals(o)) {
                newOrders.add(o);
            }
        }
        return new State(newRobots, newOrders, state.getTime());

    }

    private int calculateUsedTime(Position position, Position position0) {
        return Math.abs(position.getX() - position0.getX()) + Math.abs(position.getY() - position0.getY());
    }

    @Override
    public int stepCost(State state) {
        return 0;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String toString() {
        return "[ " + robot.getName() + " - " + product.getName() + " - " + station.getName() + " ]";
    }

    @Override
    public Action clone() {
        return new Deliver((Robot) robot.clone(), (Product) product.clone(), (Station) station.clone());
    }

}
