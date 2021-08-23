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
public class Qualification {
    private String qaID;
    private String qaName;
    private String qaAddress;

    public Qualification(String qaID, String qaName, String qaAddress) {
        this.qaID = qaID;
        this.qaName = qaName;
        this.qaAddress = qaAddress;
    }

    public Qualification() {
    }

    public String getQaID() {
        return qaID;
    }

    public void setQaID(String qaID) {
        this.qaID = qaID;
    }

    public String getQaName() {
        return qaName;
    }

    public void setQaName(String qaName) {
        this.qaName = qaName;
    }

    public String getQaAddress() {
        return qaAddress;
    }

    public void setQaAddress(String qaAddress) {
        this.qaAddress = qaAddress;
    }

    
}
