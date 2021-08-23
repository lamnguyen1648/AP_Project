/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author lamsu
 */
public class Department {
    private String dpID;
    private String dpName;
    private String dpAddress;

    public Department(String dpID, String dpName, String dpAddress) {
        this.dpID = dpID;
        this.dpName = dpName;
        this.dpAddress = dpAddress;
    }

    public Department() {
    }

    public String getDpID() {
        return dpID;
    }

    public void setDpID(String dpID) {
        this.dpID = dpID;
    }

    public String getDpName() {
        return dpName;
    }

    public void setDpName(String dpName) {
        this.dpName = dpName;
    }

    public String getDpAddress() {
        return dpAddress;
    }

    public void setDpAddress(String dpAddress) {
        this.dpAddress = dpAddress;
    }
    
    
}
