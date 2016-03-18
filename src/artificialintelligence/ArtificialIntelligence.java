/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificialintelligence;

import java.util.ArrayList;
import java.util.List;
import problems.orderDelivery.OrderDeliveryProblem;
import problems.orderDelivery.models.Order;
import problems.orderDelivery.models.Position;
import problems.orderDelivery.models.Product;
import problems.orderDelivery.models.Robot;
import problems.orderDelivery.models.State;
import problems.orderDelivery.models.Station;
import problems.orderDelivery.models.Status;
import problems.orderDelivery.search.AHeuristic;
import search.models.Action;
import problems.orderDelivery.search.Deliver;
import problems.orderDelivery.search.MoveForward;
import search.AStar;
import search.models.Problem;
import search.models.Solution;

/**
 *
 * @author danieljunior
 */
public class ArtificialIntelligence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Action> actions = new ArrayList<>();
        actions.add(new MoveForward());
        actions.add(new Deliver());

        List<Product> products = new ArrayList<>();
        Product p1 = new Product("prod1", new Position(0, 0));
        products.add(p1);
        Product p2 = new Product("prod2", new Position(0, 10));
        products.add(p2);
        Product p3 = new Product("prod3", new Position(0, 20));
        products.add(p3);

        Station s1 = new Station("pack1", new Position(20, 0));
        Station s2 = new Station("pack2", new Position(20, 10));
        Station s3 = new Station("pack3", new Position(20, 20));

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("order1", p1, s1));
        orders.add(new Order("order2", p2, s2));
        orders.add(new Order("order3", p3, s3));

        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot("r1", Status.ON_DELIVERY, new Position(20, 10), 14));
        robots.add(new Robot("r2", Status.ON_DELIVERY, new Position(20, 20), 8));
        robots.add(new Robot("r3", Status.ON_DELIVERY, new Position(20, 0), 8));

        State initialState = new State(robots, orders, 0);

        Problem problem = new OrderDeliveryProblem(actions, initialState, null);

        AStar<State, Action> astar = new AStar();
        Solution resp = astar.search(problem, new AHeuristic());
        if (resp != null) {
            resp.print();
        } else {
            System.out.println("Solução não encontrada!");
        }
    }
}
