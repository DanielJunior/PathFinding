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
public class Robot {

    private String name;
    private Status status;
    private Position position;
    private int usedTime;

    public Robot(String name, Status status, Position position) {
        this.name = name;
        this.status = status;
        this.position = position;
        this.usedTime = 0;
    }

    public Robot(String name, Status status, Position position, int usedTime) {
        this.name = name;
        this.status = status;
        this.position = position;
        this.usedTime = usedTime;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(int usedTime) {
        this.usedTime= usedTime;
    }

}
