package com.webportal.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedlab.framework.spring.dao.AbstractDAO;
import com.jedlab.framework.spring.service.AbstractService;
import com.webportal.app.dao.UserDao;
import com.webportal.app.domain.User;

/**
 *
 * @author Omid Pourhadi
 *
 */
@Service
public class UserService extends AbstractService<User>
{
    
    @Autowired
    UserDao userDao;

    @Override
    public AbstractDAO<User> getDao()
    {
        return userDao;
    }

}
