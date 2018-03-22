package com.webportal.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedlab.framework.spring.dao.AbstractDAO;
import com.jedlab.framework.spring.service.AbstractService;
import com.webportal.app.dao.TaskDao;
import com.webportal.app.domain.Task;

/**
 *
 * @author Omid Pourhadi
 *
 */
@Service
public class TaskService extends AbstractService<Task>
{
    
    @Autowired
    TaskDao taskDao;

    @Override
    public AbstractDAO<Task> getDao()
    {
        return taskDao;
    }

}
