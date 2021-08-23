/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lamsu
 */
public interface Action {
    
    Object add();
    
    boolean edit(String id);
    
    boolean delete(String id);
    
    boolean search(String id);
    
    void display();
    
    int checkID(String id);
    
    boolean checkInput(String input, String check);
    
}
