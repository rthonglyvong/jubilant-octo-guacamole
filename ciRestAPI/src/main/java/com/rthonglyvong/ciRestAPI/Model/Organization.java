package com.rthonglyvong.ciRestAPI.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long organization_id;
}
