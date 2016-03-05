/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDelivery.models;

/**
 *
 * @author danieljunior
 */
public class Order {

    private String name;
    private Product product;
    private Station stationDeliver;

    public Order(String name, Product product, Station stationDeliver) {
        this.name = name;
        this.product = product;
        this.stationDeliver = stationDeliver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Station getStationDeliver() {
        return stationDeliver;
    }

    public void setStationDeliver(Station stationDeliver) {
        this.stationDeliver = stationDeliver;
    }

}
