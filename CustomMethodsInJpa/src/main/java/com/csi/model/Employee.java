package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private  int empId;
    private String empName;
    private int empAge;
    private long empContactNo;
    private double empSalary;
    @JsonFormat (pattern = "dd-MM-yyyy" , timezone = "Asia/Kolkata")
    @Temporal(TemporalType.DATE)
    private Date empDob;
    private String empEmailId;
    private String empPassword;

}
