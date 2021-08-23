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
public class Employee {
    private String emID;
    private String emName;
    private String emEmail;
    private String emPhone;
    private String emDoB;
    private Department dp;
    private Qualification qa;
    private Salary sl;

    public Employee(String emID, String emName, String emEmail, String emPhone, String emDoB) {
        this.emID = emID;
        this.emName = emName;
        this.emEmail = emEmail;
        this.emPhone = emPhone;
        this.emDoB = emDoB;
    }

    public Employee() {
    }

    public String getEmID() {
        return emID;
    }

    public void setEmID(String emID) {
        this.emID = emID;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public String getEmEmail() {
        return emEmail;
    }

    public void setEmEmail(String emEmail) {
        this.emEmail = emEmail;
    }

    public String getEmPhone() {
        return emPhone;
    }

    public void setEmPhone(String emPhone) {
        this.emPhone = emPhone;
    }

    public String getEmDoB() {
        return emDoB;
    }

    public void setEmDoB(String emDoB) {
        this.emDoB = emDoB;
    }
    
    
}
