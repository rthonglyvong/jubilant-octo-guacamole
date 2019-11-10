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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_organization",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "organization_id") }
    )
    Set<Organization> organizations = new HashSet<>();
}
