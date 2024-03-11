package com.example.Employee.Records.Repositories;

import com.example.Employee.Records.Models.EmpData;

import java.util.List;

public interface SearchRepo {

    List<EmpData> findByText(String text);

}
