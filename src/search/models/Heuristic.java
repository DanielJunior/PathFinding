/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.models;

/**
 *
 * @author danieljunior
 */
public interface Heuristic<TNode> {

    public double function(TNode node);
}
