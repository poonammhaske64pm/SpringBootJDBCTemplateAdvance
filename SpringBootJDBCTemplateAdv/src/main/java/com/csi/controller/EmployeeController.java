package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    // signup
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee){
        log.info("####################################################### sign up for employee");
        employeeService.signUp(employee);
        return ResponseEntity.ok("SIGN UP SUCCESS");
    }

    // signin
    @GetMapping("/signin/{emailId}/{emailPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String emailId, @PathVariable String emailPassword){
        log.info("########################################################### sign in for employee");
        return ResponseEntity.ok(employeeService.signIn(emailId, emailPassword));
    }

    // getdatabyid
    @GetMapping("/getdatabyid/{id}")
    public ResponseEntity<Employee> getDataById(@PathVariable int id){
        log.info("################################################# get data by employee ID");
        return ResponseEntity.ok(employeeService.getDataById(id));
    }

    // getdatabyname
    @GetMapping("/getdatabyname/{name}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String name){
        log.info("################################################# get data by employee name");
        return ResponseEntity.ok(employeeService.getDataByName(name));
    }

    // getdatabyemail
    @GetMapping("/getdatabyemail/{emailId}")
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String emailId){
        log.info("################################################# get data by employee emailid");
        return ResponseEntity.ok(employeeService.getDataByEmailId(emailId));
    }

    // getdatabycontact
    @GetMapping("/getdatabycontact/{contact}")
    public ResponseEntity<Employee> getDataByContact(@PathVariable long contact){
        log.info("################################################# get data by employee contact");
        return ResponseEntity.ok(employeeService.getDataByContact(contact));
    }

    // getdatabyanyinput
    @GetMapping("/getdatabyanyinput/{input}")
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input){
        log.info("################################################# get data of employee by any input");
        return ResponseEntity.ok(employeeService.getDataByAnyInput(input));
    }

    // getalldata
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        log.info("################################################# get all employee data");
        return ResponseEntity.ok(employeeService.getAllData());
    }

    // sortbyid
    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>> sortById(){
        log.info("####################################################### sort employee data by ID");
        return ResponseEntity.ok(employeeService.sortById());
    }

    // sortbyname
    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        log.info("####################################################### sort employee data by name");
        return ResponseEntity.ok(employeeService.sortByName());
    }

    // sortbyage
    @GetMapping("/sortbyage")
    public ResponseEntity<List<Employee>> sortByAge(){
        log.info("####################################################### sort employee data by age");
        return ResponseEntity.ok(employeeService.sortByAge());
    }

    // sortbysalary
    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary(){
        log.info("####################################################### sort employee data by salary");
        return ResponseEntity.ok(employeeService.sortBySalary());
    }

    // sortbydob
    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDobDate(){
        log.info("####################################################### sort employee data by DOB date");
        return ResponseEntity.ok(employeeService.sortByDobDate());
    }

    // filterdatabysalary
    @GetMapping("/filterdatabysalary/{salary}")
    public ResponseEntity<List<Employee>> filterDataBYSalary(@PathVariable double salary){
        log.info("####################################################### filter employee data by salary");
        return ResponseEntity.ok(employeeService.filterDataBYSalary(salary));
    }

    // loaneligibility
    @GetMapping("/loaneligibility/{id}")
    public ResponseEntity<String> IsEligibleForLoan(@PathVariable int id){
        log.info("################################################### checking loan eligibility for employee data by ID");

        String msg = null;
        if(employeeService.IsEligibleForLoan(id)){
            msg = "YES! ELIGIBLE";
        } else {
            msg = "NOT ELIGIBLE";
        }
        return ResponseEntity.ok(msg);
    }

    // updatedata
    @PutMapping("/updatedatabyid/{id}")
    public ResponseEntity<String> updateDataById(@PathVariable int id, @RequestBody Employee employee){
        log.info("################################################### updating employee data by id");
        employeeService.updateDataById(id, employee);
        return ResponseEntity.ok("DATA UPDATED");
    }

    // deletedatabyid
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        log.info("########################################### delete employee data by ID");
        employeeService.deleteById(id);
        return ResponseEntity.ok("DATA DELETED");
    }

    // deletealldata
    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        log.info("########################################### delete all employee data");
        employeeService.deleteAllData();
        return ResponseEntity.ok("DATA DELETED");
    }
}
