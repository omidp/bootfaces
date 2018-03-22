package com.webportal.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jedlab.framework.spring.dao.BasePO;

@Entity
@Table(name = "projects")
public class Project extends BasePO
{

    @Column(name="name")
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
