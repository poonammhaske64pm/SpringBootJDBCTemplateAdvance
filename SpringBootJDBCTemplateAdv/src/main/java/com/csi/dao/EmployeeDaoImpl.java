package com.csi.dao;

import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class EmployeeDaoImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    String INSERT_SQL = "insert into empjdbcadv(id, name, address, salary, age, contact, dobDate, emailId, emailPassword) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String SELECT_ALL_SQL = "select * from empjdbcadv";

    String SELECT_SQL_BY_ID = "select * from empjdbcadv where id = ?";

    String SELECT_SQL_BY_EMAILID = "select * from empjdbcadv where emailId = ?";

    String UPDATE_SQL = "update empjdbcadv set name = ?, address = ?, salary = ?, age = ?, contact = ?, dobDate = ?, emailId = ?, emailPassword = ? where id = ?";

    String DELETE_BY_ID = "delete from empjdbcadv where id = ?";

    String DELETE_ALL = "truncate table empjdbcadv";

    private Employee employee(ResultSet resultSet, int numRow) throws SQLException {
        return Employee.builder().id(resultSet.getInt(1)).name(resultSet.getString(2)).address(resultSet.getString(3)).salary(resultSet.getDouble(4)).age(resultSet.getInt(5)).contact(resultSet.getLong(6)).dobDate(resultSet.getDate(7)).emailId(resultSet.getString(8)).emailPassword(resultSet.getString(9)).build();
    }

    // signup
    public void signUp(Employee employee){

        jdbcTemplate.update(INSERT_SQL, employee.getId(), employee.getName(), employee.getAddress(), employee.getSalary(), employee.getAge(), employee.getContact(), employee.getDobDate(), employee.getEmailId(), employee.getEmailPassword());
    }

    // signin
    public boolean signIn(String emailId, String emailPassword){

        boolean flag = false;

        for(Employee employee : getAllData()){
            if (employee.getEmailId().equals(emailId) && employee.getEmailPassword().equals(emailPassword)) {

                flag = true;
            }
        }
        return flag;
    }

    // getdatabyid
    public Employee getDataById(int id){

        return jdbcTemplate.query(SELECT_SQL_BY_ID, this::employee, id).get(0);
    }

    // getdatabyname
    public List<Employee> getDataByName(String name){

        return getAllData().stream().filter(emp -> emp.getName().equals(name)).toList();
    }

    // getdatabyemail
    public Employee getDataByEmailId(String emailId){

        return jdbcTemplate.query(SELECT_SQL_BY_EMAILID, this::employee, emailId).get(0);
    }

    // getdatabycontact
    public Employee getDataByContact(long contact){

        return getAllData().stream().filter(emp -> emp.getContact()==contact).toList().get(0);
    }

    // getdatabyanyinput
    public List<Employee> getDataByAnyInput(String input){

        List<Employee> employeeList = new ArrayList<>();

        for(Employee employee : getAllData()){

            if(employee.getName().equals(input)
            || String.valueOf(employee.getContact()).equals(input)
            || employee.getAddress().equals(input)
            || String.valueOf(employee.getSalary()).equals(input)
            || String.valueOf(employee.getAge()).equals(input)
            || String.valueOf(employee.getDobDate()).equals(input)
            || employee.getEmailId().equals(input)
            || employee.getEmailPassword().equals(input)){

                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    // getalldata
    public List<Employee> getAllData(){

        return jdbcTemplate.query(SELECT_ALL_SQL, this::employee);
    }

    // sortbyid
    public List<Employee> sortById(){

        return getAllData().stream().sorted(Comparator.comparingInt(Employee::getId)).toList();
    }

    // sortbyname
    public List<Employee> sortByName(){

        return getAllData().stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).toList();
    }

    // sortbyage
    public List<Employee> sortByAge(){

        return getAllData().stream().sorted(Comparator.comparingInt(Employee::getAge)).toList();
    }

    // sortbysalary
    public List<Employee> sortBySalary(){

        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
    }

    // sortbydob
    public List<Employee> sortByDob(){

        return getAllData().stream().sorted((e1, e2) -> e1.getDobDate().compareTo(e2.getDobDate())).toList();
    }

    // filterdatabysalary
    public List<Employee> filterDataBySalary(double salary){

        return getAllData().stream().filter(emp -> emp.getSalary() > 50000).toList();
    }

    // loaneligibility
    public boolean isEligibleForLoan(int id){

        boolean flag = false;

        for(Employee employee : getAllData()){
            if(employee.getId() == id && employee.getSalary() > 50000){
                flag = true;
            }
        }
        return flag;
    }

    // updatedata
    public void updateDataById(int id, Employee employee){

        jdbcTemplate.update(UPDATE_SQL, employee.getName(), employee.getAddress(), employee.getSalary(), employee.getAge(), employee.getContact(), employee.getDobDate(), employee.getEmailId(), employee.getEmailPassword(), id);
    }

    // deletebyid
    public void deleteById(int id){

        jdbcTemplate.update(DELETE_BY_ID, id);
    }

    // deletealldata
    public void deleteAllData(){

        jdbcTemplate.update(DELETE_ALL);
    }
}
