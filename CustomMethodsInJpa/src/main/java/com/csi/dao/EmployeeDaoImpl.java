package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee signUp(Employee employee) {
        return employeeRepo.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;
        for (Employee employee : employeeRepo.findAll()) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
                flag = true;
            }
        }
        return flag;
    }

    public List<Employee> getAllData() {
        return employeeRepo.findAll();
    }

    public List<Employee> getDataByEmpName(String empName) {
        return employeeRepo.findByEmpName(empName);
    }

    public Optional<Employee> getDataByEmpId(int empId) {
        return employeeRepo.findById(empId);
    }
    public  List<Employee> getDataByDob(String empDob) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date empDob1 = simpleDateFormat.parse(empDob);
        return employeeRepo.findByEmpDob(empDob1);
    }

    public Employee getDataByEmpContactNo(long empContactNo) {
        return employeeRepo.findByEmpContactNo(empContactNo);
    }

    public Employee getDataByEmpEmailId(String empEmailId) {
        return employeeRepo.findByEmpEmailId(empEmailId);
    }

    public List<Employee> getDataByEmpAnyInput(String empAnyInput)  {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employeeRepo.findAll()) {
            if (employee.getEmpName().equals(empAnyInput) || employee.getEmpEmailId().equals(empAnyInput) || String.valueOf(employee.getEmpId()).equals(empAnyInput) || String.valueOf(employee.getEmpContactNo()).equals(empAnyInput) || String.valueOf(employee.getEmpAge()).equals(empAnyInput) || String.valueOf(employee.getEmpSalary()).equals(empAnyInput) || String.valueOf(employee.getEmpDob()).equals(empAnyInput) ) {
                list.add(employee);
            }
        }
        return list;
    }
    public List<Employee> sortByEmpName(){
        return getAllData().stream().sorted((e1,e2)-> e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
    }
    public List<Employee> sortByEmpId(){
        return getAllData().stream().sorted(Comparator.comparingLong(Employee :: getEmpId)).collect(Collectors.toList());
    }
    public List<Employee> sortByEmpSalary(){
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee :: getEmpSalary)).collect(Collectors.toList());
    }
    public List<Employee> sortByEmpDob(){
        return  getAllData().stream().sorted((e1,e2) -> e1.getEmpDob().compareTo(e2.getEmpDob())).collect(Collectors.toList());
    }
    public List<Employee> filterByEmpSalary(double empSalary){
        return  employeeRepo.findAll().stream().filter(emp-> emp.getEmpSalary()>empSalary).collect(Collectors.toList());
    }
    public String loanEligibilityByEmpSalary(int empId){
        String result=null;
        Optional<Employee> employee = getDataByEmpId(empId);
       Employee employee1 = (Employee) employee.stream().filter(emp -> emp.getEmpSalary()>50000).collect(Collectors.toList());
       return  employee1.getEmpName() + " Eligible for Loan";
        }
    public  Employee update(Employee employee){
        return  employeeRepo.save(employee);
    }
    public  void deleteByEmpId(int empId){
         employeeRepo.deleteById(empId);
    }
    public  void deleteAll(){
        employeeRepo.deleteAll();
    }
}


