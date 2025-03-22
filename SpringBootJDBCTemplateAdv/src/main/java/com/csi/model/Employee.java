package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    private int id;

    private String name;

    private String address;

    private double salary;

    private long contact;

    private int age;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dobDate;

    private String emailId;

    private String emailPassword;
}
