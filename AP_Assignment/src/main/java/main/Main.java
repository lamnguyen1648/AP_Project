/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Department;
import java.util.Scanner;
import model.ActionDepartment;

/**
 *
 * @author lamsu
 */
public class Main {
    public static void main(String[] args) {
        ActionDepartment ad = new ActionDepartment();
        while(true) {
            Scanner main = new Scanner(System.in);
            System.out.println("Human Resources Management System");
            System.out.println("---------------------------------\n"
                             + "Choose function:\n"
                             + "1. Manage Department\n"
                             + "2. Manage Qualification\n"
                             + "3. Manage Salary\n"
                             + "4. Manage Employee\n"
                             + "5. Exit\n"
                             + "---------------------------------\n");
            System.out.println("Please choose: ");
            int mainChoice = main.nextInt();
            switch(mainChoice) {
                case 1:                     //Department
                {
                    while(true) {
                        Scanner dept = new Scanner(System.in);
                        System.out.println("---------------------------------\n"
                                         + "Department Management\n"
                                         + "---------------------------------\n"
                                         + "Choose function:\n"
                                         + "1. Add Department\n"
                                         + "2. Update Department\n"
                                         + "3. Delete Department\n"
                                         + "4. Search Department\n"
                                         + "5. Display Department\n"
                                         + "6. Back to main menu\n"
                                         + "---------------------------------\n");
                        System.out.println("Please choose: ");
                        int deptChoice = dept.nextInt();
                        switch(deptChoice) {
                            case 1:         //Add
                            {
                                System.out.println("---------------------------------\n"
                                                 + "Add Department\n"
                                                 + "---------------------------------\n");
                                Department dp = ad.add();                       //Gọi hàm add
                                boolean res = ad.getListDP().add(dp);           //Kiểm tra gán giá trị thành công hay ko (ad.getListDP() -> gọi list bên trang ActionDepartment; add(dp) để thêm dữ liệu mà hàm add trả về vào trong ArrayList)
                                if(res == true) {                               //Thêm vào list thành công -> oke
                                    System.out.println("Add Successful\n");
                                } else {                                        //Thêm lỗi -> toang
                                    System.out.println("Add Failed\n");
                                }
                                break;
                            }
                            case 2:         //Update
                            {
                                Scanner sc = new Scanner(System.in);
                                System.out.println("---------------------------------\n"
                                                 + "Update Department\n"
                                                 + "---------------------------------\n");
                                if(ad.getListDP().isEmpty()) {                  //ArrayList trống -> lỗi
                                    System.out.println("Empty Department List");
                                } else {
                                    System.out.println("Enter Department ID: ");
                                    String id = sc.nextLine();                  //Đọc id
                                    boolean res = ad.edit(id);                  //Gán giá trị trả về từ hàm edit
                                    if(res == true) {                           //Trả về true -> sửa thành công
                                        System.out.println("Update Successful\n");
                                    } else {                                    //Trả về false -> sửa lỗi
                                        System.out.println("Update Unsuccessful\n");
                                    }
                                }
                                break;
                            }
                            case 3:         //Delete
                            {
                                Scanner sc = new Scanner(System.in);
                                System.out.println("---------------------------------\n"
                                                 + "Delete Department\n"
                                                 + "---------------------------------\n");
                                if(ad.getListDP().isEmpty()) {
                                    System.out.println("Empty Department List\n");
                                } else {
                                    System.out.println("Enter Deprtment ID: ");
                                    String id = sc.nextLine();
                                    boolean res = ad.delete(id);
                                    if(res == true) {
                                        System.out.println("Delete Successful\n");
                                    }
                                }
                                break;
                            }
                            case 4:         //Search
                            {
                                Scanner sc = new Scanner(System.in);
                                System.out.println("---------------------------------\n"
                                                 + "Search Department\n"
                                                 + "---------------------------------\n");
                                if(ad.getListDP().isEmpty()) {
                                    System.out.println("Empty Department List\n");
                                } else {
                                    System.out.println("Enter Deprtment ID: ");
                                    String id = sc.nextLine();
                                    boolean res = ad.delete(id);
                                    if(res == true) {
                                        System.out.println("Department Found\n");
                                    }
                                }
                                break;
                            }
                            case 5:         //Display
                            {
                                System.out.println("---------------------------------\n"
                                                 + "Display Department List\n"
                                                 + "---------------------------------\n");
                                if(ad.getListDP().isEmpty()) {
                                    System.out.println("Empty Department List\n");
                                } else {
                                    ad.display();
                                }
                                break;
                            }
                            case 6:         //Return to Main
                            {
                                System.out.println("Returning to Main Menu...");
                                break;
                            }
                            default:
                            {
                                System.out.println("Invalid Input");
                                break;
                            }
                        }
                        if(deptChoice == 6) break;
                    }
                }
                
                case 2:
                {
                    System.out.println("System currently in development");
                }
                
                case 3:
                {
                    System.out.println("System currently in development");
                }
                
                case 4:
                {
                    System.out.println("System currently in development");
                }
                
                case 5:
                {
                    System.exit(0);
                }
            }
        }
    }
}
