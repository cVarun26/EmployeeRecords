package com.example.Employee.Records.Repositories;

import com.example.Employee.Records.Models.EmpData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepo extends MongoRepository<EmpData,String> {
}
