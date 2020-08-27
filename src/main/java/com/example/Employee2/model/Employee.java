package com.example.Employee2.model;




import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="name")
    @NotNull(message = "name not found")
    private String name;
    @Column(name="phone")
    @NotNull(message = "phone not found")
    private String phone;
    @Column(name="address")
    @NotNull(message = "address not found")
    private String address;
    @Column(name="role")
    @NotNull(message = "role not found")
    private String role;

}
