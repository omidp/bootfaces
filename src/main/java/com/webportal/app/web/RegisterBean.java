package com.webportal.app.web;

import java.io.Serializable;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Component;

import com.jedlab.framework.spring.web.SpringViewScope;

@Component("registerBean")
@SpringViewScope
@ELBeanName("registerBean")
public class RegisterBean implements Serializable
{

    String txt;

    public String getTxt()
    {
        return txt;
    }

    public void setTxt(String txt)
    {
        this.txt = txt;
    }

    public void test()
    {
        System.out.println(getTxt());
    }

}
