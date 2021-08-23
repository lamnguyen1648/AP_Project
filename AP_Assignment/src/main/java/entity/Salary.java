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
public class Salary {
    private String slID;
    private String slName;
    private String slDesc;
    private int slBasic;
    private int slBonus;
    private int slPenalty;
    private int slTotal;

    public Salary(String slID, String slName, String slDesc, int slBasic, int slBonus, int slPenalty, int slTotal) {
        this.slID = slID;
        this.slName = slName;
        this.slDesc = slDesc;
        this.slBasic = slBasic;
        this.slBonus = slBonus;
        this.slPenalty = slPenalty;
        this.slTotal = slTotal;
    }

    public Salary() {
    }

    public String getSlID() {
        return slID;
    }

    public void setSlID(String slID) {
        this.slID = slID;
    }

    public String getSlName() {
        return slName;
    }

    public void setSlName(String slName) {
        this.slName = slName;
    }

    public String getSlDesc() {
        return slDesc;
    }

    public void setSlDesc(String slDesc) {
        this.slDesc = slDesc;
    }

    public int getSlBasic() {
        return slBasic;
    }

    public void setSlBasic(int slBasic) {
        this.slBasic = slBasic;
    }

    public int getSlBonus() {
        return slBonus;
    }

    public void setSlBonus(int slBonus) {
        this.slBonus = slBonus;
    }

    public int getSlPenalty() {
        return slPenalty;
    }

    public void setSlPenalty(int slPenalty) {
        this.slPenalty = slPenalty;
    }

    public int getSlTotal() {
        return slTotal;
    }

    public void setSlTotal(int slTotal) {
        this.slTotal = slTotal;
    }
    
    
}
