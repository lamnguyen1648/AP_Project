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
public class Tester extends Employee{
    private int tsBugsFound;

    public Tester(int tsBugsFound, String emID, String emName, String emEmail, String emPhone, String emDoB) {
        super(emID, emName, emEmail, emPhone, emDoB);
        this.tsBugsFound = tsBugsFound;
    }

    public Tester() {
    }

    public int getTsBugsFound() {
        return tsBugsFound;
    }

    public void setTsBugsFound(int tsBugsFound) {
        this.tsBugsFound = tsBugsFound;
    }
    
    
}
