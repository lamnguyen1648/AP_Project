/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Department;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lamsu
 */
public class ActionDepartment implements Action{
    
    ArrayList<Department> listDP = new ArrayList<>();

    public ArrayList<Department> getListDP() {
        return listDP;
    }

    public void setListDP(ArrayList<Department> listDP) {
        this.listDP = listDP;
    }

    @Override
    public Department add() {                                                   //Function add (Lâm)
        Scanner cmd = new Scanner(System.in);
        Department dp = null;                                                   //Gọi entity Department
        String id, name, address;                                               //Khai báo id, name, address
        String regexID = "[a-zA-Z0-9]$";                                        //Điều kiện nhập vào của ID (chỉ chứa ký tự a>z, A>Z và số 0>9)
        boolean inputRes;
        int dupeRes;
        do
        {
            System.out.println("Enter Department ID: ");
            id = cmd.nextLine();                                                //Gán id = input người dùng
            inputRes = checkInput(id, regexID);                                 //Gọi hàm kiểm tra input, truyền vào ID và điều kiện regexID, trả về kiểu boolean (true/false)
            if(inputRes == false) {                                             //Input ko hợp lệ -> báo lỗi
                System.out.println("Invalid Input");
                System.out.println("Department ID can only contains letters from a-z, capital letters from A-Z and numbers from 0-9");
            } else {                                                            //Input hợp lệ -> tiếp tục
                dupeRes = checkID(id);                                          //Kiểm tra ID xem có hay chưa, truyền vào ID, trả về kiểu int
                if(dupeRes >= 0) {                                              //Trả về 1 số lớn hơn 0 -> tìm thấy ID trùng -> báo lỗi
                    System.out.println("ID already exist");
                    inputRes = false;                                           //Sửa lại inputRes = false để lặp lại vòng lặp
                }
            }
        } while (inputRes == false);                                            //Vòng lặp do...while với điều kiện lặp inputRes trả về false 
        
        String regexString = "[a-zA-Z0-9, ]$";                                  //Điều kiện nhập vào của Name và Address (chỉ chứ ký tự a>z, A>Z, số 0>9, dấu phấy (,) và cách)
        do
        {
            System.out.println("Enter Department Name: ");
            name = cmd.nextLine();                                              //Gán name = input người dùng
            inputRes = checkInput(name, regexString);                           //Gọi hàm kiểm tra input, truyền vào name và điều kiện regexString, trả về kiểu boolean
            if(inputRes == false) {                                             //Input ko hợp lệ -> báo lỗi
                System.out.println("Invalid Input");
                System.out.println("Department Name can only contain letters from a-z, capital letters from A-Z, numbers from 0-9, comma (,) and space ( )");
            }
        } while(inputRes == false);                                             //Vòng lặp do...while với điều kiện lặp inputRes trả về false 
        
        do
        {
            System.out.println("Enter Department Address: ");
            address = cmd.nextLine();                                           //Gán address = input người dùng
            inputRes = checkInput(name, regexString);                           //Gọi hàm kiểm tra input, truyền vào address và điều kiện regexString, trả về kiểu boolean
            if(inputRes == false) {                                             //Input ko hợp lệ -> báo lỗi
                System.out.println("Invalid Input");
                System.out.println("Department Address can only contain letters from a-z, capital letters from A-Z, numbers from 0-9, comma (,) and space ( )");
            }
        } while(inputRes == false);                                             //Vòng lặp do...while với điều kiện lặp inputRes trả về false 
        
        dp = new Department(id, name, address);                                 //Truyền các giá trị trên vào class Department để thêm mới
        return dp;                                                              //Trả về dp
    }
    
    @Override
    public boolean edit(String id) {                                            //Function edit (Mạnh)                      
        Scanner cmd = new Scanner(System.in);
        int res = checkID(id);                                                  //Kiểm tra ID truyền vào
        if(res < 0) {                                                           //Trả về số âm -> ko tìm thấy
            System.out.println("ID doesn't exist");
            return false;
        } else {                                                                //Tìm thấy
            System.out.println("Current Department Name: " + listDP.get(res).getDpName() + "\n"
                             + "Enter New Department Name: \n"
                             + "Press Enter to skip\n");
            boolean nameRes;
            String name;
            do
            {
                System.out.println("Enter New Department Name: ");
                name = cmd.nextLine();                                          //Gán name = input người dùng
                if(name.equals("")) {                                           //Input = rồng -> skip, ko đổi tên
                    nameRes = true;                                             //Gán nameRes = true để thoát vòng lặp
                } else {                                                        //Input != rỗng
                    String regexString = "[a-zA-Z0-9, ]$";                      //Điều kiện input
                    nameRes = checkInput(name, regexString);                    //Kiểm tra input, truyền vào name và regexString, trả về kiểu boolean (true/false)
                    if(nameRes == true) {                                       //Input hợp lệ -> Gán giá trị mới
                        listDP.get(res).setDpName(name);
                    } else {                                                    //Input ko hợp lệ -> báo lỗi
                        System.out.println("Invalid Input");
                        System.out.println("Department Name can only contain letters from a-z, capital letters from A-Z, numbers from 0-9, comma (,) and space ( )");
                    }
                }
            } while(nameRes == false);                                          //Vòng lặp do...while với điều kiện lặp nameRes trả về false 
            
            System.out.println("Current Department Address: " + listDP.get(res).getDpAddress()+ "\n"
                             + "Enter New Department Name: \n"
                             + "Press Enter to skip\n");
            boolean addressRes;
            String address;
            do
            {
                System.out.println("Enter New Department Address: ");
                address = cmd.nextLine();                                       //Gán address = input người dùng
                if(address.equals("")) {                                        //Input rỗng -> skip, ko đổi tên
                    addressRes = true;                                          //Gán addressRes = true để thoát vòng lặp
                } else {                                                        //Input != rỗng
                    String regexString = "[a-zA-Z0-9, ]$";                      //Điều kiện input
                    addressRes = checkInput(address, regexString);              //Kiểm tra input, truyền vào address và regexString, trả về kiểu boolean (true/false)
                    if(addressRes == true) {                                    //Input hợp lệ -> Gán giá trị mới
                        listDP.get(res).setDpAddress(address);
                    } else {                                                    //Input ko hợp lệ -> báo lỗi
                        System.out.println("Invalid Input");
                        System.out.println("Department Address can only contain letters from a-z, capital letters from A-Z, numbers from 0-9, comma (,) and space ( )");
                    }
                }
            } while(nameRes == false);                                          //Vòng lặp do...while với điều kiện lặp nameRes trả về false 
            return true;                                                        //Trả về true -> edit thành công
        }
    }
    
    @Override
    public boolean delete(String id) {                                          //Function delete (Vũ)
        Scanner cmd = new Scanner(System.in);
        int res = checkID(id);                                                  //Kiểm tra ID truyền vào
        if(res < 0) {                                                           //Kết quả trả về âm -> ko tìm thấy
            System.out.println("ID doesn't exist");
            return false;
        }
        else {                                                                  //Tìm thấy
            boolean choice;
            do
            {                                                                            //lấy dữ liệu (ở đâu là tên) tại vị trí thứ res (vì res là kết quả trả về từ checkID) trong ArrayList
                System.out.println("Are you sure you want to delete Department(Y/N): " + listDP.get(res).getDpName());
                String input = cmd.nextLine();                                  //đọc input người dùng
                switch (input) {
                    case "Y":
                    case "y":
                        listDP.remove(res);                                     //Người dùng nhập Y hoặc y -> tiến hành xóa
                        choice = true;                                          //Gán choice = true để thoát khỏi vòng lặp
                        return true;                                            //Trả về true -> xóa thành công
                    case "N":
                    case "n":
                        System.out.println("Cancelled");                        //Người dùng nhập vào N hoặc n -> hủy xóa
                        choice = true;                                          //Gán choice = true để thoát khỏi vòng lặp
                        return false;                                           //Trả về flase -> xóa ko thành công
                    default:
                        System.out.println("Input Error, please try again");    //Input người dùng ko hợp lệ -> lỗi
                        choice = false;                                         //Gán choice = false để tiếp tục vòng lặp
                        return false;
                }
            } while(choice == false);
        }
    }

    @Override
    public boolean search(String id) {                                          //Function tìm kiếm (Kiên)
        int res = checkID(id);                                                  //Kiểm tra ID nhập vào
        if(res < 0) {                                                           //Trả về số âm -> ko tìm thấy
            System.out.println("ID doesn't exist");
            return false;                                                       //Trả về false -> tìm ko thành công
        } else {                                                                //Tìm thấy
            Department dp = listDP.get(res);                                    //Gán dp = dữ liệu trả về từ vị trí thứ res (vì res là kết quả trả về từ hàm checkID) trong ArrayList
            System.out.println("ID\t\tName\t\tAddress");
            System.out.println(dp.getDpID()+"\t\t"+dp.getDpName()+"\t\t"+dp.getDpAddress());    //In kết quả
            return true;                                                        //Trả về true -> tìm thành công
        }
    }
    
    @Override
    public void display() {                                                     //Function display (Cương)
        System.out.println("ID\t\tName\t\tAddress");
        for(int i = 0; i < listDP.size(); i++) {                                //Vòng lặp với limit là size của ArrayList hiện tại
            Department dp = listDP.get(i);                                      //Lấy kết quả trả về từ vị trí thứ i (i bắt đầu từ 0) trong ArrayList
            System.out.println(dp.getDpID()+"\t\t"+dp.getDpName()+"\t\t"+dp.getDpAddress());  //In
        }
    }
    
    @Override
    public int checkID(String id) {                                             //Function checkID (Lâm)
        for(int i = 0; i < listDP.size(); i++) {                                //Vòng lặp với limit là size của ArrayList hiện tại
            if(listDP.get(i).getDpID().equals(id)) {                            //Lấy kết quả trả về (ở đây là id) từ vị trí thứ i (i bắt đầu từ 0) trong ArrayList và so sánh với id truyền vào
                return i;                                                       //Tìm thấy -> trả về vị trí thứ i
            }
        }
        return -1;                                                              //Ko tìm thấy -> trả về 1 số âm vì ArrayList bắt đầu từ 0
    }

    @Override
    public boolean checkInput(String input, String check) {                     //Function checkInput (Lâm)
        Pattern p = Pattern.compile(check);                                     //Compile điều kiện truyền vào
        Matcher m = p.matcher(input);                                           //So sánh điều kiện truyền vào với input truyền vào
        boolean res = m.find();                                                 //Gán res = kết quả trả về (thỏa mãn = true; ko thỏa mãn = false)
        return res;                                                             //Trả về res
    }
   
}
