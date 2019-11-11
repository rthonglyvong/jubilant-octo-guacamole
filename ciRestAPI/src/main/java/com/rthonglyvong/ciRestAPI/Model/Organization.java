package com.rthonglyvong.ciRestAPI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long organization_id;

    private String name;
    private String address;
    private String phone;

    @ManyToMany(mappedBy = "organizations")
    @JsonBackReference
    private Set<Users> users = new HashSet<>();

    public Organization(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Organization() {}

    public Long getOrganization_id() {
        return organization_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Users> getUsers() {
        return users;
    }

}
