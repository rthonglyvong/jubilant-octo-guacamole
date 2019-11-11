package com.rthonglyvong.ciRestAPI.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long user_id;
    @Column(nullable=false)
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_organization",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "organization_id") }
    )
    Set<Organization> organizations = new HashSet<>();


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getUser_id() {
        return user_id;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

}
