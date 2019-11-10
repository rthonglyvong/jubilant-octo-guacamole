package com.rthonglyvong.ciRestAPI.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long organization_id;

    @ManyToMany(mappedBy = "organizations")
    private Set<Users> users = new HashSet<>();
}
