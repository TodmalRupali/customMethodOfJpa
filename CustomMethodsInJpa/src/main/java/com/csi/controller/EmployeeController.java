package com.csi.controller;

import com.csi.exception.RecordNotFound;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public Employee signUp(@RequestBody Employee employee) {
        return employeeService.signUp(employee);
    }

    @GetMapping("/signin")
    public ResponseEntity<List<Employee>> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        List<Employee> employee = new ArrayList<>();
        if (employeeService.signIn(empEmailId, empPassword)) {
            return ResponseEntity.ok(employeeService.getAllData());
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Employee>> getAllData() {
        return ResponseEntity.ok(employeeService.getAllData());
    }

    @GetMapping("/getbyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByEmpName(@PathVariable String empName) {
        return ResponseEntity.ok(employeeService.getDataByEmpName(empName));
    }

    @GetMapping("/getbyid")
    public ResponseEntity<Optional<Employee>> getDataByEmpId(@PathVariable int empId) {
        return ResponseEntity.ok(employeeService.getDataByEmpId(empId));
    }

    @GetMapping("/getbycontactno")
    public ResponseEntity<Employee> getDataByEmpContactNo(@PathVariable long empContactNo) {
        return ResponseEntity.ok(employeeService.getDataByEmpContactNo(empContactNo));
    }

    @GetMapping("/getbyemail/{empEmailId}")
    public ResponseEntity<Employee> getDataByEmpEmailId(@PathVariable String empEmailId) {
        return ResponseEntity.ok(employeeService.getDataByEmpEmailId(empEmailId));
    }
    @GetMapping("/getbydob/{empDob}")
    public ResponseEntity<Employee> getDataByDOB(@PathVariable String empDob) {
        return ResponseEntity.ok(employeeService.getDataByEmpEmailId(empDob));
    }


    @GetMapping("/getbyanyinput/{empAnyInput}")
    public ResponseEntity<List<Employee>> getDataByEmpAnyInput(@PathVariable String empAnyInput) {
        return ResponseEntity.ok(employeeService.getDataByEmpAnyInput(empAnyInput));

    }
    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByEmpName() {
        return ResponseEntity.ok(employeeService.sortByEmpName());
    }
    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>> sortByEmpId() {
        return ResponseEntity.ok(employeeService.sortByEmpId());
    }
    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortByEmpSalary() {
        return ResponseEntity.ok(employeeService.sortByEmpSalary());
    }
    @GetMapping("/filterbysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterByEmpSalary(@PathVariable double empSalary) {
        return ResponseEntity.ok(employeeService.filterByEmpSalary(empSalary));}
    @GetMapping("/loaneligibility/{empId}")
    public String loanEligibilityByEmpSalary(@PathVariable int empId){

        return  employeeService.loanEligibilityByEmpSalary(empId);
    }
    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByEmpDob() {
        return ResponseEntity.ok(employeeService.sortByEmpDob());}
@PutMapping("/update{empId}")
    public  Employee update(@PathVariable int empId ,@RequestBody Employee employee){
        Employee employee1 = employeeService.getDataByEmpId(empId).orElseThrow(()-> new RecordNotFound("Not Found"));
       employee1.setEmpName(employee.getEmpName());
       employee1.setEmpAge(employee.getEmpAge());
       employee1.setEmpContactNo(employee.getEmpContactNo());
       employee1.setEmpSalary(employee.getEmpSalary());
       employee1.setEmpDob(employee.getEmpDob());
       employee1.setEmpEmailId(employee.getEmpEmailId());
       employee1.setEmpPassword(employee.getEmpPassword());
        return  employeeService.update(employee1);
    }
    @DeleteMapping ("/deletebyid/{empId}")
    public  void deleteByEmpId(@PathVariable int empId){
        employeeService.deleteByEmpId(empId);
    }
    @DeleteMapping("/deleteall")
    public  void deleteAll(){
        employeeService.deleteAll();
    }












    }











