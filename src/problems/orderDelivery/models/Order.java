/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.orderDelivery.models;

/**
 *
 * @author danieljunior
 */
public class Order implements Cloneable {

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

    public String toString() {
        return "\n[ " + getName() + " - Product: " + getProduct().getName() + " - Station: " + getStationDeliver().getName() + " ]";
    }

    @Override
    public Object clone(){
        return new Order(name, new Product(product.getName(), new Position(product.getPosition().getX(), product.getPosition().getY())), new Station(stationDeliver.getName(), new Position(stationDeliver.getPosition().getX(), stationDeliver.getPosition().getY())));
    }

}
