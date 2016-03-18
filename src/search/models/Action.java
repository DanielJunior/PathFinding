/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.models;

import problems.orderDelivery.models.State;

/**
 *
 * @author danieljunior
 */
public interface Action {

    public State go(State state);
    public int stepCost(State state);
}
