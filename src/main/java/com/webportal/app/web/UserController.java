package com.webportal.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jedlab.framework.spring.rest.AbstractQueryRestController;
import com.jedlab.framework.spring.rest.QueryWhereParser.FilterProperty;
import com.jedlab.framework.spring.service.AbstractService;
import com.jedlab.framework.spring.service.JPARestriction;
import com.jedlab.framework.spring.service.JPARestrictionImpl.Join;
import com.webportal.app.domain.Task;
import com.webportal.app.service.TaskService;

/**
 *
 * @author Omid Pourhadi
 *
 */
@Controller
@RequestMapping("/v1/users")
public class UserController extends AbstractQueryRestController<Task>
{

    @Autowired
    TaskService userService;
    
    @Override
    protected AbstractService<Task> getService()
    {
        return userService;
    }

    @Override
    protected JPARestriction getRestriction(List<FilterProperty> filterProperties)
    {
        return JPARestriction.create((builder, criteria, root) -> {
            criteria.where(builder.equal(root.get("name"), "task 1"));
        }).join(Join.of("project"));
    }

}
