package com.example.Employee.Records.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document("EmployeeRecords")

public class EmpData {

    @Id
    private  String emp_id;
    private  String name;
    private String designation;
    private  String salary;

}
