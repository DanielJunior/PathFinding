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
        State resp = new State(cloneRobotList(parent.getRobots()), cloneOrderList(parent.getOrdersToDeliver()), newTime);
        return resp;
    }

    @Override
    public int stepCost(State parent) {
        return Math.abs(getNewTime() - parent.getTime());
    }

    public String toString() {
        return "MoveForward => " + newTime;
    }

    public static List<Robot> cloneRobotList(List<Robot> list){
        List<Robot> clone = new ArrayList<Robot>(list.size());
        for (Robot item : list) {
            clone.add((Robot) item.clone());
        }
        return clone;
    }
    
      public static List<Order> cloneOrderList(List<Order> list){
        List<Order> clone = new ArrayList<Order>(list.size());
        for (Order item : list) {
            try {
                clone.add((Order) item.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(MoveForward.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clone;
    }

    @Override
    public Action clone() {
        return new MoveForward(newTime);
    }
      
}
