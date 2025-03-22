package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDao;

    // signup
    public void signUp(Employee employee){
        employeeDao.signUp(employee);
    }

    // signin
    public boolean signIn(String emailId, String emailPassword){
        return employeeDao.signIn(emailId, emailPassword);
    }

    // getdatabyid
    public Employee getDataById(int id){
        return employeeDao.getDataById(id);
    }

    // getdatabyname
    public List<Employee> getDataByName(String name){
        return employeeDao.getDataByName(name);
    }

    // getdatabyemail
    public Employee getDataByEmailId(String emailId){
        return employeeDao.getDataByEmailId(emailId);
    }

    // getdatabycontact
    public Employee getDataByContact(long contact){
        return employeeDao.getDataByContact(contact);
    }

    // getdatabyanyinput
    public List<Employee> getDataByAnyInput(String input){
        return employeeDao.getDataByAnyInput(input);
    }

    // getalldata
    public List<Employee> getAllData(){
        return employeeDao.getAllData();
    }

    // sortbyid
    public List<Employee> sortById(){
        return employeeDao.sortById();
    }

    // sortbyname
    public List<Employee> sortByName(){
        return employeeDao.sortByName();
    }

    // sortbyage
    public List<Employee> sortByAge(){
        return employeeDao.sortByAge();
    }

    // sortbysalary
    public List<Employee> sortBySalary(){
        return employeeDao.sortBySalary();
    }

    // sortbydob
    public List<Employee> sortByDobDate(){
        return employeeDao.sortByDob();
    }

    // filterdatabysalary
    public List<Employee> filterDataBYSalary(double salary){
        return employeeDao.filterDataBySalary(salary);
    }

    // loaneligibility
    public boolean IsEligibleForLoan(int id){
        return employeeDao.isEligibleForLoan(id);
    }

    // updatedata
    public void updateDataById(int id, Employee employee){
         employeeDao.updateDataById(id, employee);
    }

    // deletedatabyid
    public void deleteById(int id){
        employeeDao.deleteById(id);
    }

    // deletealldata
    public void deleteAllData(){
        employeeDao.deleteAllData();
    }
}
