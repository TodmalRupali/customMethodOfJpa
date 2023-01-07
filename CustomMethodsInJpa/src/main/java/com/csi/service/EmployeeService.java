package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDaoImpl employeeDao;
    public Employee signUp(Employee employee) {
        return employeeDao.signUp(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDao.signIn(empEmailId,empPassword);
    }

    public List<Employee> getAllData() {
        return employeeDao.getAllData();
    }

    public List<Employee> getDataByEmpName(String empName) {
        return employeeDao.getDataByEmpName(empName);
    }

    public Optional<Employee> getDataByEmpId(int empId) {
        return employeeDao.getDataByEmpId(empId);
    }
    public  List<Employee> getDataByDob(String empDob) throws ParseException {
        return employeeDao.getDataByDob(empDob);
    }
    public Employee getDataByEmpContactNo(long empContactNo) {
        return employeeDao.getDataByEmpContactNo(empContactNo);
    }

    public Employee getDataByEmpEmailId(String empEmailId) {
        return employeeDao.getDataByEmpEmailId(empEmailId);
    }

    public List<Employee> getDataByEmpAnyInput(String empAnyInput)  {

        return employeeDao.getDataByEmpAnyInput(empAnyInput);
    }
    public List<Employee> sortByEmpName(){
        return employeeDao.sortByEmpName();
    }
    public List<Employee> sortByEmpId(){
        return employeeDao.sortByEmpId();
    }
    public List<Employee> sortByEmpSalary(){
        return employeeDao.sortByEmpSalary();
    }
    public List<Employee> sortByEmpDob(){
         return employeeDao.sortByEmpDob();
    }
    public List<Employee> filterByEmpSalary(double empSalary){
return employeeDao.filterByEmpSalary(empSalary);   }
    public String loanEligibilityByEmpSalary(int empId){

        return  employeeDao.loanEligibilityByEmpSalary(empId);
    }
    public  Employee update(Employee employee){
        return  employeeDao.update(employee);
    }
    public  void deleteByEmpId(int empId){
        employeeDao.deleteByEmpId(empId);
    }
    public  void deleteAll(){
        employeeDao.deleteAll();
    }
}
