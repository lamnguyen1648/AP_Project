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
public class Developer extends Employee{
    private int dvOvertime;

    public Developer(int dvOvertime, String emID, String emName, String emEmail, String emPhone, String emDoB) {
        super(emID, emName, emEmail, emPhone, emDoB);
        this.dvOvertime = dvOvertime;
    }

    public Developer() {
    }

    public int getDvOvertime() {
        return dvOvertime;
    }

    public void setDvOvertime(int dvOvertime) {
        this.dvOvertime = dvOvertime;
    }
    
    
}
