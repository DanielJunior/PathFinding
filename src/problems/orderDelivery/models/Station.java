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
public class Station {

    private String name;
    private Position position;

    public Station(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String toString() {
        return "Station: " + getName() + " - Position: " + getPosition().toString();
    }

    @Override
    public Object clone(){
        return new Station(name, new Position(getPosition().getX(), getPosition().getY()));
    }

}
