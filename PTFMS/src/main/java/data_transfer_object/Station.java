/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_transfer_object;

/**
 *
 * @author Owner
 */
public class Station {

    private int ID = -1;
    private String address = "";

    public Station() {
    }

    public Station(int id, String addr) {
        this.ID = id;
        this.address = addr;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
