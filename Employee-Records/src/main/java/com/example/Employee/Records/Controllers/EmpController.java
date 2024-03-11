package com.example.Employee.Records.Controllers;

import com.example.Employee.Records.Models.EmpData;
import com.example.Employee.Records.Repositories.EmpRepo;
import com.example.Employee.Records.Repositories.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

        @Autowired
        EmpRepo repo;
        @Autowired
        SearchRepo searchRepo;

        @GetMapping("/allEmployees")
        public List<EmpData> getEmployees(){

                return repo.findAll();
        }

        @GetMapping("/allEmployees/{text}")
        public List<EmpData>search(@PathVariable String text){

                return searchRepo.findByText(text);
        }

        @PostMapping("/addEmployee")
        public EmpData addEmployee(@RequestBody EmpData data){
                return repo.save(data);
        }
}
