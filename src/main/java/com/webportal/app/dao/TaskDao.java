package com.webportal.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jedlab.framework.spring.dao.AbstractDAO;
import com.webportal.app.domain.Task;
import com.webportal.app.domain.User;

/**
 *
 * @author Omid Pourhadi
 *
 */
public interface TaskDao extends AbstractDAO<Task>
{
    
    

}
