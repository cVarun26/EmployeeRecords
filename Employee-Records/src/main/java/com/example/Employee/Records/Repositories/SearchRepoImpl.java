package com.example.Employee.Records.Repositories;

import com.example.Employee.Records.Models.EmpData;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component

public class SearchRepoImpl implements SearchRepo{

    @Autowired
    MongoClient  client;

    @Autowired
    MongoConverter converter;
    @Override
    public List<EmpData> findByText(String text) {

        final List<EmpData> Result= new ArrayList<>();

        MongoDatabase database = client.getDatabase("Employee");
        MongoCollection<Document> collection = database.getCollection("EmployeeRecords");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                                 new Document("text",
                                new Document("query", text)
                                        .append("path", "designation"))),
                                new Document("$sort",
                          new Document("salary", 1L))));

        result.forEach((doc->Result.add(converter.read(EmpData.class,doc))));


        return Result;
    }
}
